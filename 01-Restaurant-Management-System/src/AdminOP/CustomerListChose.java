/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AdminOP;

import BussnuesLogacl.CustomersBL;
import BussnuesLogacl.UsersBL;
import Model.Chef;
import Model.Customers;
import Model.Foods;
import Model.Users;
import Model.Waiter;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;



public class CustomerListChose extends javax.swing.JFrame {

    CustomersBL customersBL;
    Customers  customers=new Customers();
    
    Waiter waiter;
    public CustomerListChose() {
        initComponents();
        customersBL=new CustomersBL();
             tbCustomerChose.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbCustomerChose.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
             
                + "separatorColor:$TableHeader.background");
       
        tableCustomer();
    }
    int op;
    public CustomerListChose(int op) {
        initComponents();
        customersBL=new CustomersBL();
        this.op=op;
                 tbCustomerChose.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbCustomerChose.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                
                + "separatorColor:$TableHeader.background");
       
        tableCustomer();
        tableCustomer();
    }
    
         public void tableCustomer() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Id","Name","Address","Phone"
            }, 0);
        ArrayList<Customers> list = customersBL.CustomerArrayList();
        Object rowdata[] = new Object[7];
        //System.out.println("size" + list.size());
        for (int i = 0; i < list.size(); i++) {
            rowdata[0] = list.get(i).getCustomerId();
            rowdata[1] = list.get(i).getCustomerName();
            rowdata[2] = list.get(i).getAddress();
            rowdata[3] = list.get(i).getPhone();
        
           
            model.addRow(rowdata);
        }

        tbCustomerChose.setModel(model);

         }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exit1 = new javax.swing.JLabel();
        jpList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCustomerChose = new javax.swing.JTable();
        btDelete = new javax.swing.JButton();
        lbName = new javax.swing.JLabel();

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
        setSize(new java.awt.Dimension(2000, 1700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Customer");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 380));

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 30, 380));

        jpList.setBackground(new java.awt.Color(51, 51, 51));
        jpList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbCustomerChose.setBackground(new java.awt.Color(51, 51, 51));
        tbCustomerChose.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCustomerChose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCustomerChoseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCustomerChose);

        jpList.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 300));

        btDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btDelete.setText("Deletee");
        jpList.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 210, 30));

        lbName.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        lbName.setForeground(java.awt.Color.white);
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbName.setText("Chose Customer");
        lbName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNameMouseClicked(evt);
            }
        });
        jpList.add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 50));

        getContentPane().add(jpList, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 480, 380));

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

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       
    }//GEN-LAST:event_jLabel6MouseClicked

    private void lbNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbNameMouseClicked

    
    private void tbCustomerChoseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCustomerChoseMouseClicked
        customers = new Customers();
         DefaultTableModel model = (DefaultTableModel) tbCustomerChose.getModel();

        int selectedrow = tbCustomerChose.getSelectedRow();
        customers.setCustomerId(Integer.parseInt(model.getValueAt(selectedrow, 0).toString()));
        customers.setCustomerName(model.getValueAt(selectedrow, 1).toString());
        customers.setAddress(model.getValueAt(selectedrow, 2).toString());
        customers.setPhone(model.getValueAt(selectedrow, 3).toString());

        if(op==1){
        ReservationFr.txtCustmoerId.setText(customers.getCustomerId()+"");
        ReservationFr.txtCustomerName.setText(customers.getCustomerName()+"");
        ReservationFr.txtAddress.setText(customers.getAddress()+"");
        ReservationFr.txtPhone.setText(customers.getPhone()+"");
        dispose();
        }else if(op==2){
        OrderMenu.txtCustmoerId.setText(customers.getCustomerId()+"");
        OrderMenu.customerId=customers.getCustomerId();
        OrderMenu.txtCustomerName.setText(customers.getCustomerName()+"");
        OrderMenu.txtAddress.setText(customers.getAddress()+"");
        OrderMenu.txtPhone.setText(customers.getPhone()+"");
        OrderMenu.coustomerExites=true;

        dispose();

        }

    }//GEN-LAST:event_tbCustomerChoseMouseClicked

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
                new CustomerListChose().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpList;
    private javax.swing.JLabel lbName;
    private javax.swing.JTable tbCustomerChose;
    // End of variables declaration//GEN-END:variables
}
