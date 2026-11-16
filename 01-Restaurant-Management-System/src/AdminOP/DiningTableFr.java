
package AdminOP;

import BussnuesLogacl.DiningTableBL;
import Model.DiningTable;
import Model.Foods;
import Model.Waiter;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class DiningTableFr extends javax.swing.JFrame {
    private DiningTableBL diningTableBL;
    private DiningTable  diningTable=new DiningTable();
    private Waiter waiter;
    private int op;

    
    public DiningTableFr() {
        initComponents();
    }
    
    public DiningTableFr(Waiter w,int op) {
        initComponents();
        diningTableBL=new DiningTableBL();
        waiter=w;
        FullDateChef();
        this.op=op;

        txtFiledNumberOnly();
        getTableId();
    }
    public void txtFiledNumberOnly(){
        txtTableNumber.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
         txtCapacit.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });  
    }

    
    public  void FullDateChef(){
        lbUserName.setText(waiter.getUserName());
        lbType.setText(waiter.getTybe());
        lbSalary.setText(waiter.getSalary()+"");
        lbShift.setText(waiter.getShift());
        lbPosition.setText(waiter.getPosition());
    }
    public void getTableId(){
        try {
            int id = diningTableBL.GetNextValue("DiningTable", "TableId");
            diningTable.setTableId(id);
            TxtTableId.setText(id+"");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerFr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void AddNewDiningTableBL()  throws SQLException {
        int result = 0;

        if (txtTableNumber.getText().equals("") || 
                txtCapacit.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } 
        else {
            diningTable.setTableNumber(Integer.parseInt(txtTableNumber.getText().toString()));
            diningTable.setCodeCharTable(txtCodeCharTable.getText().toString());
            diningTable.setCapacit(Integer.parseInt(txtCapacit.getText().toString()));
            diningTable.setWaiter(waiter);
            
            try {
                if (diningTableBL.InsertDiningTable(diningTable) == 1) {
                    ReturnDataTable(diningTable);
                    JOptionPane.showMessageDialog(this, "Records inserted successfully.", "Entry Error", 1);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Records insertion failed.", "Entry Error", 1);
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(Foods.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

      public void cleanDate() {
        txtTableNumber.setText("");
        txtCapacit.setText("");
        txtCodeCharTable.setText("");
    }
      
    public void ReturnDataTable(DiningTable d){
        
       if(op==1){
           ReservationFr.txtId.setText(d.getTableId()+"");
           ReservationFr.txtTableNumber.setText(d.getTableNumber()+"");
           ReservationFr.txtCapacti.setText(d.getCapacit()+"");
           ReservationFr.txtCodeCahar.setText(d.getCodeCharTable()+"");
           dispose();
       }
       else if(op==2){
            OrderMenu.txtTableId.setText(d.getTableId()+"");
            OrderMenu.tableId=diningTable.getTableId();
            OrderMenu.tableExites=true;
            OrderMenu.txtTableNumber.setText(d.getTableNumber()+"");
            OrderMenu.txtCapacti.setText(d.getCapacit()+"");
            OrderMenu.txtCodeCahar.setText(d.getCodeCharTable()+"");
            dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbShift = new javax.swing.JLabel();
        lbSalary = new javax.swing.JLabel();
        lbPosition = new javax.swing.JLabel();
        lbType1 = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exit1 = new javax.swing.JLabel();
        jpAddCustomer = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btSave = new javax.swing.JButton();
        txtCapacit = new javax.swing.JTextField();
        txtTableNumber = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        txtCodeCharTable = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TxtTableId = new javax.swing.JTextField();
        UserName1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(" Dining Table");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbType.setBackground(new java.awt.Color(51, 51, 51));
        lbType.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbType.setForeground(new java.awt.Color(255, 255, 255));
        lbType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTypeMouseClicked(evt);
            }
        });
        jPanel1.add(lbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 100, 20));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setBackground(new java.awt.Color(51, 51, 51));
        jLabel28.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Type");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, -1));

        jLabel29.setBackground(new java.awt.Color(51, 51, 51));
        jLabel29.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("User Name");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 10, 130, 20));

        jLabel27.setBackground(new java.awt.Color(51, 51, 51));
        jLabel27.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Position");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 160, -1));

        jLabel26.setBackground(new java.awt.Color(51, 51, 51));
        jLabel26.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Salary");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 150, -1));

        jLabel25.setBackground(new java.awt.Color(51, 51, 51));
        jLabel25.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Shift");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 160, -1));

        lbShift.setBackground(new java.awt.Color(51, 51, 51));
        lbShift.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbShift.setForeground(java.awt.Color.white);
        lbShift.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbShift.setText("    ");
        lbShift.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbShiftMouseClicked(evt);
            }
        });
        jPanel2.add(lbShift, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 140, 20));

        lbSalary.setBackground(new java.awt.Color(51, 51, 51));
        lbSalary.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbSalary.setForeground(new java.awt.Color(255, 255, 255));
        lbSalary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSalaryMouseClicked(evt);
            }
        });
        jPanel2.add(lbSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 120, 20));

        lbPosition.setBackground(new java.awt.Color(51, 51, 51));
        lbPosition.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbPosition.setForeground(new java.awt.Color(255, 255, 255));
        lbPosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPosition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPositionMouseClicked(evt);
            }
        });
        jPanel2.add(lbPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, 20));

        lbType1.setBackground(new java.awt.Color(51, 51, 51));
        lbType1.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbType1.setForeground(new java.awt.Color(255, 255, 255));
        lbType1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbType1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbType1MouseClicked(evt);
            }
        });
        jPanel2.add(lbType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 20));

        lbUserName.setBackground(new java.awt.Color(51, 51, 51));
        lbUserName.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbUserName.setForeground(java.awt.Color.white);
        lbUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUserName.setText("    ");
        lbUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUserNameMouseClicked(evt);
            }
        });
        jPanel2.add(lbUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 150, 330));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 360));

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 30, 370));

        jpAddCustomer.setBackground(new java.awt.Color(51, 51, 51));
        jpAddCustomer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65), 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btSave.setText("Save");
        btSave.setToolTipText("");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        jPanel5.add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 220, 40));

        txtCapacit.setBackground(java.awt.Color.lightGray);
        txtCapacit.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel5.add(txtCapacit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 90, 30));

        txtTableNumber.setBackground(java.awt.Color.lightGray);
        txtTableNumber.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel5.add(txtTableNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 90, 30));

        jLabel17.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel17.setText("Capacit");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 70, 20));

        UserName.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName.setText("Id");
        UserName.setToolTipText("");
        jPanel5.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, 20));

        txtCodeCharTable.setBackground(java.awt.Color.lightGray);
        txtCodeCharTable.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel5.add(txtCodeCharTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 90, 30));

        jLabel18.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel18.setText("Code Char");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, -1));

        TxtTableId.setBackground(java.awt.Color.lightGray);
        TxtTableId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel5.add(TxtTableId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 90, 30));

        UserName1.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName1.setText("Table Number");
        UserName1.setToolTipText("");
        jPanel5.add(UserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, 20));

        jpAddCustomer.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 270, 220));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Add Dining Table");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jpAddCustomer.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 280, -1));

        getContentPane().add(jpAddCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 2, 310, 350));

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

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed

        try {
            AddNewDiningTableBL();
            cleanDate();
            jpAddCustomer.setVisible(false);
        } 
        catch (SQLException ex) {
            Logger.getLogger(DiningTableFr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void lbTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTypeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTypeMouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void lbShiftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbShiftMouseClicked

    }//GEN-LAST:event_lbShiftMouseClicked

    private void lbSalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalaryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbSalaryMouseClicked

    private void lbPositionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPositionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbPositionMouseClicked

    private void lbType1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbType1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbType1MouseClicked

    private void lbUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserNameMouseClicked

    }//GEN-LAST:event_lbUserNameMouseClicked

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
                new DiningTableFr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtTableId;
    private javax.swing.JLabel UserName;
    private javax.swing.JLabel UserName1;
    private javax.swing.JButton btSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jpAddCustomer;
    private javax.swing.JLabel lbPosition;
    private javax.swing.JLabel lbSalary;
    private javax.swing.JLabel lbShift;
    private javax.swing.JLabel lbType;
    private javax.swing.JLabel lbType1;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JTextField txtCapacit;
    private javax.swing.JTextField txtCodeCharTable;
    private javax.swing.JTextField txtTableNumber;
    // End of variables declaration//GEN-END:variables
}
