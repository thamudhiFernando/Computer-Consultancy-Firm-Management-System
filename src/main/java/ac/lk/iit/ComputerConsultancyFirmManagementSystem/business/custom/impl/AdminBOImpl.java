package ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity.Admin;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.AdminBO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.DAOFactory;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.DAOTypes;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.AdminDAO;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto.AdminDTO;

import java.util.ArrayList;
import java.util.List;

public class AdminBOImpl implements AdminBO {


    private AdminDAO adminDAO = DAOFactory.getInstance().getDAO(DAOTypes.ADMIN);


    public boolean save(AdminDTO dto) throws Exception {
        return adminDAO.save(new Admin(dto.getAdminId(), dto.getAdminName(), dto.getAdminPassword(), dto.getAdminAddress(),dto.getAdminContact()));

    }

    public boolean update(AdminDTO dto) throws Exception {
        return false;
    }

    public boolean remove(String dtoId) throws Exception {
        return false;
    }

    public List<AdminDTO> getAll() throws Exception {
        List<Admin> allAdmin = adminDAO.findAll();
        List<AdminDTO> adminDTOS = new ArrayList<>();
        for (Admin admin : allAdmin){
            AdminDTO adminDTO = new AdminDTO(admin.getAdminId(),admin.getAdminName(),admin.getAdminPassword(),admin.getAdminAddress(),admin.getAdminContact());
            adminDTOS.add(adminDTO);
        }
        return adminDTOS;
//        return adminDAO.findAll().stream().map(admin -> new AdminDTO(admin.getAdminId(),
//                admin.getAdminName(), admin.getAdminPassword(), admin.getAdminAddress(),admin.getAdminContact())).collect(Collectors.toList());

    }

    public AdminDTO getById(String dtoId) throws Exception {
        return null;
    }
}
