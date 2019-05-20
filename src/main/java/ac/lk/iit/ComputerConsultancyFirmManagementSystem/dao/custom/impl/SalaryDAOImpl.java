package ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.impl;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.CrudUtil;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity.Salary;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.SalaryDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAOImpl implements SalaryDAO {

    public boolean save(Salary entity) throws Exception {
        String SQL = "INSERT INTO Salary VALUES (?,?,?,?,?,?)";

        return CrudUtil.execute(SQL , entity.getSalaryId(),entity.getEmployeeId(),entity.getEmployeeName(),entity.getPositionsType(),entity.getTotalSalary(),entity.getSalaryDate());
    }

    public boolean update(Salary entity) throws Exception {
        String SQL = "UPDATE Salary SET totalSalary=? WHERE salaryId=?";

        return CrudUtil.execute(SQL, entity.getSalaryId(),entity.getEmployeeId(),entity.getEmployeeName(),entity.getPositionsType(),entity.getTotalSalary(),entity.getSalaryDate());
    }

    public boolean delete(String entityId) throws Exception {
        String SQL = "DELETE FROM Salary WHERE salaryId=?";
        return CrudUtil.execute(SQL,entityId);
    }

    public List<Salary> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Salary");
        List<Salary> alISalarys = new ArrayList<>();
        while (rst.next()) {
            alISalarys.add(new Salary(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getDate(6)));
        }
        return alISalarys;
    }

    public Salary find(String entityId) throws Exception {
        String SQL = "SELECT * FROM Salary WHERE salaryId=?" ;
        ResultSet rst = CrudUtil.execute(SQL, entityId);

        if (rst.next()) {
            return new Salary(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getDate(6));
        }
        return null;
    }

}
