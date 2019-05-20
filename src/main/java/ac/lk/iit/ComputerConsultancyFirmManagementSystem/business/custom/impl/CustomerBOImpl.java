package ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.CustomerBO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.DAOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.DAOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.impl.CustomerDAOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.CustomerDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity.Contracts;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    private CustomerDAOImpl customerDAO = DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);

    public boolean save(CustomerDTO dto) throws Exception {
        return customerDAO.save(new Customer(dto.getCustomerNIC(), dto.getCustomerName(), dto.getcustomerAddress(), dto.getcustomerContact()));

    }

    public boolean update(CustomerDTO dto) throws Exception {
        return customerDAO.update(new Customer(dto.getCustomerNIC(), dto.getCustomerName(), dto.getcustomerAddress(), dto.getcustomerContact()));

    }

    public boolean remove(String dtoId) throws Exception {
        return false;
    }

    public List<CustomerDTO> getAll() throws Exception {

        List<Customer> allCustomers = customerDAO.findAll();
        List<CustomerDTO> custDTOS = new ArrayList<>();
        for (Customer customer : allCustomers){
            CustomerDTO custDTO = new CustomerDTO(customer.getCustomerNIC(),customer.getCustomerName(),customer.getcustomerAddress(),customer.getcustomerContact());
            custDTOS.add(custDTO);
        }
        return custDTOS;
    }

    public CustomerDTO getById(String dtoId) throws Exception {
        return null;
    }
}
