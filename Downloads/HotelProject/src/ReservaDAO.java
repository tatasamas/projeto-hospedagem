/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 55519
 */
import java.sql.*;

public class ReservaDAO {
    private Connection conn;

    public ReservaDAO() {
        try {
            this.conn = ConexaoBD.getConnection(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvarReserva(Reserva reserva) {
        try {
            String query = "INSERT INTO reservas (numero_quarto, cliente_id, data_entrada, data_saida) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, reserva.getNumeroQuarto());
            stmt.setInt(2, reserva.getClienteId());
            stmt.setString(3, reserva.getDataEntrada());
            stmt.setString(4, reserva.getDataSaida());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


