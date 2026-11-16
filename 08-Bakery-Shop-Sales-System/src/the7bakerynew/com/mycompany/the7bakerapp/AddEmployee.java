/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the7bakerynew.com.mycompany.the7bakerapp;

import DB.DataService;
import Modela.Customer;
import Modela.Staff;
import View.CustomerView;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class AddEmployee extends javax.swing.JFrame {

    /**
     * Creates new form AddEmployee
     */
    public AddEmployee(Staff staff) {
        initComponents();
        this.manger = staff;
        ds = new DataService();
        tableStaff();
    }
    DataService ds;
    Staff staff = new Staff();
    Staff manger = new Staff();

    private AddEmployee() {
        super();
    }

    public void add() throws SQLException {
        int result = 0;

        if (txtFname.getText().equals("") || txtLname.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } else {
            staff.setDateBirth(new java.sql.Date(jDateChooser1.getDate().getTime()));

            staff.setFname(txtFname.getText());
            staff.setLname(txtLname.getText());
            staff.setEmail(txtEmail.getText());
            staff.setPhone(Integer.parseInt(txtPhone.getText()));
            staff.setUserName(txtUserName.getText());
            staff.setPassword(txtPassword.getText());
            staff.setSalary(Double.parseDouble(txtSalary.getText()));
            staff.setGender(typeGender);
            staff.setShift(typeShift);
            staff.setMng_staffID(manger.getMng_staffID());

            if (ds.InsertStaff(staff) == 1) {
                //tableemp();
                JOptionPane.showMessageDialog(this, "Records inserted successfully.", "Entry Error", 1);
            } else {
                JOptionPane.showMessageDialog(this, "Records insertion failed.", "Entry Error", 1);
            }

            //   con.close();
        }
    }

    public void cleanTextBox() {

        txtFname.setText("");
        txtEmail.setText("");
        txtLname.setText("");
        btSave.setEnabled(true);
        btUpdate.setEnabled(false);
        btDelete.setEnabled(false);

    }
    String typeGender = "Male";
    String typeShift = "Morning";

    public void TypeSelecyed_m_f() {
        if (rbMale.isSelected()) {
            typeGender = "Male";

        }
        if (rbFemale.isSelected()) {
            typeGender = "Female";

        }
    }

    public void TypeSelecyedShift() {
        if (rbMorning.isSelected()) {
            typeShift = "Morning";

        }
        if (rbEvening.isSelected()) {
            typeShift = "Evening";

        }
    }

    public void updateData() {

        if (txtFname.getText().equals("") || txtLname.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } else {
            staff.setDateBirth(new java.sql.Date(jDateChooser1.getDate().getTime()));

            staff.setFname(txtFname.getText());
            staff.setLname(txtLname.getText());
            staff.setEmail(txtEmail.getText());
            staff.setPhone(Integer.parseInt(txtPhone.getText()));
            staff.setUserName(txtUserName.getText());
            staff.setPassword(txtPassword.getText());
            staff.setSalary(Double.parseDouble(txtSalary.getText()));
            staff.setGender(typeGender);
            staff.setShift(typeShift);
            staff.setMng_staffID(manger.getMng_staffID());

            ds.updateStaff(Integer.valueOf(txtEmployeeId.getText()), staff);

        }
    }
    ArrayList<Staff> list;

    public void tableStaff() {
        //new DefaultTableModel(new String[] {"id","name","price","Qty","Total"},0);
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Id", "Fname", "Lname", 
            "Email", "phone", "Gender",
            "Salary", "Shift", "DateBrid"
        }, 0);
        try {
            list = ds.getStaffAll();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object rowdata[] = new Object[9];
        //System.out.println("size" + list.size());
        for (int i = 0; i < list.size(); i++) {
            rowdata[0] = list.get(i).getStaff_ID();
            rowdata[1] = list.get(i).getFname();
            rowdata[2] = list.get(i).getLname();
            rowdata[3] = list.get(i).getEmail();
            rowdata[4] = list.get(i).getPhone();
            rowdata[5] = list.get(i).getGender();
            rowdata[6] = list.get(i).getSalary();
            rowdata[7] = list.get(i).getShift();
            rowdata[8] = list.get(i).getDateBirth();
//            rowdata[9] = list.get(i).getEmail();
//            rowdata[10] = list.get(i).getPhone();
            model.addRow(rowdata);
        }

        jTable1.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btDelete = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        txtEmployeeId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbMorning = new javax.swing.JRadioButton();
        rbEvening = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        rbFemale = new javax.swing.JRadioButton();
        rbMale = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 48)); // NOI18N
        jLabel12.setText("Emplpyee");

        jScrollPane1.setBackground(new java.awt.Color(247, 247, 247));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setBackground(new java.awt.Color(247, 247, 247));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setGridColor(new java.awt.Color(247, 247, 247));
        jTable1.setSelectionBackground(new java.awt.Color(96, 83, 150));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btDelete.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btDelete.setForeground(new java.awt.Color(255, 102, 0));
        btDelete.setText("Delete");
        btDelete.setEnabled(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btUpdate.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btUpdate.setForeground(new java.awt.Color(255, 102, 0));
        btUpdate.setText("Update");
        btUpdate.setEnabled(false);
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btClear.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btClear.setText("Clear");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        btSave.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSave.setText("Add");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        txtEmployeeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmployeeIdActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jLabel9.setText("Bir date");

        jLabel10.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jLabel10.setText("Password");

        jLabel13.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jLabel13.setText("Phone");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setText("The Bakery Management System ");

        jLabel14.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jLabel14.setText("Employee ID");

        jLabel15.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jLabel15.setText("Frist Name");

        jLabel16.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jLabel16.setText("Last Name");

        jLabel17.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jLabel17.setText("Email");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup2.add(rbMorning);
        rbMorning.setFont(new java.awt.Font("Lemonada Light", 1, 12)); // NOI18N
        rbMorning.setText("Morning");
        rbMorning.setActionCommand("cbFree");
        rbMorning.setName("rbMorning"); // NOI18N
        rbMorning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMorningActionPerformed(evt);
            }
        });
        jPanel1.add(rbMorning, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 80, -1));

        buttonGroup2.add(rbEvening);
        rbEvening.setFont(new java.awt.Font("Lemonada Light", 1, 12)); // NOI18N
        rbEvening.setText("Evening");
        rbEvening.setActionCommand("chNotFree");
        rbEvening.setName("rbEvening"); // NOI18N
        rbEvening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEveningActionPerformed(evt);
            }
        });
        jPanel1.add(rbEvening, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 22, 150, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rbFemale);
        rbFemale.setFont(new java.awt.Font("Lemonada Light", 1, 12)); // NOI18N
        rbFemale.setText("Female");
        rbFemale.setActionCommand("cbFree");
        rbFemale.setName("rbFree"); // NOI18N
        rbFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFemaleActionPerformed(evt);
            }
        });
        jPanel2.add(rbFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 80, -1));

        buttonGroup1.add(rbMale);
        rbMale.setFont(new java.awt.Font("Lemonada Light", 1, 12)); // NOI18N
        rbMale.setText("Male");
        rbMale.setActionCommand("chNotFree");
        rbMale.setName("rbNotFree"); // NOI18N
        rbMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMaleActionPerformed(evt);
            }
        });
        jPanel2.add(rbMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 22, 150, -1));

        jLabel18.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jLabel18.setText("Salary");

        jLabel19.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jLabel19.setText("User Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSave)
                    .addComponent(btClear)
                    .addComponent(btUpdate)
                    .addComponent(btDelete))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        this.staff = new Staff();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        int selectedrow = jTable1.getSelectedRow();
        txtEmployeeId.setText(model.getValueAt(selectedrow, 0).toString());
        txtFname.setText(model.getValueAt(selectedrow, 1).toString());
        txtLname.setText(model.getValueAt(selectedrow, 2).toString());
     //   txtEmail.setText(model.getValueAt(selectedrow, 3).toString());
        txtPhone.setText(model.getValueAt(selectedrow, 4).toString());
        txtSalary.setText(model.getValueAt(selectedrow, 6).toString());
        try {
            if (model.getValueAt(selectedrow, 8).toString() == null) {

            } else {
                String dateValue = (model.getValueAt(selectedrow, 8).toString());
// Your column Name
                if (dateValue.equals("")) {

                } else {
                    java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateValue);

                    jDateChooser1.setDate(date);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        btUpdate.setEnabled(true);
        btDelete.setEnabled(true);
        btSave.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
        if (check == 0) {
            int empId = Integer.valueOf(txtEmployeeId.getText());
            ds.deleteStadiums(empId);
            cleanTextBox();
            tableStaff();
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        updateData();
//        try {
////
////         //   String dateValue = (football.getDateMatch().toString());
////// Your column Name
////            if (dateValue.equals("")) {
////
////            } else {
////                java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateValue);
////
////                txtDateTime.setDate(date);
////            }
//
//        } catch (ParseException ex) {
//            Logger.getLogger(TeamsOp.class.getName()).log(Level.SEVERE, null, ex);
//        }
        cleanTextBox();
        tableStaff();
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        // TODO add your handling code here:
        cleanTextBox();
    }//GEN-LAST:event_btClearActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed

        try {
            add();
            cleanTextBox();
            tableStaff();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " error" + e.getMessage());
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void txtEmployeeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmployeeIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmployeeIdActionPerformed

    private void rbMorningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMorningActionPerformed
        TypeSelecyedShift();  // if choose gender this method call

        // TODO add your handling code here:
    }//GEN-LAST:event_rbMorningActionPerformed

    private void rbEveningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEveningActionPerformed

        TypeSelecyedShift();  // if choose gender this method call
    }//GEN-LAST:event_rbEveningActionPerformed

    private void rbFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemaleActionPerformed
        TypeSelecyed_m_f();  // if choose gender this method call

    }//GEN-LAST:event_rbFemaleActionPerformed

    private void rbMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMaleActionPerformed
        TypeSelecyed_m_f();
    }//GEN-LAST:event_rbMaleActionPerformed

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
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbEvening;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JRadioButton rbMorning;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmployeeId;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
