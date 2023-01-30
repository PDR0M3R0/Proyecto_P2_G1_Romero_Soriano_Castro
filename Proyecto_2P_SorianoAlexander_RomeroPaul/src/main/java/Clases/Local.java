package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *  Representa una sucursal del negocio.
 */
public class Local {
    
    /**
     * Representa el identificador del local.
     */
    String nombre;
    /**
     * Representa la ubicacion general del local.
     */
    String direccion;
    /**
     * Representa el horario de atencion del local.
     */
    String horario;
    /**
     * Representa la ubicacion del local con coordenadas en el mapa.
     */
    double coordenadaX;
    /**
     * Representa la ubicacion del local con coordenadas en el mapa.
     */
    double coordenadaY;
    
    /**
     * Crea una instancia de la clase Local.
     * @param nombre
     * @param direccion
     * @param horario
     * @param coordenadaX
     * @param coordenadaY 
     */
    
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

    /**
     * Lee el archivo locales.txt.
     * @return Lista de locales.
     */
    public static ArrayList<Local> leerLocales() {
        try ( BufferedReader bfr = new BufferedReader(new FileReader("Locales.txt",StandardCharsets.UTF_8))) {
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