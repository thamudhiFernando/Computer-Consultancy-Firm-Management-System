package ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.impl;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.CrudUtil;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity.Admin;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.AdminDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    public boolean save(Admin entity) throws Exception {
        System.out.println(entity.getAdminId() + " - " + entity.getAdminName() + " - " + entity.getAdminPassword() + " - " + entity.getAdminAddress() + " - " + entity.getAdminContact());
        String SQL = "INSERT INTO Admin VALUES (?,?,?,?,?)";

        return CrudUtil.execute(SQL , entity.getAdminId(),entity.getAdminName(),entity.getAdminPassword(),entity.getAdminAddress(),entity.getAdminContact());
    }

    public boolean update(Admin entity) throws Exception {
        String SQL = "UPDATE Admin SET adminPassword=?, adminAddress=?, adminContact=? WHERE adminId=?";

        return CrudUtil.execute(SQL, entity.getAdminId(),entity.getAdminName(),entity.getAdminPassword(),entity.getAdminAddress(),entity.getAdminContact());
    }

    public boolean delete(String entityId) throws Exception {
        String SQL = "DELETE FROM Admin WHERE adminId=?";
        return CrudUtil.execute(SQL,entityId);
    }

    public List<Admin> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Admin");
        List<Admin> alIAdmins = new ArrayList<>();
        while (rst.next()) {
            alIAdmins.add(new Admin(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)));
        }
        return alIAdmins;
    }

    public Admin find(String entityId) throws Exception {
        String SQL = "SELECT * FROM Admin WHERE adminId=?" ;
        ResultSet rst = CrudUtil.execute(SQL, entityId);

        if (rst.next()) {
            return new Admin(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5));
        }
        return null;
    }

}
