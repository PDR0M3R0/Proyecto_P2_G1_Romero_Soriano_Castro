
package Clases;

import static com.mycompany.proyecto_2p_sorianoalexander_romeropaul.IngresoSistemaController.usuarios;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 *
 * @author axsl3
 */
public class Pedido{
    private String descripcion;  //id del pedido 
    private String nombreCliente;
    private int cantidad;
    private double valor;
    
    public Pedido(String descripcion,String nombreCliente,int cantidad,double valor){
        this.descripcion = descripcion;
        this.nombreCliente = nombreCliente;
        this.cantidad = cantidad;
        this.valor = valor;
        
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
   
    public double totalCant(){
        double total = this.getCantidad() * this.getValor();
        return total;
      
    }
    
}
