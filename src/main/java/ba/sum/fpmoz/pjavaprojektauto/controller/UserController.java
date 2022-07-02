package ba.sum.fpmoz.pjavaprojektauto.controller;

import ba.sum.fpmoz.pjavaprojektauto.Program;
import ba.sum.fpmoz.pjavaprojektauto.model.Table;
import ba.sum.fpmoz.pjavaprojektauto.model.Workers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @FXML
    protected void returnback (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "intro-view.fxml", "Pocetna stranica");
    }

    @FXML
    TextField nameTxt;

    @FXML
    TextField lastnameTxt;

    @FXML
    TextField uidTxt;

    @FXML
    TextField emailTxt;

    @FXML
    TextField phoneTxt;

    @FXML
    TextField incomeTxt;

    @FXML
    TableColumn tablecolumnID;

    @FXML
    TableColumn tablecolumnname;

    @FXML
    TableColumn tablecolumnlastname;

    @FXML
    TableColumn tablecolumnuid;

    @FXML
    TableColumn tablecolumnemail;

    @FXML
    TableColumn tablecolumnphone;

    @FXML
    TableColumn tablecolumnincome;

    @FXML
    TableView tableviewworkers;

    @FXML
    Button deletebtn;

    Workers selectedWorker;

    @FXML
    protected void selectworker (){
        this.selectedWorker = (Workers) this.tableviewworkers.getSelectionModel().getSelectedItem();
        this.deletebtn.setDisable(false);
        this.nameTxt.setText(this.selectedWorker.getName());
        this.lastnameTxt.setText(this.selectedWorker.getLastname());
        this.uidTxt.setText(this.selectedWorker.getUid());
        this.emailTxt.setText(this.selectedWorker.getEmail());
        this.phoneTxt.setText(this.selectedWorker.getPhone());
        this.incomeTxt.setText(this.selectedWorker.getIncome());
    }

    @FXML
    protected void deleteworker () throws Exception {
        if (this.selectedWorker != null){
            this.selectedWorker.delete();
            this.fillUsers();
        }
    }

    @FXML
    protected void saveUser () throws Exception {
        if (this.selectedWorker == null) {
            Workers newWorker = new Workers();
            newWorker.setName(this.nameTxt.getText());
            newWorker.setLastname(this.lastnameTxt.getText());
            newWorker.setUid(this.uidTxt.getText());
            newWorker.setEmail(this.emailTxt.getText());
            newWorker.setPhone(this.phoneTxt.getText());
            newWorker.setIncome(this.incomeTxt.getText());
            newWorker.save();
        } else {
            this.selectedWorker.setName(this.nameTxt.getText());
            this.selectedWorker.setLastname(this.lastnameTxt.getText());
            this.selectedWorker.setUid(this.uidTxt.getText());
            this.selectedWorker.setEmail(this.emailTxt.getText());
            this.selectedWorker.setPhone(this.phoneTxt.getText());
            this.selectedWorker.setIncome(this.incomeTxt.getText());
            this.selectedWorker.update();
            this.selectedWorker = null;
        }
        this.fillUsers();
        this.nameTxt.setText("");
        this.lastnameTxt.setText("");
        this.uidTxt.setText("");
        this.emailTxt.setText("");
        this.phoneTxt.setText("");
        this.incomeTxt.setText("");
    }

    private void fillUsers (){
        try {
            ObservableList<?> users = FXCollections.observableList(Table.list(Workers.class));
            this.tableviewworkers.setItems(users);
        } catch (Exception e) {
            System.out.println("Nastala je greška: " + e.getMessage());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tablecolumnID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        this.tablecolumnname.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.tablecolumnlastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        this.tablecolumnuid.setCellValueFactory(new PropertyValueFactory<>("uid"));
        this.tablecolumnemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.tablecolumnphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        this.tablecolumnincome.setCellValueFactory(new PropertyValueFactory<>("income"));
        this.fillUsers();
    }
}