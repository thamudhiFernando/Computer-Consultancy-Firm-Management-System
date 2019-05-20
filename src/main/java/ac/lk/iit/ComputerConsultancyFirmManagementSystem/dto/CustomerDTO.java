package ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto;

public class CustomerDTO {
    private String customerNIC;
    private String customerName;
    private String customerAddress;
    private String customerContact;

    public CustomerDTO() {

    }

    public CustomerDTO(String customerNIC, String customerName, String customerAddress, String customerContact) {
        this.customerNIC = customerNIC;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerContact = customerContact;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getcustomerAddress() {
        return customerAddress;
    }

    public void setcustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getcustomerContact() {
        return customerContact;
    }

    public void setcustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerNIC='" + customerNIC + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerContact='" + customerContact + '\'' +
                '}';
    }
}
