package ac.lk.iit.ComputerConsultancyFirmManagementSystem.tablemodel;

import javafx.beans.property.SimpleStringProperty;

public class CustomerTableModel {
    private SimpleStringProperty customerNIC = new SimpleStringProperty("");
    private SimpleStringProperty customerName = new SimpleStringProperty("");
    private SimpleStringProperty customerAddress = new SimpleStringProperty("");
    private SimpleStringProperty customerContact = new SimpleStringProperty("");

    public CustomerTableModel() {

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

    public String getCustomerAddress() {
        return customerAddress.get();
    }

    public SimpleStringProperty customerAddressProperty() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress.set(customerAddress);
    }

    public String getCustomerContact() {
        return customerContact.get();
    }

    public SimpleStringProperty customerContactProperty() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact.set(customerContact);
    }
}
