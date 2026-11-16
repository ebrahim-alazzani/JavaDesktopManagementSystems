/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author ibral
 * 

 */
public class Reservation {
    private int ReservationId;
    private Date ReservationDate;
    private Time StartTime;
    private Time EndTime;
    private  int CountPrson;
    private int Status;
    private  DiningTable diningTable;
    private  Customers customer;
    private Waiter waiter; 

    public Reservation() {
    }

    public Reservation(int ReservationId, Date ReservationDate, Time StartTime, Time EndTime, int CountPrson, 
            int Status, DiningTable diningTable, Customers customer, Waiter waiter) {
        this.ReservationId = ReservationId;
        this.ReservationDate = ReservationDate;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.CountPrson = CountPrson;
        this.Status = Status;
        this.diningTable = diningTable;
        this.customer = customer;
        this.waiter = waiter;
    }

    public Reservation(int ReservationId, Date ReservationDate, Time StartTime, Time EndTime, int CountPrson, int Status) {
        this.ReservationId = ReservationId;
        this.ReservationDate = ReservationDate;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.CountPrson = CountPrson;
        this.Status = Status;
    }

    public int getReservationId() {
        return ReservationId;
    }

    public void setReservationId(int ReservationId) {
        this.ReservationId = ReservationId;
    }

    public Date getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(Date ReservationDate) {
        this.ReservationDate = ReservationDate;
    }

    public Time getStartTime() {
        return StartTime;
    }

    public void setStartTime(Time StartTime) {
        this.StartTime = StartTime;
    }

    public Time getEndTime() {
        return EndTime;
    }

    public void setEndTime(Time EndTime) {
        this.EndTime = EndTime;
    }

    public int getCountPrson() {
        return CountPrson;
    }

    public void setCountPrson(int CountPrson) {
        this.CountPrson = CountPrson;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public DiningTable getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(DiningTable diningTable) {
        this.diningTable = diningTable;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    
    
    


}
