/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 55519
 */
import javax.swing.*;
import java.awt.event.*;

public class CadastroForm extends JFrame {

    private JTextField txtNome, txtCpf, txtTelefone, txtNumeroQuarto, txtClienteId, txtDataEntrada, txtDataSaida;
    private JButton btnSalvarCliente, btnSalvarReserva;

    public CadastroForm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Cliente e Reserva");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Inicialização dos componentes
        JLabel lblNome = new JLabel("Nome:");
        JLabel lblCpf = new JLabel("CPF:");
        JLabel lblTelefone = new JLabel("Telefone:");
        JLabel lblNumeroQuarto = new JLabel("Número do Quarto:");
        JLabel lblClienteId = new JLabel("ID Cliente:");
        JLabel lblDataEntrada = new JLabel("Data de Entrada:");
        JLabel lblDataSaida = new JLabel("Data de Saída:");

        txtNome = new JTextField();
        txtCpf = new JTextField();
        txtTelefone = new JTextField();
        txtNumeroQuarto = new JTextField();
        txtClienteId = new JTextField();
        txtDataEntrada = new JTextField();
        txtDataSaida = new JTextField();
        btnSalvarCliente = new JButton("Salvar Cliente");
        btnSalvarReserva = new JButton("Salvar Reserva");

        // Posicionamento dos componentes
        lblNome.setBounds(30, 30, 120, 25);
        txtNome.setBounds(150, 30, 200, 25);
        
        lblCpf.setBounds(30, 70, 120, 25);
        txtCpf.setBounds(150, 70, 200, 25);
        
        lblTelefone.setBounds(30, 110, 120, 25);
        txtTelefone.setBounds(150, 110, 200, 25);
        
        lblNumeroQuarto.setBounds(30, 150, 120, 25);
        txtNumeroQuarto.setBounds(150, 150, 200, 25);
        
        lblClienteId.setBounds(30, 190, 120, 25);
        txtClienteId.setBounds(150, 190, 200, 25);
        
        lblDataEntrada.setBounds(30, 230, 120, 25);
        txtDataEntrada.setBounds(150, 230, 200, 25);
        
        lblDataSaida.setBounds(30, 270, 120, 25);
        txtDataSaida.setBounds(150, 270, 200, 25);
        
        btnSalvarCliente.setBounds(30, 310, 150, 30);
        btnSalvarReserva.setBounds(200, 310, 150, 30);

        // Adicionando os componentes à tela
        add(lblNome);
        add(txtNome);
        add(lblCpf);
        add(txtCpf);
        add(lblTelefone);
        add(txtTelefone);
        add(lblNumeroQuarto);
        add(txtNumeroQuarto);
        add(lblClienteId);
        add(txtClienteId);
        add(lblDataEntrada);
        add(txtDataEntrada);
        add(lblDataSaida);
        add(txtDataSaida);
        add(btnSalvarCliente);
        add(btnSalvarReserva);

        // Ação do botão Salvar Cliente
        btnSalvarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String cpf = txtCpf.getText();
                String telefone = txtTelefone.getText();

                Cliente cliente = new Cliente(nome, cpf, telefone);
                new ClienteDAO().salvarCliente(cliente);

                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            }
        });

        // Ação do botão Salvar Reserva
        btnSalvarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroQuarto = Integer.parseInt(txtNumeroQuarto.getText());
                int clienteId = Integer.parseInt(txtClienteId.getText());
                String dataEntrada = txtDataEntrada.getText();
                String dataSaida = txtDataSaida.getText();

                Reserva reserva = new Reserva(numeroQuarto, clienteId, dataEntrada, dataSaida);
                new ReservaDAO().salvarReserva(reserva);

                JOptionPane.showMessageDialog(null, "Reserva cadastrada com sucesso!");
            }
        });
    }

    public static void main(String[] args) {
        new CadastroForm().setVisible(true);
    }
}


