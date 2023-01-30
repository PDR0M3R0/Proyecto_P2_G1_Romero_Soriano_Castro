package Clases;

/** 
 * Representa los platos clasificados por su tipo.
 */
public class Menu {
    
    /**
     * Representa el identificador del menu.
     */
    private String descripcion;
    /** 
     * Representa el precio de un plato del menu.
     */
    private double precio;
    /**
     * Representa el tipo de menu y pueden ser plato fuerte, postre, piqueo o bebida.
     */
    private String tipo;
    
    /**
     * Crea una instancia de la clase Menu
     * @param descripcion
     * @param precio
     * @param tipo 
     */
    
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