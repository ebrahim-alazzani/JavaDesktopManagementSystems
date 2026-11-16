/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import static  food.Connectdb.con;

/**
 *
 * @author 
 */
public class create_account_users extends javax.swing.JFrame {

    java.util.Date sc1 = new java.util.Date();
    int state;
    int role;
    String user_name;
    String password1;
    String password2;
    DataService ds;
    /**
     * Creates new form create_account_users
     */
    public create_account_users() {
        // this.d1 = new Date();
        initComponents();
        ds=new DataService();
        selectUser();
        update.setVisible(false);
        user_id_box.setVisible(false);

    }
public void selectUser(){
    //new DefaultTableModel(new String[] {"id","name","price","Qty","Total"},0);
    DefaultTableModel model = new DefaultTableModel(new String[]{"id", "user_name", "password1", "password2", "state", "role", "add_date"}, 0);
    ArrayList<User> list = ds.SelectUser();
    Object rowdata[] = new Object[6];
    //System.out.println("size" + list.size());
    for (int i = 0; i < list.size(); i++)
    {   
        rowdata[0] = list.get(i).getId();
        rowdata[1] = list.get(i).getUser_name();
        rowdata[2] = list.get(i).getPasswrod();
        rowdata[3] = list.get(i).getPasswrod1();
        rowdata[4] = list.get(i).getState();
        rowdata[5] = list.get(i).getRole();

        model.addRow(rowdata);
    }
        
        jTable1.setModel(model);
}

    public void get_state(String state_name) {
        switch (state_name.toLowerCase()) {
            case "active":
                state = 1;
                break;
            case "unactive":
                state = 0;
                break;
        }

    }
    public void get_role(String role_name) {
        switch (role_name.toLowerCase()) {
            case "admin":
                role = 1;
                break;
           case "enterdata":
                role = 2;
                break;
            case "cashier":
                role = 3;
                break;
        }

    }
   int result;
   
   boolean s;
   User user;
 public boolean addData(){
        get_state(state_com_box.getSelectedItem().toString());
         get_role(role_com_box.getSelectedItem().toString());
       
                user=new User();

        user.setUser_name(user_name_box.getText()); 
        user.setPasswrod( password_box.getText()); 
        user.setPasswrod1( password1_box.getText()); 
        user.setState(state); 
        user.setState(role); 

        
        if (user.getUser_name().equals("")) {
            JOptionPane.showMessageDialog(null, "Add A user_nsme");

        } else if (user.getPasswrod().equals("")) {

            JOptionPane.showMessageDialog(null, "Add A Password");

        } else if (!user.getPasswrod().equals(user.getPasswrod())) {
            JOptionPane.showMessageDialog(null, "Retype The Password Again");

        } else {
            //actionGender().equals("not selected")
      try{
                
                         
                     
                  
                if (ds.InsertUser(user)== 1) {
                    JOptionPane.showMessageDialog(this, "Your account has been created sucessfully!", "Entry Error", 1);
                      s=true;
                JOptionPane.showMessageDialog(null, "Updated Successfully");

                clear_box();
                selectUser();
                } else {
                    s=false;
                    JOptionPane.showMessageDialog(this, "There was an error while creating your account", "Entry Error", 1);
                    return s;
                }
               

            } catch (SQLException a) {
                JOptionPane.showMessageDialog(this, "SQL EXCEPTION"+a.getMessage(), "Entry Error", 1);
                a.getStackTrace();
                s=false;
                return s;
            }}
                  return  s;

        }
 
 public boolean updateData(){
          get_state(state_com_box.getSelectedItem().toString());
         get_role(role_com_box.getSelectedItem().toString());
       
                user=new User();
        int id = Integer.valueOf(user_id_box.getText());
        user.setId(id); 

        user.setUser_name(user_name_box.getText()); 
        user.setPasswrod( password_box.getText()); 
        user.setPasswrod1( password1_box.getText()); 
        user.setState(state); 
        user.setState(role); 

        
        if (user.getUser_name().equals("")) {
            JOptionPane.showMessageDialog(null, "Add A user_nsme");
              s=false;

        } else if (user.getPasswrod().equals("")) {

            JOptionPane.showMessageDialog(null, "Add A Password");
                 s=false;

        } else if (!user.getPasswrod().equals(user.getPasswrod())) {
            JOptionPane.showMessageDialog(null, "Retype The Password Again");
                         s=false;

        } else {
            //actionGender().equals("not selected")
      try{
                
                         
                     
                  
                if (ds.UpdayeUser(user)== 1) {
                    s=true;
                      JOptionPane.showMessageDialog(null, "Updated Successfully");
                
                clear_box();
                selectUser();
                } else {
                    s=false;
                    JOptionPane.showMessageDialog(this, "There was an error while creating your account", "Entry Error", 1);
                    return s;
                }
               

            } catch (SQLException a) {
                JOptionPane.showMessageDialog(this, "SQL EXCEPTION"+a.getMessage(), "Entry Error", 1);
                a.getStackTrace();
                s=false;
                return s;
            }}
                  return  s;

        }
    
   
    public void clear_box()
    {
        user_name_box.setText("");
        password_box.setText("");
        password1_box.setText("");
        state = 1;
        role = 0;
        user_id_box.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        password1_box = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        user_name_box = new javax.swing.JTextField();
        password_box = new javax.swing.JTextField();
        role_com_box = new javax.swing.JComboBox();
        user_id_box = new javax.swing.JTextField();
        state_com_box = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        registerbutton = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel3.setBackground(java.awt.Color.darkGray);

        jTable1.setBackground(java.awt.Color.darkGray);
        jTable1.setForeground(java.awt.Color.lightGray);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable1.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(java.awt.Color.darkGray);
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel7.setForeground(java.awt.Color.lightGray);
        jLabel7.setText("New User Account");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 0, 340, 40);

        password1_box.setBackground(java.awt.Color.lightGray);
        jPanel1.add(password1_box);
        password1_box.setBounds(190, 200, 220, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(java.awt.Color.lightGray);
        jLabel5.setText("Role");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 280, 60, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(java.awt.Color.lightGray);
        jLabel3.setText("Password Confirm");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 200, 160, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(java.awt.Color.lightGray);
        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 160, 120, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(java.awt.Color.lightGray);
        jLabel4.setText("State");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 250, 42, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(java.awt.Color.lightGray);
        jLabel1.setText("User Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 120, 90, 20);

        user_name_box.setBackground(java.awt.Color.lightGray);
        jPanel1.add(user_name_box);
        user_name_box.setBounds(190, 120, 220, 30);

        password_box.setBackground(java.awt.Color.lightGray);
        jPanel1.add(password_box);
        password_box.setBounds(190, 160, 220, 30);

        role_com_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Cashier", "EnterData" }));
        role_com_box.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                role_com_boxMouseClicked(evt);
            }
        });
        role_com_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                role_com_boxActionPerformed(evt);
            }
        });
        jPanel1.add(role_com_box);
        role_com_box.setBounds(190, 280, 220, 30);

        user_id_box.setText("jTextField1");
        jPanel1.add(user_id_box);
        user_id_box.setBounds(20, 320, 60, 20);

        state_com_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "unActive" }));
        state_com_box.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                state_com_boxMouseClicked(evt);
            }
        });
        state_com_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                state_com_boxActionPerformed(evt);
            }
        });
        jPanel1.add(state_com_box);
        state_com_box.setBounds(190, 240, 220, 30);

        jPanel2.setBackground(java.awt.Color.darkGray);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        registerbutton.setText("Add");
        registerbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(registerbutton);

        update.setText("update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel2.add(update);

        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        jPanel2.add(delete_btn);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 350, 490, 40);

        jPanel4.setBackground(java.awt.Color.darkGray);
        jPanel4.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        button1.setBackground(new java.awt.Color(255, 51, 0));
        button1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("X");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mange User & Role");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel6)
                .addGap(647, 647, 647))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
  
        
        int  id = Integer.valueOf(user_id_box.getText());

        this.ds.deletetables(Integer.valueOf(user_id_box.getText()));
          registerbutton.setEnabled(true); 
          delete_btn.setEnabled(false); 
          update.setEnabled(false); 
        clear_box();
          
        


    }//GEN-LAST:event_delete_btnActionPerformed

    private void registerbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbuttonActionPerformed
        boolean x=addData();
        if(x==true){
            
        }else{
            
        }

                    
        
    }//GEN-LAST:event_registerbuttonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int select = jTable1.getSelectedRow();
         user_id_box.setText(model.getValueAt(select, 0).toString());
        user_name_box.setText(model.getValueAt(select, 1).toString());
        password_box.setText(model.getValueAt(select, 2).toString());
        password1_box.setText(model.getValueAt(select, 3).toString());
        state = Integer.valueOf(model.getValueAt(select, 4).toString());
        role = Integer.valueOf(model.getValueAt(select, 5).toString());
        
        update.setVisible(true);
      //n.setText(model.getValueAt(s, 1));

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        update.setVisible(false);
 boolean x=updateData();
        if(x==true){
            
        }else{
            
        }
// TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       clear_box();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void state_com_boxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_state_com_boxMouseClicked
       
    }//GEN-LAST:event_state_com_boxMouseClicked

    private void role_com_boxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_role_com_boxMouseClicked
        
       
    }//GEN-LAST:event_role_com_boxMouseClicked

    private void state_com_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_state_com_boxActionPerformed
        get_state(state_com_box.getSelectedItem().toString());
    }//GEN-LAST:event_state_com_boxActionPerformed

    private void role_com_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_role_com_boxActionPerformed
         get_role(role_com_box.getSelectedItem().toString());
    }//GEN-LAST:event_role_com_boxActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        if( JOptionPane.showConfirmDialog(null,"Are you sure to close window ", "Warning",JOptionPane.WARNING_MESSAGE) == 0)
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(create_account_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(create_account_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(create_account_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(create_account_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new create_account_users().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField password1_box;
    private javax.swing.JTextField password_box;
    private javax.swing.JButton registerbutton;
    private javax.swing.JComboBox role_com_box;
    private javax.swing.JComboBox state_com_box;
    private javax.swing.JButton update;
    private javax.swing.JTextField user_id_box;
    private javax.swing.JTextField user_name_box;
    // End of variables declaration//GEN-END:variables

   
}
