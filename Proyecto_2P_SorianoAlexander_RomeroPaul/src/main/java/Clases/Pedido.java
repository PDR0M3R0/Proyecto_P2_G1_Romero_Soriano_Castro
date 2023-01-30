package Clases;


import java.io.Serializable;

/**
 * Representa lo que adquirirá el usuario.
 */
public class Pedido implements Serializable{
    
    /**
     * Representa el identificador del pedido.
     */
    private String descripcion;  //id del pedido 
    /**
     * Representa un identificador de quien va a realizar el pedido.
     */
    private String nombreCliente;
    /**
     * Representa cuanto se adquirirá de platos del menú.
     */
    private int cantidad;
    /**
     * Representa el total del pedido, es un valor en dólares.
     */
    private double valor;
    
    /**
     * Crea una instancia de la clase Pedido
     * @param descripcion
     * @param nombreCliente
     * @param cantidad
     * @param valor 
     */
    
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
    
 /**
 * Permite calcular el valor por cantidad de producto.
 * @return total
 */
    public double totalCant(){
        double total = this.getCantidad() * this.getValor();
        return total;
      
    }
    
    
    
}