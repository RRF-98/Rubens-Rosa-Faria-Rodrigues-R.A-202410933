package poo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector_DB {
    
    static final String URL = "jdbc:postgresql://localhost:5432/ESTOQUE";
    
    static final String USUARIO = "postgres";
   
    static final String SENHA = "9800"; 
    
    public static Connection criarConexao() throws SQLException {
       
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver PostgreSQL não encontrado: " + e.getMessage());
            
            throw new SQLException("Driver PostgreSQL não encontrado.", e);
        }

        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
       
        System.out.println("Conexão efetuada com sucesso!");
        return conexao;
       
    }
}