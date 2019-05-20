package ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.ContractBO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.DAOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.DAOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.impl.ContractDAOImpl;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.ContractDTO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity.Contracts;

import java.util.ArrayList;
import java.util.List;

public class ContractBOImpl implements ContractBO {

    private ContractDAOImpl contractDAO = DAOFactory.getInstance().getDAO(DAOTypes.CONTRACTS);

    public boolean save(ContractDTO dto) throws Exception {
        return contractDAO.save(
                new Contracts(dto.getContractID(),
                dto.getEmployeeId(),
                dto.getContractName(),
                dto.getDescriptions(),
                dto.getServiceType(),
                dto.getEmployeeName(),
                dto.getCreationDate(),
                dto.getCustomerNIC(),
                dto.getCustomerName()));

    }

    public boolean update(ContractDTO dto) throws Exception {
        return false;
    }

    public boolean remove(String dtoId) throws Exception {
        return false;
    }

    public List<ContractDTO> getAll() throws Exception {

        List<Contracts> allContract = contractDAO.findAll();
        List<ContractDTO> conDTOS = new ArrayList<>();
        for (Contracts contract : allContract){
            ContractDTO empDTO = new ContractDTO(contract.getContractID(),
                    contract.getEmployeeId(),
                    contract.getContractName(),
                    contract.getDescriptions(),
                    contract.getServiceType(),
                    contract.getEmployeeName(),
                    contract.getCreationDate(),
                    contract.getCustomerNIC(),
                    contract.getCustomerName());
            conDTOS.add(empDTO);
        }
        return conDTOS;
    }

    public ContractDTO getById(String dtoId) throws Exception {
        return null;
    }
}
