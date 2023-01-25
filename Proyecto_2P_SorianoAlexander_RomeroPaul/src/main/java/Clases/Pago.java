/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author axsl3
 */
public class Pago {
    int idPago;
    int idPedido;
    String nombreCliente;
    double totalPagar;
    String fecha;
    String tipo; //Enum posiblemente 

    public Pago(int idPago, int idPedido, String nombreCliente, double totalPagar, String fecha, String tipo) {
        this.idPago = idPago;
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.totalPagar = totalPagar;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
