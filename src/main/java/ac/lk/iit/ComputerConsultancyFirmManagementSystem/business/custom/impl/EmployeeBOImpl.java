package ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity.Employee;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.EmployeeBO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.DAOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.DAOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.EmployeeDAO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    private EmployeeDAO employeeDAO = DAOFactory.getInstance().getDAO(DAOTypes.EMPLOYEE);


    @Override
    public boolean save(EmployeeDTO dto) throws Exception {
        return employeeDAO.save(new Employee(dto.getEmployeeId(), dto.getPositionsType(), dto.getEmployeeNIC(), dto.getEmployeeName(),dto.getEmployeeAddress(),dto.getEmployeeContact()));
    }

    @Override
    public boolean update(EmployeeDTO dto) throws Exception {
        return employeeDAO.update(new Employee(dto.getEmployeeId(), dto.getPositionsType(), dto.getEmployeeNIC(), dto.getEmployeeName(),dto.getEmployeeAddress(),dto.getEmployeeContact()));
    }

    @Override
    public boolean remove(String dtoId) throws Exception {
        return false;
    }

    @Override
    public List<EmployeeDTO> getAll() throws Exception {

        List<Employee> allEmployee = employeeDAO.findAll();
        List<EmployeeDTO> empDTOS = new ArrayList<>();
        for (Employee employee : allEmployee){
            EmployeeDTO empDTO = new EmployeeDTO(employee.getEmployeeId(),employee.getPositionsType(),employee.getEmployeeNIC(),employee.getEmployeeName(),employee.getEmployeeAddress(),employee.getEmployeeContact());
            empDTOS.add(empDTO);
        }
        return empDTOS;

    }

    @Override
    public EmployeeDTO getById(String dtoId) throws Exception {
        return null;
    }
}
