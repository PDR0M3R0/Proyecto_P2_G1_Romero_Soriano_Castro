package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import Clases.Menu;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;

/**
 * FXML Controller class
 *
 * @author pdrb1
 */
public class PedidoController implements Initializable {
    static ArrayList<Menu> menulista = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        menulista = leerMenu();
        comboTipo.getItems().addAll("Platos Fuertes","Postres","Piqueos","Bebidas");
        
        
        
    }    
    
    @FXML
    private ComboBox<String> comboTipo;
    @FXML
    private ComboBox<String> comboOrden;
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
    public void elegirTipo(ActionEvent ae){
      ArrayList<Menu> lista = new ArrayList<>();
      String opcion = comboTipo.getValue();

      
      
            if(opcion.equals("Platos Fuertes")){
                String tipo = "F";
                mostrarEnGridPane(tipo);


            }else if(opcion.equals("Piqueos")){
                String tipo = "Q";
                mostrarEnGridPane(tipo);


            }else if(opcion.equals("Postres")){          
                String tipo = "P";
                mostrarEnGridPane(tipo);

            }else if(opcion.equals("Bebidas")){
                String tipo = "B";
                mostrarEnGridPane(tipo);  
            }  
        
    }
    
    //Aqui te muestra en el mimso gridOpciones 
    public void mostrarEnGridPane(String tipo){
        for(int i=0;i<menulista.size();i++){            
            if(menulista.get(i).getTipo().equals(tipo)){                
                //HBox seccDescripcion = new HBox();
                Label lbldescripcion = new Label(menulista.get(i).getDescripcion());
                //seccDescripcion.getChildren().add(lbldescripcion);

                //HBox seccPrecio = new HBox();
                Label lblprecio = new Label(String.valueOf(menulista.get(i).getPrecio()));
                //seccPrecio.getChildren().add(lblprecio);

                //HBox seccCant = new HBox();
                TextField cant = new TextField();
                //seccCant.getChildren().add(cant);

                //HBox seccAgre = new HBox();
                Button btnEscoger = new Button("Agregar");
                //seccDescripcion.getChildren().add(btnEscoger);
                
               
                
                //Para anadir 4 columnas
                GridPane.setConstraints(lbldescripcion,0,i+1);
                GridPane.setConstraints(lblprecio,1,i+1);
                GridPane.setConstraints(cant,2,i+1);
                GridPane.setConstraints(btnEscoger,3,i+1);
                
                gridOpciones.getChildren().addAll(lbldescripcion,lblprecio,cant,btnEscoger);
                
            }                   
        }
    }
    
       
    @FXML
    public void ordenarPor(ActionEvent ae){
        
    }
    
    
    public ArrayList<Menu> leerMenu(){
        ArrayList<Menu> menulista = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader("menu.txt"))){
           String linea;
           linea = br.readLine();//salto de linea
           
           while((linea = br.readLine()) != null){
               String[] parametros = linea.split(",");
               
               Menu menu = new Menu(parametros[0],Double.parseDouble(parametros[1]),parametros[2]);
               menulista.add(menu);
           }
            
        }catch(IOException ioe){
            System.out.println("No se ha podido ingresar al documento menu");
        }     
        
        return menulista;
    }
    
    
    
    
    
    
    
    
}
