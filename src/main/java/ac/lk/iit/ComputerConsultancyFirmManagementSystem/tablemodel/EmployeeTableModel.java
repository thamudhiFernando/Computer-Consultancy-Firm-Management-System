package ac.lk.iit.ComputerConsultancyFirmManagementSystem.tablemodel;

import javafx.beans.property.SimpleStringProperty;

public class EmployeeTableModel {

    private SimpleStringProperty employeeId = new SimpleStringProperty("");
    private SimpleStringProperty positionsType = new SimpleStringProperty("");
    private SimpleStringProperty employeeNIC = new SimpleStringProperty("");
    private SimpleStringProperty employeeName = new SimpleStringProperty("");
    private SimpleStringProperty employeeAddress = new SimpleStringProperty("");
    private SimpleStringProperty employeeContact = new SimpleStringProperty("");

    public EmployeeTableModel() {

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

    public String getPositionsType() {
        return positionsType.get();
    }

    public SimpleStringProperty positionsTypeProperty() {
        return positionsType;
    }

    public void setPositionsType(String positionsType) {
        this.positionsType.set(positionsType);
    }

    public String getEmployeeNIC() {
        return employeeNIC.get();
    }

    public SimpleStringProperty employeeNICProperty() {
        return employeeNIC;
    }

    public void setEmployeeNIC(String employeeNIC) {
        this.employeeNIC.set(employeeNIC);
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

    public String getEmployeeAddress() {
        return employeeAddress.get();
    }

    public SimpleStringProperty employeeAddressProperty() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress.set(employeeAddress);
    }

    public String getEmployeeContact() {
        return employeeContact.get();
    }

    public SimpleStringProperty employeeContactProperty() {
        return employeeContact;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact.set(employeeContact);
    }
}
