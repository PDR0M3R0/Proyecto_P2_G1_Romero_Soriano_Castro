package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import Clases.Menu;
import Clases.Pedido;
import static com.mycompany.proyecto_2p_sorianoalexander_romeropaul.IngresoSistemaController.usuarioIngreso;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author pdrb1
 */
public class PedidoController implements Initializable {
    static ArrayList<Menu> menulista = new ArrayList<>();
    static ArrayList<Pedido> pedidolista = new ArrayList<>();
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        menulista = leerMenu();
        comboTipo.getItems().addAll("Platos Fuertes","Postres","Piqueos","Bebidas");
        comboOrden.getItems().addAll("Precio","Nombre");
        
        
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
    private Label lblTotal;
    @FXML
    private Label lblIVA;
    @FXML
    private Label lblSubtotal;
    @FXML
    private HBox hsubtotal;
    @FXML
    private HBox htotal;
    @FXML
    private HBox hiva;
            
    
    @FXML
    public void limpiar(ActionEvent ae){
        gridOpciones.getChildren().clear();
        gridPedido.getChildren().clear();
        pedidolista.clear();
        
        
    }
    
    
    @FXML
    public void continuar(ActionEvent ae){
        //aqui se debe registrar el pedido
        registrarPedido(pedidolista);
        
    }
    
    
    @FXML
    public void elegirTipo(ActionEvent ae){
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
        gridOpciones.getChildren().clear();
        for(int i=0;i<menulista.size();i++){
            Menu m = menulista.get(i);
            
            if(menulista.get(i).getTipo().equals(tipo)){                
                //HBox seccDescripcion = new HBox();
                Label lbldescripcion = new Label(m.getDescripcion());
                //seccDescripcion.getChildren().add(lbldescripcion);

                //HBox seccPrecio = new HBox();
                Label lblprecio = new Label(String.valueOf(m.getPrecio()));
                //seccPrecio.getChildren().add(lblprecio);

                //HBox seccCant = new HBox();
                TextField cant = new TextField();
                //seccCant.getChildren().add(cant);

                //HBox seccAgre = new HBox();
                Button btnEscoger = new Button("Agregar");
                //seccDescripcion.getChildren().add(btnEscoger);
                
               btnEscoger.setOnMouseClicked(new EventHandler<MouseEvent>(){
                   
                    @Override
                    public void handle(MouseEvent t) {
                        Pedido p = new Pedido(m.getDescripcion(),usuarioIngreso.getNombreApellido(),Integer.parseInt(cant.getText()),m.getPrecio());
                        pedidolista.add(p);
                        mostrarPedidos();
                        
                    }
                   
               });
                
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
    
    public void mostrarPedidos(){
        double total = 0.0;
        
        for(int i = 0;i<pedidolista.size();i++){
            Label lbldesc = new Label(pedidolista.get(i).getDescripcion()); 
            Label lblcant = new Label(String.valueOf(pedidolista.get(i).getCantidad()));
            Label lblpre = new Label(String.valueOf(pedidolista.get(i).totalCant()));

            GridPane.setConstraints(lbldesc,0,i);
            GridPane.setConstraints(lblcant,1,i);
            GridPane.setConstraints(lblpre,2,i);

            gridPedido.getChildren().addAll(lbldesc,lblpre,lblcant);
        }    

        for(int j = 0;j<pedidolista.size();j++){
            double suma = pedidolista.get(j).totalCant();
            total += suma;


            double subtotalIVA = total + (total*0.14);
            lblSubtotal.setText(String.valueOf(total));
            lblIVA.setText("12%");
            lblTotal.setText(String.valueOf(subtotalIVA));

        }
        
    }
    
    // Metodo para crear Archivo de pedido formato(idPedido - nombre Cliente - Total)
    public void registrarPedido(ArrayList<Pedido> listaPedido){
        double valor = 0.0;
        
        for(Pedido p:listaPedido){           
            valor += p.getValor();
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Pedidos.txt"))){
            for(Pedido p:listaPedido){
                bw.write(p.getDescripcion() + "," + p.getNombreCliente() + "," + valor);
            }
            
        }catch(IOException ioe){
            System.out.println("Se ha registrado un error al registrar el pedido!");
            
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error de Registro");
            alerta.setHeaderText("No ha sido posible registrar este pedido");
            alerta.showAndWait();

        }
    }
    
    
    
    
}
