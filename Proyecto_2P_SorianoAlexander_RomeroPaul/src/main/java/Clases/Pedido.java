
package Clases;

/**
 *
 * @author axsl3
 */
public class Pedido {

    int idPedido;
    String nombreCliente;
    double total;

    public Pedido(int idPedido, String nombreCliente, double total) {
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.total = total;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
