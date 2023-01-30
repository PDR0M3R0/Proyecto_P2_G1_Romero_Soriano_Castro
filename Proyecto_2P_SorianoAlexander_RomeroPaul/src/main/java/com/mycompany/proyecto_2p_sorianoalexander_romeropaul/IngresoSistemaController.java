package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import Clases.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



/**
 * FXML Controller class -- Esta clase se encarga de gestionar el ingreso dentro de la aplicacion
 * @author pdrb1
 * 
 */



public class IngresoSistemaController implements Initializable {
    //Listas estaticas donde se alojaran los objetos creados de sus respesctiva lectura de arhivos:
    public static ArrayList<Usuario> usuarios;
    public static Usuario usuarioIngreso;
    
    //Variables necesarias para hacer el cambio de escena:
    private Stage stage;
    private Scene scene;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarios = leerUsuarios();
        
        for(Usuario u: usuarios){
            System.out.println(u.getUsuario());
            System.out.println(u.getContrasena());
        }
    }
    
   
    @FXML
    private ImageView seccionView1;
    @FXML
    private ImageView seccionView2;
    @FXML
    private Button btnIngresar;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtContrasena;

    
    
    /**
     * Metodos que invocara a los demas metodos para verificar si el usuario se encuentr registrado para usar la aplicacion
     * @param ae Evento atrapado por la accion de un boton con este metodo
     * 
    **/
    @FXML
    public void ingresar(ActionEvent ae) throws IOException {
        String u = txtUsuario.getText();
        String c = txtContrasena.getText();
        
        verificacionUsuario(u,c,ae);
    }
    
    
    /**
      *Este metodo que se usar para la validacion del usuario y apertura de la nueva escena
      * @param u String se recibe el usuario que ha ingresado en el textfiled
      * @param c String se recibe la contrasena que ha ingresado en el textfield
      * @param ae ActionEvent se recibe del metodo ingresar para usarlo en el metodo cambiovista()
      * 
    **/
    public void verificacionUsuario(String u, String c,ActionEvent ae) {
        for(Usuario usu:usuarios){
            
            if ((usu.getUsuario().equals(u) == true) && (usu.getContrasena().equals(c) == true)){
                //Esta variable nos permitira usar el nombre del cliente en otros metodos por ende se lo guarda en esta variable
                usuarioIngreso = usu;
                
                try {
                    cambioVista(ae);
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                    
                }

            }else if ((usu.getUsuario().equals(u) == true) && (usu.getContrasena().equals(c) == false)){
                txtContrasena.setText("");

                Alert alerta = new Alert(AlertType.WARNING);
                alerta.setTitle("Intentelo nuevamente!");
                alerta.setHeaderText("Su contrasena es incorrecta!");
                alerta.showAndWait();

            }else if ((usu.getUsuario().equals(u) == false) && (usu.getContrasena().equals(c) == true)){
                txtUsuario.setText("");

                Alert alerta = new Alert(AlertType.WARNING);
                alerta.setTitle("Intentelo nuevamente!");
                alerta.setHeaderText("El usuario no esta registrado!");
                alerta.showAndWait();

            }
        }    
    }  
    
    
    /**
    *Este metodo se encarga de devolver una lista de usuarios ara su posterior verificacion:
    *@return Un ArrayList del tipo Usuario que servira para setearlas en la lista de menu estatica
    * 
    **/ 
    public ArrayList<Usuario> leerUsuarios(){
        ArrayList<Usuario> usuarioslistas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] pr = linea.split(",");
                
                String u = pr[0];
                String c = pr[1];
                String nombreApellidos = pr[2];
                
                Usuario uu = new Usuario(u,c,nombreApellidos);
                System.out.println(uu);
                usuarioslistas.add(uu);

            }

        } catch (IOException ioe) {
            System.out.println("Ha ocurrido un error!");

        }
        return usuarioslistas;
        
    }
    
    
    /**
    *Este metodo permite cambiar de escena conservando la misma ventana:
    * @param ae que recibe tras apuchar el boton de ingreso
    * 
    **/
    public void cambioVista(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OpcionesCliente.fxml"));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    
    
}

