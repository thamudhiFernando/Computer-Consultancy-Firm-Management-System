package ac.lk.iit.ComputerConsultancyFirmManagementSystem.controller;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.EmployeeBOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.PositionBOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.EmployeeDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.PositionDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.other.Validation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddEmployeeControllerImpl implements Initializable {

    @FXML
    private JFXTextField txtNIC;

    @FXML
    private JFXTextField txtEmployeeName;

    @FXML
    private JFXTextField txtTelephone;

    @FXML
    private JFXTextField txtUserAddress;

    @FXML
    private JFXButton btnAddEmployee;

    @FXML
    private JFXTextField txtEmployeeID;

    @FXML
    private JFXComboBox comboPositions;

    @FXML
    private ImageView imgGoBack;

    private EmployeeBOImpl employeeBOImpl = BOFactory.getInstance().getBOTypes(BOTypes.EMPLOYEE);
    private PositionBOImpl positionBOImpl = BOFactory.getInstance().getBOTypes(BOTypes.POSITIONS);


    public void initialize(URL location, ResourceBundle resources) {
        loadPostions();
    }

    @FXML
    void btnAddEmployee_OnMouseClicked(MouseEvent event) {
        String empID = txtEmployeeID.getText();
        String empType = (String) comboPositions.getValue();
        String empNIC = txtNIC.getText();
        String empName = txtEmployeeName.getText();
        String empTel = txtTelephone.getText();
        String empAddress = txtUserAddress.getText();

        boolean isFilled = checkFields();


        if (isFilled){
            System.out.println("success");

            try {
                List<EmployeeDTO> allEmployeeList = employeeBOImpl.getAll();

                for (EmployeeDTO employees : allEmployeeList) {
                    System.out.println(employees.getEmployeeId());
                    if (empID.equals(employees.getEmployeeId())){
                        new Alert(Alert.AlertType.WARNING, "This ID is Reserved", ButtonType.OK).showAndWait();
                        txtEmployeeID.requestFocus();
                        return;
                    }else if(empNIC.equals(employees.getEmployeeNIC())){
                        new Alert(Alert.AlertType.WARNING, "This Employee is Added Before", ButtonType.OK).showAndWait();
                        txtNIC.requestFocus();
                        return;
                    }
                }

                boolean isAdded = employeeBOImpl.save(
                        new EmployeeDTO(empID,
                                empType,
                                empNIC,
                                empName,
                                empAddress,
                                empTel));

                if (isAdded){
                    new Alert(Alert.AlertType.CONFIRMATION, "Employee has been Added successfully ", ButtonType.OK).showAndWait();

                    Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/AddEmployee.fxml"));
                    Scene adminScene = new Scene(manageAdmin);

                    Stage adminStage = (Stage) btnAddEmployee.getScene().getWindow();
                    adminStage.setScene(adminScene);
                }else {
                    new Alert(Alert.AlertType.ERROR, "Failed to save the Employee, try again", ButtonType.OK).showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("-_-");

        }
    }

    @FXML
    void comboCompanies_OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void imgGoBack_OnMouseClicked(MouseEvent event) throws IOException {
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/Admin.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) btnAddEmployee.getScene().getWindow();
        adminStage.setScene(adminScene);
    }

    public boolean checkFields(){
        System.out.println(comboPositions.getValue());
        if (txtEmployeeID.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Employee ID is empty", ButtonType.OK).showAndWait();
            txtEmployeeID.requestFocus();
        }else if(comboPositions.getValue() == null){
            new Alert(Alert.AlertType.ERROR, "Select a Postion", ButtonType.OK).showAndWait();
            comboPositions.requestFocus();
            return false;
        }else if (txtNIC.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Employee NIC is empty", ButtonType.OK).showAndWait();
            txtNIC.requestFocus();
        }else if (txtEmployeeName.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Employee Name is empty", ButtonType.OK).showAndWait();
            txtEmployeeName.requestFocus();
        }else if (txtTelephone.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Employee Telephone is empty", ButtonType.OK).showAndWait();
            txtTelephone.requestFocus();
        }else if (txtUserAddress.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Employee Address is empty", ButtonType.OK).showAndWait();
            txtUserAddress.requestFocus();
        }else if (!Validation.isInt(txtTelephone.getText())){
            new Alert(Alert.AlertType.ERROR, "Invalid Telephone", ButtonType.OK).showAndWait();
            txtTelephone.requestFocus();
        }else if (txtTelephone.getText().trim().length() != 10){
            new Alert(Alert.AlertType.ERROR, "You must enter 10 characters", ButtonType.OK).showAndWait();
            txtTelephone.requestFocus();
        }else if (!Validation.isAlpha(txtEmployeeName.getText())){
            new Alert(Alert.AlertType.ERROR, "Dont use numeric characters - Employee Name", ButtonType.OK).showAndWait();
            txtEmployeeName.requestFocus();
        }else if (txtNIC.getText().trim().length() != 10){
            new Alert(Alert.AlertType.ERROR, "Invalid NIC - It should 123456789V", ButtonType.OK).showAndWait();
            txtNIC.requestFocus();
        }else {
            return true;
        }

        return false;
    }

    private void loadPostions(){
        try {
            List<PositionDTO> allPositionList = positionBOImpl.getAll();

            for (PositionDTO positions : allPositionList) {
                String posName = positions.getPositionsType();
                comboPositions.getItems().addAll(posName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
