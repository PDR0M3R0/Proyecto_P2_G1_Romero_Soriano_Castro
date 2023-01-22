/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import com.mycompany.proyecto_2p_sorianoalexander_romeropaul.modelo.Local;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author axsl3
 */
public class LocalesMapaController implements Initializable {

    private ArrayList<Local> local;

    @FXML
    private Pane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        local = Local.leerLocales();
        agregarImgview();
    }

    void agregarImgview() {
        rootPane.getChildren().clear();
        ImageView imgv = null;
        for (Local loc : local) {
            try ( FileInputStream input = new FileInputStream(Principal.pathImages + "icono.png")) {
                Image img = new Image(input, 40, 40, false, false);
                imgv = new ImageView(img);

                imgv.setX(loc.getCoordenadaX());
                imgv.setY(loc.getCoordenadaY());
                
            } catch (IOException ex) {

            }
            
            String name=loc.getNombre();
            String direccion=loc.getDireccion();
            String horario=loc.getHorario();
            
          
            rootPane.getChildren().add(imgv);
            imgv.setOnMouseClicked(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){
                    Alert al=new Alert(AlertType.INFORMATION);
                    al.showAndWait();
                    
                }
            });

        }
    }

}
