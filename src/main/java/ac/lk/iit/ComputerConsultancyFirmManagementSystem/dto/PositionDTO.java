package ac.lk.iit.ComputerConsultancyFirmManagementSystem.dto;

public class PositionDTO {
    private String positionsType ;
    private double paidAmountPerHour ;

    public PositionDTO() {

    }

    public PositionDTO(String positionsType, double paidAmountPerHour) {
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
        return "PositionDTO{" +
                "positionsType='" + positionsType + '\'' +
                ", paidAmountPerHour=" + paidAmountPerHour +
                '}';
    }
}
