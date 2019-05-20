package ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrudUtil {
    public static <T> T execute(String sql, Object... params ) throws Exception{

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement(sql);

        if (sql.trim().startsWith("UPDATE")){
            for (int i = 0; i < params.length-1; i++) {
                pstm.setObject(i+1,params[i+1]);
            }
            pstm.setObject(params.length, params[0]);
        }else {
            for (int i = 0; i < params.length; i++) {
                pstm.setObject(i + 1, params[i]);
            }
        }

        if (sql.trim().startsWith("SELECT")){
            System.out.println(sql);
            return (T) pstm.executeQuery();
        }else {
            System.out.println(sql);
            return (T) (Boolean)(pstm.executeUpdate()>=0);
        }

    }
}
