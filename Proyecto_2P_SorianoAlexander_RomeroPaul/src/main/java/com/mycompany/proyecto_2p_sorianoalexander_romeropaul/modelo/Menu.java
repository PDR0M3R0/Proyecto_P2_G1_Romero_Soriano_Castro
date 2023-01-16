package com.mycompany.proyecto_2p_sorianoalexander_romeropaul.modelo;

import java.util.ArrayList;

public class Menu {
    public static ArrayList<Comida> comidas;
    
    public Menu(ArrayList<Comida> comidas){
        this.comidas = comidas;
        
    }

    public static ArrayList<Comida> getComidas() {
        return comidas;
    }

    public static void setComidas(ArrayList<Comida> comidas) {
        Menu.comidas = comidas;
    }
    
    
}
