package ac.lk.iit.ComputerConsultancyFirmManagementSystem.entity;

public class Admin extends SuperEntity {
    private String adminId ;
    private String adminName;
    private String adminPassword ;
    private String adminAddress ;
    private String adminContact ;

    public Admin() {

    }

    public Admin(String adminId, String adminName, String adminPassword, String adminAddress, String adminContact) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminAddress = adminAddress;
        this.adminContact = adminContact;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public String getAdminContact() {
        return adminContact;
    }

    public void setAdminContact(String adminContact) {
        this.adminContact = adminContact;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminAddress='" + adminAddress + '\'' +
                ", adminContact='" + adminContact + '\'' +
                '}';
    }
}
