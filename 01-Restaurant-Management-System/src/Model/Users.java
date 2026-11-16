/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ibral
 */
public class Users {
    
    private  int UserId;
    private  String UserName;
    private  String Password;
    private  String Tybe;
    private  String Position;

    public Users() {
    }

    public Users(int UserId, String UserName, String Password, String Tybe, String Position) {
        this.UserId = UserId;
        this.UserName = UserName;
        this.Password = Password;
        this.Tybe = Tybe;
        this.Position = Position;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTybe() {
        return Tybe;
    }

    public void setTybe(String Tybe) {
        this.Tybe = Tybe;
    }

   
    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

  
    

    
}
