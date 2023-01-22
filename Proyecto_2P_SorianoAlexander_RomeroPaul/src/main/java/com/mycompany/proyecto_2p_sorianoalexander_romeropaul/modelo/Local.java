/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_2p_sorianoalexander_romeropaul.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author axsl3
 */
public class Local {

    String nombre;
    String direccion;
    String horario;
    double coordenadaX;
    double coordenadaY;

    public Local(String nombre, String direccion, String horario, double coordenadaX, double coordenadaY) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;

        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public static ArrayList<Local> leerLocales() {
        try ( BufferedReader bfr = new BufferedReader(new FileReader("Locales.txt"))) {
            ArrayList<Local> local = new ArrayList<>();
            String linea= bfr.readLine();
            while (linea != null) {
                String[] lineas = linea.trim().strip().split(",");
                String nombre = lineas[0];
                String direccion = lineas[1];
                String horario = lineas[2];
                double coordX = Double.parseDouble(lineas[3]);
                double coordY = Double.parseDouble(lineas[4]);
                Local lo = new Local(nombre, direccion, horario, coordX, coordY);
                local.add(lo);
               
                linea = bfr.readLine();

            }
            return local;

        } catch (IOException ex) {
            return null;
        }
    }
}
