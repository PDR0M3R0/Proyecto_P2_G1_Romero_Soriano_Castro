package com.mycompany.proyecto_2p_sorianoalexander_romeropaul.modelo;

/**
 *
 * @author axsl3
 */
public class Comida {

    String descripcion;
    double precio;
    String tipoMenu; //Enum posiblemente

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
