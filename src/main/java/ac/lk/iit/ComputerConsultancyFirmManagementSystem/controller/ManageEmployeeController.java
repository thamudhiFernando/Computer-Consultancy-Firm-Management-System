package ac.lk.iit.ComputerConsultancyFirmManagementSystem.controller;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.EmployeeBOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.EmployeeDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.other.Validation;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.tablemodel.EmployeeTableModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ManageEmployeeController implements Initializable {


    @FXML
    private JFXButton btnUpdate;

    @FXML
    private ImageView imgGoBack;

    @FXML
    private JFXTextField txtTelephone;

    @FXML
    private JFXTextField txtEmployeeAddress;

    @FXML
    private TableView<EmployeeTableModel> tblEmployee;

    @FXML
    private TableColumn tblClmEmployeeID;

    @FXML
    private TableColumn tblClmEmployeeType;

    @FXML
    private TableColumn tblClmEmployeeName;

    @FXML
    private TableColumn tblClmNIC;

    @FXML
    private TableColumn tblClmAddress;

    @FXML
    private TableColumn tblClmTelephone;

    ObservableList<EmployeeTableModel> employees = FXCollections.observableArrayList();
    private EmployeeBOImpl employeeBOImpl = BOFactory.getInstance().getBOTypes(BOTypes.EMPLOYEE);

    public void initialize(URL location, ResourceBundle resources) {
        loadEmployees();

        tblEmployee.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<EmployeeTableModel>() {
                    @Override
                    public void changed(ObservableValue<? extends EmployeeTableModel> observable, EmployeeTableModel oldValue, EmployeeTableModel newValue) {
                        if (newValue != null){
                            txtTelephone.setText(newValue.getEmployeeContact());
                            txtEmployeeAddress.setText(newValue.getEmployeeAddress());
                        }else {
                            return;
                        }
                    }
                });
    }

    @FXML
    void btnUpdate_OnMouseClicked(MouseEvent event) {
        EmployeeTableModel etmodel =(EmployeeTableModel) tblEmployee.getSelectionModel().getSelectedItem();
        String emp_code = etmodel.getEmployeeId();

        String empID = emp_code;
        String empType = "";
        String empNIC = "";
        String empName = "";
        String tel = txtTelephone.getText();
        String add = txtEmployeeAddress.getText();
        try {
            List<EmployeeDTO> allEmployeeList = employeeBOImpl.getAll();

            for (EmployeeDTO employee : allEmployeeList) {
                if (empID.equals(employee.getEmployeeId())){
                    empType = employee.getPositionsType();
                    empNIC = employee.getEmployeeNIC();
                    empName = employee.getEmployeeName();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        boolean isFilled = checkFields();

        try {
            if (isFilled){
                boolean result = employeeBOImpl.update(new EmployeeDTO(empID,empType,empNIC,empName,add,tel));

                if (result){
                    tblEmployee.refresh();
                    new Alert(Alert.AlertType.INFORMATION, "Employee has been updated successfully", ButtonType.OK).showAndWait();
                }else{
                    new Alert(Alert.AlertType.ERROR,"Failed to update the employee, try again").show();
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void imgGoBack_OnMouseClicked(MouseEvent event) throws IOException {
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/Admin.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) tblEmployee.getScene().getWindow();
        adminStage.setScene(adminScene);
    }


    private void loadEmployees() {

        tblClmEmployeeID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        tblClmEmployeeType.setCellValueFactory(new PropertyValueFactory<>("positionsType"));
        tblClmNIC.setCellValueFactory(new PropertyValueFactory<>("employeeNIC"));
        tblClmEmployeeName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        tblClmAddress.setCellValueFactory(new PropertyValueFactory<>("employeeAddress"));
        tblClmTelephone.setCellValueFactory(new PropertyValueFactory<>("employeeContact"));

        tblEmployee.setItems(employees);


        try {
            List<EmployeeDTO> allEmployeeList = employeeBOImpl.getAll();

            for (EmployeeDTO employee : allEmployeeList) {
                EmployeeTableModel etmodel = new EmployeeTableModel();
                etmodel.setEmployeeId(employee.getEmployeeId());
                etmodel.setPositionsType(employee.getPositionsType());
                etmodel.setEmployeeNIC(employee.getEmployeeNIC());
                etmodel.setEmployeeName(employee.getEmployeeName());
                etmodel.setEmployeeAddress(employee.getEmployeeAddress());
                etmodel.setEmployeeContact(employee.getEmployeeContact());

                employees.add(etmodel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public boolean checkFields(){
        if (txtTelephone.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Employee Telephone is empty", ButtonType.OK).showAndWait();
            txtTelephone.requestFocus();
        }else if (txtEmployeeAddress.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Employee Address is empty", ButtonType.OK).showAndWait();
            txtEmployeeAddress.requestFocus();
        }else if (!Validation.isInt(txtTelephone.getText())){
            new Alert(Alert.AlertType.ERROR, "Invalid Telephone", ButtonType.OK).showAndWait();
            txtTelephone.requestFocus();
        }else {
            return true;
        }

        return false;
    }


}
