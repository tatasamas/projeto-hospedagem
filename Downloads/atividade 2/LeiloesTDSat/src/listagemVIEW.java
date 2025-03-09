
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class listagemVIEW extends JFrame {

    private JTable tabelaProdutos;
    private ProdutosDAO produtosDAO;

    public listagemVIEW() {
        produtosDAO = new ProdutosDAO();
        setTitle("Listagem de Produtos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        List<Produto> produtos = produtosDAO.listarTodosProdutos();
        String[] colunas = {"ID", "Nome", "Descrição", "Preço Inicial", "Data do Leilão", "Status"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Produto produto : produtos) {
            Object[] row = {produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPrecoInicial(), produto.getDataLeilao(), produto.getStatus()};
            model.addRow(row);
        }

        tabelaProdutos = new JTable(model);
        add(new JScrollPane(tabelaProdutos));

        JButton btnVender = new JButton("Vender");
        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabelaProdutos.getSelectedRow();
                if (selectedRow >= 0) {
                    int produtoId = (int) tabelaProdutos.getValueAt(selectedRow, 0);
                    produtosDAO.venderProduto(produtoId);
                    JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
                    // Atualizar a tabela ou realizar outras ações necessárias...
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um produto para vender.");
                }
            }
        });
        add(btnVender, BorderLayout.SOUTH);

        setVisible(true);
    }
}
