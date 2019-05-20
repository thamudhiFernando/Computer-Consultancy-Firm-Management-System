package ac.lk.iit.ComputerConsultancyFirmManagementSystem.controller;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.BOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.ContractBOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.ContractDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.tablemodel.ContractTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

public class ManageContractController implements Initializable {


    @FXML
    private ImageView imgGoBack;

    @FXML
    private TableView<ContractTableModel> tblContracts;

    @FXML
    private TableColumn tblClmContractID;

    @FXML
    private TableColumn tblClmEmployeeID;

    @FXML
    private TableColumn tblClmContractName;

    @FXML
    private TableColumn tblClmDescriptions;

    @FXML
    private TableColumn tblClmServiceType;

    @FXML
    private TableColumn tblClmEmployeeName;

    @FXML
    private TableColumn tblClmCreationDate;

    @FXML
    private TableColumn tblClmCustomerNIC;

    @FXML
    private TableColumn tblClmCustomerName;


    ObservableList<ContractTableModel> contracts = FXCollections.observableArrayList();
    private ContractBOImpl contractBOImpl = BOFactory.getInstance().getBOTypes(BOTypes.CONTRACTS);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadContracts();
    }

    @FXML
    void imgGoBack_OnMouseClicked(MouseEvent event) throws IOException {
        Parent manageAdmin = FXMLLoader.load(getClass().getResource("/fxml/Admin.fxml"));
        Scene adminScene = new Scene(manageAdmin);

        Stage adminStage = (Stage) tblContracts.getScene().getWindow();
        adminStage.setScene(adminScene);
    }



    private void loadContracts() {


        tblClmContractID.setCellValueFactory(new PropertyValueFactory<>("contractID"));
        tblClmEmployeeID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        tblClmContractName.setCellValueFactory(new PropertyValueFactory<>("contractName"));
        tblClmDescriptions.setCellValueFactory(new PropertyValueFactory<>("descriptions"));
        tblClmServiceType.setCellValueFactory(new PropertyValueFactory<>("serviceType"));
        tblClmEmployeeName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        tblClmCreationDate.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
        tblClmCustomerNIC.setCellValueFactory(new PropertyValueFactory<>("customerNIC"));
        tblClmCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        tblContracts.setItems(contracts);


        try {
            List<ContractDTO> allContractList = contractBOImpl.getAll();

            for (ContractDTO contract : allContractList) {
                ContractTableModel ctmodel = new ContractTableModel();
                ctmodel.setContractID(contract.getContractID());
                ctmodel.setEmployeeId(contract.getEmployeeId());
                ctmodel.setContractName(contract.getContractName());
                ctmodel.setDescriptions(contract.getDescriptions());
                ctmodel.setServiceType(contract.getServiceType());
                ctmodel.setEmployeeName(contract.getEmployeeName());
                ctmodel.setCreationDate(contract.getCreationDate() + "");
                ctmodel.setCustomerNIC(contract.getCustomerNIC());
                ctmodel.setCustomerName(contract.getCustomerName());

                contracts.add(ctmodel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
