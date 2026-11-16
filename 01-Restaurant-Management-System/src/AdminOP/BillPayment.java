/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AdminOP;

import BussnuesLogacl.DiningTableBL;
import BussnuesLogacl.OrderBL;
import BussnuesLogacl.ReservationBL;
import Model.Customers;
import Model.DiningTable;
import Model.Foods;
import Model.Order;
import Model.OrderDetails;
import Model.PaymentCach;
import Model.PaymentCard;
import Model.Reservation;
import Model.Waiter;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import static java.awt.Frame.NORMAL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;



public class BillPayment extends javax.swing.JFrame {
    OrderBL orderBL;
    Reservation  reservation=new Reservation();
    
    Waiter waiter;
    Customers customers;
    DiningTable diningTable;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date=new Date();
    String datestring=dateFormat.format(date);

    Order order;
      public BillPayment() {
        initComponents();}
    public BillPayment(int orderId,Waiter w) {
        initComponents();
        this.OrderId=orderId;
        orderBL=new OrderBL();
        tableBill();
        txtDate.setText(datestring);
        getDateOrder();
        jpcardNumber.setVisible(false);
        this.waiter=w;
           jpReport.setVisible(false);
       jpMake.setVisible(true);

     
        
        
    }
    String type;
    int OrderId;
    public void getDateOrder(){
        try {
            order=orderBL.OrderData(OrderId);
            customers=new Customers();
            customers=order.getCustomers();
            diningTable=order.getDiningTable();
            txtOrderId.setText(OrderId+"");
            txtDate.setText(order.getOrderDate()+"");
            txtTotal.setText(order.getTotal()+"");
            
            
            txtCustmoerId.setText(customers.getCustomerId()+"");
            txtCustomerName.setText(customers.getCustomerName()+"");
            txtAddress.setText(customers.getAddress()+"");
            txtPhone.setText(customers.getPhone()+"");
            
            
            txtTableId.setText(diningTable.getTableId()+"");
            txtTableNumber.setText(diningTable.getTableNumber()+"");
            txtCapacti.setText(diningTable.getCapacit()+"");
            txtCodeCahar.setText(diningTable.getCodeCharTable()+"");
        } catch (SQLException ex) {
            Logger.getLogger(BillPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void TypeSelecyed() {
        if (rbCash.isSelected()) {
            type = "Cash";
        }
        if (rbCredit.isSelected()) {
            type = "Credit";
        }
        if (rbApplePay.isSelected()) {
            type = "ApplePay";
        }
        }
    
    double amount;
      ArrayList<OrderDetails> list;
     public void tableBill() {
     DefaultTableModel model = new DefaultTableModel(new Object[]{"Id","Food Id","Name","Type","Price",
         "Quantity","Calories","TotallQuantity","ToatllPrice"
            }, 0);
      list = orderBL.ArrayListBill(26);
        Object rowdata[] = new Object[9];
        //System.out.println("size" + list.size());
        for (int i = 0; i < list.size(); i++) {
             rowdata[0] = list.get(i).getOrderDetailsId();
            rowdata[1] = list.get(i).getFoods().getFoodId();
            rowdata[2] = list.get(i).getFoods().getFoodName();
            rowdata[3] = list.get(i).getFoods().getFoodType();
            rowdata[4] = list.get(i).getFoods().getPrice();
            rowdata[5] = list.get(i).getFoods().getQuantity();
            rowdata[6] = list.get(i).getFoods().getCalories();
            rowdata[7] = list.get(i).getQuantity();
            rowdata[8] = list.get(i).getPrice();
            amount+=list.get(i).getPrice();

            model.addRow(rowdata);
        }

          
        tbBill.setModel(model);
        txtAmount.setText(amount+"");
    }

      public void cleanDate() {

        txtCardnumber.setText("");

    }
  
      PaymentCach cach;
      PaymentCard card;
      
      public  void IntaDate() throws SQLException{
          
          if(type.equals("Cach")){
            cach=new PaymentCach();
            card=new PaymentCard();
            card.setOrderId(OrderId);
            card.setAmount(Double.parseDouble(txtTotal.getText()));
            card.setPaymentDate( new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()));
            card.setTypeMothd(type);
            AddNewPay(card);
          }
           if(type.equals("Credit")){
            card=new PaymentCard();
            card.setOrderId(OrderId);
            card.setAmount(Double.parseDouble(txtTotal.getText()));
            card.setCardNumber(Integer.parseInt(txtCardnumber.getText()));
            card.setPaymentDate( new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()));
            card.setTypeMothd(type);
            AddNewPay(card);
          }
            if(type.equals("ApplePay")){
            card=new PaymentCard();
            card.setOrderId(OrderId);
            card.setAmount(Double.parseDouble(txtTotal.getText()));
            card.setCardNumber(Integer.parseInt(txtCardnumber.getText()));
            card.setPaymentDate( new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()));
            card.setTypeMothd(type);
            AddNewPay(card);

          }
           
            
      }
    public void AddNewPay(Order order)  throws SQLException {
            int result = 0;
            try {
                if (orderBL.InsertPayment(order) == 1) {
                    JOptionPane.showMessageDialog(this, "Records inserted successfully.", "Entry Error", 1);
                } else {
                    JOptionPane.showMessageDialog(this, "Records insertion failed.", "Entry Error", 1);
                }

            } catch (SQLException ex) {
            Logger.getLogger(Foods.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    JFileChooser fileChooser;

       private void doSaveFile() {
        fileChooser = new JFileChooser();
        int result;
        result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            // We'll be making a mytmp.txt file, write in there, then move it to
            // the selected
            // file. This takes care of clearing that file, should there be
            // content in it.
            File targetFile = fileChooser.getSelectedFile();

            try {
                if (!targetFile.exists()) {
                    targetFile.createNewFile();
                }

                FileWriter fw = new FileWriter(targetFile + ".txt");

                fw.write(jTextArea1.getText());
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btMakeReservationt = new javax.swing.JButton();
        btPaysave = new javax.swing.JButton();
        btPaysave1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        exit1 = new javax.swing.JLabel();
        jpMake = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        UserName3 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBill = new javax.swing.JTable();
        UserName12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        UserName14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        UserName1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        UserName9 = new javax.swing.JLabel();
        UserName10 = new javax.swing.JLabel();
        UserName11 = new javax.swing.JLabel();
        txtTableId = new javax.swing.JLabel();
        txtTableNumber = new javax.swing.JLabel();
        txtCodeCahar = new javax.swing.JLabel();
        txtCapacti = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        UserName2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        UserName5 = new javax.swing.JLabel();
        UserName7 = new javax.swing.JLabel();
        UserName8 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JLabel();
        txtAddress = new javax.swing.JLabel();
        txtPhone = new javax.swing.JLabel();
        txtCustmoerId = new javax.swing.JLabel();
        txtOrderId = new javax.swing.JLabel();
        UserName15 = new javax.swing.JLabel();
        txtOrderDate = new javax.swing.JLabel();
        UserName16 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        UserName17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        rbCash = new javax.swing.JRadioButton();
        rbApplePay = new javax.swing.JRadioButton();
        rbCredit = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        jpcardNumber = new javax.swing.JPanel();
        lbCardNumber = new javax.swing.JLabel();
        txtCardnumber = new javax.swing.JTextField();
        jpReport = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();

        exit.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Option");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, -1));

        btMakeReservationt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btMakeReservationt.setText("Exit");
        btMakeReservationt.setToolTipText("");
        btMakeReservationt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMakeReservationtActionPerformed(evt);
            }
        });
        jPanel1.add(btMakeReservationt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 100, -1));

        btPaysave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btPaysave.setText("Pay");
        btPaysave.setToolTipText("");
        btPaysave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPaysaveActionPerformed(evt);
            }
        });
        jPanel1.add(btPaysave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 100, 30));

        btPaysave1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btPaysave1.setText("Pay");
        btPaysave1.setToolTipText("");
        btPaysave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPaysave1ActionPerformed(evt);
            }
        });
        jPanel1.add(btPaysave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 100, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 560));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit1.setBackground(new java.awt.Color(0, 0, 255));
        exit1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        exit1.setForeground(new java.awt.Color(255, 255, 255));
        exit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit1.setText("X");
        exit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exit1MousePressed(evt);
            }
        });
        jPanel3.add(exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 20, 560));

        jpMake.setBackground(new java.awt.Color(51, 51, 51));
        jpMake.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserName3.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName3.setText("To");
        UserName3.setToolTipText("");
        jPanel4.add(UserName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 30, 20));

        txtAmount.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        txtAmount.setToolTipText("");
        jPanel4.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 110, 20));

        tbBill.setBackground(new java.awt.Color(51, 51, 51));
        tbBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Food Id", "Food Name", "Price", "Quantity", "Calories", "Total Quantity", "Total Price"
            }
        ));
        tbBill.setEnabled(false);
        jScrollPane1.setViewportView(tbBill);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 750, 140));

        UserName12.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName12.setText("From");
        UserName12.setToolTipText("");
        jPanel4.add(UserName12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 50, 20));

        jLabel16.setFont(new java.awt.Font("Cambria Math", 0, 26)); // NOI18N
        jLabel16.setText("Bill");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        UserName14.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName14.setText("Total");
        UserName14.setToolTipText("");
        jPanel4.add(UserName14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 110, 20));

        jpMake.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 800, 250));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Payment Bill");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jpMake.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 10, 260, 40));

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));

        UserName1.setFont(new java.awt.Font("Cambria Math", 0, 24)); // NOI18N
        UserName1.setForeground(new java.awt.Color(51, 51, 51));
        UserName1.setText("Tabel Info");
        UserName1.setToolTipText("");
        jPanel9.add(UserName1);

        jpMake.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 180, 40));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserName9.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName9.setText("Capcti");
        UserName9.setToolTipText("");
        jPanel5.add(UserName9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 50, 20));

        UserName10.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName10.setText("Number");
        UserName10.setToolTipText("");
        jPanel5.add(UserName10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, 20));

        UserName11.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName11.setText("Code");
        UserName11.setToolTipText("");
        jPanel5.add(UserName11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 50, 20));

        txtTableId.setFont(new java.awt.Font(" Abdoullah Ashgar EL-kharef", 1, 12)); // NOI18N
        txtTableId.setText("0");
        jPanel5.add(txtTableId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        txtTableNumber.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        txtTableNumber.setText("0");
        jPanel5.add(txtTableNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 160, 20));

        txtCodeCahar.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        txtCodeCahar.setText("0");
        jPanel5.add(txtCodeCahar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 170, 20));

        txtCapacti.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        txtCapacti.setText("0");
        jPanel5.add(txtCapacti, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 170, -1));

        jpMake.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 270, 150));

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));

        UserName2.setFont(new java.awt.Font("Cambria Math", 0, 24)); // NOI18N
        UserName2.setForeground(new java.awt.Color(51, 51, 51));
        UserName2.setText("Customer Info");
        UserName2.setToolTipText("");
        jPanel10.add(UserName2);

        jpMake.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 180, 40));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserName5.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName5.setText("Phone");
        UserName5.setToolTipText("");
        jPanel2.add(UserName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 50, 20));

        UserName7.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName7.setText("Name");
        UserName7.setToolTipText("");
        jPanel2.add(UserName7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, 20));

        UserName8.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName8.setText("Address");
        UserName8.setToolTipText("");
        jPanel2.add(UserName8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 60, 20));

        txtCustomerName.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        txtCustomerName.setText("0");
        jPanel2.add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 160, 20));

        txtAddress.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        txtAddress.setText("0");
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 170, -1));

        txtPhone.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        txtPhone.setText("0");
        jPanel2.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 170, -1));

        txtCustmoerId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCustmoerId.setText("0");
        jPanel2.add(txtCustmoerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jpMake.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 260, 150));

        txtOrderId.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        txtOrderId.setText("0");
        txtOrderId.setToolTipText("");
        jpMake.add(txtOrderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 60, -1));

        UserName15.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName15.setText("Order Id");
        UserName15.setToolTipText("");
        jpMake.add(UserName15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txtOrderDate.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        txtOrderDate.setText("0");
        txtOrderDate.setToolTipText("");
        jpMake.add(txtOrderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 80, -1));

        UserName16.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName16.setText("Order Date");
        UserName16.setToolTipText("");
        jpMake.add(UserName16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtTotal.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        txtTotal.setText("0");
        txtTotal.setToolTipText("");
        jpMake.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 80, -1));

        UserName17.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName17.setText("Total");
        UserName17.setToolTipText("");
        jpMake.add(UserName17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rbCash);
        rbCash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbCash.setText("Cach");
        rbCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCashActionPerformed(evt);
            }
        });
        jPanel6.add(rbCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 100, -1));

        buttonGroup1.add(rbApplePay);
        rbApplePay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbApplePay.setText("Apple Pay");
        rbApplePay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbApplePayActionPerformed(evt);
            }
        });
        jPanel6.add(rbApplePay, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 100, -1));

        buttonGroup1.add(rbCredit);
        rbCredit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbCredit.setText("Credit");
        rbCredit.setToolTipText("");
        rbCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCreditActionPerformed(evt);
            }
        });
        jPanel6.add(rbCredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 100, -1));

        jLabel17.setFont(new java.awt.Font("Cambria Math", 0, 26)); // NOI18N
        jLabel17.setText("Payment");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtDate.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        txtDate.setText("Bill Date");
        txtDate.setToolTipText("");
        jPanel6.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, -1));

        jpcardNumber.setBackground(new java.awt.Color(51, 51, 51));
        jpcardNumber.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbCardNumber.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        lbCardNumber.setText("Card Number");
        lbCardNumber.setToolTipText("");
        jpcardNumber.add(lbCardNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, -1));
        jpcardNumber.add(txtCardnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 140, -1));

        jPanel6.add(jpcardNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 200, 70));

        jpMake.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 810, 90));

        getContentPane().add(jpMake, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 810, 560));

        jpReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("jLabel1");
        jpReport.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 5, 180, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jpReport.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 630, 300));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jpReport.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        getContentPane().add(jpReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 810, 560));
        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMousePressed

    private void exit1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MousePressed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_exit1MousePressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btMakeReservationtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMakeReservationtActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btMakeReservationtActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btPaysaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPaysaveActionPerformed
   try {
            IntaDate();
             jpcardNumber.setVisible(false);
             cleanDate();
             WaiterMain m = new WaiterMain(waiter);
             m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             m.setVisible(true);
             dispose();
        } catch (SQLException ex) {
            Logger.getLogger(BillPayment.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }//GEN-LAST:event_btPaysaveActionPerformed

    private void rbCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCashActionPerformed

        TypeSelecyed();
         jpcardNumber.setVisible(false);
    }//GEN-LAST:event_rbCashActionPerformed

    private void rbApplePayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbApplePayActionPerformed
             TypeSelecyed();
             jpcardNumber.setVisible(true);
    }//GEN-LAST:event_rbApplePayActionPerformed

    private void rbCreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCreditActionPerformed
         
             TypeSelecyed();
             jpcardNumber.setVisible(true);
             
          
       
    }//GEN-LAST:event_rbCreditActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     try {
            jTextArea1.setLineWrap(true);
            jTextArea1.setText(list.size()+"");
            for (int i = 0; i < list.size(); i++) {

                jTextArea1.setText(jTextArea1.getText() + " Restaurant-management-system  ");
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + "Id :  " + list.get(i).getOrderDetailsId());
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + "Food Name :  " + list.get(i).getFoods().getFoodName());
                jTextArea1.append("\n");
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + " Type :  " + list.get(i).getFoods().getFoodType());
                jTextArea1.append("\n");
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + "  Price :  " + list.get(i).getPrice());
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + " Quantity :  " +list.get(i).getFoods().getQuantity());
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + "   Calories :  " +  list.get(i).getFoods().getCalories());
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + " TotallQuantity   :  " + list.get(i).getQuantity());
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + " ToatllPrice :  " +list.get(i).getPrice());
                jTextArea1.append("\n");
                jTextArea1.append("\n");
            }
            FileOutputStream fos = null;
            String fileData = jTextArea1.getText();
            fos = new FileOutputStream(txtCustomerName.getText() + ".txt");
            fos.write(fileData.getBytes());
            fos.flush();
            fos.close();
            FileWriter myWriter = null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BillPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BillPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        doSaveFile();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btPaysave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPaysave1ActionPerformed
           jpReport.setVisible(true);
       jpMake.setVisible(false);
    }//GEN-LAST:event_btPaysave1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        UIManager.setLookAndFeel(new FlatDarculaLaf());

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserName1;
    private javax.swing.JLabel UserName10;
    private javax.swing.JLabel UserName11;
    private javax.swing.JLabel UserName12;
    private javax.swing.JLabel UserName14;
    private javax.swing.JLabel UserName15;
    private javax.swing.JLabel UserName16;
    private javax.swing.JLabel UserName17;
    private javax.swing.JLabel UserName2;
    private javax.swing.JLabel UserName3;
    private javax.swing.JLabel UserName5;
    private javax.swing.JLabel UserName7;
    private javax.swing.JLabel UserName8;
    private javax.swing.JLabel UserName9;
    private javax.swing.JButton btMakeReservationt;
    private javax.swing.JButton btPaysave;
    private javax.swing.JButton btPaysave1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel jpMake;
    private javax.swing.JPanel jpReport;
    private javax.swing.JPanel jpcardNumber;
    private javax.swing.JLabel lbCardNumber;
    private javax.swing.JRadioButton rbApplePay;
    private javax.swing.JRadioButton rbCash;
    private javax.swing.JRadioButton rbCredit;
    private javax.swing.JTable tbBill;
    public static javax.swing.JLabel txtAddress;
    private javax.swing.JLabel txtAmount;
    public static javax.swing.JLabel txtCapacti;
    private javax.swing.JTextField txtCardnumber;
    public static javax.swing.JLabel txtCodeCahar;
    public static javax.swing.JLabel txtCustmoerId;
    public static javax.swing.JLabel txtCustomerName;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtOrderDate;
    private javax.swing.JLabel txtOrderId;
    public static javax.swing.JLabel txtPhone;
    public static javax.swing.JLabel txtTableId;
    public static javax.swing.JLabel txtTableNumber;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
