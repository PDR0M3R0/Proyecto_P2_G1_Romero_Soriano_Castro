
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
   
    // Metodo para crear Archivo de pedido formato(idPedido - nombre Cliente - Total)
    public void registrarPedido(ArrayList<Pedido> listaPedido){
        double total = 0.0;
        for(Pedido p:listaPedido){
            total += p.getValor();
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Pedidos.txt"))){
            for(Pedido p:listaPedido){
                bw.write(p.getDescripcion() + "," + p.getNombreCliente() + "," + total);
            }
            
        }catch(IOException ioe){
            System.out.println("Se ha registrado un error al registrar el pedido!");
            
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error de Registro");
            alerta.setHeaderText("No ha sido posible registrar este pedido");
            alerta.showAndWait();

        }
    }
    
    
}
