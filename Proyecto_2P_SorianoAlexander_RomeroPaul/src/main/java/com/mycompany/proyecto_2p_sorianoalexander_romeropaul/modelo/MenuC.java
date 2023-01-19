package com.mycompany.proyecto_2p_sorianoalexander_romeropaul.modelo;

import java.util.ArrayList;

public class MenuC {
    public static ArrayList<Comida> comidas;
    private String descripcion;
    private double precio;
    private TipoMenu tipo;

    public MenuC(String descripcion, double precio, TipoMenu tipo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }
    
    
//    public MenuC(ArrayList<Comida> comidas){
//        this.comidas = comidas;
//        
//    }

    public static ArrayList<Comida> getComidas() {
        return comidas;
    }

    public static void setComidas(ArrayList<Comida> comidas) {
        MenuC.comidas = comidas;
    }
    
    
}
