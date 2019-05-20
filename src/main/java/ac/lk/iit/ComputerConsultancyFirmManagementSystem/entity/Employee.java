package ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity;

public class Employee extends SuperEntity{
    private String employeeId ;
    private String positionsType ;
    private String employeeNIC ;
    private String employeeName ;
    private String employeeAddress ;
    private String employeeContact ;

    public Employee() {

    }

    public Employee(String employeeId, String positionsType, String employeeNIC, String employeeName, String employeeAddress, String employeeContact) {
        this.employeeId = employeeId;
        this.positionsType = positionsType;
        this.employeeNIC = employeeNIC;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeContact = employeeContact;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPositionsType() {
        return positionsType;
    }

    public void setPositionsType(String positionsType) {
        this.positionsType = positionsType;
    }

    public String getEmployeeNIC() {
        return employeeNIC;
    }

    public void setEmployeeNIC(String employeeNIC) {
        this.employeeNIC = employeeNIC;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact = employeeContact;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", positionsType='" + positionsType + '\'' +
                ", employeeNIC='" + employeeNIC + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeContact='" + employeeContact + '\'' +
                '}';
    }
}
