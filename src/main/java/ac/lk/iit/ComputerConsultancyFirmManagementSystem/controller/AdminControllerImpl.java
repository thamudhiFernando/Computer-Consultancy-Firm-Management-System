package ac.lk.iit.ComputerConsultancyFirmManagementSystem.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminControllerImpl implements Initializable {

    @FXML
    private Label lblMakeEmployeeSalary;

    @FXML
    private Label btnMakeContract;

    @FXML
    private Label btnManageEmployees;

    @FXML
    private Label lblAddEmployee;

    @FXML
    private Label btnManageCustomers;

    @FXML
    private Label btnViewContracts;

    @FXML
    private ImageView imgLogOut;


    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    void lblAddEmployee_OnMouseClicked(MouseEvent event) throws IOException {
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/AddEmployee.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) lblAddEmployee.getScene().getWindow();
        adminStage.setScene(adminScene);
    }

    @FXML
    void lblMakeEmployeeSalary_OnMouseClicked(MouseEvent event) throws IOException {
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/SettleEmployeeSalary.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) lblAddEmployee.getScene().getWindow();
        adminStage.setScene(adminScene);
    }

    @FXML
    void btnMakeContract_OnMouseClicked(MouseEvent event) throws IOException {
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/Contract.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) lblAddEmployee.getScene().getWindow();
        adminStage.setScene(adminScene);
    }

    @FXML
    void btnManageCustomers_OnMouseClicked(MouseEvent event) throws IOException {
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/ManageCustomer.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) lblAddEmployee.getScene().getWindow();
        adminStage.setScene(adminScene);
    }

    @FXML
    void btnManageEmployees_OnMouseClicked(MouseEvent event) throws IOException {
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/ManageEmployee.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) lblAddEmployee.getScene().getWindow();
        adminStage.setScene(adminScene);
    }

    @FXML
    void btnViewContracts_OnMouseClicked(MouseEvent event) throws IOException {
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/ManageContract.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) lblAddEmployee.getScene().getWindow();
        adminStage.setScene(adminScene);
    }

    @FXML
    void imgLogOut_OnMouseClicked(MouseEvent event) throws IOException {
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/HomeLogin.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) lblAddEmployee.getScene().getWindow();
        adminStage.setScene(adminScene);
    }

}
