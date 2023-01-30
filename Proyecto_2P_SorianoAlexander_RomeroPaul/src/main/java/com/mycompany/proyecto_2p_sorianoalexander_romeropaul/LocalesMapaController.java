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
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author axsl3
 *
 *
 */
public class LocalesMapaController implements Initializable {

    private ArrayList<Local> local;
    private ImageView imgv;
    private DialogPane dialog;
    private Stage stage;
    private Scene scene;

    @FXML
    private Pane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        local = Local.leerLocales();
        agregarImgview();
    }
/**
 * FXML Controller class
 * Este metodo se encarga de crear un boton con programacion dinamica y de incluir los pines en el mapa con su respectivos threads
 * @param rootPane Es el root donde ajustaremos el mapa
 * @param bt Un Boton creado con programacion dinamica que sirve para salir y volver al menu
 * @param alerta El alert que va a mostrar las opciones salir/menu/cancelar
 * @param imgv Es el imageview que va a contener las imagenes para señalar las locaciones
 * @param t Este thread se encarga generar un numero entre 0 y 10 seg para colocar los pines en ese tiempo
 * @param t2 Este thread se encarga de cerrar despues de 5 segundos el alert utilizado en el setOnMouseClick 
 *
 *
 */
    void agregarImgview() {
       

        rootPane.getChildren().clear();
        imgv = null;
        // Se crea un Boton con programacion dinamica para usarlo para volver al menu
        // o salir del programa
        Button bt = new Button("Salir");
        rootPane.getChildren().add(bt);
        //Posicionamiento absoluto
        bt.setLayoutX(410);
        bt.setLayoutY(450);
        //creacion de setonaction para que al apretar el boton salga el alert
        bt.setOnAction(e -> {
            ButtonType menu = new ButtonType("Menú");
            ButtonType salir = new ButtonType("Salir");
            ButtonType cancelar = new ButtonType("Cancelar");
            Alert alerta = new Alert(AlertType.CONFIRMATION, "Elija una opcion", menu, salir, cancelar);
            alerta.setHeaderText("Esta segur@ que quiere salir?");
            Optional<ButtonType> opciones = alerta.showAndWait();
            if (opciones.get() == menu) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("OpcionesCliente.fxml"));
                    stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                }
            } else if (opciones.get() == salir) {
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.close();
            }
        });
        //uso de threads para los iconos en el mapa
        Thread t = new Thread(new Runnable() {
            public void run() {
                // Se recorre listas para conseguir el valor en X / Y de los iconos
                for (Local loc : local) {
                    //Random para que salga cada uno entre 0 y 10 seg
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
                            //creacion de evento al hacer click el icono para que salga la informacion de los locales
                            imgv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                public void handle(MouseEvent e) {
                                    Alert al = new Alert(AlertType.INFORMATION);

                                    al.setHeaderText(nombre + "\n" + direccion + "\n" + horario);
                                    dialog = al.getDialogPane();
                                    String cssLayout = "-fx-background-color: #ffe4e1; -fx-font-size: 15px;";
                                    dialog.setStyle(cssLayout);
                                    // nuevo thread para que la alerta se cierre en 5 seg
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
