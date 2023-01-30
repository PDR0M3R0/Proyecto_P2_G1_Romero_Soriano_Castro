package Clases;

/**
 * Representa un plato específico que se encuentran a disposición del usuario.
 */
public class Comida {
    
    /**
     * Representa el identificador de la comida.
     */
    String descripcion;
    /**
     * Representa el valor unitario de la comida.
     */
    double precio;
    /**
     * Representa la clasificación del plato.
     */
    String tipoMenu; //Enum posiblemente
    
    /**
     * Crea una instancia de la clase Comida.
     * @param descripcion
     * @param precio
     * @param tipoMenu 
     */

    public Comida(String descripcion, double precio, String tipoMenu) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoMenu = tipoMenu;
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

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }
    
    @Override 
    public String toString(){
        return descripcion + " - " + precio + " - " + tipoMenu;
    }
    
}