package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import Clases.Usuario;
import static com.mycompany.proyecto_2p_sorianoalexander_romeropaul.Principal.escena;
import static com.mycompany.proyecto_2p_sorianoalexander_romeropaul.Principal.pathFXML;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pdrb1
 */
public class IngresoSistemaController implements Initializable {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static Usuario usuarioIngreso;
    private Stage stage;
    private Scene scene;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        leerUsuarios();

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

    
    //Metodos del controlador: 
    @FXML
    public void ingresar(ActionEvent ae) throws IOException {
        String usuario = txtUsuario.getText();
        String contrasena = txtContrasena.getText();
        boolean pase = verificacionUsuario(usuario, contrasena);

        if ( pase == true) {
            System.out.println("ingreso");
            cambioVista(ae);
        } else {
            System.out.println("No funciona metodo ingresar");
        }
    }

    public void cambioVista(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OpcionesCliente.fxml"));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public boolean verificacionUsuario(String usuario, String contrasena) {
        
        for (Usuario usu : usuarios) {
            
            if (usu.getUsuario().equals(usuario) && usu.getContrasena().equals(contrasena)) {
                usuarioIngreso = usu;
                return true;

            } else if (usu.getUsuario().equals(usuario) || usu.getContrasena().equals(contrasena)) {
                txtUsuario.setText("");  
                txtContrasena.setText("");
                
                Alert alerta = new Alert(AlertType.WARNING);
                alerta.setTitle("Intentelo nuevamente!");
                alerta.setHeaderText("Los datos ingresados son incorrectos");
                alerta.showAndWait();
                
                return false;
                 
                    
            }
    }
    return false;    
  }  
    
    public void leerUsuarios(){
        ArrayList<String[]> parametros = new ArrayList<>();
        
        try ( BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                
                String[] pr = linea.split(",");
                
                String u = pr[0];
                String c = pr[1];
                String nombreApellidos = pr[2];
                
                Usuario uu = new Usuario(u,c,nombreApellidos);
                usuarios.add(uu);
                
            }

        } catch (IOException ioe) {
            System.out.println("Ha ocurrido un error!");

        }
    }
  
}

