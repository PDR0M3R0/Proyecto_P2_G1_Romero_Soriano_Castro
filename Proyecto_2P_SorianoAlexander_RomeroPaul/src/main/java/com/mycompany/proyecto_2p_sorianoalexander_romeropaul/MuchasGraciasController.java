/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class MuchasGraciasController implements Initializable{
    private Stage stage;
    private Scene scene;
    @FXML
    private Text texto;
    @FXML
    private Label cerrando;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        texto.setText("Su pedido Nro.... ha sido pagado y ahora empezaremos a prepararlo.\nEn aproximadamente 30 minutos llegará a su destino.\nGracias por preferirnos.");
        hiloCerrar();
    }    
    
    void hiloCerrar(){
        Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 5; i >= 0; i--) {
                String finish = "La ventana se cerrara en " + i + " segundos";

                try {
                    Thread.sleep(1000);
                   } catch (InterruptedException ex) {

                   }Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                        cerrando.setText(finish);
                        }
                          });
                             }
                              }
                               });
                        t2.setDaemon(true);
                        t2.start();
    }
}
