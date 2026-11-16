/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ibral
 */
public class DiningTable {
    
   private int TableId;
   private int TableNumber;
   private String CodeCharTable;
   private int Capacit;
   private int Status;
   private Waiter waiter;

    public DiningTable(int TableId, int TableNumber, String CodeCharTable, int Capacit, int Status) {
        this.TableId = TableId;
        this.TableNumber = TableNumber;
        this.CodeCharTable = CodeCharTable;
        this.Capacit = Capacit;
        this.Status = Status;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
   

    public DiningTable() {
    }

    public int getTableId() {
        return TableId;
    }

    public void setTableId(int TableId) {
        this.TableId = TableId;
    }

    public int getTableNumber() {
        return TableNumber;
    }

    public void setTableNumber(int TableNumber) {
        this.TableNumber = TableNumber;
    }

    public String getCodeCharTable() {
        return CodeCharTable;
    }

    public void setCodeCharTable(String CodeCharTable) {
        this.CodeCharTable = CodeCharTable;
    }

    public int getCapacit() {
        return Capacit;
    }

    public void setCapacit(int Capacit) {
        this.Capacit = Capacit;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
   
    
}
