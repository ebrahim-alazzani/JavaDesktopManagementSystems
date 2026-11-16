
package AdminOP;

import BussnuesLogacl.ReservationBL;
import Model.Customers;
import Model.DiningTable;
import Model.Foods;
import Model.Reservation;
import Model.Waiter;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;



public class ReservationFr extends javax.swing.JFrame {
    private ReservationBL reservationBL;
    private Reservation  reservation=new Reservation();
    private Waiter waiter;
    private Customers customers;
    private DiningTable diningTable;

    
    public ReservationFr() {
        initComponents();
        reservationBL=new ReservationBL();    
              tbReservation.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbReservation.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
             
                + "separatorColor:$TableHeader.background");
       
                tableReservation();

    }

 
    public ReservationFr(Waiter w) {
        initComponents();
        reservationBL=new ReservationBL();
        waiter=w;
        
                  tbReservation.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbReservation.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
             
                + "separatorColor:$TableHeader.background");
             
        txtFiledNumberOnly();
        FullDateChef();
        tableReservation();
    }    
 
    public  void FullDateChef(){
        lbUserName.setText(waiter.getUserName());
        lbType.setText(waiter.getTybe());
        lbSalary.setText(waiter.getSalary()+"");
        lbShift.setText(waiter.getShift());
        lbPosition.setText(waiter.getPosition());

    }
    public void txtFiledNumberOnly(){
        txtCountPrson.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
        
    }
    public void tableReservation() {
        DefaultTableModel model = new DefaultTableModel(new Object[]
        {"Id","Customer Name","Reservation Date","Start Time","End Time","Count Prson","Table Number","Code Table"
            }, 0);
        ArrayList<Reservation> list = reservationBL.ReservationArrayList();
        Object rowdata[] = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            rowdata[0] = list.get(i).getReservationId();
            rowdata[1] = list.get(i).getCustomer().getCustomerName();
            rowdata[2] = list.get(i).getReservationDate();
            rowdata[3] = list.get(i).getStartTime();
            rowdata[4] = list.get(i).getEndTime();
            rowdata[5] = list.get(i).getCountPrson();
            rowdata[6] = list.get(i).getDiningTable().getTableNumber();
            rowdata[7] = list.get(i).getDiningTable().getCodeCharTable();

            model.addRow(rowdata);
        }

        tbReservation.setModel(model);
    }

    public void AddReservation()  throws SQLException, ParseException {
        int result = 0;

        if (txtStartTime.getText().equals("") || 
                txtEndTime.getText().equals("") ||dtReservationDate.getDate().equals("") || txtCountPrson.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } else {
            reservation.setReservationDate(new java.sql.Date(dtReservationDate.getDate().getTime()));
            SimpleDateFormat format = new SimpleDateFormat("hh:m"); //if 24 hour format
            java.sql.Time timeValueStart = new java.sql.Time(format.parse(txtStartTime.getText()).getTime());
            java.sql.Time timeValueEnd = new java.sql.Time(format.parse(txtEndTime.getText()).getTime());
            reservation.setStartTime(timeValueStart);
            reservation.setEndTime(timeValueEnd);
            reservation.setCountPrson(Integer.parseInt(txtCountPrson.getText().toString()));
            customers=new Customers();
            customers.setCustomerId(Integer.parseInt(txtCustmoerId.getText()));
            diningTable=new DiningTable();
            diningTable.setTableId(Integer.parseInt(txtId.getText()));
            reservation.setCustomer(customers);
            reservation.setDiningTable(diningTable);
            reservation.setWaiter(waiter);
            try {
                if (reservationBL.InsertReservation(reservation) == 1) {
                    JOptionPane.showMessageDialog(this, "Records inserted successfully.", "Entry Error", 1);
                } else {
                    JOptionPane.showMessageDialog(this, "Records insertion failed.", "Entry Error", 1);
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(Foods.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void cleanDate() {
        txtCountPrson.setText("");
        txtStartTime.setText("");
        txtEndTime.setText("");
        txtAddress.setText("");
        txtCountPrson.setText("");
        txtStartTime.setText("");
        txtEndTime.setText("");
        txtAddress.setText("");
        txtCodeCahar.setText("");
        txtCapacti.setText("");
        txtCustmoerId.setText("");
        txtCustomerName.setText("");
          txtId.setText("");
        txtPhone.setText("");
        txtTableNumber.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();
        timePicker1 = new com.raven.swing.TimePicker();
        timePicker2 = new com.raven.swing.TimePicker();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btMakeReservationt = new javax.swing.JButton();
        btViewReservationt = new javax.swing.JButton();
        btDeleteReservationt = new javax.swing.JButton();
        btSingOut = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        lbShift = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        lbPosition = new javax.swing.JLabel();
        lbSalary = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exit1 = new javax.swing.JLabel();
        jpMake = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        UserName4 = new javax.swing.JLabel();
        UserName9 = new javax.swing.JLabel();
        UserName10 = new javax.swing.JLabel();
        UserName11 = new javax.swing.JLabel();
        btSearch1 = new javax.swing.JButton();
        btNew1 = new javax.swing.JButton();
        txtId = new javax.swing.JLabel();
        txtTableNumber = new javax.swing.JLabel();
        txtCodeCahar = new javax.swing.JLabel();
        txtCapacti = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtCountPrson = new javax.swing.JTextField();
        UserName3 = new javax.swing.JLabel();
        txtStartTime = new javax.swing.JTextField();
        UserName = new javax.swing.JLabel();
        txtEndTime = new javax.swing.JTextField();
        dtReservationDate = new com.toedter.calendar.JDateChooser();
        btEndTime = new javax.swing.JButton();
        btsave = new javax.swing.JButton();
        btStartTime = new javax.swing.JButton();
        UserName2 = new javax.swing.JLabel();
        UserName6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        UserName1 = new javax.swing.JLabel();
        UserName5 = new javax.swing.JLabel();
        UserName7 = new javax.swing.JLabel();
        UserName8 = new javax.swing.JLabel();
        btSearch = new javax.swing.JButton();
        btNew = new javax.swing.JButton();
        txtCustomerName = new javax.swing.JLabel();
        txtAddress = new javax.swing.JLabel();
        txtPhone = new javax.swing.JLabel();
        txtCustmoerId = new javax.swing.JLabel();
        jpList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbReservation = new javax.swing.JTable();
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

        timePicker1.setDisplayText(txtStartTime);

        timePicker2.setDisplayText(txtEndTime);

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
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 212, -1, 30));

        btMakeReservationt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btMakeReservationt.setText("Make Reservationt");
        btMakeReservationt.setToolTipText("");
        btMakeReservationt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMakeReservationtActionPerformed(evt);
            }
        });
        jPanel1.add(btMakeReservationt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 170, -1));

        btViewReservationt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btViewReservationt.setText("View Reservationt");
        btViewReservationt.setToolTipText("");
        btViewReservationt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewReservationtActionPerformed(evt);
            }
        });
        jPanel1.add(btViewReservationt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 170, -1));

        btDeleteReservationt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btDeleteReservationt.setText("Delete Reservationt");
        btDeleteReservationt.setToolTipText("");
        btDeleteReservationt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteReservationtActionPerformed(evt);
            }
        });
        jPanel1.add(btDeleteReservationt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 170, -1));

        btSingOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSingOut.setForeground(java.awt.Color.red);
        btSingOut.setText("Sing Out");
        btSingOut.setToolTipText("");
        btSingOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSingOutActionPerformed(evt);
            }
        });
        jPanel1.add(btSingOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 190, -1));

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
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

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
        jPanel1.add(lbShift, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 90, 30));

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
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

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
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

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
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

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
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

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
        jPanel1.add(lbUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, -1));

        lbType.setBackground(new java.awt.Color(51, 51, 51));
        lbType.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbType.setForeground(new java.awt.Color(255, 255, 255));
        lbType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTypeMouseClicked(evt);
            }
        });
        jPanel1.add(lbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 100, 20));

        lbPosition.setBackground(new java.awt.Color(51, 51, 51));
        lbPosition.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbPosition.setForeground(new java.awt.Color(255, 255, 255));
        lbPosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPosition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPositionMouseClicked(evt);
            }
        });
        jPanel1.add(lbPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 100, 20));

        lbSalary.setBackground(new java.awt.Color(51, 51, 51));
        lbSalary.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbSalary.setForeground(new java.awt.Color(255, 255, 255));
        lbSalary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSalaryMouseClicked(evt);
            }
        });
        jPanel1.add(lbSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 420));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 30, 420));

        jpMake.setBackground(new java.awt.Color(51, 51, 51));
        jpMake.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Make Reservationt");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jpMake.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 430, 40));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserName4.setFont(new java.awt.Font("Cambria Math", 0, 24)); // NOI18N
        UserName4.setText("Tabel Info");
        UserName4.setToolTipText("");
        jPanel5.add(UserName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 150, -1));

        UserName9.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName9.setText("Capcti");
        UserName9.setToolTipText("");
        jPanel5.add(UserName9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 50, 20));

        UserName10.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName10.setText("Number");
        UserName10.setToolTipText("");
        jPanel5.add(UserName10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 60, 20));

        UserName11.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName11.setText("Code");
        UserName11.setToolTipText("");
        jPanel5.add(UserName11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, 20));

        btSearch1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSearch1.setText("Save");
        btSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearch1ActionPerformed(evt);
            }
        });
        jPanel5.add(btSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 40, 30));

        btNew1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btNew1.setForeground(new java.awt.Color(255, 0, 51));
        btNew1.setText("+");
        btNew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNew1ActionPerformed(evt);
            }
        });
        jPanel5.add(btNew1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 40, 30));

        txtId.setText("0");
        jPanel5.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, -1, 20));

        txtTableNumber.setText("0");
        jPanel5.add(txtTableNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 160, 20));

        txtCodeCahar.setText("0");
        jPanel5.add(txtCodeCahar, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 60, 170, 20));

        txtCapacti.setText("0");
        jPanel5.add(txtCapacti, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 170, -1));

        jpMake.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 300, 120));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCountPrson.setBackground(java.awt.Color.lightGray);
        txtCountPrson.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel4.add(txtCountPrson, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 220, 30));

        UserName3.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName3.setText("To");
        UserName3.setToolTipText("");
        jPanel4.add(UserName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 30, 20));

        txtStartTime.setEditable(false);
        txtStartTime.setBackground(java.awt.Color.lightGray);
        txtStartTime.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtStartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStartTimeActionPerformed(evt);
            }
        });
        jPanel4.add(txtStartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 220, 30));

        UserName.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName.setText("Count Prson");
        UserName.setToolTipText("");
        jPanel4.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, 20));

        txtEndTime.setBackground(java.awt.Color.lightGray);
        txtEndTime.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel4.add(txtEndTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 220, 30));

        dtReservationDate.setForeground(new java.awt.Color(255, 255, 255));
        dtReservationDate.setDateFormatString("dd‏/MM‏/y ");
        jPanel4.add(dtReservationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 220, 30));

        btEndTime.setText("jButton1");
        btEndTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEndTimeActionPerformed(evt);
            }
        });
        jPanel4.add(btEndTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 40, 30));

        btsave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btsave.setText("Save");
        btsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsaveActionPerformed(evt);
            }
        });
        jPanel4.add(btsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 210, -1));

        btStartTime.setText("jButton1");
        btStartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartTimeActionPerformed(evt);
            }
        });
        jPanel4.add(btStartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 40, 30));

        UserName2.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName2.setText("Reservation Date");
        UserName2.setToolTipText("");
        jPanel4.add(UserName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, -1));

        UserName6.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        UserName6.setText("From");
        UserName6.setToolTipText("");
        jPanel4.add(UserName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, 20));

        jpMake.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 600, 210));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserName1.setFont(new java.awt.Font("Cambria Math", 0, 24)); // NOI18N
        UserName1.setText("Customer Info");
        UserName1.setToolTipText("");
        jPanel2.add(UserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 150, -1));

        UserName5.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName5.setText("Phone");
        UserName5.setToolTipText("");
        jPanel2.add(UserName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 50, 20));

        UserName7.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName7.setText("Name");
        UserName7.setToolTipText("");
        jPanel2.add(UserName7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 50, 20));

        UserName8.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName8.setText("Address");
        UserName8.setToolTipText("");
        jPanel2.add(UserName8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 60, 20));

        btSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSearch.setText("Save");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });
        jPanel2.add(btSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 40, 30));

        btNew.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btNew.setForeground(new java.awt.Color(255, 0, 51));
        btNew.setText("+");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });
        jPanel2.add(btNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 40, 30));

        txtCustomerName.setText("0");
        jPanel2.add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 140, 20));

        txtAddress.setText("0");
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 150, -1));

        txtPhone.setText("0");
        jPanel2.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 100, 150, -1));

        txtCustmoerId.setText("0");
        jPanel2.add(txtCustmoerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jpMake.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 290, 120));

        getContentPane().add(jpMake, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 610, 420));

        jpList.setBackground(new java.awt.Color(51, 51, 51));
        jpList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbReservation.setBackground(new java.awt.Color(51, 51, 51));
        tbReservation.setModel(new javax.swing.table.DefaultTableModel(
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
        tbReservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbReservationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbReservation);

        jpList.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 590, 290));

        btDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btDelete.setText("Deletee");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        jpList.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 210, 30));

        lbName.setBackground(new java.awt.Color(255, 255, 255));
        lbName.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        lbName.setForeground(java.awt.Color.white);
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbName.setText("Delete Reservationt");
        lbName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNameMouseClicked(evt);
            }
        });
        jpList.add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 50));

        getContentPane().add(jpList, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 600, 420));

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

    private void lbNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbNameMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btMakeReservationtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMakeReservationtActionPerformed

        jpMake.setVisible(true);
        jpList.setVisible(false);
    }//GEN-LAST:event_btMakeReservationtActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btViewReservationtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewReservationtActionPerformed
       jpList.setVisible(true);
       jpMake.setVisible(false);
       btDelete.setVisible(false);
       lbName.setText("List Reservation");
    }//GEN-LAST:event_btViewReservationtActionPerformed

    private void btDeleteReservationtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteReservationtActionPerformed
       jpList.setVisible(true);
       jpMake.setVisible(false);
       btDelete.setVisible(true);
       lbName.setText("Delete Reservation");
       
    }//GEN-LAST:event_btDeleteReservationtActionPerformed

    private void btSingOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSingOutActionPerformed
       WaiterMain m = new WaiterMain();
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_btSingOutActionPerformed

    private void btsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsaveActionPerformed
         try {
            // TODO add your handling code here:
          
            AddReservation();
              cleanDate();
              tableReservation();
                      
          jpMake.setVisible(false);
     
        
            // tableCategroies();
        } catch (SQLException ex) {
            Logger.getLogger(DiningTableFr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ReservationFr.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_btsaveActionPerformed

    private void txtStartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStartTimeActionPerformed
        // TODO add your handling code here:
     

    }//GEN-LAST:event_txtStartTimeActionPerformed

    private void btStartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartTimeActionPerformed
        timePicker1.showPopup(this, 100, 100);
    }//GEN-LAST:event_btStartTimeActionPerformed

    private void btEndTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEndTimeActionPerformed
 timePicker1.showPopup(this, 100, 100);    }//GEN-LAST:event_btEndTimeActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        CustomerListChose chose = new CustomerListChose(1);
        chose.pack();
        chose.setVisible(true);
        chose.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btSearchActionPerformed

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        CustomerFr fr = new CustomerFr(waiter,1);
        fr.pack();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btNewActionPerformed

    private void btSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearch1ActionPerformed
        DiningTableListChose chose = new DiningTableListChose(1);
        chose.pack();
        chose.setVisible(true);
        chose.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btSearch1ActionPerformed

    private void btNew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNew1ActionPerformed
        DiningTableFr fr = new DiningTableFr(waiter,1);
        fr.pack();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_btNew1ActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void lbShiftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbShiftMouseClicked

    }//GEN-LAST:event_lbShiftMouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void lbUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserNameMouseClicked

    }//GEN-LAST:event_lbUserNameMouseClicked

    private void lbTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTypeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTypeMouseClicked

    private void lbPositionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPositionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbPositionMouseClicked

    private void lbSalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalaryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbSalaryMouseClicked

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
          int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
                if (check == 0) {
                    reservationBL.deleteReservationById(resid);
                    tableReservation();
              
                }
    }//GEN-LAST:event_btDeleteActionPerformed

    int resid;
    private void tbReservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbReservationMouseClicked
        this.reservation = new Reservation();
        DefaultTableModel model = (DefaultTableModel) tbReservation.getModel();
        int selectedrow = tbReservation.getSelectedRow();

        reservation.setReservationId(Integer.parseInt(model.getValueAt(selectedrow, 0).toString()));
        resid=reservation.getReservationId();
        btDelete.setEnabled(true);
    }//GEN-LAST:event_tbReservationMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        UIManager.setLookAndFeel(new FlatMacDarkLaf());

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservationFr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserName;
    private javax.swing.JLabel UserName1;
    private javax.swing.JLabel UserName10;
    private javax.swing.JLabel UserName11;
    private javax.swing.JLabel UserName2;
    private javax.swing.JLabel UserName3;
    private javax.swing.JLabel UserName4;
    private javax.swing.JLabel UserName5;
    private javax.swing.JLabel UserName6;
    private javax.swing.JLabel UserName7;
    private javax.swing.JLabel UserName8;
    private javax.swing.JLabel UserName9;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btDeleteReservationt;
    private javax.swing.JButton btEndTime;
    private javax.swing.JButton btMakeReservationt;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btNew1;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btSearch1;
    private javax.swing.JButton btSingOut;
    private javax.swing.JButton btStartTime;
    private javax.swing.JButton btViewReservationt;
    private javax.swing.JButton btsave;
    private com.toedter.calendar.JDateChooser dtReservationDate;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpList;
    private javax.swing.JPanel jpMake;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPosition;
    private javax.swing.JLabel lbSalary;
    private javax.swing.JLabel lbShift;
    private javax.swing.JLabel lbType;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JTable tbReservation;
    private com.raven.swing.TimePicker timePicker1;
    private com.raven.swing.TimePicker timePicker2;
    public static javax.swing.JLabel txtAddress;
    public static javax.swing.JLabel txtCapacti;
    public static javax.swing.JLabel txtCodeCahar;
    private javax.swing.JTextField txtCountPrson;
    public static javax.swing.JLabel txtCustmoerId;
    public static javax.swing.JLabel txtCustomerName;
    private javax.swing.JTextField txtEndTime;
    public static javax.swing.JLabel txtId;
    public static javax.swing.JLabel txtPhone;
    private javax.swing.JTextField txtStartTime;
    public static javax.swing.JLabel txtTableNumber;
    // End of variables declaration//GEN-END:variables
}
