package repository;

import exceptions.BancoDeDadosException;
import model.BatalhaEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BatalhaRepository {

    private Connection getConn() throws SQLException {
        return ConexaoBancoDeDados.getConnection();
    }

    private long nextId(Connection c, String seq) throws SQLException {
        // Assumindo que a sequência está no schema VEM_SER (baseado no seu Scrip.sql)
        String sql = "SELECT " + seq + ".NEXTVAL FROM DUAL";
        try (PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getLong(1);
            throw new SQLException("Não foi possível obter NEXTVAL da sequência: " + seq);
        }
    }

    public void registrarBatalha(Integer idPersonagem, Integer idInimigo) throws BancoDeDadosException {
        String sql = "INSERT INTO BATALHA (id_batalha, id_personagem, id_inimigo) VALUES (?, ?, ?)";
        Connection c = null;
        try {
            c = getConn();
            int id = (int) nextId(c, "SEQ_BATALHA");
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.setInt(2, idPersonagem);
                ps.setInt(3, idInimigo);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (c != null) c.close();
            } catch (SQLException e) {

            }
        }
    }

    public List<BatalhaEntity> listarBatalhas() throws BancoDeDadosException {
        Connection con = null;
        List<BatalhaEntity> batalhas = new ArrayList<>();
        try {
            con = getConn();
            String sql = "SELECT id_batalha, id_personagem, id_inimigo FROM BATALHA";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                BatalhaEntity b = new BatalhaEntity();
                b.setIdBatalha(res.getInt("id_batalha"));
                b.setIdPersonagem(res.getInt("id_personagem"));
                b.setIdInimigo(res.getInt("id_inimigo"));
                batalhas.add(b);
            }
            return batalhas;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean atualizarBatalha(BatalhaEntity b) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = getConn();
            String sql = "UPDATE BATALHA SET id_personagem = ?, id_inimigo = ? WHERE id_batalha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, b.getIdPersonagem());
            stmt.setInt(2, b.getIdInimigo());
            stmt.setInt(3, b.getIdBatalha());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean apagarLogDeBatalha(Integer idBatalha) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = getConn();

            String sql = "DELETE FROM BATALHA WHERE id_batalha = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idBatalha);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}