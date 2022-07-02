package ba.sum.fpmoz.pjavaprojektauto.controller;

import ba.sum.fpmoz.pjavaprojektauto.Program;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class IntroController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void userAdministration (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "user-view.fxml", "Administracija korisnika");
    }

    @FXML
    protected void vratise(ActionEvent evt) {
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swappScene(stage, "customers-view.fxml", "Uredi listu kupaca");
    }
}