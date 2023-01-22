package com.mycompany.proyecto_2p_sorianoalexander_romeropaul;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pdrb1
 */
public class Principal extends Application{
    public static Scene escena;
    public static String pathFXML = "src/main/resources/com/mycompany/proyecto_2p_sorianoalexander_romeropaul/";
    
    @Override
    public void start(Stage s) throws Exception{
        
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("IngresoSistema.fxml"));
        
        Parent root = fxmlloader.load();
        escena = new Scene(root,600,600);
        s.setScene(escena);
        s.setTitle("The Good Burguer Restaurant");
        s.show();
        
    }
    
    public static void main(String[] args){
        launch();
        
    }
    
    
}
