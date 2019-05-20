package ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.DAOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity.Positions;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.PositionBO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.DAOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.PositionDAO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.PositionDTO;

import java.util.ArrayList;
import java.util.List;

public class PositionBOImpl implements PositionBO {

    private PositionDAO positionDAO = DAOFactory.getInstance().getDAO(DAOTypes.POSITIONS);

    public boolean save(PositionDTO dto) throws Exception {
        return false;
    }

    public boolean update(PositionDTO dto) throws Exception {
        return false;
    }

    public boolean remove(String dtoId) throws Exception {
        return false;
    }

    public List<PositionDTO> getAll() throws Exception {

        List<Positions> allPositions = positionDAO.findAll();
        List<PositionDTO> posDTOS = new ArrayList<>();
        for (Positions position : allPositions){
            PositionDTO posDTO = new PositionDTO(position.getPositionsType(),position.getpaidAmountPerHour());
            posDTOS.add(posDTO);
        }
        return posDTOS;
    }

    public PositionDTO getById(String dtoId) throws Exception {
        return null;
    }
}
