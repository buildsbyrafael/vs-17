package repository;

import exceptions.BancoDeDadosException;
import model.Missao;
import model.TipoMissao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MissaoRepository {
    public List<Missao> buscarPorCapitulo(int numeroCapitulo) throws BancoDeDadosException {
        List<Missao> listaDeMissoes = new ArrayList<>();

        try (Connection con = ConexaoBancoDeDados.getConnection()) {

            String sql = "SELECT * FROM missao WHERE capitulo = ? ORDER BY ordem ASC";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, numeroCapitulo);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Missao missao = new Missao(
                        rs.getInt("id_missao"),
                        rs.getInt("capitulo"),
                        rs.getInt("ordem"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getString("atributo_necessario"),
                        rs.getInt("dificuldade"),
                        TipoMissao.valueOf(rs.getString("tipo_missao"))
                );

                listaDeMissoes.add(missao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new BancoDeDadosException(e);
        }

        return listaDeMissoes;
    }
}
