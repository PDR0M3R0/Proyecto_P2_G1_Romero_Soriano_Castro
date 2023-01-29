package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import static com.mycompany.proyecto_2p_sorianoalexander_romeropaul.PedidoController.totalUsuario;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class PagoController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private ToggleGroup grupo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //hola
    }

    @FXML
    private Button btnContinuar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private RadioButton rButtonEfectivo;

    @FXML
    private RadioButton rButtonTarjeta;

    @FXML
    private TextField txtDireccion;

    @FXML
    private VBox vBoxInteractive;
    @FXML
    private Button btnSalir;

    @FXML
    void Salir(ActionEvent event) {
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
            }
        } else if (opciones.get() == salir) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void continuar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MuchasGracias.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void limpiar(ActionEvent event) {

    }

    @FXML
    private void selecEfectivo(ActionEvent event) {
        vBoxInteractive.getChildren().clear();
        vBoxInteractive.setAlignment(Pos.CENTER_LEFT);
        Text texto = new Text();
        texto.setText("Tendrá que pagar un total de " + totalUsuario + " dólares.\nAsegúrese de tener el dinero completo por si el repartidor no tiene cambio.");
        vBoxInteractive.getChildren().add(texto);
    }

    @FXML
    private void selecTarjeta(ActionEvent event) {
        double nuevoTotal = (double) (Double.parseDouble(totalUsuario) + Double.parseDouble(totalUsuario) * 0.05);
        totalUsuario = String.format("%.2f", nuevoTotal);
        vBoxInteractive.getChildren().clear();
        vBoxInteractive.setAlignment(Pos.TOP_LEFT);
        GridPane gridpane = new GridPane();
        Label titular = new Label("Titular:");
        Label numero = new Label("Número:");
        Label caducidad = new Label("Caducidad:");
        Label cvv = new Label("CVV:");
        TextField t1 = new TextField();
        t1.setPrefWidth(300);
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();

        GridPane.setConstraints(titular, 0, 0);
        GridPane.setConstraints(t1, 1, 0);
        GridPane.setConstraints(numero, 0, 1);
        GridPane.setConstraints(t2, 1, 1);
        GridPane.setConstraints(caducidad, 0, 2);
        GridPane.setConstraints(t3, 1, 2);
        GridPane.setConstraints(cvv, 0, 3);
        GridPane.setConstraints(t4, 1, 3);

        gridpane.getChildren().addAll(titular, numero, caducidad, cvv, t1, t2, t3, t4);
        

        vBoxInteractive.getChildren().add(gridpane);
        Text texto = new Text();
        texto.setText("\nTendrá que pagar un total de " + totalUsuario + " dólares por el incremento del 5% por uso de la tarjeta");
        vBoxInteractive.getChildren().add(texto);
        
        double totalAnterior = (double) (Double.parseDouble(totalUsuario) - Double.parseDouble(totalUsuario) * 0.05);
        totalUsuario = String.format("%.2f", totalAnterior);

    }

}
