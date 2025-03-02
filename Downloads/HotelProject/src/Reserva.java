/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 55519
 */
public class Reserva {
    private int numeroQuarto;
    private int clienteId;
    private String dataEntrada;
    private String dataSaida;

    public Reserva(int numeroQuarto, int clienteId, String dataEntrada, String dataSaida) {
        this.numeroQuarto = numeroQuarto;
        this.clienteId = clienteId;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    // Getters e setters
    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }
}

