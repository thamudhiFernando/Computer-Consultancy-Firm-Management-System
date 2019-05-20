package ac.lk.iit.ComputerConsultancyFirmManagementSystem.business;

import ac.lk.iit.ComputerConsultancyFirmManagementSystem.business.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public <T extends SuperBO> T getBOTypes(BOTypes boTypes){
        switch (boTypes){
            case ADMIN:
                return (T) new AdminBOImpl();
            case CONTRACTS:
                return (T) new ContractBOImpl();
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case EMPLOYEE:
                return (T) new EmployeeBOImpl();
            case POSITIONS:
                return (T) new PositionBOImpl();
            case SALARY:
                return (T) new SalaryBOImpl();
            default:
                return null;
        }
    }
}
