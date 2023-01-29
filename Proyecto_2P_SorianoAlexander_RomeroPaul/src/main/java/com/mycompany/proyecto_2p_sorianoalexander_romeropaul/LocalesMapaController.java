/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import Clases.Local;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
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
    private ImageView imgv;
    private DialogPane dialog;

    @FXML
    private Pane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        local = Local.leerLocales();
        agregarImgview();
    }

    void agregarImgview() {

        rootPane.getChildren().clear();
        imgv = null;

        Thread t = new Thread(new Runnable() {
            public void run() {

                for (Local loc : local) {
                    Random r = new Random();
                    int n = r.nextInt(11);
                    try {
                        Thread.sleep(n * 1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try ( FileInputStream input = new FileInputStream(Principal.pathImages + "icono.png")) {
                                Image img = new Image(input, 40, 40, false, false);
                                imgv = new ImageView(img);

                                imgv.setX(loc.getCoordenadaX());
                                imgv.setY(loc.getCoordenadaY());

                            } catch (IOException ex) {

                            }

                            String nombre = loc.getNombre();
                            String direccion = loc.getDireccion();
                            String horario = loc.getHorario();

                            rootPane.getChildren().add(imgv);
                            imgv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                public void handle(MouseEvent e) {
                                    Alert al = new Alert(AlertType.INFORMATION);
                                   
                                    al.setHeaderText(nombre + "\n" + direccion + "\n" + horario);
                                    dialog = al.getDialogPane();
                                    String cssLayout = "-fx-background-color: #ffe4e1; -fx-font-size: 15px;";
                                    dialog.setStyle(cssLayout);
                                    
                                    Thread t2 = new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int i = 5; i >= 0; i--) {
                                                int contador = i;
                                                String finish = "La ventana se cerrara en " + i + " segundos";

                                                try {
                                                    Thread.sleep(1000);
                                                } catch (InterruptedException ex) {

                                                }
                                                Platform.runLater(new Runnable() {

                                                    @Override
                                                    public void run() {
                                                        al.setContentText(finish);
                                                        if (contador == 0) {
                                                            al.close();
                                                        }
                                                    }
                                                });

                                            }
                                        }
                                    });
                                    t2.setDaemon(true);
                                    t2.start();
                                    al.showAndWait();
                                }
                            }
                            );

                        }

                    });
                }
            }
        });
        t.start();
    }
}
