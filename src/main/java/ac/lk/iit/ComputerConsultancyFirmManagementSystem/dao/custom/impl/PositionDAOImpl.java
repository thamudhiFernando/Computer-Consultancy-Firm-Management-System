package ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.impl;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.CrudUtil;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity.Positions;
import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.PositionDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PositionDAOImpl implements PositionDAO {

    public boolean save(Positions entity) throws Exception {
        String SQL = "INSERT INTO Positions VALUES (?,?)";

        return CrudUtil.execute(SQL , entity.getPositionsType(),entity.getpaidAmountPerHour());
    }

    public boolean update(Positions entity) throws Exception {
        String SQL = "UPDATE Positions SET paidAmount=? WHERE positionsType=?";

        return CrudUtil.execute(SQL, entity.getPositionsType(),entity.getpaidAmountPerHour());
    }

    public boolean delete(String entityId) throws Exception {
        String SQL = "DELETE FROM Positions WHERE positionsType=?";
        return CrudUtil.execute(SQL,entityId);
    }

    public List<Positions> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Positions");
        List<Positions> allPositions = new ArrayList<>();
        while (rst.next()) {
            allPositions.add(new Positions(rst.getString(1),
                    rst.getDouble(2)));
        }
        return allPositions;
    }

    public Positions find(String entityId) throws Exception {
        String SQL = "SELECT * FROM Positions WHERE positionsType=?" ;
        ResultSet rst = CrudUtil.execute(SQL, entityId);

        if (rst.next()) {
            return new Positions(rst.getString(1),
                    rst.getDouble(2));
        }
        return null;
    }

}
