/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import com.mycompany.proyecto_2p_sorianoalexander_romeropaul.modelo.TipoMenu;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.layout.GridPane;
import com.mycompany.proyecto_2p_sorianoalexander_romeropaul.modelo.MenuC;

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
    private ComboBox<String> comboTipo;
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
    public void mostrarCombo(ActionEvent ae){
        System.out.println("actuo el combos");
        ObservableList<String> tipos = FXCollections.observableArrayList();           
        tipos.addAll("F", TipoMenu.P.toString(), TipoMenu.B.toString(), TipoMenu.Q.toString());
        comboTipo =new ComboBox(tipos);
    }
    
    @FXML
    public void ordenarPor(ActionEvent ae){
        System.out.println("actuo el combos");
    }
    
    
    
    
    
    
}
