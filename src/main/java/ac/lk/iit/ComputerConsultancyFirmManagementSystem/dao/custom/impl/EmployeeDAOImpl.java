package ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.impl;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.CrudUtil;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity.Employee;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.EmployeeDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    public boolean save(Employee entity) throws Exception {
        String SQL = "INSERT INTO Employee VALUES (?,?,?,?,?,?)";

        return CrudUtil.execute(SQL , entity.getEmployeeId(),entity.getPositionsType(),entity.getEmployeeNIC(),entity.getEmployeeName(),entity.getEmployeeAddress(),entity.getEmployeeContact());
    }

    public boolean update(Employee entity) throws Exception {
        String SQL = "UPDATE Employee SET positionsType=?,employeeNIC=?,employeeName=?, employeeAddress=?, employeeContact=? WHERE employeeId=?";
        return CrudUtil.execute(SQL, entity.getEmployeeId(),entity.getPositionsType(),entity.getEmployeeNIC(),entity.getEmployeeName(),entity.getEmployeeAddress(),entity.getEmployeeContact());
    }

    public boolean delete(String entityId) throws Exception {
        String SQL = "DELETE FROM Employee WHERE employeeId=?";
        return CrudUtil.execute(SQL,entityId);
    }

    public List<Employee> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Employee");
        List<Employee> allEmployees = new ArrayList<>();
        while (rst.next()) {
            allEmployees.add(new Employee(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)));
        }
        return allEmployees;
    }

    public Employee find(String entityId) throws Exception {
        String SQL = "SELECT * FROM Employee WHERE employeeId=?" ;
        ResultSet rst = CrudUtil.execute(SQL, entityId);

        if (rst.next()) {
            return new Employee(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6));
        }
        return null;
    }
}
