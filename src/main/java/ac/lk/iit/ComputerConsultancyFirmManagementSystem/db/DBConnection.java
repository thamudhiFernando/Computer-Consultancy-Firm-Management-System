package ac.lk.iit.ComputerConsultancyFirmManagementSystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "CCFSYSTEM","root","mysql");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance(){
        if (dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
