package ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto;

import java.sql.Date;

public class SalaryDTO {
    private String salaryId;
    private String employeeId;
    private String employeeName;
    private String positionsType;
    private double totalSalary;
    private Date salaryDate;

    public SalaryDTO() {

    }

    public SalaryDTO(String employeeId, String employeeName, String positionsType, double totalSalary, Date salaryDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.positionsType = positionsType;
        this.totalSalary = totalSalary;
        this.salaryDate = salaryDate;
    }

    public SalaryDTO(String salaryId, String employeeId, String employeeName, String positionsType, double totalSalary, Date salaryDate) {
        this.salaryId = salaryId;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.positionsType = positionsType;
        this.totalSalary = totalSalary;
        this.salaryDate = salaryDate;
    }

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPositionsType() {
        return positionsType;
    }

    public void setPositionsType(String positionsType) {
        this.positionsType = positionsType;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public Date getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }

    @Override
    public String toString() {
        return "SalaryDTO{" +
                "salaryId='" + salaryId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", positionsType='" + positionsType + '\'' +
                ", totalSalary=" + totalSalary +
                ", salaryDate=" + salaryDate +
                '}';
    }
}
