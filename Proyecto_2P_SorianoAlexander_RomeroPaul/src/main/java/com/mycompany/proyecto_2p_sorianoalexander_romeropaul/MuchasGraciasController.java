package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * Controlador de la vista MuchasGracias.
 * @author Usuario
 */
public class MuchasGraciasController implements Initializable {

    /**
     * Representa el escenario de la vista.
     */
    private Stage stage;
    /**
     * Representa la escena o vista.
     */
    private Scene scene;
    /**
     * Representa el mensaje a mostrar una vez que se muestre la vista.
     */
    @FXML
    private Text texto;
    /**
     * Mensaje que cambia acorde un conteo regresivo.
     */
    @FXML
    private Label cerrando;

    /**
     * Inicializa la clase controladora.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        texto.setText("Su pedido Nro.... ha sido pagado y ahora empezaremos a prepararlo.\nEn aproximadamente 30 minutos llegará a su destino.\nGracias por preferirnos.");
        hiloCerrar();
        cerrar();
    }
    
/**
 * Da funcionalidad al hilo que controla el conteo regresivo.
 */
    void hiloCerrar() {
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 5; i >= 0; i--) {
                    String finish = "La ventana se cerrara en " + i + " segundos";

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {

                    }
                    Platform.runLater(new Runnable() {

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
    
/**
 * Cierra la vista MuchasGracias.
 */
    void cerrar() {
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                
                 try {
                        Thread.sleep(6100);
                    } catch (InterruptedException ex) {

                    }
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        Stage stage = (Stage) texto.getScene().getWindow();
                        stage.close();
                    }
                });

            }
        });
        t3.setDaemon(true);
        t3.start();

    }
}