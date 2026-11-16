
package AdminOP;

import BussnuesLogacl.UsersBL;
import Model.Chef;
import Model.Users;
import Model.Waiter;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import static java.awt.Frame.NORMAL;

import java.sql.SQLException;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Login extends javax.swing.JFrame {

    private UsersBL usersBL;
    private Users users;

    public Login() {
        initComponents();
        usersBL=new UsersBL();
    }
    
    public void UserLogin() throws SQLException {

        users=new Users();
        if (txtUserName.getText().equals("") || txtassword.getPassword().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } else {
            users.setUserName(txtUserName.getText());
            users.setPassword(txtassword.getText());
            users = usersBL.getManager(users);
            if (users.getUserId()== 0) {
            } else {
                new java.util.Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if(users.getTybe().equals("Manager")){
                            ManagerMain m = new ManagerMain(users);
                            m.setExtendedState(NORMAL);
                            m.setVisible(true);
                            dispose();
                        }
                         if(users.getTybe().equals("Chef")){
                            Chef chef=usersBL.getChef(users.getUserId());
                            ChefMain m = new ChefMain(chef);
                            m.setExtendedState(NORMAL);
                            m.setVisible(true);
                            dispose();
                        }
                       if(users.getTybe().equals("Waiter")){
                           Waiter waiter=usersBL.getWaiter(users.getUserId());
                            WaiterMain m = new WaiterMain(waiter);
                            m.setExtendedState(NORMAL);
                            m.setVisible(true);
                            dispose();
                        }

                    }
                }, 1000 * 2);

            }
        }}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtassword = new javax.swing.JPasswordField();
        btLogin = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        exit1 = new javax.swing.JLabel();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("LogIn ");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 470));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("USERNAME ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, 30));

        jLabel8.setBackground(new java.awt.Color(51, 51, 255));
        jLabel8.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PASSWORD ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, 40));

        txtUserName.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        txtUserName.setToolTipText("");
        jPanel2.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 210, 30));

        txtassword.setFont(new java.awt.Font("Cambria Math", 0, 24)); // NOI18N
        txtassword.setEchoChar('*');
        txtassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtasswordKeyTyped(evt);
            }
        });
        jPanel2.add(txtassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 210, 30));

        btLogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btLogin.setForeground(java.awt.Color.white);
        btLogin.setText("Login");
        btLogin.setToolTipText("");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 210, 40));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit1.setBackground(new java.awt.Color(255, 255, 255));
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

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, 480));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Login   ");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 80));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 490, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        System.exit(0);
    }//GEN-LAST:event_exitMousePressed

    private void exit1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MousePressed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_exit1MousePressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txtasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtasswordKeyTyped

    }//GEN-LAST:event_txtasswordKeyTyped

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed

        try {
            UserLogin();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btLoginActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
    }//GEN-LAST:event_jLabel7MouseClicked

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
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JPasswordField txtassword;
    // End of variables declaration//GEN-END:variables
}
