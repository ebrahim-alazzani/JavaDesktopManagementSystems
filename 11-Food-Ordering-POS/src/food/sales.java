/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package food;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.ImageIcon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Computer
 */

public class sales extends javax.swing.JFrame {
    
    //DefaultTableModel modelbill;
    DefaultTableModel modelBill = new DefaultTableModel(new String[] {"id","name","price","Qty","Total"},0);
    Connection con = new Connectdb().openDb();
    PreparedStatement preparedStatement;
    ResultSet re ;
    User user ;
    TableRest table;          // class Table 
    double total_bill = 0.0;
  // Color itemColor = new Color(236,164,66);
     Color catBackColor = new Color(255,255,255);
     Color catFrontColor = new Color(0,0,0);
    Color itemBackColor = new Color(255,255,255);
    // Color itemBackColor = new Color(255,0,255);
     Color itemFrontColor = new Color(0,0,0);
  

    
   /**
     * Creates new form sales
     */
     
    public sales(User user) {
        
        initComponents();
        this.table = new TableRest();
        table.setId(1);         //  defualt table number 
        this.user = user;
        user_name_label.setText("user Name : " + user.getUser_name());
        add.setEnabled(false);
        get_table();
         item_price.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
         item_qty.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
          item_qty_save.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
        categorySelect();
        getBillId();
    }
    
public void get_table(){
     try {
            preparedStatement = con.prepareStatement("select *  from tables ");
            re = preparedStatement.executeQuery();
             tables_list.removeAllItems();
             ArrayList<TableRest> tablelist = new ArrayList();
            while (re.next()) 
           {
               tablelist.add(new TableRest(re.getInt("id"), re.getString("name"),re.getInt("capacity")));
           
              tables_list.setModel(new DefaultComboBoxModel(tablelist.toArray()));
           }   
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
}
public void get_total_bill (DefaultTableModel modelBill){
    double temp =0.0;
     for (int i =0; i< modelBill.getRowCount();i++)
        {
            temp += Double.valueOf( modelBill.getValueAt(i, 4).toString());      
        }
    total_bill = temp;
    total_bill_box .setText(total_bill + "");
}
    public void getBillId()
    {
        
         try {
             preparedStatement = con.prepareStatement("select max(id) as billid from orders");
              re = preparedStatement.executeQuery();
             while (re.next()) 
           {
               int id =Integer.valueOf(re.getString("billid"));
               bill_id.setText((id+1)+"");
           }   
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
            
    }
    
    public void categorySelect(){
          item_id.setVisible(false);
     try {
          
            preparedStatement = con.prepareStatement("select * from category");
            re = preparedStatement.executeQuery();
            Dimension dm= jPanel1.getPreferredSize();
            dm.height=0;
            dm.width= 0;
            jPanel1.setPreferredSize(dm); 
            int control_btn_location_y =0;
           while (re.next()) 
           {
               jPanel1.add( createBtn( control_btn_location_y * 200, re.getString("name")));          
               dm.height = dm.height + 100;
               dm.width =dm.width + 200;
               jPanel1.setPreferredSize(dm);
               control_btn_location_y++;    
            }
          
        }catch( Exception e)
        {
            System.out.println(e.getMessage());
        }
}

public JButton createBtn(int var, String cat_name)
{
        JButton button;
        button = new JButton();
        button.setBounds(var,1, 200, 150);
       // button.setBackground(add.getBackground() );
        button.setForeground(catFrontColor);
        button.setFont(new Font("Tahoma", 1, 16));
        button.setText(cat_name);
        
        button.addActionListener(new ActionListener()
        {            
            public void actionPerformed(ActionEvent e)
            {
                // check if button of category is press if anther button pree this does not work
               if(e.getSource() == button)
               {
                   itemSelect(((JButton)e.getSource()).getText());  
               }           
            } 
        });
        return button;
}



 public JButton createBtn2(int hor, int var, String  item_n, String item_img){
      JButton button1;
     // ImageIcon icon =new ImageIcon("c:\\a.png");
      button1 = new JButton();
      button1.setBounds(hor,var, 300, 150);
      button1.setBackground(itemBackColor);
       button1.setForeground(itemFrontColor);
      button1.setText(item_n);
      Font n = new Font("Tahoma", 1, 12);
      button1.setFont( n);
      button1.setIcon(Resize(item_img, button1));
     
      button1.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e){
                
                if(e.getSource() == button1)
                {
                    try
                    {
                       
                        preparedStatement = con.prepareStatement("select id, name, price ,quantity from item  where name ='"+ ((JButton)e.getSource()).getText() + "'");
                        re = preparedStatement.executeQuery();
                        item_id.setText("");
                        item_name.setText("");
                        item_price.setText("");
                        item_qty_save.setText("");
                        add.setEnabled(true);
                        while(re.next())
                        { 
                            item_id.setText(re.getInt("id")+"");
                            item_name.setText(re.getNString("name"));
                            item_price.setText(re.getDouble("price")+"");
                            item_qty_save.setText(re.getInt("quantity")+"");
                            item_qty.setText(1+"");
                        
                        }
                       
                    } catch(Exception ex)
                      {
                          System.out.println(ex.getMessage());
                      }
                  }
                  }
        });
        return button1;
}

/*public void selectbill(String id, String name, String price, String qty){
       //modelbill = new DefaultTableModel(new String[] {"id", "name","price","quantity"},0);
     //  modelbill.addRow(new Object[] {id,name,price,qty});
       //jTable3.setModel(modelbill);
       
       
    // DefaultTableModel model = new DefaultTableModel(new String[] {"id", ""},0);
}*/
public void itemSelect(String cat_name){
     try 
     { 
        preparedStatement = con.prepareStatement("select item.name as Name, price,img "
                + "from item join category on item.category_id = category.id where category.name ='"+ cat_name + "'");

        re = preparedStatement.executeQuery();    
        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();
        Dimension dm= jPanel2.getPreferredSize();
        dm.height=0;
        dm.width=0;
        jPanel2.setPreferredSize(dm); 
        int var = 1;
        int hor = 0;
         
        while (re.next()) 
        {
            
            if(hor == 1200)
            {
                hor =0;
                if (var ==0)
                {
                    var +=100;
                }
                else
                {
                    var +=150-1;
                }
            }
            String str = re.getString("Name");
            String img_path = re.getNString("img");
            jPanel2.add(createBtn2(hor, var,str,img_path));
            hor += 300; 
            dm.height = dm.height+200;
            dm.width = dm.width+400;
            jPanel1.setPreferredSize(dm);
        }// end while
         
        }catch( Exception e){
            System.out.println(e.getMessage());
        }
}
public void insert_order(DefaultTableModel modelBill , int orders_id, double total_price_order, int user_id, int table_id){
        try{
            
            String sql ="insert into orders (total,user_id,table_id) values(?, ?, ?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, total_price_order );
            preparedStatement.setInt(2, user_id);
            preparedStatement.setInt(3, table_id);
            
            preparedStatement.execute();
              
            for (int i =0; i< modelBill.getRowCount();i++)
            {
                int itemid= Integer.valueOf( modelBill.getValueAt(i, 0).toString());
                double itemPrice = Double.valueOf( modelBill.getValueAt(i, 2).toString());
                int itemQty = Integer.valueOf( modelBill.getValueAt(i, 3).toString());
                sql ="update  item set quantity = quantity - " + itemQty +" where id = " + itemid;
                preparedStatement.execute(sql);
                
                sql="insert into order_detail (quantity,price,item_id,order_id)"
                                              + " values("+itemQty+","+itemPrice+","+itemid+","+orders_id+")";
                preparedStatement.execute(sql);
               
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
      
}

public ImageIcon Resize(String Imagepath,JButton btn) {
        ImageIcon myimage = new ImageIcon(Imagepath);
        Image img = myimage.getImage();
        img = img.getScaledInstance(btn.getWidth()/2, btn.getHeight(), Image.SCALE_SMOOTH);
        return  new ImageIcon(img);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        item_qty = new javax.swing.JTextField();
        item_name = new javax.swing.JTextField();
        item_price = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        item_qty_save = new javax.swing.JTextField();
        jLabel6q = new javax.swing.JLabel();
        jLabel7q = new javax.swing.JLabel();
        total_bill_box = new java.awt.Label();
        jButton2 = new javax.swing.JButton();
        item_id = new javax.swing.JTextField();
        bill_id = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        label1 = new java.awt.Label();
        tables_list = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        user_name_label = new javax.swing.JLabel();

        jInternalFrame1.setBackground(new java.awt.Color(0, 204, 204));
        jInternalFrame1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("pos");
        setBackground(new java.awt.Color(0, 204, 204));
        setUndecorated(true);
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBackground(new java.awt.Color(236, 164, 66,80));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        item_qty.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        item_qty.setName("item_qty"); // NOI18N
        item_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_qtyActionPerformed(evt);
            }
        });

        item_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        item_name.setEnabled(false);
        item_name.setName("item_name"); // NOI18N
        item_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_nameActionPerformed(evt);
            }
        });

        item_price.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        item_price.setEnabled(false);
        item_price.setName("item_price"); // NOI18N
        item_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_priceActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("price ");

        add.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add.setText("ADD");
        add.setToolTipText("");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Name ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Quantity save");

        jButton1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        item_qty_save.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        item_qty_save.setEnabled(false);
        item_qty_save.setName("item_name"); // NOI18N
        item_qty_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_qty_saveActionPerformed(evt);
            }
        });

        jLabel6q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6q.setText("Total ");

        jLabel7q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7q.setText("Quantity");

        total_bill_box.setBackground(new java.awt.Color(255, 255, 255));
        total_bill_box.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        total_bill_box.setText("0.0");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7q, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6q, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_name, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_price, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_qty_save, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_bill_box, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(338, 338, 338))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(item_name, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(item_price)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(item_qty_save, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(item_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7q, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6q, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(total_bill_box, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        item_id.setEditable(false);
        item_id.setEnabled(false);
        item_id.setName("item_id"); // NOI18N
        item_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_idActionPerformed(evt);
            }
        });

        bill_id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bill_id.setMargin(new java.awt.Insets(2, 2, 2, 14));
        bill_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_idActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1174, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 667, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1216, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("  Number Invice Context :");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        label1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        label1.setText("Table numbe");

        tables_list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tables_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tables_listMouseClicked(evt);
            }
        });
        tables_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tables_listActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1202, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(item_id, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(54, 54, 54)
                                .addComponent(bill_id, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(tables_list, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tables_list, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bill_id, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(104, 104, 104)
                .addComponent(item_id, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );

        jPanel4.setBackground(new java.awt.Color(236, 164, 66));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setForeground(new java.awt.Color(236, 164, 66,80));

        jLabel1.setBackground(new java.awt.Color(0, 250, 0,80));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("POS");

        button1.setBackground(new java.awt.Color(255, 51, 0));
        button1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("X");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        user_name_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        user_name_label.setText("jLabel6");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(user_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(594, 594, 594)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(user_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1801, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       // modelBill = new DefaultTableModel(new String[] {"id","name","price","Qty","Total"},0);
      try{  int saveQty =  Integer.valueOf(item_qty_save.getText());
        int ordQty =  Integer.valueOf(item_qty.getText());
        if( ordQty < saveQty )
        {
            double total_price_order = Integer.valueOf(item_qty.getText()) * Double.valueOf(item_price.getText());
           // System.out.println("*********************************************");
            modelBill.addRow(new Object[]{item_id.getText(),item_name.getText(),item_price.getText(),item_qty.getText(),total_price_order});
           // System.out.println("****************************************");
            jTable2.setModel(modelBill);  
          
            item_id.setText("");
            item_name.setText("");
            item_price.setText("");  
            item_qty.setText("");
            item_qty_save.setText("");
            add.setEnabled(false);
            
            get_total_bill((DefaultTableModel)jTable2.getModel());
           
        }
        else
           JOptionPane.showConfirmDialog(null, " Quantity not not allow");
      }catch(Exception e)
      {
          System.out.println("696: " + e.getMessage());
      }
              
    }//GEN-LAST:event_addActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if( JOptionPane.showConfirmDialog(null,"Do you confirm this order ", "Question",JOptionPane.WARNING_MESSAGE) == 0)
      {
          // DefaultTableModel modelBill = new DefaultTableModel(new String[] {"id","name","price","Qty","Total"},0);
           modelBill =( DefaultTableModel) jTable2.getModel();
           int orders_id = Integer.valueOf(bill_id.getText());
           insert_order( modelBill, orders_id,total_bill, this.user.getId(),this.table.getId());
           System.out.println("************** table id : " + this.table.getId());
           modelBill=new DefaultTableModel(null,new String[] {"id","name","price","Qty","Total"});
           jTable2.setModel(modelBill);
           jTable2.removeAll();
           total_bill_box.setText("0.0");
           getBillId();
      }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void item_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item_nameActionPerformed

    private void bill_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bill_idActionPerformed

    private void item_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item_idActionPerformed

    private void item_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item_qtyActionPerformed

    private void item_qty_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_qty_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item_qty_saveActionPerformed

    private void item_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item_priceActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        int chickMess =  JOptionPane.showConfirmDialog(null,"Are you sure to close window ", "Warning",JOptionPane.WARNING_MESSAGE);
        if(chickMess == 0 && this.user.getRole() == 1)
            this.dispose();
        if(chickMess == 0 && this.user.getRole() == 3)
            System.exit(0);
      
    }//GEN-LAST:event_button1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
      if( JOptionPane.showConfirmDialog(null,"Are you sure cancel this order ", "Warning",JOptionPane.WARNING_MESSAGE) == 0)
      {
         //DefaultTableModel  model=new DefaultTableModel(new String[] {"id", "name","price","quantity"},0);
            modelBill=new DefaultTableModel(null,new String[] {"id","name","price","Qty","Total"});
            jTable2.setModel(modelBill);
            jTable2.removeAll();
            total_bill_box.setText("0.0");
      }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
         modelBill = ( DefaultTableModel)jTable2.getModel();
         modelBill.removeRow(jTable2.getSelectedRow());
            jTable2.setModel(modelBill);
           
    }//GEN-LAST:event_jTable2MouseClicked

    private void tables_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tables_listActionPerformed
     
        this.table =  (TableRest) tables_list.getSelectedItem();  
    }//GEN-LAST:event_tables_listActionPerformed

    private void tables_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tables_listMouseClicked
 //System.out.println("+++"+ tables_list.getItemAt(tables_list.getSelectedIndex()));
//      this.table =  (TableRest) tables_list.getSelectedItem();        // TODO add your handling code here:
    }//GEN-LAST:event_tables_listMouseClicked

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
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
           /*sales i =    new sales();
           i.setVisible(true);*/
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton bill_id;
    private java.awt.Button button1;
    private javax.swing.JTextField item_id;
    private javax.swing.JTextField item_name;
    private javax.swing.JTextField item_price;
    private javax.swing.JTextField item_qty;
    private javax.swing.JTextField item_qty_save;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6q;
    private javax.swing.JLabel jLabel7q;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private java.awt.Label label1;
    private javax.swing.JComboBox tables_list;
    private java.awt.Label total_bill_box;
    private javax.swing.JLabel user_name_label;
    // End of variables declaration//GEN-END:variables
}
