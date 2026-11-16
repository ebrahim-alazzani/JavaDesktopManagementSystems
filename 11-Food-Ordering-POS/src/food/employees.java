package food;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import food.*;
import food.Connectdb;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import static food.Connectdb.con;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;

/**
 *
 * @author AZZ
 */
public class employees extends javax.swing.JFrame {
   // Connection sos = null;
    Employee employee;
   public Job job_class;
   Categ categ;
    String gender = "Male";
        DataService ds;

     
    /**
     * Creates new form employees
     */
    public employees() {
        this.job_class =new Job();
        categ=new Categ();
        categ.setCategorieId(1);
      this.job_class.setId(1); // defoult job if not insert job all will be waiter
        this.employee = new Employee();
        ds=new DataService();
        initComponents();
      
        get_job();
        
        tableemp();
        salary_box.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
         phon_number_box.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
       
     // tableemp();
        emp_id.setVisible(false);
       
    }
 public void cleanTextBox(){
     
     firs_name_box.setText("");
     last_name_box.setText("");
     salary_box.setText("");
     phon_number_box.setText("");
     
 }
    public void gender_m_f() {
        if (male.isSelected()) {
            gender = "Male";
        }
        if (female.isSelected()) {
            gender = "Female";
        }
    }
    
   
public void get_job(){
     try {
          //  preparedStatement = con.prepareStatement("select *  from tables ");
   //         this.resultSet = preparedStatement.executeQuery();
             //tables_list.removeAllItems();
            com_box.removeAllItems();
             ArrayList<Job> jobs_list =  ds.Selectjobs();
             for (int i = 0; i < jobs_list.size(); i++)
             {
                 com_box.setModel(new DefaultComboBoxModel(jobs_list.toArray()));
             }
           
         } catch (Exception ex) {
             System.out.println(ex.getMessage());
         }
}

//-----------------------------------------------------------------------------------


     public void tableemp(){
    //new DefaultTableModel(new String[] {"id","name","price","Qty","Total"},0);
  DefaultTableModel model = new DefaultTableModel(new Object[]{"id", "frist_name ", "last_name ",
                "gender", "hire_date ", " salary", "phone_number", " job_id"}, 0);
                ArrayList<Employee> list = ds.Selectemployee();
    Object rowdata[] = new Object[9];
    //System.out.println("size" + list.size());
    for (int i = 0; i < list.size(); i++)
    {   
        rowdata[0] = list.get(i).getIdE();
        rowdata[1] = list.get(i).getFrist_name();
          rowdata[2] = list.get(i).getLast_name();
        rowdata[3] = list.get(i).getGanders();
          rowdata[4] = list.get(i).getHire_date();
        rowdata[5] = list.get(i).getSealary();
        rowdata[6] = list.get(i).getPhone_number();
                  rowdata[7] = list.get(i).getId();

        model.addRow(rowdata);
    }
        
        jTable1.setModel(model);
}

/*public void search() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"id", "frist_name ", "last_name ",
            "gender", "hire_date ", " salary", "phone_number", " job_id"}, 0);

        String sea = search.getText();

        try {
            //Connection c = con();
            String sql = "SELECT * FROM employee WHERE  frist_name LIKE '%" + sea + "%'OR id LIKE '%" + sea + "%'";
            this.preparedStatement = con.prepareStatement(sql);
            this.resultSet = this.preparedStatement.executeQuery();
            // while (rs.next()) {
            System.out.println(this.resultSet.getString("id") + "");
               // model.addRow(new Object[]{rs.getString("id"), rs.getString("frist_name"), rs.getString("last_name"), rs.getString("gender"),
            ///  rs.getString("hire_date"), rs.getString("salary"), rs.getString("phone_number"), rs.getString("job_id")});

            // }
            jTable2.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }
*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
 public char actionGender(){
        if(male.isSelected()){
            return 'M';
        }else if(female.isSelected()){
                       return 'F';
 
        }else{
            return 'n';
        }
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        salary_box = new javax.swing.JTextField();
        phon_number_box = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        com_box = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        emp_id = new javax.swing.JTextField();
        firs_name_box = new javax.swing.JTextField();
        last_name_box = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Clear_box = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("AGA Arabesque", 1, 14)); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(java.awt.Color.gray);

        jTable1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(java.awt.Color.gray);
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.lightGray);
        jLabel2.setText("First name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.lightGray);
        jLabel3.setText("Last name");

        salary_box.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        salary_box.setName("sal"); // NOI18N
        salary_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salary_boxActionPerformed(evt);
            }
        });

        phon_number_box.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phon_number_box.setName("phone_number"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.lightGray);
        jLabel5.setText("Salary");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.lightGray);
        jLabel4.setText("Phone number");

        com_box.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        com_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        com_box.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                com_boxItemStateChanged(evt);
            }
        });
        com_box.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                com_boxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                com_boxMouseEntered(evt);
            }
        });
        com_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_boxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.lightGray);
        jLabel6.setText("Job ID");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.lightGray);
        jLabel7.setText("Gender");

        buttonGroup1.add(male);
        male.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        male.setLabel("M");
        male.setName("male"); // NOI18N
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        buttonGroup1.add(female);
        female.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        female.setLabel("F");
        female.setName("female"); // NOI18N
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        emp_id.setText("jTextField6");

        firs_name_box.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        firs_name_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firs_name_boxActionPerformed(evt);
            }
        });

        last_name_box.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        last_name_box.setName("lastname"); // NOI18N
        last_name_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last_name_boxActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        Clear_box.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Clear_box.setText("Cancel");
        Clear_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_boxActionPerformed(evt);
            }
        });
        jPanel1.add(Clear_box);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firs_name_box, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(salary_box, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                .addComponent(last_name_box, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 45, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(male, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(female, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(com_box, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phon_number_box, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firs_name_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(last_name_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salary_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phon_number_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(com_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(male)
                    .addComponent(female))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton4)
                .addGap(117, 117, 117))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Manage Employees");

        button1.setBackground(new java.awt.Color(255, 51, 0));
        button1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("X");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(604, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(386, 386, 386)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel1.setText("search");

        search.setBackground(new java.awt.Color(204, 204, 204));
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(639, 639, 639)
                                .addComponent(jLabel1)
                                .addGap(39, 39, 39)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void addData(){
           
            
            
            String countPhone= String.valueOf(phon_number_box.getText().length());
            int countInt=Integer.parseInt(countPhone);
            char x=actionGender();
            //actionGender().equals("not selected")
        if (firs_name_box.getText().equals("") || last_name_box .equals("") || 
                salary_box.equals("") || x=='n' ) {
                JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", JOptionPane.WARNING_MESSAGE);
        }
             if(countInt<9 || countInt >9){
                JOptionPane.showMessageDialog(this, "Phone number must contain exactly 10 digits.", "Entry Error", JOptionPane.WARNING_MESSAGE);
        }
        else {
             //int id=GetNextValue("persons", "person_id");
                
                ds.insert(firs_name_box.getText(),last_name_box.getText(),
                Double.valueOf(salary_box.getText()),phon_number_box.getText(),this.gender, this.job_class.getId());
                
            
        }
      
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
         try
         {
        
       addData();
        
         cleanTextBox();
          tableemp();
         }catch(Exception e){
             JOptionPane.showMessageDialog(null," error"+e.getMessage());
             System.out.println(e.getMessage());
         }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
public void updateData(){
           
            
            
            String countPhone= String.valueOf(phon_number_box.getText().length());
            int countInt=Integer.parseInt(countPhone);
            char x=actionGender();
            //actionGender().equals("not selected")
        if (firs_name_box.getText().equals("") || last_name_box .equals("") || 
                salary_box.equals("") || x=='n' ) {
                JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", JOptionPane.WARNING_MESSAGE);
        }
             if(countInt<9 || countInt >9){
                JOptionPane.showMessageDialog(this, "Phone number must contain exactly 10 digits.", "Entry Error", JOptionPane.WARNING_MESSAGE);
        }
        else {
             //int id=GetNextValue("persons", "person_id");
                
               ds.update(Integer.valueOf(emp_id.getText()), firs_name_box.getText(),last_name_box.getText(),
                Double.valueOf(salary_box.getText()),phon_number_box.getText(),this.gender, this.job_class.getId());
                
            
        }
      
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       
         updateData();
        
        cleanTextBox();
         tableemp();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void firs_name_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firs_name_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firs_name_boxActionPerformed

    private void salary_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salary_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salary_boxActionPerformed

    private void last_name_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last_name_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_last_name_boxActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        
        
        gender_m_f();  // if choose gender this method call
       
    }//GEN-LAST:event_femaleActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
       this.job_class = new Job();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        int selectedrow = jTable1.getSelectedRow();
        firs_name_box.setText(model.getValueAt(selectedrow, 1).toString());
        last_name_box.setText(model.getValueAt(selectedrow, 2).toString()); 
        phon_number_box.setText(model.getValueAt(selectedrow, 6).toString());
        salary_box.setText(model.getValueAt(selectedrow, 5).toString());
        emp_id.setText(model.getValueAt(selectedrow, 0).toString());
        this.job_class.setId( Integer.valueOf(model.getValueAt(selectedrow, 7).toString()));
        gender = model.getValueAt(selectedrow, 4).toString();
      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
        if (check == 0) 
        {
            int empId = Integer.valueOf(emp_id.getText());
            ds.delete(empId);   
            cleanTextBox();
            tableemp();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void com_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_boxActionPerformed

        job_class = (Job)com_box.getSelectedItem();
    }//GEN-LAST:event_com_boxActionPerformed

    private void com_boxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_com_boxItemStateChanged

    }//GEN-LAST:event_com_boxItemStateChanged

    private void com_boxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_com_boxMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_com_boxMouseClicked

    private void com_boxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_com_boxMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_com_boxMouseEntered

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
///search();
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyReleased

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        gender_m_f();
        // TODO add your handling code here:
    }//GEN-LAST:event_maleActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        if( JOptionPane.showConfirmDialog(null,"Are you sure to close window ", "Warning",JOptionPane.WARNING_MESSAGE) == 0)
        this.dispose();

    }//GEN-LAST:event_button1ActionPerformed

    private void Clear_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_boxActionPerformed
        
        cleanTextBox();
    }//GEN-LAST:event_Clear_boxActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
                        JOptionPane.showMessageDialog(this, "Phgits."+job_class.getId(), "Entry Error", JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear_box;
    private java.awt.Button button1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox com_box;
    private javax.swing.JTextField emp_id;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField firs_name_box;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField last_name_box;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField phon_number_box;
    private javax.swing.JTextField salary_box;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables

    
}
