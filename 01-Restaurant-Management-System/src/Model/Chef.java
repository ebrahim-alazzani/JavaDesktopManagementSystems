/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ibral
 */
public class Chef extends Users{
   private String Specialization;
   private int Experience;

    public Chef() {
    }

    public Chef(String Specialization, int Experience) {
        this.Specialization = Specialization;
        this.Experience = Experience;
    }

    public Chef(String Specialization, int Experience, int UserId, String UserName, String Password, String Tybe, String Position) {
        super(UserId, UserName, Password, Tybe, Position);
        this.Specialization = Specialization;
        this.Experience = Experience;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int Experience) {
        this.Experience = Experience;
    }
   
}
