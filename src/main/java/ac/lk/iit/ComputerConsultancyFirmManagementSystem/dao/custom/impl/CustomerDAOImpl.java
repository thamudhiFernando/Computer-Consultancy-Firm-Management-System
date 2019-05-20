package ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.impl;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.CrudUtil;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity.Customer;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.CustomerDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    public boolean save(Customer entity) throws Exception {
        String SQL = "INSERT INTO Customer VALUES (?,?,?,?)";

        return CrudUtil.execute(SQL , entity.getCustomerNIC(),entity.getCustomerName(),entity.getcustomerAddress(),entity.getcustomerContact());
    }

    public boolean update(Customer entity) throws Exception {
        String SQL = "UPDATE Customer SET customerName=?, customerAddress=?, customerContact=? WHERE customerNIC=?";
        System.out.println(entity.getCustomerNIC() + " "+entity.getCustomerName() + " "+entity.getcustomerAddress() + " "+entity.getcustomerContact());
        return CrudUtil.execute(SQL , entity.getCustomerNIC(),entity.getCustomerName(),entity.getcustomerAddress(),entity.getcustomerContact());
    }

    public boolean delete(String entityId) throws Exception {
        String SQL = "DELETE FROM Customer WHERE customerNIC=?";
        return CrudUtil.execute(SQL,entityId);
    }

    public List<Customer> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer");
        List<Customer> allCustomers = new ArrayList<>();
        while (rst.next()) {
            allCustomers.add(new Customer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)));
        }
        return allCustomers;
    }

    public Customer find(String entityId) throws Exception {
        String SQL = "SELECT * FROM Customer WHERE customerNIC=?" ;
        ResultSet rst = CrudUtil.execute(SQL, entityId);

        if (rst.next()) {
            return new Customer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4));
        }
        return null;
    }

}
