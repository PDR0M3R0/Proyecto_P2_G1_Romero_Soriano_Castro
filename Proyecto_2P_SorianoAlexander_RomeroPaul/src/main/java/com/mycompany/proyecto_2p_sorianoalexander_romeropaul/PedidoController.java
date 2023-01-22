package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import com.mycompany.proyecto_2p_sorianoalexander_romeropaul.*;
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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
//        System.out.println("actuo el combos");
//        ObservableList<String> tipos = FXCollections.observableArrayList();           
//        tipos.addAll("F", TipoMenu.P.toString(), TipoMenu.B.toString(), TipoMenu.Q.toString());
//        comboTipo = new ComboBox(tipos);

        
    }
    
    public ArrayList<Menu> cargarCombos(){
        ArrayList<String[]> listaParametros = new ArrayList<>();
        ArrayList<Menu> menulista = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader("menu.txt"))){
           String linea;
           linea = br.readLine();//salto de linea
           
           while((linea = br.readLine()) != null){
               String[] parametros = linea.split(",");
               listaParametros.add(parametros);
               
           }
           
           for(String[] p:listaParametros){
               String descripcion = p[0];
               double precio = Double.parseDouble(p[1]);
               String tipo = p[2];
               
               Menu m = new Menu(descripcion,precio,tipo);
                              
           }
            
        }catch(IOException ioe){
            
        }     
        
        return menulista;
    }
    
    @FXML
    public void ordenarPor(ActionEvent ae){
        System.out.println("actuo el combos");
    }
    
    
    
    
    
    
}
