/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 55519
 */
import java.sql.*;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO() {
        try {
            this.conn = ConexaoBD.getConnection(); // Obtém a conexão usando a classe ConexaoDB
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvarCliente(Cliente cliente) {
        try {
            String query = "INSERT INTO clientes (nome, cpf, telefone) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


