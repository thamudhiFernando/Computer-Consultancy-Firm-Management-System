package ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto;

import java.sql.Date;

public class ContractDTO {
    private String contractID ;
    private String employeeId ;
    private String contractName ;
    private String descriptions ;
    private String serviceType ;
    private String employeeName ;
    private Date creationDate ;
    private String customerNIC ;
    private String customerName ;

    public ContractDTO() {

    }

    public ContractDTO(String contractID, String employeeId, String contractName, String descriptions, String serviceType, String employeeName, Date creationDate, String customerNIC, String customerName) {
        this.contractID = contractID;
        this.employeeId = employeeId;
        this.contractName = contractName;
        this.descriptions = descriptions;
        this.serviceType = serviceType;
        this.employeeName = employeeName;
        this.creationDate = creationDate;
        this.customerNIC = customerNIC;
        this.customerName = customerName;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
}
