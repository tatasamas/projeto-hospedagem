/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 55519
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VendasView extends JFrame {

    private JTable tabelaProdutosVendidos;
    private ProdutosDAO produtosDAO;

    public VendasView() {
        produtosDAO = new ProdutosDAO();
        setTitle("Produtos Vendidos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        List<Produto> produtosVendidos = produtosDAO.listarProdutosVendidos();
        String[] colunas = {"ID", "Nome", "Descrição", "Preço Inicial", "Data do Leilão", "Status"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Produto produto : produtosVendidos) {
            Object[] row = {produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPrecoInicial(), produto.getDataLeilao(), produto.getStatus()};
            model.addRow(row);
        }

        tabelaProdutosVendidos = new JTable(model);
        add(new JScrollPane(tabelaProdutosVendidos));

        setVisible(true);
    }
}