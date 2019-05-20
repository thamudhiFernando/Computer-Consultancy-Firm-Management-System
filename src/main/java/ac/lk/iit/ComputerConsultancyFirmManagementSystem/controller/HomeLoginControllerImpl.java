package ac.lk.iit.ComputerConsultancyFirmManagementSystem.controller;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.AdminBOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.AdminDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HomeLoginControllerImpl implements Initializable {

    @FXML
    private AnchorPane idPane;

    @FXML
    private JFXButton btnRegistration;

    @FXML
    private JFXPasswordField txtLoginUserPassword;

    @FXML
    private JFXButton btnSignIn;

    @FXML
    private JFXTextField txtLoginUserName;

    private AdminBOImpl adminBOImpl = BOFactory.getInstance().getBOTypes(BOTypes.ADMIN);

    public void initialize(URL location, ResourceBundle resources) {
        txtLoginUserName.requestFocus();
        txtLoginUserName.setStyle("-fx-text-fill:white");
        txtLoginUserPassword.setStyle("-fx-text-fill:white");
        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), idPane);
        fadeIn.setFromValue(0.1);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void btnRegistration_OnMouseClicked(MouseEvent event) throws IOException {
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/RegistrationForm.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) btnRegistration.getScene().getWindow();
        adminStage.setScene(adminScene);
    }

    @FXML
    void btnSignIn_OnMouseClicked(MouseEvent event) throws IOException {
        String adminName = txtLoginUserName.getText();
        String adminPassword = txtLoginUserPassword.getText();
        boolean isNotFind = true;
        boolean isFilled = checkFields();

        try {
            if (isFilled){
                List<AdminDTO> allAdmin = adminBOImpl.getAll();
                for (AdminDTO admins : allAdmin) {
                    if (adminName.equals(admins.getAdminName())){
                        if (adminPassword.equals(admins.getAdminPassword())){
                            isNotFind = false;
                            new Alert(Alert.AlertType.CONFIRMATION, "Welcome to Administrator !", ButtonType.OK).showAndWait();
                            Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/Admin.fxml"));
                            Scene adminScene = new Scene(manageAdmin);

                            Stage adminStage = (Stage) btnRegistration.getScene().getWindow();
                            adminStage.setScene(adminScene);
                        }else {
                            new Alert(Alert.AlertType.ERROR, "Incorrect Password !", ButtonType.OK).showAndWait();
                            txtLoginUserPassword.requestFocus();
                            return;
                        }
                    }
                }

                if (isNotFind){
                    new Alert(Alert.AlertType.ERROR, "UserName is Not Found !", ButtonType.OK).showAndWait();
                    txtLoginUserName.requestFocus();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean checkFields(){
        if(txtLoginUserName.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Admin Name is empty", ButtonType.OK).showAndWait();
            txtLoginUserName.requestFocus();
        }else if (txtLoginUserPassword.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Admin Password is empty", ButtonType.OK).showAndWait();
            txtLoginUserPassword.requestFocus();
        }else {
            return true;
        }

        return false;
    }
}
