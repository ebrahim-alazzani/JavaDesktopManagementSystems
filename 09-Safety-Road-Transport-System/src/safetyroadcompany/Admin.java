/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safetyroadcompany;

/**
 *
 * @author ASUS
 */
public class Admin {
       
    private int AdminID;
    private String AdminName;
    private String AdminEmail;
    private String AdminPassword;
    private String AdminUserName;
    private String AdminPhoneNumber;
    private int AdministatorID;

    public Admin() {
    }

    public Admin(int AdminID, String AdminName, String AdminEmail, String AdminPassword, String AdminUserName, String AdminPhoneNumber, int AdministatorID) {
        this.AdminID = AdminID;
        this.AdminName = AdminName;
        this.AdminEmail = AdminEmail;
        this.AdminPassword = AdminPassword;
        this.AdminUserName = AdminUserName;
        this.AdminPhoneNumber = AdminPhoneNumber;
        this.AdministatorID = AdministatorID;
    }

    public int getAdministatorID() {
        return AdministatorID;
    }

    public void setAdministatorID(int AdministatorID) {
        this.AdministatorID = AdministatorID;
    }

  
    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String AdminName) {
        this.AdminName = AdminName;
    }

    public String getAdminEmail() {
        return AdminEmail;
    }

    public void setAdminEmail(String AdminEmail) {
        this.AdminEmail = AdminEmail;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String AdminPassword) {
        this.AdminPassword = AdminPassword;
    }

    public String getAdminUserName() {
        return AdminUserName;
    }

    public void setAdminUserName(String AdminUserName) {
        this.AdminUserName = AdminUserName;
    }

    public String getAdminPhoneNumber() {
        return AdminPhoneNumber;
    }

    public void setAdminPhoneNumber(String AdminPhoneNumber) {
        this.AdminPhoneNumber = AdminPhoneNumber;
    }
    
    
    
}