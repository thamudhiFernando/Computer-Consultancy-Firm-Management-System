package ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType){
        switch (daoType){
            case ADMIN:
                return (T) new AdminDAOImpl();
            case POSITIONS:
                return (T) new PositionDAOImpl();
            case CONTRACTS:
                return (T) new ContractDAOImpl();
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case EMPLOYEE:
                return (T) new EmployeeDAOImpl();
            case SALARY:
                return (T) new SalaryDAOImpl();
            default:
                return null;
        }
    }
}
