/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AdminOP;

import BussnuesLogacl.FoodsBL;
import Model.Chef;
import Model.Foods;
import Model.Reservation;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;



public class ChefMain extends javax.swing.JFrame {

    private FoodsBL foodsBL;
    private Foods foods;
    private String ImgPath;
    private String type;
    private  Chef chef;
    private int foodId;
    

    public ChefMain() {
        initComponents();
      }
   
    public ChefMain(Chef c) {
        initComponents();
        foodsBL=new FoodsBL();
        foods=new Foods();
        chef=c;
        jpListDelte.setVisible(false);
        jpAddFood.setVisible(false);
        jpList.setVisible(false);
              tbDessert.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbDessert.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
             
                + "separatorColor:$TableHeader.background");
          tbDrkins.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbDrkins.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
             
                + "separatorColor:$TableHeader.background");
        
          tbFood.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbFood.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
             
                + "separatorColor:$TableHeader.background");
        
          tbMainCaurs.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbMainCaurs.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
             
                + "separatorColor:$TableHeader.background");

 tbPizza.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbPizza.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
             
                + "separatorColor:$TableHeader.background");     
        
 tbSalad.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbSalad.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
             
                + "separatorColor:$TableHeader.background");     
 tbSandwich.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbSandwich.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
             
                + "separatorColor:$TableHeader.background");     
                
       
        refrchTable();
        txtFiledNumberOnly();
        FullDateChef();
    }
    public  void FullDateChef(){
        lbUserName.setText(chef.getUserName());
        lbType.setText(chef.getTybe());
        lbExperience.setText(chef.getExperience()+"");
        lbSpecialization.setText(chef.getSpecialization());
        lbPosition.setText(chef.getPosition());
    }
    public void txtFiledNumberOnly(){
        txtPrice.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
         txtCalories.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });  
    }

    public  void refrchTable(){
     
        tableFoods();
        tableFoodsType("MainCaurs");
        tableFoodsType("Drinks");
        tableFoodsType("Dessert");
        tableFoodsType("Salad");
        tableFoodsType("Sandwich");
        tableFoodsType("Pizza");
        
    }
    
    public void tableFoods() {
        DefaultTableModel model = new DefaultTableModel(new Object[]
        {"FoodId","FoodName","FoodType","Price", "Quantity","Calories","FoodImg"
            }, 0);
        ArrayList<Foods> list = foodsBL.FoodsArrayList();
        Object rowdata[] = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            rowdata[0] = list.get(i).getFoodId();
            rowdata[1] = list.get(i).getFoodName();
            rowdata[2] = list.get(i).getFoodType();
            rowdata[3] = list.get(i).getPrice();
            rowdata[4] = list.get(i).getQuantity();
            rowdata[5] = list.get(i).getCalories();
            model.addRow(rowdata);
        }
        tbFood.setModel(model);
    }
      
    public void tableFoodsType(String Type) {
        DefaultTableModel model = new DefaultTableModel(new Object[]
        {"FoodId","FoodName","Price", "Quantity","Calories"
            }, 0);
        ArrayList<Foods> list = foodsBL.FoodsArrayList(Type);
        Object rowdata[] = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            rowdata[0] = list.get(i).getFoodId();
            rowdata[1] = list.get(i).getFoodName();
            rowdata[2] = list.get(i).getPrice();
            rowdata[3] = list.get(i).getQuantity();
            rowdata[4] = list.get(i).getCalories();
            model.addRow(rowdata);
        }
        if(Type.equals("MainCaurs")){
             tbMainCaurs.setModel(model);
        }
        else if(Type.equals("Drinks")){
             tbDrkins.setModel(model);
        }
         else if(Type.equals("Dessert")){
             tbDessert.setModel(model);
        }
         else if(Type.equals("Salad")){
             tbSalad.setModel(model);
        }
         else if(Type.equals("Sandwich")){
             tbSandwich.setModel(model);
        }
         else if(Type.equals("Pizza")){
             tbPizza.setModel(model);
        }
    }
      
        public void TypeSelecyed() {
        if (rbMainCaurs.isSelected()) {
            type = "MainCaurs";
        }
        if (rbDrinks.isSelected()) {
            type = "Drinks";
        }
        if (rbDessert.isSelected()) {
            type = "Dessert";
        }
        if (rbSalaad.isSelected()) {
            type = "Salad";
        }
        if (rbSandwich.isSelected()) {
            type = "Sandwich";
        }
        if (rbPizza.isSelected()) {
            type = "Pizza";
        }
    }
    
        
    public void AddNewFoods()  throws SQLException {
        int result = 0;
        if (txtFoodName.getText().equals("") ||
                txtPrice.getText().equals("")
                || txtCalories.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } 
        else {
            foods.setFoodName(txtFoodName.getText().toString());
            foods.setPrice(Double.parseDouble(txtPrice.getText().toString()));
            foods.setQuantity(Integer.parseInt(spQuantity.getValue().toString()));
            foods.setFoodType(type);
            foods.setCalories(Integer.parseInt(txtCalories.getText().toString()));
            foods.setFoodImg(ImgPath);
            foods.setChef(chef);
            try {
                if (foodsBL.InsertFoods(foods) == 1) {
                    tableFoods();
                    JOptionPane.showMessageDialog(this, "Records inserted successfully.", "Entry v", 1);
                } else {
                    JOptionPane.showMessageDialog(this, "Records insertion failed.", "Entry Error", 1);
                }
            } catch (SQLException ex) {
            Logger.getLogger(Foods.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public ImageIcon Resize(String Imagepath) {
        ImageIcon myimage = null;
        if (Imagepath != null) {
            myimage = new ImageIcon(Imagepath);
        }
        Image img = myimage.getImage();
        img = img.getScaledInstance(imgView.getWidth(), imgView.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jpListDelte = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFood = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        btDeletFood = new javax.swing.JButton();
        jpList = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbDrkins = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbSalad = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbDessert = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbPizza = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbSandwich = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Salad = new javax.swing.JLabel();
        tbSa = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbMainCaurs = new javax.swing.JTable();
        jpAddFood = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFoodName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        imgView = new javax.swing.JLabel();
        addImage = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        rbDrinks = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        rbMainCaurs = new javax.swing.JRadioButton();
        rbDessert = new javax.swing.JRadioButton();
        rbSalaad = new javax.swing.JRadioButton();
        rbSandwich = new javax.swing.JRadioButton();
        rbPizza = new javax.swing.JRadioButton();
        spQuantity = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        btSave1 = new javax.swing.JButton();
        txtCalories = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exit1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btSingOut = new javax.swing.JButton();
        btDisplay = new javax.swing.JButton();
        btDeleteEmployee = new javax.swing.JButton();
        btAddEmployee1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        hh = new javax.swing.JLabel();
        lbSpecialization = new javax.swing.JLabel();
        lbExperience = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbPosition = new javax.swing.JLabel();
        jbHome = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

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

        jpListDelte.setBackground(new java.awt.Color(51, 51, 51));
        jpListDelte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbFood.setBackground(new java.awt.Color(51, 51, 51));
        tbFood.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbFood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbFood.setToolTipText("");
        tbFood.setSelectionBackground(new java.awt.Color(255, 153, 153));
        tbFood.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbFood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFoodMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFood);

        jpListDelte.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 710, 370));

        jLabel14.setBackground(new java.awt.Color(51, 51, 255));
        jLabel14.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Foods List ");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jpListDelte.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        btDeletFood.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btDeletFood.setText("Delete");
        btDeletFood.setEnabled(false);
        btDeletFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletFoodActionPerformed(evt);
            }
        });
        jpListDelte.add(btDeletFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 160, -1));

        getContentPane().add(jpListDelte, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 810, 480));

        jpList.setBackground(new java.awt.Color(51, 51, 51));
        jpList.setToolTipText("");
        jpList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbDrkins.setBackground(new java.awt.Color(51, 51, 51));
        tbDrkins.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        tbDrkins.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tbDrkins);

        jpList.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 350, 120));

        tbSalad.setBackground(new java.awt.Color(51, 51, 51));
        tbSalad.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        tbSalad.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tbSalad);

        jpList.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 350, 120));

        tbDessert.setBackground(new java.awt.Color(51, 51, 51));
        tbDessert.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        tbDessert.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tbDessert);

        jpList.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 370, 120));

        tbPizza.setBackground(new java.awt.Color(51, 51, 51));
        tbPizza.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        tbPizza.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(tbPizza);

        jpList.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 350, 120));

        tbSandwich.setBackground(new java.awt.Color(51, 51, 51));
        tbSandwich.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        tbSandwich.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(tbSandwich);

        jpList.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 370, 120));

        jLabel15.setBackground(new java.awt.Color(51, 51, 255));
        jLabel15.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Pizza");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jpList.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, 30));

        jLabel17.setBackground(new java.awt.Color(51, 51, 255));
        jLabel17.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Foods List ");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jpList.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 300, 30));

        jLabel18.setBackground(new java.awt.Color(51, 51, 255));
        jLabel18.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Main caurs");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jpList.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 30));

        jLabel19.setBackground(new java.awt.Color(51, 51, 255));
        jLabel19.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Drkins");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jpList.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, 30));

        jLabel20.setBackground(new java.awt.Color(51, 51, 255));
        jLabel20.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Dessert");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jpList.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, 30));

        Salad.setBackground(new java.awt.Color(51, 51, 255));
        Salad.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 18)); // NOI18N
        Salad.setForeground(new java.awt.Color(255, 255, 255));
        Salad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Salad.setText("Salad");
        Salad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaladMouseClicked(evt);
            }
        });
        jpList.add(Salad, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, 30));

        tbSa.setBackground(new java.awt.Color(51, 51, 255));
        tbSa.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 18)); // NOI18N
        tbSa.setForeground(new java.awt.Color(255, 255, 255));
        tbSa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbSa.setText("Sandwich");
        tbSa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSaMouseClicked(evt);
            }
        });
        jpList.add(tbSa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, 30));

        tbMainCaurs.setAutoCreateColumnsFromModel(false);
        tbMainCaurs.setBackground(new java.awt.Color(51, 51, 51));
        tbMainCaurs.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        tbMainCaurs.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(tbMainCaurs);

        jpList.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, 120));

        getContentPane().add(jpList, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 810, 480));

        jpAddFood.setBackground(new java.awt.Color(51, 51, 51));
        jpAddFood.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel7.setText("Calories");
        jpAddFood.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 100, 40));

        jLabel10.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel10.setText("Food Name");
        jpAddFood.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, 40));

        txtFoodName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpAddFood.add(txtFoodName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 210, 30));

        jLabel11.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel11.setText("Price");
        jpAddFood.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, 30));

        txtPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        jpAddFood.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 140, 30));

        imgView.setBackground(new java.awt.Color(102, 102, 102));
        imgView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AdminOP/menu_main.jpg"))); // NOI18N
        jpAddFood.add(imgView, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 190, 110));

        addImage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addImage.setForeground(java.awt.Color.white);
        addImage.setText("Chose Image");
        addImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addImageActionPerformed(evt);
            }
        });
        jpAddFood.add(addImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 140, 60));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rbDrinks);
        rbDrinks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbDrinks.setText("Drinks");
        rbDrinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDrinksActionPerformed(evt);
            }
        });
        jPanel6.add(rbDrinks, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 100, -1));

        jLabel16.setFont(new java.awt.Font("Cambria Math", 0, 26)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setText("Food Type");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        buttonGroup1.add(rbMainCaurs);
        rbMainCaurs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbMainCaurs.setText("Main Caurs");
        rbMainCaurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMainCaursActionPerformed(evt);
            }
        });
        jPanel6.add(rbMainCaurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 100, -1));

        buttonGroup1.add(rbDessert);
        rbDessert.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbDessert.setText("Dessert");
        rbDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDessertActionPerformed(evt);
            }
        });
        jPanel6.add(rbDessert, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 100, -1));

        buttonGroup1.add(rbSalaad);
        rbSalaad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbSalaad.setText("Salad");
        rbSalaad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSalaadActionPerformed(evt);
            }
        });
        jPanel6.add(rbSalaad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 100, -1));

        buttonGroup1.add(rbSandwich);
        rbSandwich.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbSandwich.setText("Sandwich");
        rbSandwich.setToolTipText("");
        rbSandwich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSandwichActionPerformed(evt);
            }
        });
        jPanel6.add(rbSandwich, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 100, -1));

        buttonGroup1.add(rbPizza);
        rbPizza.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbPizza.setText("Pizza");
        rbPizza.setToolTipText("");
        rbPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPizzaActionPerformed(evt);
            }
        });
        jPanel6.add(rbPizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 100, -1));

        jpAddFood.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 600, 140));

        spQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jpAddFood.add(spQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 140, 30));

        jLabel12.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel12.setText("Price");
        jpAddFood.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, 30));

        btSave1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btSave1.setText("Save");
        btSave1.setToolTipText("");
        btSave1.setEnabled(false);
        btSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSave1ActionPerformed(evt);
            }
        });
        jpAddFood.add(btSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 390, -1));

        txtCalories.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCalories.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCaloriesCaretUpdate(evt);
            }
        });
        txtCalories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCaloriesActionPerformed(evt);
            }
        });
        jpAddFood.add(txtCalories, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 210, 30));

        jLabel13.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel13.setText("Quantity :");
        jpAddFood.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, 30));

        jLabel9.setBackground(new java.awt.Color(51, 51, 255));
        jLabel9.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Food Add");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jpAddFood.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        getContentPane().add(jpAddFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 810, 480));

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, -1, 480));

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
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 30));

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Foods");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, -1));

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
        jPanel1.add(btDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 170, -1));

        btDeleteEmployee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btDeleteEmployee.setForeground(java.awt.Color.white);
        btDeleteEmployee.setText("Delete Foods");
        btDeleteEmployee.setToolTipText("");
        btDeleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteEmployeeActionPerformed(evt);
            }
        });
        jPanel1.add(btDeleteEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 170, -1));

        btAddEmployee1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btAddEmployee1.setForeground(java.awt.Color.white);
        btAddEmployee1.setText("Add Foods");
        btAddEmployee1.setToolTipText("");
        btAddEmployee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddEmployee1ActionPerformed(evt);
            }
        });
        jPanel1.add(btAddEmployee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 170, -1));

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
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel22.setBackground(new java.awt.Color(51, 51, 51));
        jLabel22.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Type");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

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
        jPanel1.add(lbUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 90, -1));

        lbType.setBackground(new java.awt.Color(51, 51, 51));
        lbType.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbType.setForeground(new java.awt.Color(255, 255, 255));
        lbType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTypeMouseClicked(evt);
            }
        });
        jPanel1.add(lbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 70, 20));

        jLabel23.setBackground(new java.awt.Color(51, 51, 51));
        jLabel23.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Specialization");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        hh.setBackground(new java.awt.Color(51, 51, 51));
        hh.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        hh.setForeground(new java.awt.Color(255, 255, 255));
        hh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hh.setText("Experience");
        hh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hhMouseClicked(evt);
            }
        });
        jPanel1.add(hh, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 140, 90, -1));

        lbSpecialization.setBackground(new java.awt.Color(51, 51, 51));
        lbSpecialization.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbSpecialization.setForeground(java.awt.Color.white);
        lbSpecialization.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSpecialization.setText("    ");
        lbSpecialization.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSpecializationMouseClicked(evt);
            }
        });
        jPanel1.add(lbSpecialization, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 150, 40));

        lbExperience.setBackground(new java.awt.Color(51, 51, 51));
        lbExperience.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbExperience.setForeground(new java.awt.Color(255, 255, 255));
        lbExperience.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbExperience.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExperienceMouseClicked(evt);
            }
        });
        jPanel1.add(lbExperience, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 70, 20));

        jLabel24.setBackground(new java.awt.Color(51, 51, 51));
        jLabel24.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Position");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        lbPosition.setBackground(new java.awt.Color(51, 51, 51));
        lbPosition.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbPosition.setForeground(new java.awt.Color(255, 255, 255));
        lbPosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPosition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPositionMouseClicked(evt);
            }
        });
        jPanel1.add(lbPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 100, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 480));

        jbHome.setBackground(new java.awt.Color(51, 51, 51));
        jbHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Welcome Chef");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jbHome.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 450, 80));

        getContentPane().add(jbHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 740, 480));

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

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btSingOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSingOutActionPerformed

        MainSystem m = new MainSystem();
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_btSingOutActionPerformed

    private void btDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDisplayActionPerformed
        // TODO add your handling code here:
         jpListDelte.setVisible(false);
         jpAddFood.setVisible(false);
         jpList.setVisible(true);
    }//GEN-LAST:event_btDisplayActionPerformed

    private void btDeleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteEmployeeActionPerformed
        jpListDelte.setVisible(true);
        jpAddFood.setVisible(false);
        jpList.setVisible(false);
    }//GEN-LAST:event_btDeleteEmployeeActionPerformed

    private void btAddEmployee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddEmployee1ActionPerformed
        jpListDelte.setVisible(false);
        jpAddFood.setVisible(true);
        jpList.setVisible(false);       
    }//GEN-LAST:event_btAddEmployee1ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void addImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addImageActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        imgView.setIcon(Resize(f.toString()));
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
        dest = new File(d1 + "/imagel." + new Random().nextInt(1000000) + exten); // we use Random to solve  repeated image name
        try {
            Files.copy(sourefile.toPath(), dest.toPath());
        } catch (IOException ex) {
        }
        ImgPath = dest.toString();
        ImgPath = ImgPath.replace("\\", "///");   // to save path in database with out problems

    }//GEN-LAST:event_addImageActionPerformed

    private void rbDrinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDrinksActionPerformed
        // TODO add your handling code here:
        TypeSelecyed();
    }//GEN-LAST:event_rbDrinksActionPerformed

    private void rbMainCaursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMainCaursActionPerformed
        // TODO add your handling code here:
        TypeSelecyed();
    }//GEN-LAST:event_rbMainCaursActionPerformed

    private void btSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSave1ActionPerformed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            AddNewFoods();
            refrchTable();
            jpListDelte.setVisible(false);
            jpAddFood.setVisible(false);
            jpList.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_btSave1ActionPerformed

    private void txtCaloriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCaloriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCaloriesActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void rbDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDessertActionPerformed
       TypeSelecyed();

    }//GEN-LAST:event_rbDessertActionPerformed

    private void rbSalaadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSalaadActionPerformed
       TypeSelecyed();

    }//GEN-LAST:event_rbSalaadActionPerformed

    private void rbSandwichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSandwichActionPerformed
       TypeSelecyed();

    }//GEN-LAST:event_rbSandwichActionPerformed

    private void rbPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPizzaActionPerformed
       TypeSelecyed();

    }//GEN-LAST:event_rbPizzaActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked

    private void SaladMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaladMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SaladMouseClicked

    private void tbSaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbSaMouseClicked

    private void btDeletFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletFoodActionPerformed
    int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
                if (check == 0) {
                    foodsBL.deleteFoodById(foodId);
                    tableFoods();
              
                
    }                     
    }//GEN-LAST:event_btDeletFoodActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void lbUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserNameMouseClicked

    }//GEN-LAST:event_lbUserNameMouseClicked

    private void lbTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTypeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTypeMouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void hhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_hhMouseClicked

    private void lbSpecializationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSpecializationMouseClicked

    }//GEN-LAST:event_lbSpecializationMouseClicked

    private void lbExperienceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExperienceMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbExperienceMouseClicked

    private void txtCaloriesCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCaloriesCaretUpdate
       btSave1.setEnabled(true);
    }//GEN-LAST:event_txtCaloriesCaretUpdate

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void lbPositionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPositionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbPositionMouseClicked

    private void tbFoodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFoodMouseClicked
        this.foods = new Foods();
        DefaultTableModel model = (DefaultTableModel) tbFood.getModel();
        int selectedrow = tbFood.getSelectedRow();

        foods.setFoodId(Integer.parseInt(model.getValueAt(selectedrow, 0).toString()));
        foodId=foods.getFoodId();
        btDeletFood.setEnabled(true);
    }//GEN-LAST:event_tbFoodMouseClicked

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
                new ChefMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Salad;
    private javax.swing.JButton addImage;
    private javax.swing.JButton btAddEmployee1;
    private javax.swing.JButton btDeletFood;
    private javax.swing.JButton btDeleteEmployee;
    private javax.swing.JButton btDisplay;
    private javax.swing.JButton btSave1;
    private javax.swing.JButton btSingOut;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel hh;
    private javax.swing.JLabel imgView;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jbHome;
    private javax.swing.JPanel jpAddFood;
    private javax.swing.JPanel jpList;
    private javax.swing.JPanel jpListDelte;
    private javax.swing.JLabel lbExperience;
    private javax.swing.JLabel lbPosition;
    private javax.swing.JLabel lbSpecialization;
    private javax.swing.JLabel lbType;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JRadioButton rbDessert;
    private javax.swing.JRadioButton rbDrinks;
    private javax.swing.JRadioButton rbMainCaurs;
    private javax.swing.JRadioButton rbPizza;
    private javax.swing.JRadioButton rbSalaad;
    private javax.swing.JRadioButton rbSandwich;
    private javax.swing.JSpinner spQuantity;
    private javax.swing.JTable tbDessert;
    private javax.swing.JTable tbDrkins;
    private javax.swing.JTable tbFood;
    private javax.swing.JTable tbMainCaurs;
    private javax.swing.JTable tbPizza;
    private javax.swing.JLabel tbSa;
    private javax.swing.JTable tbSalad;
    private javax.swing.JTable tbSandwich;
    private javax.swing.JTextField txtCalories;
    private javax.swing.JTextField txtFoodName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
