package ac.lk.iit.ComputerConsultancyFirmManagementSystem.tablemodel;

import javafx.beans.property.SimpleStringProperty;

public class ContractTableModel {
    private SimpleStringProperty contractID = new SimpleStringProperty("");
    private SimpleStringProperty employeeId = new SimpleStringProperty("");
    private SimpleStringProperty contractName = new SimpleStringProperty("");
    private SimpleStringProperty descriptions = new SimpleStringProperty("");
    private SimpleStringProperty serviceType = new SimpleStringProperty("");
    private SimpleStringProperty employeeName = new SimpleStringProperty("");
    private SimpleStringProperty creationDate = new SimpleStringProperty("");
    private SimpleStringProperty customerNIC = new SimpleStringProperty("");
    private SimpleStringProperty customerName = new SimpleStringProperty("");

    public ContractTableModel() {

    }

    public String getContractID() {
        return contractID.get();
    }

    public SimpleStringProperty contractIDProperty() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID.set(contractID);
    }

    public String getEmployeeId() {
        return employeeId.get();
    }

    public SimpleStringProperty employeeIdProperty() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId.set(employeeId);
    }

    public String getContractName() {
        return contractName.get();
    }

    public SimpleStringProperty contractNameProperty() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName.set(contractName);
    }

    public String getDescriptions() {
        return descriptions.get();
    }

    public SimpleStringProperty descriptionsProperty() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions.set(descriptions);
    }

    public String getServiceType() {
        return serviceType.get();
    }

    public SimpleStringProperty serviceTypeProperty() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType.set(serviceType);
    }

    public String getEmployeeName() {
        return employeeName.get();
    }

    public SimpleStringProperty employeeNameProperty() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName.set(employeeName);
    }

    public String getCreationDate() {
        return creationDate.get();
    }

    public SimpleStringProperty creationDateProperty() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate.set(creationDate);
    }

    public String getCustomerNIC() {
        return customerNIC.get();
    }

    public SimpleStringProperty customerNICProperty() {
        return customerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC.set(customerNIC);
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public SimpleStringProperty customerNameProperty() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }
}
