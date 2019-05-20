package ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.DAOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.DAOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.impl.SalaryDAOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.SalaryDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.SalaryBO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity.Salary;

import java.util.List;

public class SalaryBOImpl implements SalaryBO {

    private SalaryDAOImpl salaryDAOImpl = DAOFactory.getInstance().getDAO(DAOTypes.SALARY);

    public boolean save(SalaryDTO dto) throws Exception {
        return salaryDAOImpl.save(new Salary(dto.getSalaryId(), dto.getEmployeeId(), dto.getEmployeeName(), dto.getPositionsType(),dto.getTotalSalary(),dto.getSalaryDate()));
    }

    public boolean update(SalaryDTO dto) throws Exception {
        return false;
    }

    public boolean remove(String dtoId) throws Exception {
        return false;
    }

    public List<SalaryDTO> getAll() throws Exception {
        return null;
    }

    public SalaryDTO getById(String dtoId) throws Exception {
        return null;
    }
}
