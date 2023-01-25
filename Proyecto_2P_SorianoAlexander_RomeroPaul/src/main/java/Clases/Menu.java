package Clases;

/**
 *
 * @author pdrb1
 */
public class Menu {
    private String descripcion;
    private double precio;
    private String tipo;
    
    public Menu(String descripcion,double precio,String tipo){
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
        
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return descripcion + " - " + precio + " - " + tipo;
 
    }
    
}
