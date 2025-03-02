/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 55519
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD{
    private static final String URL = "jdbc:mysql://localhost:3306/hospedagem"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "91216393"; 
    
    // Método para obter a conexão com o banco
    public static Connection getConnection() throws SQLException {
        try {
            // Carregar o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD); // Retorna a conexão
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Erro ao conectar ao banco de dados", e);
        }
    }
}
