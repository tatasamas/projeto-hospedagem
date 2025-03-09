/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    // Conexão com o banco de dados
    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/Leiloes";
        String user = "talitasamara";
        String password = "91216393";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Operação de venderProduto
    public void venderProduto(int produtoId) {
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, produtoId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Operação de listarProdutosVendidos
    public List<Produto> listarProdutosVendidos() {
        String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";
        List<Produto> produtosVendidos = new ArrayList<>();
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoInicial(rs.getDouble("preco_inicial"));
                produto.setDataLeilao(rs.getDate("data_leilao"));
                produto.setStatus(rs.getString("status"));
                produtosVendidos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return produtosVendidos;
    }

    // Método adicional para listar todos os produtos (necessário para ListagemView)
    public List<Produto> listarTodosProdutos() {
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoInicial(rs.getDouble("preco_inicial"));
                produto.setDataLeilao(rs.getDate("data_leilao"));
                produto.setStatus(rs.getString("status"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return produtos;
    }
}