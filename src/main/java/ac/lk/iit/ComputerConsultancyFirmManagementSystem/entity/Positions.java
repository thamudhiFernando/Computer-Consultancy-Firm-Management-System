package ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity;

public class Positions extends SuperEntity{
    private String positionsType ;
    private double paidAmountPerHour ;

    public Positions() {

    }

    public Positions(String positionsType, double paidAmountPerHour) {
        this.positionsType = positionsType;
        this.paidAmountPerHour = paidAmountPerHour;
    }

    public String getPositionsType() {
        return positionsType;
    }

    public void setPositionsType(String positionsType) {
        this.positionsType = positionsType;
    }

    public double getpaidAmountPerHour() {
        return paidAmountPerHour;
    }

    public void setpaidAmountPerHour(double paidAmountPerHour) {
        this.paidAmountPerHour = paidAmountPerHour;
    }

    @Override
    public String toString() {
        return "Positions{" +
                "positionsType='" + positionsType + '\'' +
                ", paidAmountPerHour=" + paidAmountPerHour +
                '}';
    }
}
