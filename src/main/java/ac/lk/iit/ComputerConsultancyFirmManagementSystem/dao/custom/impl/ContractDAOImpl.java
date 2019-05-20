package ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.impl;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.CrudUtil;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity.Contracts;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.ContractDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContractDAOImpl implements ContractDAO {

    public boolean save(Contracts entity) throws Exception {
        String SQL = "INSERT INTO Contracts VALUES (?,?,?,?,?,?,?,?,?)";

        return CrudUtil.execute(SQL , entity.getContractID(),
                entity.getEmployeeId(),
                entity.getContractName(),
                entity.getDescriptions(),
                entity.getServiceType(),
                entity.getEmployeeName(),
                entity.getCreationDate(),
                entity.getCustomerNIC(),
                entity.getCustomerName());
    }

    public boolean update(Contracts entity) throws Exception {
        String SQL = "UPDATE Contracts SET contractName=?, descriptions=? WHERE contractID=? and employeeId=?";

        return CrudUtil.execute(SQL , entity.getContractID(),
                entity.getEmployeeId(),
                entity.getContractName(),
                entity.getDescriptions(),
                entity.getServiceType(),
                entity.getEmployeeName(),
                entity.getCreationDate(),
                entity.getCustomerNIC(),
                entity.getCustomerName());
    }

    public boolean delete(String entityId) throws Exception {
        String SQL = "DELETE FROM Contracts WHERE contractID=? and employeeId=?";
        return CrudUtil.execute(SQL,entityId);
    }

    public List<Contracts> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Contracts");
        List<Contracts> allContracts = new ArrayList<>();
        while (rst.next()) {
            allContracts.add(new Contracts(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getDate(7),
                    rst.getString(8),
                    rst.getString(9)));
        }
        return allContracts;
    }

    public Contracts find(String entityId) throws Exception {
        String SQL = "SELECT * FROM Contracts WHERE contractID=? and employeeId=?" ;
        ResultSet rst = CrudUtil.execute(SQL, entityId);

        if (rst.next()) {
            return new Contracts(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getDate(7),
                    rst.getString(8),
                    rst.getString(9));
        }
        return null;
    }

}
