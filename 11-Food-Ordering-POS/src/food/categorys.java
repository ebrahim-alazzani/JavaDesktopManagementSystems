/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
//import static product.Product.con;

/**
 *
 * @author AZZ
 */
public class categorys extends javax.swing.JFrame {

    int c_id;
    String Imagepath;
    String cat_name;
    String category;
    Connection sos = null;
    PreparedStatement sss = null;
    ResultSet rs = null;
    DataService ds;

    /**
     * Creates new form category
     */
    public categorys() {
        initComponents();
        tablecategory();
        tableitem();
        get_category();
        id.setVisible(false);
        updateemp.setEnabled(false);
        Delete.setEnabled(false);;
 ds=new DataService();
        jTextField3.setVisible(false);
        p.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
        q.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
         state_box.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
        //System.out.println(category);

    }

    public ImageIcon Resize(String Imagepath) {
        ImageIcon myimage = null;
        if (Imagepath != null)
            myimage = new ImageIcon(Imagepath);
        Image img = myimage.getImage();
        img = img.getScaledInstance(leb_image.getWidth(), leb_image.getHeight(), Image.SCALE_SMOOTH);  
        return  new ImageIcon(img);
    }

    public void tablecategory() {

        try {
            DefaultTableModel model = new DefaultTableModel(new String[]{"id ", "name", "state"}, 0);
           Connection con = new Connectdb().openDb();

            String sql = "select * from category";
            sss = con.prepareStatement(sql);
            rs = sss.executeQuery();
            while (rs.next()) {
                /// System.out.println(rs.getString("name") + "");
                model.addRow(new Object[]{rs.getString("id"), rs.getString("name"), rs.getString("state")});

            }
            jTable1.setModel(model);
        } catch (Exception e) {

        }

    }

    public void tableitem() {
        
       
         DefaultTableModel mode2 = new DefaultTableModel(new String[]{"id ", "name", "price", "description ", "date", "state", "category_id ", "quantity", "image"}, 0);
        try {

           // Date d = new Date();
           
            Connection con = new Connectdb().openDb();
            
            String sql = "select * from item";
            
            sss = con.prepareStatement(sql);
            
            rs = sss.executeQuery();
             

            while (rs.next()) {
                // 
                /// System.out.println(rs.getString("name") + "");
                mode2.addRow(new Object[]{rs.getString("id"), rs.getString("name"), rs.getString("price"), rs.getString("description"), rs.getString("date"), rs.getString("state"), rs.getString("category_id"), rs.getString("quantity"), rs.getString("img")});

            }
            
            jTable2.setModel(mode2);
        } catch (Exception e) {

        }

    }

    public void get_category_id() {

        try {
            Connection con = new Connectdb().openDb();
            String s = "select * from category where name=?";

            sss = con.prepareStatement(s);
            sss.setString(1, cat_name);
            rs = sss.executeQuery();

            // jComboBox1.removeAllItems();
            while (rs.next()) {
                // model.addRow(new Object[]{rs.getString("id"), rs.getString("name")});
                c_id = Integer.valueOf(rs.getString("id"));
                //id =rs.getString("id");
                System.out.println(c_id);
            }
        } catch (Exception e) {
        }

    }

    public void get_category() {

        try {
            Connection con = new Connectdb().openDb();
            String s = "select * from category";
            sss = con.prepareStatement(s);
            rs = sss.executeQuery();
            com_cat.removeAllItems();

            while (rs.next()) {
                //  model.addRow(new Object[]{rs.getString("id"), rs.getString("name")});
                com_cat.addItem(rs.getString("name"));

            }
        } catch (Exception e) {
            ///////////////////////////////
        }

    }
    Product product;
    public  void intilationDataItem(){

      

               
                    if (n.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Add A name");

        } else if (p.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Add A price");

        }
        else if (d.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Add A description");

        }
       
        
     else if (q.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Add A quantity");

        }
         else {
              String name = n.getText();
                Double price = Double.valueOf(p.getText());
                String desc = d.getText();

                int state = Integer.valueOf(state_box.getText());
                int quantity = Integer.valueOf(q.getText());
                cat_name = com_cat.getSelectedItem().toString();
                get_category_id();

                  product=new Product();
                   product=new Product(0,name,price,desc,state,c_id,quantity,Imagepath);
        }
    }
    boolean s;

    public boolean addData(){
       
            intilationDataItem();
            //actionGender().equals("not selected")
      try{   
                  
                if (ds.insertitem(product)== 1) {
                    JOptionPane.showMessageDialog(this, "Your account has been created sucessfully!", "Entry Error", 1);
                      s=true;
                JOptionPane.showMessageDialog(null, "Updated Successfully");

                clear_box();
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
            }
                  return  s;

        }

 public boolean updateData(){
       
            intilationDataItem();
             if (id.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Add A quantity");

        }else{
         int item_id = Integer.valueOf(id.getText());

            //actionGender().equals("not selected")
      try{   
                  
                if (ds.update_item(product,item_id)== 1) {
                    JOptionPane.showMessageDialog(this, "Your account has been created sucessfully!", "Entry Error", 1);
                      s=true;
                JOptionPane.showMessageDialog(null, "Updated Successfully");

                clear_box();
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
            }
             }          return  s;

        }
 category categor; 
    public  void intilationDatacategory(){

      

               
                    if (jTextField1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Add A name category(");

        } else if (jTextField2.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Add A state");

        
     }
         else {
                String c_name = jTextField1.getText();
        String c_state = jTextField2.getText();

                  categor=new category(c_name,Integer.parseInt(c_state));
        }
    }
    public boolean addDatacategory(){
       
intilationDatacategory();            //actionGender().equals("not selected")
      try{   
                  
                if (ds.inser_category(categor)== 1) {
                    JOptionPane.showMessageDialog(this, "Your category has been created sucessfully!", "Entry Error", 1);
                      s=true;

                clear_box();
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
            }
                  return  s;

        }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        n = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        p = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        d = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        q = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        com_cat = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        state_box = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        add_s = new javax.swing.JButton();
        label_s = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        updateemp = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        leb_image = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(java.awt.Color.darkGray);

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(java.awt.Color.darkGray);
        jTable1.setForeground(java.awt.Color.lightGray);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("category");

        jLabel2.setText("type");

        jTextField3.setText("jTextField3");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(199, Short.MAX_VALUE))
        );

        jTable2.setBackground(java.awt.Color.darkGray);
        jTable2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable2.setForeground(java.awt.Color.lightGray);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", ""
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel2.setBackground(java.awt.Color.darkGray);

        n.setMinimumSize(new java.awt.Dimension(6, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setText("Price");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setText("Description");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("Quantity");

        com_cat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        com_cat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                com_catItemStateChanged(evt);
            }
        });
        com_cat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                com_catMouseClicked(evt);
            }
        });
        com_cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_catActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setText("Type");

        state_box.setText("1");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setText("State");

        add_s.setText("Add");
        add_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_sActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setText("Iamge");

        id.setText("jTextField4");
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        updateemp.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        updateemp.setText("Update");
        updateemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateempActionPerformed(evt);
            }
        });

        Delete.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        leb_image.setToolTipText("");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leb_image)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(q, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(state_box, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(com_cat, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(updateemp, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton5))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label_s, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(add_s, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(leb_image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(com_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add_s))
                        .addGap(18, 18, 18)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateemp)
                                    .addComponent(Delete)
                                    .addComponent(jButton5)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(state_box, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Mange Prodact  & Category");

        jButton4.setBackground(java.awt.Color.red);
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("X");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(666, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(467, 467, 467)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jButton7.setText("Open File Text");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setText("Save File Text");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1555, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-9, 10, 1660, 2370));

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void clear_box(){
        id.setText("");
        n.setText("");
        p.setText("");
        d.setText("");
        state_box.setText("");
        q.setText("");
        label_s.setText("");
        leb_image.setIcon( new ImageIcon());
    
}
    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
       // int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
            int check = JOptionPane.showConfirmDialog(null, "Do you want to delete?");

        if (check == 0) {

            try {
             //    Connection c = con();
                Connection con = new Connectdb().openDb();
                String sql = "DELETE FROM item WHERE id =?";
                this.sss = con.prepareCall(sql);
                 this.sss.setInt(1,Integer.valueOf(id.getText()));
                 this.sss.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
                System.out.println(e.getMessage());
            }
              tableitem();

        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteActionPerformed

    private void updateempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateempActionPerformed
          boolean x=updateData();
        if(x==true){
           tableitem();
        tablecategory();   
        }else{
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_updateempActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           boolean x=addData();
        if(x==true){
           tableitem();
        tablecategory();   
        }else{
            
        }

      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void add_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_sActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);

        File f = chooser.getSelectedFile();
        leb_image.setIcon( Resize(f.toString()));

        String f_name = f.getAbsolutePath();
        File dir = new File(f_name);
        if (!dir.exists()) {
            dir.mkdirs();

        }
        File sourefile = null;
        File dest = null;
        String exten = f_name.substring(f_name.lastIndexOf('\\') + 1);
        System.out.println(exten);
        sourefile = new File(f_name);
        String d1 = "D:\\";
        
        dest = new File(d1 + "/imagel." +new Random().nextInt(1000000) + exten); // we use Random to solve  repeated image name 

        try {
            Files.copy(sourefile.toPath(), dest.toPath());
        } catch (IOException ex) {
            Logger.getLogger(categorys.class.getName()).log(Level.SEVERE, null, ex);
        }

        label_s.setText(dest.toString());
        Imagepath = dest.toString();
      
        Imagepath = Imagepath.replace("\\", "///");   // to save path in database with out problems
       
    }//GEN-LAST:event_add_sActionPerformed

    private void com_catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_catActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_com_catActionPerformed

    private void com_catMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_com_catMouseClicked
       // System.out.println("0000  "+com_cat.getSelectedItem().toString());
        cat_name = com_cat.getSelectedItem().toString();
        get_category_id();
        // TODO add your handling code here:
    }//GEN-LAST:event_com_catMouseClicked

    private void com_catItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_com_catItemStateChanged

        // System.out.println("1");
        // TODO add your handling code here:
    }//GEN-LAST:event_com_catItemStateChanged

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        DefaultTableModel mode2 = (DefaultTableModel) jTable2.getModel();
        int selectedrow = jTable2.getSelectedRow();
        id.setText(mode2.getValueAt(selectedrow, 0).toString());
        n.setText(mode2.getValueAt(selectedrow, 1).toString());
        p.setText(mode2.getValueAt(selectedrow, 2).toString());
        d.setText(mode2.getValueAt(selectedrow, 3).toString());
        state_box.setText(mode2.getValueAt(selectedrow, 5).toString());
         c_id = Integer.valueOf(mode2.getValueAt(selectedrow, 6).toString());
        q.setText(mode2.getValueAt(selectedrow, 7).toString());
       
        updateemp.setEnabled(true);
        Delete.setEnabled(true);
        label_s.setText(mode2.getValueAt(selectedrow, 8).toString().replace("///", "\\"));
            JFileChooser ch = new JFileChooser();
            File f = ch.getSelectedFile();
            String f_name = label_s.getText();
            ImageIcon icon = new ImageIcon(f_name);
            System.out.println(f_name);
            Image g = icon.getImage().getScaledInstance(leb_image.getWidth(), leb_image.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(g);
            leb_image.setIcon(icon);
            // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedrow = jTable1.getSelectedRow();
        jTextField1.setText(model.getValueAt(selectedrow, 1).toString());
        jTextField2.setText(model.getValueAt(selectedrow, 2).toString());
        jTextField3.setText(model.getValueAt(selectedrow, 0).toString());

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 boolean x=addDatacategory();
        if(x==true){
           
        tablecategory();   
        }else{
            
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete?");

        if (check == 0) {
            String id = jTextField3.getText();

            try {
                Connection con = new Connectdb().openDb();
                String sql = "DELETE FROM category WHERE id = '" + id + "'";
                sss = con.prepareCall(sql);
                sss.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
                tablecategory();
                jTextField1.setText(" ");
                jTextField2.setText(" ");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
                                     
private void doOpenFile() {
    int result = k.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        Path path = k.getSelectedFile().toPath();

        try {
            String contentString = "";

            for (String s : Files.readAllLines(path, StandardCharsets.UTF_8)) {
                contentString += s;
            }

            jTextArea2.setText(contentString);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
JFileChooser k=new JFileChooser();
private void doSaveFile() {
    int result;
                    result = k.showSaveDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        // We'll be making a mytmp.txt file, write in there, then move it to
        // the selected
        // file. This takes care of clearing that file, should there be
        // content in it.
        File targetFile = k.getSelectedFile();

        try {
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }

            FileWriter fw = new FileWriter(targetFile+".txt");

            fw.write(jTextArea1.getText());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
        if( JOptionPane.showConfirmDialog(null,"Are you sure to close window ", "Warning",JOptionPane.WARNING_MESSAGE) == 0)
            this.dispose();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       clear_box();
    }//GEN-LAST:event_jButton5ActionPerformed
 
    
//Full texts
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            jTextArea1.setLineWrap(true);
            jTextArea1.setText("producet Id :  "+id.getText());
            jTextArea1.append("\n");
            jTextArea1.setText( jTextArea1.getText()+" "+"Product name :  "+n.getText());
            jTextArea1.append("\n");
            jTextArea1.append("\n");
            jTextArea1.setText( jTextArea1.getText()+" "+" Product price :  "+p.getText());
            jTextArea1.append("\n");
            jTextArea1.append("\n");
            jTextArea1.setText( jTextArea1.getText()+" "+" Product category_id :  "+com_cat.getSelectedItem().toString());
            jTextArea1.append("\n");
            jTextArea1.append("\n");
            jTextArea1.setText( jTextArea1.getText()+" "+"Product Name  :  "+state_box.getText());
            jTextArea1.append("\n");
            jTextArea1.append("\n");
            jTextArea1.setText( jTextArea1.getText()+" "+"Product description  :  "+d.getText());
            jTextArea1.append("\n");
            jTextArea1.append("\n");
            jTextArea1.setText( jTextArea1.getText()+" "+"Product quantity  :  "+q.getText());
            jTextArea1.append("\n");
            jTextArea1.append("\n");
            jTextArea1.append("\n");
            FileOutputStream fos = null;
            String fileData = jTextArea1.getText();
            fos = new FileOutputStream(n.getText()+".txt");
            fos.write(fileData.getBytes());
            fos.flush();
            fos.close();
            FileWriter myWriter = null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
        }
        doSaveFile() ;

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        doOpenFile();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed


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
            java.util.logging.Logger.getLogger(categorys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(categorys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(categorys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(categorys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new categorys().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton add_s;
    private javax.swing.JComboBox com_cat;
    private javax.swing.JTextField d;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField label_s;
    private javax.swing.JLabel leb_image;
    private javax.swing.JTextField n;
    private javax.swing.JTextField p;
    private javax.swing.JTextField q;
    private javax.swing.JTextField state_box;
    private javax.swing.JButton updateemp;
    // End of variables declaration//GEN-END:variables

  
}
