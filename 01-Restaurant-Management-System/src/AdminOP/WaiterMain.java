/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AdminOP;

import Model.Waiter;
import com.formdev.flatlaf.FlatLightLaf;
import static java.awt.Frame.NORMAL;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class WaiterMain extends javax.swing.JFrame {

    public WaiterMain() {
        initComponents(); 
    }
    Waiter waiter;
   public WaiterMain(Waiter w) {
        initComponents(); 
        this.waiter=w;
        FullDateChef();
    }
   
     public  void FullDateChef(){
        lbUserName.setText(waiter.getUserName());
        lbType.setText(waiter.getTybe());
        lbSalary.setText(waiter.getSalary()+"");
        lbShift.setText(waiter.getShift());
        lbPosition.setText(waiter.getPosition());

    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exit1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btReservationt = new javax.swing.JButton();
        btOrder = new javax.swing.JButton();
        lbUserName = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbSalary = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbShift = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbPosition = new javax.swing.JLabel();
        btSingOut = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

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

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 30, 470));

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
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        btReservationt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btReservationt.setText("Reservationt");
        btReservationt.setToolTipText("");
        btReservationt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReservationtActionPerformed(evt);
            }
        });
        jPanel1.add(btReservationt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 170, -1));

        btOrder.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btOrder.setText("Order");
        btOrder.setToolTipText("");
        btOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOrderActionPerformed(evt);
            }
        });
        jPanel1.add(btOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 170, -1));

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
        jPanel1.add(lbUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 90, -1));

        jLabel21.setBackground(new java.awt.Color(51, 51, 51));
        jLabel21.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("User Name");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel22.setBackground(new java.awt.Color(51, 51, 51));
        jLabel22.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Position");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        lbType.setBackground(new java.awt.Color(51, 51, 51));
        lbType.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbType.setForeground(new java.awt.Color(255, 255, 255));
        lbType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTypeMouseClicked(evt);
            }
        });
        jPanel1.add(lbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 100, 20));

        jLabel24.setBackground(new java.awt.Color(51, 51, 51));
        jLabel24.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Salary");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        lbSalary.setBackground(new java.awt.Color(51, 51, 51));
        lbSalary.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbSalary.setForeground(new java.awt.Color(255, 255, 255));
        lbSalary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSalaryMouseClicked(evt);
            }
        });
        jPanel1.add(lbSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 120, 30));

        jLabel23.setBackground(new java.awt.Color(51, 51, 51));
        jLabel23.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Shift");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

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
        jPanel1.add(lbShift, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 130, 30));

        jLabel25.setBackground(new java.awt.Color(51, 51, 51));
        jLabel25.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Type");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lbPosition.setBackground(new java.awt.Color(51, 51, 51));
        lbPosition.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbPosition.setForeground(new java.awt.Color(255, 255, 255));
        lbPosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPosition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPositionMouseClicked(evt);
            }
        });
        jPanel1.add(lbPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 20));

        btSingOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSingOut.setForeground(java.awt.Color.red);
        btSingOut.setText("Sing Out");
        btSingOut.setToolTipText("");
        btSingOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSingOutActionPerformed(evt);
            }
        });
        jPanel1.add(btSingOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 450));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Welcome Waiter :)");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 450, 80));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 450, 440));

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

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btReservationtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReservationtActionPerformed
                ReservationFr m = new ReservationFr(waiter);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
                dispose();
    }//GEN-LAST:event_btReservationtActionPerformed

    private void btOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOrderActionPerformed
                OrderMenu m = new OrderMenu(waiter);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
                dispose();
    }//GEN-LAST:event_btOrderActionPerformed

    private void lbUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserNameMouseClicked

    }//GEN-LAST:event_lbUserNameMouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void lbTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTypeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTypeMouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void lbSalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalaryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbSalaryMouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void lbShiftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbShiftMouseClicked

    }//GEN-LAST:event_lbShiftMouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void lbPositionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPositionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbPositionMouseClicked

    private void btSingOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSingOutActionPerformed
        MainSystem m = new MainSystem();
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_btSingOutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        UIManager.setLookAndFeel(new FlatLightLaf());

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WaiterMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOrder;
    private javax.swing.JButton btReservationt;
    private javax.swing.JButton btSingOut;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbPosition;
    private javax.swing.JLabel lbSalary;
    private javax.swing.JLabel lbShift;
    private javax.swing.JLabel lbType;
    private javax.swing.JLabel lbUserName;
    // End of variables declaration//GEN-END:variables
}
