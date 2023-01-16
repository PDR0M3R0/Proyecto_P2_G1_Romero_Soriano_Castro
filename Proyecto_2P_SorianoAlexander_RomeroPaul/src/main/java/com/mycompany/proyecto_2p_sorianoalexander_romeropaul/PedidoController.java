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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author pdrb1
 */
public class PedidoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private ComboBox<Menu> comboTipo;
    @FXML
    private ComboBox<Menu> comboOrden;
    @FXML
    private GridPane gridOpciones;
    @FXML
    private GridPane gridPedido;
    @FXML
    private Button btnContinuar;
    @FXML
    private Button btnLimpiar;
    
    
    
    @FXML
    public void limpiar(ActionEvent ae){
        
    }
    
    @FXML
    public void continuar(ActionEvent ae){
        
    }
    
    @FXML
    public void mostrarTipos(ActionEvent ae){
           
    }
    
    @FXML
    public void ordenarPor(ActionEvent ae){
        
    }
    
    
    
    
    
    
}
