/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modela;

/**
 *
 * @author ASUS
 */
public class Cake extends Order_Info{
public String Size;
public int Layer ;
public String Frosting ;
public String Flavor;

    public Cake(String Size, int Layer, 
            String Frosting, String Flavor, int Order_Info_ID, Order order, Items items, int Quantity, double Item_price) {
        super(Order_Info_ID, order, items, Quantity, Item_price);
        this.Size = Size;
        this.Layer = Layer;
        this.Frosting = Frosting;
        this.Flavor = Flavor;
    }

    public Cake(String Size, int Layer, String Frosting, String Flavor) {
        this.Size = Size;
        this.Layer = Layer;
        this.Frosting = Frosting;
        this.Flavor = Flavor;
    }

    

    



}
/*
CREATE TABLE Orders(
Order_ID INT NOT NULL primary key,
Customer_ID INT NOT NULL,
Order_Date Date NOT NULL,
Total DOUBLE NOT NULL,
FOREIGN KEY (Customer_ID)REFERENCES Customer (Customer_ID)

);
CREATE TABLE Categories(
Categorie_ID INT NOT NULL primary key,
Categorie_NAME varchar(50) NOT NULL

);
CREATE TABLE Items(
Item_ID INT NOT NULL primary key,
Name varchar(50) NOT NULL,
Categorie_ID int not null,
Price DOUBLE NOT NULL,
ItemImg  VARCHAR(200),
Calories int not null,
FOREIGN KEY (Categorie_ID)REFERENCES Categories (Categorie_ID)

);

CREATE TABLE Order_info (
Order_Info_ID INTEGER NOT NULL primary key,
Order_ID INTEGER  NOT NULL,
Item_ID INTEGER NOT NULL,
Quantity INTEGER NOT NULL,
Item_price DOUBLE NOT NULL,
FOREIGN KEY (Order_ID)REFERENCES Orders (Order_ID),
FOREIGN KEY (Item_ID)REFERENCES Items (Item_ID)

);

CREATE TABLE Hot_Drinks(
AddSugar boolean,
H_ID int,
price double,
Size int,
MilkType Char,
ExtraHot boolean,
Flavor varchar(15),
PRIMARY KEY (H_ID),
FOREIGN KEY (H_ID)REFERENCES Order_info (Order_Info_ID)
);

create table Cake(
cake_ID int not null primary key,
size int,
price double(10,2),
layer int,
calories int, 
frosting varchar(45),
flavor varchar(45),
foreign key (cake_ID) references Order_info(Order_info)
);

Create table Sandwich
(
Sandwitch_ID int not null primary key,
Spicy boolean not null,
BreadType VARCHAR(15) not null,
ProteinType VARCHAR(20) not null,
foreign key (Sandwitch_ID) references Order_info(Order_info)
);
 
 
CREATE TABLE Customer(
Customer_ID INT NOT NULL PRIMARY KEY,
Email VARCHAR(20) NOT NULL,
FName VARCHAR(20) NOT NULL,
LName VARCHAR(20) NOT NULL,
Phone_NO INT NOT NULL,
UserName VARCHAR(10) NOT NULL,
CPassword VARCHAR(20) NOT NULL
);
CREATE TABLE Staff( 
Mng_staffID int, 
Phone int, 
Staff_ID int, 
Password int, 
UserName varchar(15) , 
Fname varchar(15) , 
Lname varchar(15) , 
Salary double, 
Shift VARCHAR(15), 
Gender VARCHAR(15), 
Email varchar(51), 
DateBirth Date, 
 
PRIMARY KEY (Staff_ID), 
);
Create table Payment
(
Payment_ID int NOT NULL,
Amount double NOT NULL,
primary key(Payment_ID)
,
foreign key (Payment_ID) references Orders(Order_ID)
);
Create table Bakes
(
Staff_ID int NOT NULL,
Cake_ID int NOT NULL,
primary key(Cake_ID, staff_ID)
,
foreign key (Staff_ID) references Staff(Staff_ID),
foreign key (Cake_ID) references Cake(Cake_ID)
);
CREATE TABLE Adds_new(
H_ID int NOT NULL,
Staff_ID int NOT NULL,
PRIMARY KEY (H_ID,Staff_ID),
FOREIGN KEY (Staff_ID)REFERENCES Staff (Staff_ID),
FOREIGN KEY (H_ID)REFERENCES Hot_Drinks(H_ID),
);
create table Adds_new2(
H_ID int NOT NULL ,
Staff_ID int NOT NULL ,
H_ID int FOREIGN KEY REFERENCES Hot_Drinks(H_ID),
Staff_ID varchar(45) FOREIGN KEY REFERENCES Staff(Staff_ID),
primary key(H_ID, staff_ID)
);
CREATE TABLE Cooks (
Sandwich_ID int NOT NULL,
Staff_ID int NOT NULL ,
primary key(Sandwich_ID, staff_ID)
,
FOREIGN KEY Sandwich_ID references Sandwich (Sandwich_ID) ,
FOREIGN KEY Staff_ID references Staff (Staff_ID)
);
*/