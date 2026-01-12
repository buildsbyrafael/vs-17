package repository;

import exceptions.BancoDeDadosException;
import model.Inimigo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InimigoRepository {

    public Inimigo adicionar(Inimigo inimigo) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sqlSeq = "SELECT SEQ_INIMIGO.nextval myseq FROM DUAL";
            Statement stmtSeq = con.createStatement();
            ResultSet res = stmtSeq.executeQuery(sqlSeq);
            if(res.next()) inimigo.setIdInimigo(res.getInt("myseq"));

            String sql = "INSERT INTO INIMIGO (id_inimigo, nome, hp, forca) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, inimigo.getIdInimigo());
            stmt.setString(2, inimigo.getNome());
            stmt.setInt(3, inimigo.getVida());
            stmt.setInt(4, inimigo.getForca());

            stmt.executeUpdate();
            return inimigo;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    public List<Inimigo> listar() throws BancoDeDadosException {
        return new ArrayList<>();
    }
}
