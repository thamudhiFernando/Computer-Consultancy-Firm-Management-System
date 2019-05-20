package ac.lk.iit.ComputerConsultancyFirmManagementSystem.controller;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.AdminBOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.AdminDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.other.Validation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegistrationControllerImpl implements Initializable {

    @FXML
    private AnchorPane idPane;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private JFXTextField txtUserID;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtUserPassword;

    @FXML
    private JFXTextField txtTelephone;

    @FXML
    private JFXTextField txtUserAddress;

    @FXML
    private ImageView imgGoBack;

    private AdminBOImpl adminBOImpl = BOFactory.getInstance().getBOTypes(BOTypes.ADMIN);

    public void initialize(URL location, ResourceBundle resources) {
        txtUserID.setStyle("-fx-text-fill:white");
        txtUserName.setStyle("-fx-text-fill:white");
        txtUserPassword.setStyle("-fx-text-fill:white");
        txtUserAddress.setStyle("-fx-text-fill:white");
        txtTelephone.setStyle("-fx-text-fill:white");

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), idPane);
        fadeIn.setFromValue(0.1);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void btnSignIn_OnMouseClicked(MouseEvent event) {
        String adminID = txtUserID.getText();
        String adminName = txtUserName.getText();
        String adminPassword = txtUserPassword.getText();
        String tel = txtTelephone.getText();
        String address = txtUserAddress.getText();

        boolean isFilled = checkFields();

        if (isFilled){
            System.out.println("success");

            try {
                List<AdminDTO> allAdmin = adminBOImpl.getAll();
                for (AdminDTO admins : allAdmin) {
                    System.out.println(admins.getAdminId());
                    if (adminID.equals(admins.getAdminId())){
                        new Alert(Alert.AlertType.WARNING, "This ID is Reserved", ButtonType.OK).showAndWait();
                        txtUserID.requestFocus();
                        return;
                    }
                }

                boolean isAdded = adminBOImpl.save(
                        new AdminDTO(adminID,
                                adminName,
                                adminPassword,
                                address,
                                tel));

                if (isAdded){
                    new Alert(Alert.AlertType.CONFIRMATION, "Admin has been Added successfully", ButtonType.OK).showAndWait();

                    Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/HomeLogin.fxml"));
                    Scene adminScene = new Scene(manageAdmin);

                    Stage adminStage = (Stage) btnRegister.getScene().getWindow();
                    adminStage.setScene(adminScene);
                }else {
                    new Alert(Alert.AlertType.ERROR, "Failed to save the Admin, try again", ButtonType.OK).showAndWait();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("-_-");
        }
    }

    @FXML
    void imgGoBack_OnMouseClicked(MouseEvent event) throws IOException {
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/HomeLogin.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) btnRegister.getScene().getWindow();
        adminStage.setScene(adminScene);
    }

    public boolean checkFields(){
        if (txtUserID.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Admin ID is empty", ButtonType.OK).showAndWait();
            txtUserID.requestFocus();
        }else if(txtUserName.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Admin Name is empty", ButtonType.OK).showAndWait();
            txtUserName.requestFocus();
        }else if (txtUserPassword.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Admin Password is empty", ButtonType.OK).showAndWait();
            txtUserPassword.requestFocus();
        }else if (txtUserAddress.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Address is empty", ButtonType.OK).showAndWait();
            txtUserAddress.requestFocus();
        }else if (txtTelephone.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Telephone is empty", ButtonType.OK).showAndWait();
            txtTelephone.requestFocus();
        }else if (!Validation.isInt(txtTelephone.getText())){
            new Alert(Alert.AlertType.ERROR, "Invalid Telephone", ButtonType.OK).showAndWait();
            txtTelephone.requestFocus();
        }else if (!Validation.isAlpha(txtUserName.getText())){
            new Alert(Alert.AlertType.ERROR, "Dont use numeric characters - Admin Name", ButtonType.OK).showAndWait();
            txtUserName.requestFocus();
        }else if (txtTelephone.getText().trim().length() != 10){
            new Alert(Alert.AlertType.ERROR, "You must enter 10 characters", ButtonType.OK).showAndWait();
            txtTelephone.requestFocus();
        } else {
            return true;
        }
        return false;
    }
}
