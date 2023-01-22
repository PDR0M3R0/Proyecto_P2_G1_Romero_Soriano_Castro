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
          Thread t = new Thread(new Runnable(){
            @Override
              public void run(){
                Platform.runLater(new Runnable(){
                  @Override
                  public void run(){
                      mostrarEnGridPane(tipo);
                  }
                });
              }
          });
          
          t.start();
          
      }else if(opcion.equals("Postres")){          
          String tipo = "P";
          
          Platform.runLater(new Runnable(){
            @Override
            public void run(){
                mostrarEnGridPane(tipo);
            }
          });
          
      }else if(opcion.equals("Bebidas")){
          String tipo = "B";
          Platform.runLater(new Runnable(){
            @Override
            public void run(){
                mostrarEnGridPane(tipo);
            }
        });
      }     
    }
    
    public void mostrarEnGridPane(String tipo){
        for(Menu m:menulista){
            if(m.getTipo().equals(tipo)){
                
                HBox seccDescripcion = new HBox();
                Label lbldescripcion = new Label(m.getDescripcion());
                seccDescripcion.getChildren().add(lbldescripcion);

                HBox seccPrecio = new HBox();
                Label lblprecio = new Label(String.valueOf(m.getPrecio()));
                seccPrecio.getChildren().add(lblprecio);

                HBox seccCant = new HBox();
                TextField cant = new TextField();
                seccCant.getChildren().add(cant);

                HBox seccAgre = new HBox();
                Button btnEscoger = new Button("Agregar");
                seccDescripcion.getChildren().add(btnEscoger);


                //Para anadir 4 columnas
                gridOpciones.setConstraints(seccDescripcion,1,0);
                gridOpciones.setConstraints(seccPrecio,1,0);
                gridOpciones.setConstraints(seccCant,1,0);
                gridOpciones.setConstraints(seccAgre,1,0);
                
        
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
