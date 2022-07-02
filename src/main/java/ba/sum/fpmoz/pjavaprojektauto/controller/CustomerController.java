package ba.sum.fpmoz.pjavaprojektauto.controller;

import ba.sum.fpmoz.pjavaprojektauto.Program;
import ba.sum.fpmoz.pjavaprojektauto.model.Customers;
import ba.sum.fpmoz.pjavaprojektauto.model.Table;
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

public class CustomerController implements Initializable {
    @FXML
    protected void vratise(ActionEvent evt) {
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swappScene(stage, "intro-view.fxml", "Uredi listu kupaca");
    }

    @FXML
    TextField nameTXT;

    @FXML
    TextField lastnameTXT;

    @FXML
    TextField uidTXT;

    @FXML
    TextField emailTXT;

    @FXML
    TextField adressTXT;

    @FXML
    TextField phoneTXT;


    @FXML
    TableColumn tablecolumnnID;

    @FXML
    TableColumn tablecolumnnname;

    @FXML
    TableColumn tablecolumnnlastname;

    @FXML
    TableColumn tablecolumnnuid;

    @FXML
    TableColumn tablecolumnnemail;


    @FXML
    TableColumn tablecolumnnadress;
    @FXML
    TableColumn tablecolumnnphone;

    @FXML
    TableView tableviewwcustomers;

    @FXML
    Button deletebutton;

    Customers selectedCustomer;

    @FXML
    protected void selectcustomer() {
        this.selectedCustomer = (Customers) this.tableviewwcustomers.getSelectionModel().getSelectedItem();
        this.deletebutton.setDisable(false);
        this.nameTXT.setText(this.selectedCustomer.getName());
        this.lastnameTXT.setText(this.selectedCustomer.getLastname());
        this.uidTXT.setText(this.selectedCustomer.getUid());
        this.emailTXT.setText(this.selectedCustomer.getEmail());
        this.adressTXT.setText(this.selectedCustomer.getAdress());
        this.phoneTXT.setText(this.selectedCustomer.getPhone());
    }

    @FXML
    protected void deletecustomer() throws Exception {
        if (this.selectedCustomer != null) {
            this.selectedCustomer.delete();
            this.fillCustomers();
        }
    }

    @FXML
    protected void saveCustomer() throws Exception {
        if (this.selectedCustomer == null) {
            Customers newCustomer = new Customers();
            newCustomer.setName(this.nameTXT.getText());
            newCustomer.setLastname(this.lastnameTXT.getText());
            newCustomer.setUid(this.uidTXT.getText());
            newCustomer.setEmail(this.emailTXT.getText());
            newCustomer.setAdress(this.adressTXT.getText());
            newCustomer.setPhone(this.phoneTXT.getText());
            newCustomer.save();
        } else {
            this.selectedCustomer.setName(this.nameTXT.getText());
            this.selectedCustomer.setLastname(this.lastnameTXT.getText());
            this.selectedCustomer.setUid(this.uidTXT.getText());
            this.selectedCustomer.setEmail(this.emailTXT.getText());
            this.selectedCustomer.setAdress(this.adressTXT.getText());
            this.selectedCustomer.setPhone(this.phoneTXT.getText());
            this.selectedCustomer.update();
            this.selectedCustomer = null;
        }
        this.fillCustomers();
        this.nameTXT.setText("");
        this.lastnameTXT.setText("");
        this.uidTXT.setText("");
        this.emailTXT.setText("");
        this.adressTXT.setText("");
        this.phoneTXT.setText("");
    }

    private void fillCustomers() {
        try {
            ObservableList<?> customers = FXCollections.observableList(Table.list(Customers.class));
            this.tableviewwcustomers.setItems(customers);
        } catch (Exception e) {
            System.out.println("Nastala je greška: " + e.getMessage());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tablecolumnnID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        this.tablecolumnnname.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.tablecolumnnlastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        this.tablecolumnnuid.setCellValueFactory(new PropertyValueFactory<>("uid"));
        this.tablecolumnnemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.tablecolumnnadress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        this.tablecolumnnphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        this.fillCustomers();
    }
}

