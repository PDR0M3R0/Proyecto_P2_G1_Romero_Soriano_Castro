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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pdrb1
 */

public class PedidoController implements Initializable {
    //Listas estaticas donde se alojaran los objetos correspodientes:
    static ArrayList<Menu> menulista = new ArrayList<>();
    static ArrayList<Pedido> pedidolista = new ArrayList<>();
    
    //Varaibles para abrir la siguiente escena:
    private Stage stage;
    private Scene scene;
    
    //Variable donde se guardar el nombre del usuario que ha ingresado:
    public static double totalUsuario;
    
  
    //Variables de la escena a utilizar:
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
    private Button btnSalir;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Se carga la lista estatica del menu:
        menulista = leerMenu();
        
        //Se rellenan los comboBox resectivos:
        comboTipo.getItems().addAll("Platos Fuertes", "Postres", "Piqueos", "Bebidas");
        comboOrden.getItems().addAll("Precio", "Nombre");

    }

    

    //Metodo que se usara ara poder regrsar o salir de la aplicacion:
    @FXML
    public void Salir(ActionEvent event) {
        ButtonType menu = new ButtonType("Menú");
        ButtonType salir = new ButtonType("Salir");
        ButtonType cancelar = new ButtonType("Cancelar");
        
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "Elija una opcion", menu, salir, cancelar);
        alerta.setHeaderText("Esta segur@ que quiere salir?");
        Optional<ButtonType> opciones = alerta.showAndWait();
        
        if (opciones.get() == menu) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("OpcionesCliente.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                
            } catch (IOException ex) {
                System.out.println("Se no se ha podido ejecutar este evento!");
                
            }
            
        } else if (opciones.get() == salir) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            
        }
    }
    
    
    
    //Metodo que se encarga de limpiar los gridpane pero tamvien los pedidos realizados en acumlativo
    @FXML
    public void limpiar(ActionEvent ae) {
        gridOpciones.getChildren().clear();
        gridPedido.getChildren().clear();
        pedidolista.clear();
        
        lblTotal.setText("0.0");
        lblSubtotal.setText("0.0");
        
        

    }

    
    
    //Aqui se carga la siguiente lista para proseguir con el pago del pedido:
    @FXML
    public void continuar(ActionEvent ae) throws IOException {
        //aqui se debe registrar el pedido
        registrarPedido(pedidolista);

        Parent root = FXMLLoader.load(getClass().getResource("Pago.fxml"));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    
    
    
    //Este metodo se encarga clasificar y mostrar en el gridpane, las opociones segun la clasificacion seleccionada:
    @FXML
    public void elegirTipo(ActionEvent ae) {
        String opcion = comboTipo.getValue();

        if (opcion.equals("Platos Fuertes")) {
            String tipo = "F";
            
            Thread hilo1 = new Thread(new Runnable(){
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
            
            hilo1.start();

        } else if (opcion.equals("Piqueos")) {
            String tipo = "Q";
            
            Thread hilo2 = new Thread(new Runnable(){
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
            
            hilo2.start();

        } else if (opcion.equals("Postres")) {
            String tipo = "P";
           
            Thread hilo3 = new Thread(new Runnable(){
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
            
            hilo3.start();

        } else if (opcion.equals("Bebidas")) {
            String tipo = "B";
            
            Thread hilo4 = new Thread(new Runnable(){
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
            
            hilo4.start();
        }
    }

    
    
    //Aqui te muestra las opcione del menu segun la clasificaion seleccionada en el combobox:
    public void mostrarEnGridPane(String tipo) {
        gridOpciones.getChildren().clear();
        
        for (int i = 0; i < menulista.size(); i++) {
            Menu m = menulista.get(i);

            if (menulista.get(i).getTipo().equals(tipo)) {
                Label lbldescripcion = new Label(m.getDescripcion());
                Label lblprecio = new Label(String.valueOf(m.getPrecio()));
                TextField cant = new TextField();
                Button btnEscoger = new Button("Agregar");
                btnEscoger.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        Pedido p = new Pedido(m.getDescripcion(), usuarioIngreso.getNombreApellido(), Integer.parseInt(cant.getText()), m.getPrecio());
                        pedidolista.add(p);
                        mostrarPedidos();

                    }
                });

                //Para anadir 4 columnas
                GridPane.setConstraints(lbldescripcion, 0, i);
                GridPane.setConstraints(lblprecio, 1, i);
                GridPane.setConstraints(cant, 2, i);
                GridPane.setConstraints(btnEscoger, 3, i);

                gridOpciones.getChildren().addAll(lbldescripcion, lblprecio, cant, btnEscoger);

            }
        }
    }
    
    
    
    //Este metodo se encarga de ordenar el gridpane deediendo de si el usuario quiere ordenarlas por precio o por nombre: 
    @FXML
    public void ordenarPor(ActionEvent ae) {
        String tipoOrden = comboOrden.getValue();
        gridPedido.getChildren().clear();
        
        Thread hiloOrden = new Thread(new Runnable(){            
            @Override
            public void run(){
                Platform.runLater(new Runnable(){        
                @Override
                public void run(){
                    if(tipoOrden.equals("Precio")){
                        Collections.sort(pedidolista, new Comparator<Pedido>(){
                            public int compare(Pedido p1,Pedido p2){
                                return Double.compare(p1.totalCant(),p2.totalCant());

                            }
                        });
                        mostrarPedidos();

                    }else if(tipoOrden.equals("Nombre")){
                        Collections.sort(pedidolista, new Comparator<Pedido>(){
                            public int compare(Pedido p1,Pedido p2){
                                return p1.getDescripcion().compareTo(p2.getDescripcion());

                            }
                        });    
                        mostrarPedidos();
                    }  
                }
                });
            }    
        });
        
        hiloOrden.start();
    }
    
    
    
    //Este metodo retorna una lista de las opciones que existen en em menu:
    public ArrayList<Menu> leerMenu() {
        ArrayList<Menu> menulista = new ArrayList<>();

        try ( BufferedReader br = new BufferedReader(new FileReader("menu.txt",StandardCharsets.UTF_8))) {
            String linea;
            linea = br.readLine();//salto de linea

            while ((linea = br.readLine()) != null) {
                String[] parametros = linea.split(",");

                Menu menu = new Menu(parametros[0], Double.parseDouble(parametros[1]), parametros[2]);
                menulista.add(menu);
                
            }

        } catch (IOException ioe) {
            System.out.println("No se ha podido ingresar al documento menu");
            
        }
        return menulista;
         
    }
    
    
    
    //Este metod se muentra los pedido que ha agregado el usuario al gridpane de pedidos:
    public void mostrarPedidos() {
        double total = 0.0;

        for (int i = 0; i < pedidolista.size(); i++) {
            Label lbldesc = new Label(pedidolista.get(i).getDescripcion());
            Label lblcant = new Label(String.valueOf(pedidolista.get(i).getCantidad()));
            Label lblpre = new Label(String.valueOf(pedidolista.get(i).totalCant()));

            GridPane.setConstraints(lbldesc, 0, i);
            GridPane.setConstraints(lblcant, 1, i);
            GridPane.setConstraints(lblpre, 2, i);

            gridPedido.getChildren().addAll(lbldesc, lblpre, lblcant);
            
        }

        for (int j = 0; j < pedidolista.size(); j++) {
            double suma = pedidolista.get(j).totalCant();
            total += (double)Math.round(suma*100.0)/100.0;

            double subtotalIVA = total + (total * 0.14);
            lblSubtotal.setText(String.valueOf(total));
            lblIVA.setText("12%");
            lblTotal.setText(String.valueOf(subtotalIVA));
            totalUsuario = subtotalIVA;

        }
    }
    
    
    
    // Metodo para crear Archivo de pedido formato(idPedido - nombre Cliente - Total):
    public void registrarPedido(ArrayList<Pedido> pedidolista) {
        double valor = 0.0;

        for(Pedido p:pedidolista){
          valor += p.totalCant();
          
        }

        try(ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("Pedidos_Serializados"))){
          obj.writeObject(pedidolista);

        }catch(Exception ee){
          System.out.println("Ha ocurrido un problema con la serializacion");
          ee.printStackTrace();

          Alert alerta = new Alert(Alert.AlertType.ERROR);
          alerta.setTitle("Error de Registro");
          alerta.setHeaderText("No ha sido posible registrar este pedido");
          alerta.showAndWait();  

             
        } 
    }
}
