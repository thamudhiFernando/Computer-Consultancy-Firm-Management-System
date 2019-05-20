package ac.lk.iit.ComputerConsultancyFirmManagementSystem.controller;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.EmployeeBOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.PositionBOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.SalaryBOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.EmployeeDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.PositionDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.SalaryDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class SettleEmployeeSalaryController implements Initializable {


    @FXML
    private JFXButton btnSubmit;

    @FXML
    private ImageView imgGoBack;

    @FXML
    private JFXComboBox comboEmployeeName;

    @FXML
    private JFXTextField txtPosition;

    @FXML
    private JFXTextField txtNIC;

    @FXML
    private JFXTextField txtHT_hour;

    @FXML
    private JFXTextField txtHT_hourlyPayment;

    @FXML
    private JFXTextField txtHT_amount;

    @FXML
    private JFXTextField txtP_hour;

    @FXML
    private JFXTextField txtP_hourlyPayment;

    @FXML
    private JFXTextField txtP_amount;

    @FXML
    private JFXTextField txtST_hour;

    @FXML
    private JFXTextField txtST_hourlyPayment;

    @FXML
    private JFXTextField txtST_amount;

    @FXML
    private JFXTextField txtPaymentDate;

    @FXML
    private JFXTextField txtEmployeeSalaryAmount;

    private EmployeeBOImpl employeeBOImpl = BOFactory.getInstance().getBOTypes(BOTypes.EMPLOYEE);
    private PositionBOImpl positionBOImpl = BOFactory.getInstance().getBOTypes(BOTypes.POSITIONS);
    private SalaryBOImpl salaryBOImpl = BOFactory.getInstance().getBOTypes(BOTypes.SALARY);
    private Double total = 0.00;

    public void initialize(URL location, ResourceBundle resources) {
        loadEmployeeName();
        loadPostionFee();
        setTodayDate();
        comboEmployeeName.setStyle("-fx-font-size: 15px");

        comboEmployeeName.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        if (newValue != null) {
                            String selectedName = (String) comboEmployeeName.getValue();

                            try {
                                List<EmployeeDTO> allEmployeeList = employeeBOImpl.getAll();

                                for (EmployeeDTO employees : allEmployeeList) {
                                    String empName = employees.getEmployeeName();
                                    String empPos = employees.getPositionsType();
                                    String empNIC = employees.getEmployeeNIC();

                                    if (empName.equals(selectedName)){
                                        txtPosition.setText(empPos);
                                        txtNIC.setText(empNIC);
                                    }
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        } else {
                            return;
                        }
                    }
                });
    }

    @FXML
    void btnSubmit_OnMouseClicked(MouseEvent event) throws ParseException {
        boolean isFilled = checkFields();

        if (isFilled){
            String employeeName = (String) comboEmployeeName.getValue();

            String employeeId = findEmpID(employeeName);
            String positionsType = txtPosition.getText();
            double totalSalary = total;

            SimpleDateFormat simpleDateF = new SimpleDateFormat("dd-MM-yyyy");
            Date date = simpleDateF.parse(txtPaymentDate.getText());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            System.out.println(sqlDate);
            try {
                boolean isAdded = salaryBOImpl.save(
                        new SalaryDTO(employeeId,
                                employeeName,
                                positionsType,
                                totalSalary,
                                sqlDate));

                if (isAdded){
                    new Alert(Alert.AlertType.CONFIRMATION, "Salary has been Added successfully ", ButtonType.OK).showAndWait();

                    Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/Admin.fxml"));
                    Scene adminScene = new Scene(manageAdmin);

                    Stage adminStage = (Stage) btnSubmit.getScene().getWindow();
                    adminStage.setScene(adminScene);
                }else {
                    new Alert(Alert.AlertType.ERROR, "Failed to make the This Salary, try again", ButtonType.OK).showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void comboEmployeeName_OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void imgGoBack_OnMouseClicked(MouseEvent event) throws IOException {
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/Admin.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) btnSubmit.getScene().getWindow();
        adminStage.setScene(adminScene);
    }

    @FXML
    void txtHT_hour_OnAction(ActionEvent event) {
        int hours = Integer.parseInt(txtHT_hour.getText());
        double payment = Double.parseDouble(txtHT_hourlyPayment.getText());
        double fullPayment = hours * payment;
        total = total + fullPayment;
        txtEmployeeSalaryAmount.setText(total+"");
        txtHT_amount.setText(fullPayment+"");
    }

    @FXML
    void txtP_hour_OnAction(ActionEvent event) {
        int hours = Integer.parseInt(txtP_hour.getText());
        double payment = Double.parseDouble(txtP_hourlyPayment.getText());
        double fullPayment = hours * payment;
        total = total + fullPayment;
        txtEmployeeSalaryAmount.setText(total+"");
        txtP_amount.setText(fullPayment+"");
    }

    @FXML
    void txtST_hour_OnAction(ActionEvent event) {
        int hours = Integer.parseInt(txtST_hour.getText());
        double payment = Double.parseDouble(txtST_hourlyPayment.getText());
        double fullPayment = hours * payment;
        total = total + fullPayment;
        txtEmployeeSalaryAmount.setText(total+"");
        txtST_amount.setText(fullPayment+"");
    }

    private void loadEmployeeName(){
        try {
            List<EmployeeDTO> allEmployeeList = employeeBOImpl.getAll();

            for (EmployeeDTO employees : allEmployeeList) {
                String empName = employees.getEmployeeName();
                comboEmployeeName.getItems().addAll(empName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadPostionFee(){
        try {
            List<PositionDTO> allPositionList = positionBOImpl.getAll();

            for (PositionDTO positions : allPositionList) {
                String posName = positions.getPositionsType();
                if (posName.equals("Hardware Technician")){
                    txtHT_hourlyPayment.setText(positions.getpaidAmountPerHour()+"");
                }else if (posName.equals("Programmer")){
                    txtP_hourlyPayment.setText(positions.getpaidAmountPerHour()+"");
                }else if (posName.equals("Software Installer")){
                    txtST_hourlyPayment.setText(positions.getpaidAmountPerHour()+"");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setTodayDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todayDate = dateFormat.format(date);

        txtPaymentDate.setText(todayDate);
    }

    private String findEmpID(String name){
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

    private boolean checkFields(){
        if (comboEmployeeName.getValue() == null){
            new Alert(Alert.AlertType.ERROR, "Select Employee Name", ButtonType.OK).showAndWait();
            comboEmployeeName.requestFocus();
            return false;
        }else if (total == 0.00){
            new Alert(Alert.AlertType.ERROR, "Enter working hours to Calculate Payments", ButtonType.OK).showAndWait();
            return false;
        }else {
            return true;
        }

    }
}
