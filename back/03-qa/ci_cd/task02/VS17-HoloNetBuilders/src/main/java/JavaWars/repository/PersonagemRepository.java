package repository;

import exceptions.BancoDeDadosException;
import model.Droid;
import model.Jedi;
import model.Personagem;
import model.Wookie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagemRepository implements Repositorio<Integer, Personagem>{

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_PERSONAGEM.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");

        }
        return null;
    }

    @Override
    public Personagem adicionar(Personagem personagem) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            personagem.setIdPersonagem(proximoId);

            String sql = "INSERT INTO Personagem\n" +
                    "(ID_Personagem, nivel, nickname, classe_personagem, agilidade, furtividade, forca, defesa, vida)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, personagem.getIdPersonagem());
            stmt.setInt(2, personagem.getNivel());
            stmt.setString(3, personagem.getNickname());
            stmt.setString(4, personagem.getClass().getSimpleName());
            stmt.setInt(5, personagem.getAgilidade());
            stmt.setInt(6, personagem.getFurtividade());
            stmt.setInt(7, personagem.getForca());
            stmt.setInt(8, personagem.getDefesa());
            stmt.setInt(9, personagem.getVida());

            int res = stmt.executeUpdate();
            return personagem;

        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM PERSONAGEM WHERE id_personagem = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            int res = stmt.executeUpdate();

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean editar(Integer id, Personagem personagem) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE Personagem SET ");
            sql.append(" nivel = ?,");
            sql.append(" nickname = ?,");
            sql.append(" agilidade = ?, ");
            sql.append(" furtividade = ?, ");
            sql.append(" forca = ?, ");
            sql.append(" defesa = ?, ");
            sql.append(" vida = ? ");
            sql.append(" WHERE id_personagem = ? ");
            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, personagem.getNivel());
            stmt.setString(2, personagem.getNickname());
            stmt.setInt(3, personagem.getAgilidade());
            stmt.setInt(4, personagem.getFurtividade());
            stmt.setInt(5, personagem.getForca());
            stmt.setInt(6, personagem.getDefesa());
            stmt.setInt(7, personagem.getVida());
            stmt.setInt(8, id);

            int res = stmt.executeUpdate();

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Personagem> listar() throws BancoDeDadosException {

        List<Personagem> personagens = new ArrayList<>();
        Connection con = null;

        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM PERSONAGEM";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {

                String classe = res.getString("CLASSE_PERSONAGEM");

                Personagem personagem = switch (classe) {
                    case "Wookie" -> new Wookie();
                    case "Jedi" -> new Jedi();
                    case "Droid" -> new Droid();
                    default -> new Personagem() {};
                };

                personagem.setIdPersonagem(res.getInt("ID_PERSONAGEM"));
                personagem.setNivel(res.getInt("NIVEL"));
                personagem.setNickname(res.getString("NICKNAME"));
                personagem.setAgilidade(res.getInt("AGILIDADE"));
                personagem.setFurtividade(res.getInt("FURTIVIDADE"));
                personagem.setForca(res.getInt("FORCA"));
                personagem.setDefesa(res.getInt("DEFESA"));
                personagem.setVida(res.getInt("VIDA"));

                personagens.add(personagem);

            }
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return personagens;
    }
}
