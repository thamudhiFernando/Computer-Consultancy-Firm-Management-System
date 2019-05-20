package ac.lk.iit.ComputerConsultancyFirmManagementSystem.controller;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.CustomerBOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.CustomerDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.other.Validation;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.tablemodel.CustomerTableModel;
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

public class ManageCustomerController implements Initializable {

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private ImageView imgGoBack;

    @FXML
    private JFXTextField txtTelephone;

    @FXML
    private JFXTextField txtCustomerAddress;

    @FXML
    private TableView<CustomerTableModel> tblCustomers;

    @FXML
    private TableColumn tblClmCustomerNIC;

    @FXML
    private TableColumn tblClmCustomerName;

    @FXML
    private TableColumn tblClmAddress;

    @FXML
    private TableColumn tblClmTelephone;


    ObservableList<CustomerTableModel> customers = FXCollections.observableArrayList();
    private CustomerBOImpl customerBOImpl = BOFactory.getInstance().getBOTypes(BOTypes.CUSTOMER);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCustomers();

        tblCustomers.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<CustomerTableModel>() {
                    @Override
                    public void changed(ObservableValue<? extends CustomerTableModel> observable, CustomerTableModel oldValue, CustomerTableModel newValue) {
                        if (newValue != null){
                            txtTelephone.setText(newValue.getCustomerContact());
                            txtCustomerAddress.setText(newValue.getCustomerAddress());
                        }else {
                            return;
                        }
                    }
                });
    }


    @FXML
    void btnUpdate_OnMouseClicked(MouseEvent event) {
        CustomerTableModel ctmodel =(CustomerTableModel) tblCustomers.getSelectionModel().getSelectedItem();
        String cust_code = ctmodel.getCustomerNIC();

        String custNIC = cust_code;
        String custName = "";
        String tel = txtTelephone.getText();
        String add = txtCustomerAddress.getText();
        try {
            List<CustomerDTO> allCustomerList = customerBOImpl.getAll();

            for (CustomerDTO customer : allCustomerList) {
                if (custNIC.equals(customer.getCustomerNIC())){
                    custName = customer.getCustomerName();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        boolean isFilled = checkFields();

        try {
            if (isFilled){
                boolean result = customerBOImpl.update(new CustomerDTO(custNIC,custName,add,tel));

                if (result){
                    tblCustomers.refresh();
                    new Alert(Alert.AlertType.INFORMATION, "Customer has been updated successfully", ButtonType.OK).showAndWait();
                }else{
                    new Alert(Alert.AlertType.ERROR,"Failed to update the customer, try again").show();
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

        Stage adminStage = (Stage) tblCustomers.getScene().getWindow();
        adminStage.setScene(adminScene);
    }


    private void loadCustomers() {

        tblClmCustomerNIC.setCellValueFactory(new PropertyValueFactory<>("customerNIC"));
        tblClmCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        tblClmAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        tblClmTelephone.setCellValueFactory(new PropertyValueFactory<>("customerContact"));

        tblCustomers.setItems(customers);


        try {
            List<CustomerDTO> allCustomerList = customerBOImpl.getAll();

            for (CustomerDTO customer : allCustomerList) {
                CustomerTableModel ctmodel = new CustomerTableModel();
                ctmodel.setCustomerNIC(customer.getCustomerNIC());
                ctmodel.setCustomerName(customer.getCustomerName());
                ctmodel.setCustomerAddress(customer.getcustomerAddress());
                ctmodel.setCustomerContact(customer.getcustomerContact());

                customers.add(ctmodel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public boolean checkFields(){
        if (txtTelephone.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Customer Telephone is empty", ButtonType.OK).showAndWait();
            txtTelephone.requestFocus();
        }else if (txtCustomerAddress.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Customer Address is empty", ButtonType.OK).showAndWait();
            txtCustomerAddress.requestFocus();
        }else if (!Validation.isInt(txtTelephone.getText())){
            new Alert(Alert.AlertType.ERROR, "Invalid Telephone", ButtonType.OK).showAndWait();
            txtTelephone.requestFocus();
        }else {
            return true;
        }

        return false;
    }

}
