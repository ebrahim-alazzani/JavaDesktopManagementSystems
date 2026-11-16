
package AdminOP;

import BussnuesLogacl.UsersBL;
import Model.Chef;
import Model.Foods;
import Model.Users;
import Model.Waiter;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;



public class ManagerMain extends javax.swing.JFrame {

    private UsersBL usersBL;
    private Users  users=new Users();
    private Chef chef;
    private Waiter waiter;
    private String type,typeDelete;
    
    
     public ManagerMain() {
        initComponents();
     }
    public ManagerMain(Users u) {
        initComponents();
        usersBL=new UsersBL();
        this.users=u;
        jpAddEmployee.setVisible(false);
        jpDeleteEmployy.setVisible(false);
        jpList.setVisible(false);
        lbUserName.setText(u.getUserName());
        lbType.setText(u.getTybe());
        InVisiblePanel();
         tbChef1.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbChef1.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
              
                + "separatorColor:$TableHeader.background");
         tbWaiter.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbWaiter.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
               
                + "separatorColor:$TableHeader.background");
       
       recfrchTable();
       txtFiledNumberOnly();
    }
    
    
    public void txtFiledNumberOnly(){
        txtSalary.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
         txtExperience.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
      
    }
    
    public void InVisiblePanel(){
        jpChef.setVisible(false);
        jpWaiter.setVisible(false);
    }
    public void recfrchTable(){
         try {
            tablechefList();
            tableWaiterList();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void IntitDate() throws SQLException{
        int result = 0;
        if (txtUserName.getText().equals("") || 
                txtpassword.getText().equals("")
                || 
                txtPosition.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", " Error", 1);
        } else {
           
           
            
               if (type.equals("Chef")) {
                   chef=new Chef();
                   chef.setUserName(txtUserName.getText());
                   chef.setPassword(txtpassword.getText().toString());
                   chef.setPosition(txtPosition.getText().toString());

                   chef.setTybe(type);
                   chef.setSpecialization(txtSpecialization.getText());
                   chef.setExperience(Integer.parseInt(txtExperience.getText()));
                   AddNewUser(chef);
              }
              else if (type.equals("Waiter")) {
                  waiter=new Waiter();
                  waiter.setUserName(txtUserName.getText());
                   waiter.setPassword(txtpassword.getText().toString());
                   waiter.setPosition(txtPosition.getText().toString());

                   waiter.setTybe(type);
                  waiter.setShift(txtShift.getText());
                  waiter.setSalary(Double.parseDouble(txtSalary.getText()));
                  AddNewUser(waiter);

          
              }
        }
    }
    public void AddNewUser(Users users){
        try {
            if (usersBL.InsertUser(users) == 1) {
                JOptionPane.showMessageDialog(this, "Records inserted successfully.", "Entry successfully", 1);
            } else {
                JOptionPane.showMessageDialog(this, "Records insertion failed.", "Entry Error", 1);
            }
            } catch (SQLException ex) {
                 Logger.getLogger(Foods.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
       
    public void TypeSelecyed() {
        if (rbChef.isSelected()) {
            type = "Chef";
        }
        if (rbWaiter.isSelected()) {
            type = "Waiter";
        }
    }
    
    public void TypeSelecyedDelete() {
        if (rbChef1.isSelected()) {
            typeDelete = "Chef";
        }
        if (rbWaiter1.isSelected()) {
            typeDelete = "Waiter";
        }
    }
       
    public void tablechefList() throws SQLException {
        DefaultTableModel model = new DefaultTableModel(new Object[]
        {"UserId","UserName", "Position","Experience","Specialization"
            }, 0);
        ArrayList<Chef> list = usersBL.arryListChef();
        
        Object rowdata[] = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            rowdata[0] = list.get(i).getUserId();
            rowdata[1] = list.get(i).getUserName();
            rowdata[2] = list.get(i).getPosition();
            rowdata[3] = list.get(i).getExperience();
            rowdata[4] = list.get(i).getSpecialization();
            model.addRow(rowdata);
        }
        tbChef1.setModel(model);
    }
    
    public void tableWaiterList() throws SQLException {
        DefaultTableModel model = new DefaultTableModel(new Object[]
        {"UserId","UserName", "Position","Salary","Shift"
            }, 0);
        ArrayList<Waiter> list = usersBL.arryListWaiter();
        
        Object rowdata[] = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            rowdata[0] = list.get(i).getUserId();
            rowdata[1] = list.get(i).getUserName();
            rowdata[2] = list.get(i).getPosition();
            rowdata[3] = list.get(i).getSalary();
            rowdata[4] = list.get(i).getShift();
            model.addRow(rowdata);
        }
        tbWaiter.setModel(model);
    }

    public void deleteUser() throws Exception{
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
        if (check == 0) {
            if(txtUserNameDelete.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
            }
            else {
                try {
                    String UserName =(txtUserNameDelete.getText().toString());
                    usersBL.deleteUserByUserName(UserName,typeDelete);
                    cleanDate();
                    recfrchTable();
                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Records insertion failed.",ex.getMessage() , 1);
                }   
            }   
        }
      }
    
    public void cleanDate() {
        txtUserName.setText("");
        txtPosition.setText("");
        txtSpecialization.setText("");
        txtpassword.setText("");
        txtUserNameDelete.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jpAddEmployee = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btSave = new javax.swing.JButton();
        txtPosition = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        rbWaiter = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        rbChef = new javax.swing.JRadioButton();
        jpWaiter = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtShift = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jpChef = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtSpecialization = new javax.swing.JTextField();
        txtExperience = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jpHome = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jpHome2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jpHome3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        btSingOut = new javax.swing.JButton();
        btDisplay = new javax.swing.JButton();
        btDeleteEmployee = new javax.swing.JButton();
        btAddEmployee1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        jpList = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbWaiter = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbChef1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jpDeleteEmployy = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btDelete = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        rbWaiter1 = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        rbChef1 = new javax.swing.JRadioButton();
        txtUserNameDelete = new javax.swing.JTextField();
        UserName1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exit1 = new javax.swing.JLabel();

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

        jpAddEmployee.setBackground(new java.awt.Color(51, 51, 51));
        jpAddEmployee.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.darkGray, 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btSave.setText("Save");
        btSave.setToolTipText("");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        jPanel5.add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 220, 40));

        txtPosition.setBackground(java.awt.Color.lightGray);
        txtPosition.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel5.add(txtPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 220, 30));

        txtUserName.setBackground(java.awt.Color.lightGray);
        txtUserName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel5.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 220, 30));

        jLabel17.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel17.setText("Position");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 100, 20));

        UserName.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName.setText("User Name");
        UserName.setToolTipText("");
        jPanel5.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 20));

        txtpassword.setBackground(java.awt.Color.lightGray);
        txtpassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel5.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 220, 30));

        jLabel18.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel18.setText("Password");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, -1));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rbWaiter);
        rbWaiter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbWaiter.setText("Waiter");
        rbWaiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbWaiterActionPerformed(evt);
            }
        });
        jPanel7.add(rbWaiter, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 100, -1));

        jLabel16.setFont(new java.awt.Font("Cambria Math", 0, 26)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setText("User Type");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        buttonGroup1.add(rbChef);
        rbChef.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbChef.setText("Chef");
        rbChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbChefActionPerformed(evt);
            }
        });
        jPanel7.add(rbChef, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 100, -1));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 60));

        jpWaiter.setBackground(new java.awt.Color(51, 51, 51));
        jpWaiter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel23.setText("Salary");
        jpWaiter.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, 20));

        txtShift.setBackground(java.awt.Color.lightGray);
        txtShift.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpWaiter.add(txtShift, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 220, 30));

        txtSalary.setBackground(java.awt.Color.lightGray);
        txtSalary.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpWaiter.add(txtSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 220, 30));

        jLabel22.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel22.setText("Shift");
        jpWaiter.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, 20));

        jPanel5.add(jpWaiter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 390, 80));

        jpChef.setBackground(new java.awt.Color(51, 51, 51));
        jpChef.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel19.setText("Specialization");
        jpChef.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        txtSpecialization.setBackground(java.awt.Color.lightGray);
        txtSpecialization.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpChef.add(txtSpecialization, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 220, 30));

        txtExperience.setBackground(java.awt.Color.lightGray);
        txtExperience.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpChef.add(txtExperience, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 220, 30));

        jLabel21.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel21.setText("Experience");
        jpChef.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 20));

        jPanel5.add(jpChef, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 380, 90));

        jpAddEmployee.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 410, 390));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Add Employee");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jpAddEmployee.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 450, 80));

        getContentPane().add(jpAddEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 2, 480, 470));

        jpHome.setBackground(new java.awt.Color(51, 51, 51));
        jpHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Welcome Manager");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jpHome.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 450, 80));

        jpHome2.setBackground(new java.awt.Color(255, 255, 255));
        jpHome2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        jLabel11.setForeground(java.awt.Color.blue);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Welcome Manager");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jpHome2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 450, 80));

        jpHome3.setBackground(new java.awt.Color(255, 255, 255));
        jpHome3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        jLabel12.setForeground(java.awt.Color.blue);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Welcome Manager");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jpHome3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 450, 80));

        jpHome2.add(jpHome3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 470, 170));

        jpHome.add(jpHome2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 470, 170));

        getContentPane().add(jpHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 2, 500, 480));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Options");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

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
        jPanel1.add(lbUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 70, -1));

        btSingOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSingOut.setForeground(java.awt.Color.red);
        btSingOut.setText("Sing Out");
        btSingOut.setToolTipText("");
        btSingOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSingOutActionPerformed(evt);
            }
        });
        jPanel1.add(btSingOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 170, -1));

        btDisplay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btDisplay.setForeground(java.awt.Color.white);
        btDisplay.setText("Display");
        btDisplay.setToolTipText("");
        btDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDisplayActionPerformed(evt);
            }
        });
        jPanel1.add(btDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 170, -1));

        btDeleteEmployee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btDeleteEmployee.setForeground(java.awt.Color.white);
        btDeleteEmployee.setText("Delete Employee");
        btDeleteEmployee.setToolTipText("");
        btDeleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteEmployeeActionPerformed(evt);
            }
        });
        jPanel1.add(btDeleteEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 170, -1));

        btAddEmployee1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btAddEmployee1.setForeground(java.awt.Color.white);
        btAddEmployee1.setText("Add Employee");
        btAddEmployee1.setToolTipText("");
        btAddEmployee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddEmployee1ActionPerformed(evt);
            }
        });
        jPanel1.add(btAddEmployee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 170, -1));

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Employee");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel14.setBackground(new java.awt.Color(51, 51, 51));
        jLabel14.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Type");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("User Name");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        lbType.setBackground(new java.awt.Color(51, 51, 51));
        lbType.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbType.setForeground(new java.awt.Color(255, 255, 255));
        lbType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTypeMouseClicked(evt);
            }
        });
        jPanel1.add(lbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 70, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 480));

        jpList.setBackground(new java.awt.Color(51, 51, 51));
        jpList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(51, 51, 255));
        jLabel4.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Waiter List");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jpList.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbWaiter.setBackground(new java.awt.Color(51, 51, 51));
        tbWaiter.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), null));
        tbWaiter.setFont(new java.awt.Font("Lemonada SemiBold", 0, 12)); // NOI18N
        tbWaiter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserId", "User Name", "Full Name", "Position"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbWaiter.setGridColor(new java.awt.Color(247, 247, 247));
        tbWaiter.setSelectionBackground(new java.awt.Color(255, 102, 0));
        tbWaiter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbWaiterMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbWaiter);

        jpList.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 470, 170));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbChef1.setBackground(new java.awt.Color(51, 51, 51));
        tbChef1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), null));
        tbChef1.setFont(new java.awt.Font("Lemonada SemiBold", 0, 12)); // NOI18N
        tbChef1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Id", "User Name", "Full Name", "Position"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbChef1.setGridColor(new java.awt.Color(247, 247, 247));
        tbChef1.setSelectionBackground(new java.awt.Color(255, 102, 0));
        tbChef1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbChef1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbChef1);

        jpList.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 470, 210));

        jLabel9.setBackground(new java.awt.Color(51, 51, 255));
        jLabel9.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Chef List");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jpList.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        getContentPane().add(jpList, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 2, 500, 480));

        jpDeleteEmployy.setBackground(new java.awt.Color(51, 51, 51));
        jpDeleteEmployy.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Delete Emopley");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jpDeleteEmployy.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 450, 30));

        btDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btDelete.setText("Delete");
        btDelete.setToolTipText("");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        jpDeleteEmployy.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 150, 40));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setBorder(new javax.swing.border.LineBorder(java.awt.Color.red, 1, true));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup2.add(rbWaiter1);
        rbWaiter1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbWaiter1.setText("Waiter");
        rbWaiter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbWaiter1ActionPerformed(evt);
            }
        });
        jPanel8.add(rbWaiter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 100, -1));

        jLabel20.setFont(new java.awt.Font("Cambria Math", 0, 26)); // NOI18N
        jLabel20.setForeground(java.awt.Color.white);
        jLabel20.setText("User Type");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        buttonGroup2.add(rbChef1);
        rbChef1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbChef1.setText("Chef");
        rbChef1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbChef1ActionPerformed(evt);
            }
        });
        jPanel8.add(rbChef1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 100, -1));

        jpDeleteEmployy.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 410, 60));

        txtUserNameDelete.setBackground(java.awt.Color.lightGray);
        txtUserNameDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpDeleteEmployy.add(txtUserNameDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 250, 40));

        UserName1.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName1.setText("Name To Delete");
        UserName1.setToolTipText("");
        jpDeleteEmployy.add(UserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 140, 30));

        getContentPane().add(jpDeleteEmployy, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 2, 470, 480));

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 30, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMousePressed

    private void exit1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MousePressed

        this.dispose();
    }//GEN-LAST:event_exit1MousePressed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    }//GEN-LAST:event_jLabel5MouseClicked

    private void lbUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserNameMouseClicked
       
    }//GEN-LAST:event_lbUserNameMouseClicked

    private void btSingOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSingOutActionPerformed

        MainSystem m = new MainSystem();
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_btSingOutActionPerformed

    private void btDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDisplayActionPerformed
        jpAddEmployee.setVisible(false);
        jpDeleteEmployy.setVisible(false);
        jpList.setVisible(true);
        
    }//GEN-LAST:event_btDisplayActionPerformed

    private void btDeleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteEmployeeActionPerformed
        jpAddEmployee.setVisible(false);
        jpDeleteEmployy.setVisible(true);
        jpList.setVisible(false);
        
    }//GEN-LAST:event_btDeleteEmployeeActionPerformed

    private void btAddEmployee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddEmployee1ActionPerformed
        jpAddEmployee.setVisible(true);
        jpDeleteEmployy.setVisible(false);
        jpList.setVisible(false);
        
    }//GEN-LAST:event_btAddEmployee1ActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        
        try {
            // TODO add your handling code here:
            IntitDate();
            cleanDate();
            InVisiblePanel();
            recfrchTable();
            jpAddEmployee.setVisible(false);  
        } catch (SQLException ex) {
            Logger.getLogger(ManagerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
     

    }//GEN-LAST:event_btSaveActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void tbWaiterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbWaiterMouseClicked

    }//GEN-LAST:event_tbWaiterMouseClicked

    private void tbChef1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChef1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbChef1MouseClicked

    private void rbWaiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbWaiterActionPerformed
        // TODO add your handling code here:
                TypeSelecyed();
                jpWaiter.setVisible(true);
                jpChef.setVisible(false);


    }//GEN-LAST:event_rbWaiterActionPerformed

    private void rbChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbChefActionPerformed
        // TODO add your handling code here:
        TypeSelecyed();
         jpWaiter.setVisible(false);
         jpChef.setVisible(true);

    }//GEN-LAST:event_rbChefActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void rbWaiter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbWaiter1ActionPerformed
        // TODO add your handling code here:
        TypeSelecyedDelete();

    }//GEN-LAST:event_rbWaiter1ActionPerformed

    private void rbChef1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbChef1ActionPerformed
        // TODO add your handling code here:
        TypeSelecyedDelete();
    }//GEN-LAST:event_rbChef1ActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed

        try {
            deleteUser();
            jpDeleteEmployy.setVisible(true);
        } 
        catch (Exception ex) {
            Logger.getLogger(ManagerMain.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Records insertion failed.",ex.getMessage() , 1);
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void lbTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTypeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTypeMouseClicked

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
                new ManagerMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserName;
    private javax.swing.JLabel UserName1;
    private javax.swing.JButton btAddEmployee1;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btDeleteEmployee;
    private javax.swing.JButton btDisplay;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSingOut;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpAddEmployee;
    private javax.swing.JPanel jpChef;
    private javax.swing.JPanel jpDeleteEmployy;
    private javax.swing.JPanel jpHome;
    private javax.swing.JPanel jpHome2;
    private javax.swing.JPanel jpHome3;
    private javax.swing.JPanel jpList;
    private javax.swing.JPanel jpWaiter;
    private javax.swing.JLabel lbType;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JRadioButton rbChef;
    private javax.swing.JRadioButton rbChef1;
    private javax.swing.JRadioButton rbWaiter;
    private javax.swing.JRadioButton rbWaiter1;
    private javax.swing.JTable tbChef1;
    private javax.swing.JTable tbWaiter;
    private javax.swing.JTextField txtExperience;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtShift;
    private javax.swing.JTextField txtSpecialization;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtUserNameDelete;
    private javax.swing.JTextField txtpassword;
    // End of variables declaration//GEN-END:variables
}
