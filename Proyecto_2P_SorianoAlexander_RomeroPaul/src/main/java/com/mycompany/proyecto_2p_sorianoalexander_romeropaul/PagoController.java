/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class PagoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //hola
    }    
    
    @FXML
    private Button btnContinuar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private RadioButton rButtonEfectivo;

    @FXML
    private RadioButton rButtonTarjeta;

    @FXML
    private TextField txtDireccion;
    
    @FXML
    private VBox vBoxInteractive;

    @FXML
    void continuar(ActionEvent event) {

    }

    @FXML
    void limpiar(ActionEvent event) {

    }

    @FXML
    void seleccion(ActionEvent event) {
        if(rButtonEfectivo.isSelected()){
            
        }
        if(rButtonTarjeta.isSelected()){
            
        }
    }


    
}
