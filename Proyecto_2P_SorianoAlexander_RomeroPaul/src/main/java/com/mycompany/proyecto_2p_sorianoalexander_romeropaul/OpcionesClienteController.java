/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pdrb1
 */
public class OpcionesClienteController implements Initializable {
    private Stage stage;
    private Parent root;
    private Scene escena; 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private Button btnPedido;
    @FXML
    private Button btnEncontrarLocal;
    @FXML
    private Label lblBienvenida;
    
    @FXML
    public void EncontrarLocal(ActionEvent ae){
        
        
    }
    
    @FXML
    public void HacerPedido(ActionEvent ae) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Pedido.fxml"));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        escena = new Scene(root);
        stage.setScene(escena);
        stage.show();
        
    }
    
    
}
