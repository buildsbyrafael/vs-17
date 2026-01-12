package repository;

import java.sql.Connection;
import java.sql.SQLException;


public class TesteConexao {
    public static void main(String[] args) throws SQLException {
        System.out.println("Tentando conectar...");

        Connection connection = ConexaoBancoDeDados.getConnection();

        System.out.println("✅ CONEXÃO ABERTA COM SUCESSO!");
        connection.close();
    }
}