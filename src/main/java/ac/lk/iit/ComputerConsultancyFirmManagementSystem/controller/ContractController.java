package ac.lk.iit.ComputerConsultancyFirmManagementSystem.controller;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.ContractBOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.CustomerBOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.EmployeeBOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.ContractDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.CustomerDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.EmployeeDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.other.Validation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ContractController implements Initializable {

    @FXML
    private JFXButton btnSubmit;

    @FXML
    private ImageView imgGoBack;

    @FXML
    private JFXTextField txtContractID;

    @FXML
    private JFXTextField txtContractDate;

    @FXML
    private JFXTextField txtCustomerNIC;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private Label txtSystemDevelopment;

    @FXML
    private Label txtSoftwareUpgrade;

    @FXML
    private Label txtDataRecovery;

    @FXML
    private JFXComboBox comboLeaderFor_SD;

    @FXML
    private JFXComboBox comboLeaderFor_SU;

    @FXML
    private JFXComboBox comboLeaderFor_DR;

    @FXML
    private JFXTextField txtDescriptions_SD;

    @FXML
    private JFXTextField txtDescriptions_SU;

    @FXML
    private JFXTextField txtDescriptions_DR;

    @FXML
    private JFXTextField txtName_SD;

    @FXML
    private JFXTextField txtName_SU;

    @FXML
    private JFXTextField txtName_DR;

    @FXML
    private JFXDatePicker dateCreationDate_SD;

    @FXML
    private JFXDatePicker dateCreationDate_SU;

    @FXML
    private JFXDatePicker dateCreationDate_DR;

    @FXML
    private ImageView imgSearchCustomer;

    private EmployeeBOImpl employeeBOImpl = BOFactory.getInstance().getBOTypes(BOTypes.EMPLOYEE);
    private CustomerBOImpl customerBOImpl = BOFactory.getInstance().getBOTypes(BOTypes.CUSTOMER);
    private ContractBOImpl contractBOImpl = BOFactory.getInstance().getBOTypes(BOTypes.CONTRACTS);
    private String isAddorUpdate = "";

    public void initialize(URL location, ResourceBundle resources) {
        comboLeaderFor_SD.setStyle("-fx-font-size: 15px");
        comboLeaderFor_SU.setStyle("-fx-font-size: 15px");
        comboLeaderFor_DR.setStyle("-fx-font-size: 15px");
        dateCreationDate_SD.setStyle("-fx-font-size: 14px");
        dateCreationDate_SU.setStyle("-fx-font-size: 14px");
        dateCreationDate_DR.setStyle("-fx-font-size: 14px");
        loadEmployeeName();
        setTodayDate();
    }

    @FXML
    void btnSubmit_OnMouseClicked(MouseEvent event) throws ParseException {
        String contractID = txtContractID.getText();
        String employeeName = (String) comboLeaderFor_SD.getValue();
        String employeeId = getEmpID(employeeName);
        String contractName = txtName_SD.getText();
        String descriptions = txtDescriptions_SD.getText() ;
        String serviceType = txtSystemDevelopment.getText();
        SimpleDateFormat simpleDateF = new SimpleDateFormat("dd-MM-yyyy");
        Date date = simpleDateF.parse(txtContractDate.getText());
        java.sql.Date creationSqlDate = new java.sql.Date(date.getTime());

        String customerNIC = txtCustomerNIC.getText();
        String customerName = txtCustomerName.getText() ;
        String customerAddress = txtAddress.getText();
        String customerContact = txtContact.getText();

        boolean isFilled = checkFields();

        if (isFilled){
            System.out.println("success");

            try {
                List<ContractDTO> allContractList = contractBOImpl.getAll();

                for (ContractDTO contract : allContractList) {
                    if (contractID.equals(contract.getContractID())){
                        new Alert(Alert.AlertType.WARNING, "This ID is Reserved", ButtonType.OK).showAndWait();
                        txtContractID.requestFocus();
                        return;
                    }
                }

                boolean isAddedContract = contractBOImpl.save(
                        new ContractDTO(contractID,
                                employeeId,
                                contractName,
                                descriptions,
                                serviceType,
                                employeeName,
                                creationSqlDate,
                                customerNIC,
                                customerName));

                boolean isAddedCustomer = false;
                if (isAddorUpdate.equals("Add")){
                    isAddedCustomer = customerBOImpl.save(
                            new CustomerDTO(customerNIC,customerName,customerAddress,customerContact)
                    );
                }else if (isAddorUpdate.equals("Update")){
                    isAddedCustomer = true;
                }

                if (isAddedContract){
                    if (isAddedCustomer){
                        new Alert(Alert.AlertType.CONFIRMATION, "Contract has been Added successfully ", ButtonType.OK).showAndWait();

                        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/Contract.fxml"));
                        Scene adminScene = new Scene(manageAdmin);

                        Stage adminStage = (Stage) btnSubmit.getScene().getWindow();
                        adminStage.setScene(adminScene);
                    }
                }else {
                    new Alert(Alert.AlertType.ERROR, "Failed to save the Contract, try again", ButtonType.OK).showAndWait();
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
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/Admin.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) btnSubmit.getScene().getWindow();
        adminStage.setScene(adminScene);
    }

    @FXML
    void imgSearchCustomer_OnClickedMouse(MouseEvent event) {
        String customerNIC = txtCustomerNIC.getText();
        boolean isFind = false;
        try {
            List<CustomerDTO> allCustomerList = customerBOImpl.getAll();

            for (CustomerDTO customers : allCustomerList) {
                if (customerNIC.equals(customers.getCustomerNIC())){
                    isFind = true;
                    new Alert(Alert.AlertType.CONFIRMATION, "Customer is Found", ButtonType.OK).showAndWait();
                    isAddorUpdate = "Update";
                    txtCustomerName.setText(customers.getCustomerName());
                    txtAddress.setText(customers.getcustomerAddress());
                    txtContact.setText(customers.getcustomerContact());
                }
            }

            if (!isFind){
                isAddorUpdate = "Add";
                new Alert(Alert.AlertType.CONFIRMATION, "Customer is Not Found", ButtonType.OK).showAndWait();
                txtContact.clear();
                txtAddress.clear();
                txtCustomerName.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setTodayDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todayDate = dateFormat.format(date);

        txtContractDate.setText(todayDate);
    }

    private void loadEmployeeName(){
        try {
            List<EmployeeDTO> allEmployeeList = employeeBOImpl.getAll();

            for (EmployeeDTO employees : allEmployeeList) {
                String empName = employees.getEmployeeName();
                comboLeaderFor_SD.getItems().addAll(empName);
                comboLeaderFor_SU.getItems().addAll(empName);
                comboLeaderFor_DR.getItems().addAll(empName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public boolean checkFields(){
        if (txtContractID.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Contract ID is empty", ButtonType.OK).showAndWait();
            txtContractID.requestFocus();
        }else if (txtCustomerNIC.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Costomer NIC is empty", ButtonType.OK).showAndWait();
            txtCustomerNIC.requestFocus();
        }else if (!Validation.isInt(txtContractID.getText())){
            new Alert(Alert.AlertType.ERROR, "Invalid Contract - Its must be numaric", ButtonType.OK).showAndWait();
            txtContractID.requestFocus();
        }else {
            return true;
        }

        return false;
    }

    private String getEmpID(String name){
        try {
            List<EmployeeDTO> allEmployeeList = employeeBOImpl.getAll();

            for (EmployeeDTO employees : allEmployeeList) {
                String empName = employees.getEmployeeName();
                String empID = employees.getEmployeeId();
                if (name.equals(empName)){
                    return empID;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
