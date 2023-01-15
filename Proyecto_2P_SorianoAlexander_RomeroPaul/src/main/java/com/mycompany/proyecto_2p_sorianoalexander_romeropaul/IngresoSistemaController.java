package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
    private Stage stage;
    private Scene scene;
    private Parent root;

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

        if (verificacionUsuario(usuario, contrasena) == true) {
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
        ArrayList<String[]> parametros = new ArrayList<>();

        try ( BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                String[] pr = linea.split(",");
                parametros.add(pr);

            }

        } catch (IOException ioe) {
            System.out.println("Ha ocurrido un error!");

        }

        for (String[] s : parametros) {
            System.out.println("Entro al for");
            String u = s[0];
            String c = s[1];

            if (usuario.equals(u) || contrasena.equals(c)) {
                return true;
            } 
        }
        return false;
    }
}
