/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_2p_sorianoalexander_romeropaul.modelo;

/**
 *
 * @author axsl3
 */
public class Menu {

    String descripcion;
    double precio;
    String tipoMenu; //Enum posiblemente

    public Menu(String descripcion, double precio, String tipoMenu) {
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
    
}
