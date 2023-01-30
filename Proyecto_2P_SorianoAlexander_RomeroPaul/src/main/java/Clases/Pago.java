package Clases;

/**
 *  Se genera de la realización de un pedido.
 */
public class Pago {
    
    /**
     * Representa el identificador del pago.
     */
    int idPago;
    /**
     * Representa el identificador del pedido realizado por el usuario.
     */
    int idPedido;
    /**
     * Representa un identificador de quien realiza el pago.
     */
    String nombreCliente;
    /**
     * Valor que se genera al realizar un pedido.
     */
    double totalPagar;
    /**
     * Representa el momento en que se realizó el pedido.
     */
    String fecha;
    /**
     * Representa el metódo de pago del usuario y puede ser efectivo o tarjeta.
     */
    String tipo; //Enum posiblemente 
    
    /**
     * Crea una instancia de la clase Pago
     * @param idPago
     * @param idPedido
     * @param nombreCliente
     * @param totalPagar
     * @param fecha
     * @param tipo 
     */

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