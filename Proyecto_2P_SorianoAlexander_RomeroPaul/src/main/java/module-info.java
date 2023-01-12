module com.mycompany.proyecto_2p_sorianoalexander_romeropaul {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyecto_2p_sorianoalexander_romeropaul to javafx.fxml;
    exports com.mycompany.proyecto_2p_sorianoalexander_romeropaul;
}
