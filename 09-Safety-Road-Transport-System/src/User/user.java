/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

/**
 *
 * @author hawra albrahim
 */
public class user 
{
    
 /*super class variables*/
 private String Username;
 private String Name;
 private String Email;
 private String PhoneNum;
 private String Password;
 
 /*default constructor*/
 public user()
 {
    Username="";
    Name="";
    Email="";
    PhoneNum="";
    Password="";
 }

 /*parametrized constructor*/
 public user(String username,String name,String email,String phone,String pass)
 {
    this.Username=username;
    this.Name=name;
    this.Email=email;
    this.PhoneNum=phone;
    this.Password=pass;
 }
 
//Setters& Getters
 
/*Username*/  
 public void setUserName(String username)
 {
     this.Username=username;
 }
 
 public String getUserName()
 {
     return Username;
 }
 
 /*name*/ 
 public void setName(String name)
 {
     this.Name=name;
 }
 
 public String getName()
 {
     return Name;
 }
 
 /*Email*/ 
 public void setEmail(String email)
 {
     this.Email=email;
 }
 
 public String getEmail()
 {
     return Email;
 }
 
 /*Phone Number*/ 
 public void setPhoneNum(String phone)
 {
     this.PhoneNum=phone;
 }
 
 public String getPhoneNum()
 {
     return PhoneNum;
 }
 
 /*Password*/ 
 public void setPassword(String pass)
 {
     this.Password=pass;
 }
 
 public String getPassword()
 {
     return Password;
 }
 
    
}//end of user class
