
package AdminOP;

import BussnuesLogacl.OrderBL;
import Model.Customers;
import Model.DiningTable;
import Model.Foods;
import Model.Order;
import Model.OrderDetails;
import Model.Waiter;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.multi.MultiLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;



public class OrderMenu extends javax.swing.JFrame {
    private OrderBL orderBL;
    private Order order=new Order();
    private OrderDetails details=new OrderDetails();
    private Waiter waiter;
    private Foods foods=new Foods();
    private Customers customers;
    private DiningTable diningTable;
    private ArrayList<Foods> foodses;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private Date date=new Date();
    private String datestring=dateFormat.format(date);
    private int OrderId;
    public static int customerId;
    public static int tableId;
    public boolean addOrder=false;
    public static boolean coustomerExites=false,tableExites=false;
    private int Quntity;
    private double Price;
   
    
    public OrderMenu()  {
        initComponents();
    }
    
    
    public OrderMenu(Waiter w)  {
        initComponents();
        orderBL=new OrderBL();
        waiter=w;
        
        try {
            getOrderId();
        } 
        catch (SQLException ex) {
            Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        FullDateChef();
    }

  
    public  void FullDateChef(){
        lbUserName.setText(waiter.getUserName());
        lbType.setText(waiter.getTybe());
        lbSalary.setText(waiter.getSalary()+"");
        lbShift.setText(waiter.getShift());
        lbPosition.setText(waiter.getPosition());
    }
    
    public void getOrderId() throws SQLException {
        OrderId = orderBL.GetNextValue("Orders", "OrderId");
        txtOrderId.setText(OrderId+"");  
        txtDate.setText(datestring);
        getList();       
    }
      
    public void getList(){
        ArryListMainCaurs();
        ArryListDrinks();
        ArryListDessert();
        ArryListSandwich();
        ArryListPizza();
        ArryListSalad();
    }
    public void AddOrderNew() {
        int result = 0;
        order=new Order();
        customers=new Customers();
        customers.setCustomerId(customerId);
        customers.setCustomerName(txtCustomerName.getText());
        diningTable=new DiningTable();
        diningTable.setTableId(tableId);
        diningTable.setCodeCharTable(txtCodeCahar.getText());

        try {
            OrderId = orderBL.GetNextValue("Orders", "OrderId");
        }
        catch (SQLException ex) {
            Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        order.setOrderId(OrderId);
        order.setOrderDate( new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()));
        order.setDiningTable(diningTable);
        order.setCustomers(customers);
        order.setWaiter(waiter);
        try {
            if (orderBL.InsertOrders(order) == 1) {
                addOrder=true;
            } else {
                JOptionPane.showMessageDialog(this, "Records insertion failed.", "Entry Error", 1);
                addOrder=false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
            addOrder=false;
        }
    }

    public void AddFoods()throws SQLException{
        int result = 0;
        if(Price==0&&Quntity<=0 ){
            JOptionPane.showMessageDialog(this, "Records  .", "Entry Error", 1);
        }
        else{
            details.setFoods(foods);
            details.setOrder(order);
            details.setPrice(Price);
            details.setQuantity(Quntity);

            try {
                if (orderBL.InsertItemOrder(details) == 1) {
                    JOptionPane.showMessageDialog(this, "Records  .", "Entry Error", 1);
                    getList();
                } 
                else {
                    JOptionPane.showMessageDialog(this, "Records insertion failed.", "Entry Error", 1);
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ArrayList<Foods> getFood(String Type) {
        try {
            foodses = orderBL.SelectItems(Type,OrderId);
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return foodses;
     }
    
    public void ArryListMainCaurs(){
        spMainCaurs.removeAllItems();
        ArrayList<Foods> list=getFood("MainCaurs");
        for (int i = 0; i < list.size(); i++) {
            spMainCaurs.setModel(new DefaultComboBoxModel(list.toArray()));
        }
    }
    
    public void ArryListDrinks(){
        spDrinks.removeAllItems();
        ArrayList<Foods> list=getFood("Drinks");
        for (int i = 0; i < list.size(); i++) {
            spDrinks.setModel(new DefaultComboBoxModel(list.toArray()));
        }
    }

    public void ArryListDessert(){
        spDessert.removeAllItems();
        ArrayList<Foods> list=getFood("Dessert");
        for (int i = 0; i < list.size(); i++) {
            spDessert.setModel(new DefaultComboBoxModel(list.toArray()));   
        }
    }
        
    public void ArryListSandwich(){
        spSandwich.removeAllItems();

        ArrayList<Foods> list=getFood("Sandwich");
        for (int i = 0; i < list.size(); i++) {
            spSandwich.setModel(new DefaultComboBoxModel(list.toArray()));
        }
    }
    
    public void ArryListPizza(){
        spPizza.removeAllItems();

        ArrayList<Foods> list=getFood("Pizza");
        for (int i = 0; i < list.size(); i++) {
            spPizza.setModel(new DefaultComboBoxModel(list.toArray()));
        }
    } 
    
    public void ArryListSalad(){
        spSalad.removeAllItems();

        ArrayList<Foods> list=getFood("Salaad");
        for (int i = 0; i < list.size(); i++) {
            spSalad.setModel(new DefaultComboBoxModel(list.toArray()));
        }
    }  
    
    public  void enbledMenu(){    
        if(coustomerExites&&tableExites){
            btGrenetOrder.setEnabled(true);
        }   
    }
    
    public ImageIcon Resize(String Imagepath) {
        ImageIcon myimage = null;
        if (Imagepath != null) {
            myimage = new ImageIcon(Imagepath);
        }
        Image img = myimage.getImage();
        img = img.getScaledInstance(imgMainCaurs.getWidth(), imgMainCaurs.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();
        dtNowDate = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btMakeReservationt = new javax.swing.JButton();
        btViewReservationt = new javax.swing.JButton();
        btGrenetOrder = new javax.swing.JButton();
        btSingOut = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        lbShift = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        lbPosition = new javax.swing.JLabel();
        lbSalary = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exit1 = new javax.swing.JLabel();
        jpMake = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
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
        txtCustmoerId = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        UserName4 = new javax.swing.JLabel();
        UserName9 = new javax.swing.JLabel();
        UserName10 = new javax.swing.JLabel();
        UserName11 = new javax.swing.JLabel();
        btSearch1 = new javax.swing.JButton();
        btNew1 = new javax.swing.JButton();
        txtTableNumber = new javax.swing.JLabel();
        txtCodeCahar = new javax.swing.JLabel();
        txtCapacti = new javax.swing.JLabel();
        txtTableId = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jp = new javax.swing.JTabbedPane();
        jpMainC = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        spMainCaurs = new javax.swing.JComboBox();
        txtPriceMainCaurs = new javax.swing.JLabel();
        spQuantityMainCaurs = new javax.swing.JSpinner();
        btSavespMainCaursr = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        imgMainCaurs = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        txtPriceMainCaursTotall = new javax.swing.JTextField();
        jpdrink = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        spDrinks = new javax.swing.JComboBox();
        spQuantityDrinks = new javax.swing.JSpinner();
        btSaveDrinks = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        imgDrinks = new javax.swing.JLabel();
        txtPriceDrinksTotal = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        txtPriceDrinks = new javax.swing.JLabel();
        jpDess = new javax.swing.JPanel();
        spDessert = new javax.swing.JComboBox();
        imgDessert = new javax.swing.JLabel();
        spQuantityDessert = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txtPriceDessert = new javax.swing.JLabel();
        btSaveDessert = new javax.swing.JButton();
        txtPriceDessertTotal = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jpSandwich = new javax.swing.JPanel();
        spSandwich = new javax.swing.JComboBox();
        imgSandwich = new javax.swing.JLabel();
        spQuantitySandwich = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        txtPriceSandwich = new javax.swing.JLabel();
        btSaveSandwich = new javax.swing.JButton();
        txtPriceSandwichTotall = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jpPazz = new javax.swing.JPanel();
        spPizza = new javax.swing.JComboBox();
        imgPizza = new javax.swing.JLabel();
        spQuantityPizza = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        txtPricePizza = new javax.swing.JLabel();
        btSavePizza = new javax.swing.JButton();
        txtPricePizzaTotal = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jpSaled = new javax.swing.JPanel();
        spSalad = new javax.swing.JComboBox();
        imgSalad = new javax.swing.JLabel();
        spQuantitySalad = new javax.swing.JSpinner();
        jLabel24 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        txtPriceSalad = new javax.swing.JLabel();
        btSaveSalad = new javax.swing.JButton();
        txtPriceSaladTotal = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        UserName12 = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        txtOrderId = new javax.swing.JLabel();
        UserName13 = new javax.swing.JLabel();

        exit.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });

        dtNowDate.setForeground(new java.awt.Color(255, 255, 255));
        dtNowDate.setToolTipText("");
        dtNowDate.setDateFormatString("dd‏/MM‏/y ");
        dtNowDate.setMinSelectableDate(new java.util.Date(-62135776714000L));

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
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 30));

        btMakeReservationt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btMakeReservationt.setText("New Order");
        btMakeReservationt.setToolTipText("");
        btMakeReservationt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMakeReservationtActionPerformed(evt);
            }
        });
        jPanel1.add(btMakeReservationt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 170, -1));

        btViewReservationt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btViewReservationt.setText("View Bill");
        btViewReservationt.setToolTipText("");
        btViewReservationt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewReservationtActionPerformed(evt);
            }
        });
        jPanel1.add(btViewReservationt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 170, -1));

        btGrenetOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btGrenetOrder.setText("Greneter Order");
        btGrenetOrder.setToolTipText("");
        btGrenetOrder.setEnabled(false);
        btGrenetOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrenetOrderActionPerformed(evt);
            }
        });
        jPanel1.add(btGrenetOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 170, -1));

        btSingOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSingOut.setForeground(java.awt.Color.red);
        btSingOut.setText("Sing Out");
        btSingOut.setToolTipText("");
        btSingOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSingOutActionPerformed(evt);
            }
        });
        jPanel1.add(btSingOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 190, -1));

        jLabel25.setBackground(new java.awt.Color(51, 51, 51));
        jLabel25.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Shift");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

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
        jPanel1.add(lbShift, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 110, 30));

        jLabel26.setBackground(new java.awt.Color(51, 51, 51));
        jLabel26.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Salary");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel27.setBackground(new java.awt.Color(51, 51, 51));
        jLabel27.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Position");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel28.setBackground(new java.awt.Color(51, 51, 51));
        jLabel28.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Type");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel29.setBackground(new java.awt.Color(51, 51, 51));
        jLabel29.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("User Name");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbUserName.setBackground(new java.awt.Color(51, 51, 51));
        lbUserName.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbUserName.setForeground(java.awt.Color.white);
        lbUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUserName.setText("    0");
        lbUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUserNameMouseClicked(evt);
            }
        });
        jPanel1.add(lbUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, 20));

        lbType.setBackground(new java.awt.Color(51, 51, 51));
        lbType.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbType.setForeground(new java.awt.Color(255, 255, 255));
        lbType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbType.setText("0");
        lbType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTypeMouseClicked(evt);
            }
        });
        jPanel1.add(lbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 80, 20));

        lbPosition.setBackground(new java.awt.Color(51, 51, 51));
        lbPosition.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbPosition.setForeground(new java.awt.Color(255, 255, 255));
        lbPosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPosition.setText("0");
        lbPosition.setToolTipText("");
        lbPosition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPositionMouseClicked(evt);
            }
        });
        jPanel1.add(lbPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 100, 20));

        lbSalary.setBackground(new java.awt.Color(51, 51, 51));
        lbSalary.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 14)); // NOI18N
        lbSalary.setForeground(new java.awt.Color(255, 255, 255));
        lbSalary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSalary.setText("0");
        lbSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSalaryMouseClicked(evt);
            }
        });
        jPanel1.add(lbSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 120, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 390));

        jPanel3.setBackground(new java.awt.Color(70, 73, 75));
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
        jPanel3.add(exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 30, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, -20, 30, 410));

        jpMake.setBackground(new java.awt.Color(51, 51, 51));
        jpMake.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Orders Menu");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jpMake.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, 40));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserName1.setFont(new java.awt.Font("Cambria Math", 0, 24)); // NOI18N
        UserName1.setText("Customer Info");
        UserName1.setToolTipText("");
        jPanel2.add(UserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 150, -1));

        UserName5.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName5.setText("Phone");
        UserName5.setToolTipText("");
        jPanel2.add(UserName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 50, 20));

        UserName7.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName7.setText("Name");
        UserName7.setToolTipText("");
        jPanel2.add(UserName7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 50, 20));

        UserName8.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName8.setText("Address");
        UserName8.setToolTipText("");
        jPanel2.add(UserName8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 60, 20));

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
        jPanel2.add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 160, 20));
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 66, 170, 20));
        jPanel2.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 96, 170, 20));

        txtCustmoerId.setEditable(false);
        txtCustmoerId.setEnabled(false);
        txtCustmoerId.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCustmoerIdCaretUpdate(evt);
            }
        });
        jPanel2.add(txtCustmoerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jpMake.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 300, 130));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel5.add(btNew1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 40, 30));
        jPanel5.add(txtTableNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 160, 20));
        jPanel5.add(txtCodeCahar, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 60, 170, 20));
        jPanel5.add(txtCapacti, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 170, 20));

        txtTableId.setEditable(false);
        txtTableId.setEnabled(false);
        txtTableId.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTableIdCaretUpdate(evt);
            }
        });
        txtTableId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTableIdActionPerformed(evt);
            }
        });
        jPanel5.add(txtTableId, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jpMake.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 300, 120));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(70, 73, 75)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp.setBackground(new java.awt.Color(51, 51, 51));
        jp.setForeground(java.awt.Color.lightGray);
        jp.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jp.setEnabled(false);
        jp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jpMainC.setBackground(new java.awt.Color(51, 51, 51));
        jpMainC.setEnabled(false);
        jpMainC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel73.setText("Total");
        jpMainC.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 20));

        spMainCaurs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT" }));
        spMainCaurs.setSelectedIndex(-1);
        spMainCaurs.setEnabled(false);
        spMainCaurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spMainCaursActionPerformed(evt);
            }
        });
        jpMainC.add(spMainCaurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, -1));

        txtPriceMainCaurs.setFont(new java.awt.Font("Hiragino Mincho ProN", 0, 14)); // NOI18N
        txtPriceMainCaurs.setText("10");
        jpMainC.add(txtPriceMainCaurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 110, 20));

        spQuantityMainCaurs.setEnabled(false);
        spQuantityMainCaurs.setRequestFocusEnabled(false);
        spQuantityMainCaurs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spQuantityMainCaursStateChanged(evt);
            }
        });
        jpMainC.add(spQuantityMainCaurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 110, 20));

        btSavespMainCaursr.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSavespMainCaursr.setForeground(java.awt.Color.red);
        btSavespMainCaursr.setText("Add To Order");
        btSavespMainCaursr.setEnabled(false);
        btSavespMainCaursr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSavespMainCaursrActionPerformed(evt);
            }
        });
        jpMainC.add(btSavespMainCaursr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 200, -1));

        jLabel19.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel19.setText("Quantity ");
        jpMainC.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

        imgMainCaurs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AdminOP/menu_main.jpg"))); // NOI18N
        jpMainC.add(imgMainCaurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 220, 160));

        jLabel79.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel79.setText("Price ");
        jpMainC.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        txtPriceMainCaursTotall.setEditable(false);
        txtPriceMainCaursTotall.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPriceMainCaursTotallCaretUpdate(evt);
            }
        });
        txtPriceMainCaursTotall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceMainCaursTotallActionPerformed(evt);
            }
        });
        jpMainC.add(txtPriceMainCaursTotall, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 110, -1));

        jp.addTab("Main Caurs", jpMainC);

        jpdrink.setBackground(new java.awt.Color(255, 255, 255));
        jpdrink.setEnabled(false);
        jpdrink.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel20.setText("Quantity ");
        jpdrink.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

        spDrinks.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT" }));
        spDrinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spDrinksActionPerformed(evt);
            }
        });
        jpdrink.add(spDrinks, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, -1));

        spQuantityDrinks.setEnabled(false);
        spQuantityDrinks.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spQuantityDrinksStateChanged(evt);
            }
        });
        spQuantityDrinks.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                spQuantityDrinksVetoableChange(evt);
            }
        });
        jpdrink.add(spQuantityDrinks, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 110, 20));

        btSaveDrinks.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSaveDrinks.setForeground(java.awt.Color.red);
        btSaveDrinks.setText("Add To Order");
        btSaveDrinks.setEnabled(false);
        btSaveDrinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveDrinksActionPerformed(evt);
            }
        });
        jpdrink.add(btSaveDrinks, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 220, -1));

        jLabel74.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel74.setText("Price ");
        jpdrink.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        imgDrinks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AdminOP/menu_main.jpg"))); // NOI18N
        jpdrink.add(imgDrinks, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 220, 160));

        txtPriceDrinksTotal.setEditable(false);
        txtPriceDrinksTotal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPriceDrinksTotalCaretUpdate(evt);
            }
        });
        txtPriceDrinksTotal.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtPriceDrinksTotalCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txtPriceDrinksTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceDrinksTotalActionPerformed(evt);
            }
        });
        jpdrink.add(txtPriceDrinksTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 110, -1));

        jLabel80.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel80.setText("Total");
        jpdrink.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 20));
        jpdrink.add(txtPriceDrinks, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 110, 20));

        jp.addTab("Drinks", jpdrink);

        jpDess.setEnabled(false);
        jpDess.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spDessert.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT" }));
        spDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spDessertActionPerformed(evt);
            }
        });
        jpDess.add(spDessert, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, -1));

        imgDessert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AdminOP/menu_main.jpg"))); // NOI18N
        jpDess.add(imgDessert, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 220, 160));

        spQuantityDessert.setEnabled(false);
        spQuantityDessert.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spQuantityDessertStateChanged(evt);
            }
        });
        jpDess.add(spQuantityDessert, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 110, 20));

        jLabel21.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel21.setText("Quantity ");
        jpDess.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

        jLabel75.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel75.setText("Price ");
        jpDess.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        txtPriceDessert.setFont(new java.awt.Font("Hiragino Mincho ProN", 0, 14)); // NOI18N
        txtPriceDessert.setText("0");
        jpDess.add(txtPriceDessert, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 110, 20));

        btSaveDessert.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSaveDessert.setForeground(java.awt.Color.red);
        btSaveDessert.setText("Add To Order");
        btSaveDessert.setEnabled(false);
        btSaveDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveDessertActionPerformed(evt);
            }
        });
        jpDess.add(btSaveDessert, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 210, -1));

        txtPriceDessertTotal.setEditable(false);
        txtPriceDessertTotal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPriceDessertTotalCaretUpdate(evt);
            }
        });
        txtPriceDessertTotal.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtPriceDessertTotalCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txtPriceDessertTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceDessertTotalActionPerformed(evt);
            }
        });
        jpDess.add(txtPriceDessertTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 110, -1));

        jLabel81.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel81.setText("Total");
        jpDess.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 20));

        jp.addTab("Dessert", jpDess);

        jpSandwich.setEnabled(false);
        jpSandwich.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spSandwich.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT" }));
        spSandwich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spSandwichActionPerformed(evt);
            }
        });
        jpSandwich.add(spSandwich, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, -1));

        imgSandwich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AdminOP/menu_main.jpg"))); // NOI18N
        jpSandwich.add(imgSandwich, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 220, 160));

        spQuantitySandwich.setEnabled(false);
        spQuantitySandwich.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spQuantitySandwichStateChanged(evt);
            }
        });
        jpSandwich.add(spQuantitySandwich, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 110, 20));

        jLabel22.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel22.setText("Quantity ");
        jpSandwich.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

        jLabel76.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel76.setText("Price ");
        jpSandwich.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        txtPriceSandwich.setFont(new java.awt.Font("Hiragino Mincho ProN", 0, 14)); // NOI18N
        txtPriceSandwich.setText("0");
        jpSandwich.add(txtPriceSandwich, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 110, 20));

        btSaveSandwich.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSaveSandwich.setForeground(java.awt.Color.red);
        btSaveSandwich.setText("Add To Order");
        btSaveSandwich.setEnabled(false);
        btSaveSandwich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveSandwichActionPerformed(evt);
            }
        });
        jpSandwich.add(btSaveSandwich, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 230, -1));

        txtPriceSandwichTotall.setEditable(false);
        txtPriceSandwichTotall.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPriceSandwichTotallCaretUpdate(evt);
            }
        });
        txtPriceSandwichTotall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceSandwichTotallActionPerformed(evt);
            }
        });
        jpSandwich.add(txtPriceSandwichTotall, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 110, -1));

        jLabel82.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel82.setText("Total");
        jpSandwich.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        jp.addTab("Sandwich", jpSandwich);

        jpPazz.setEnabled(false);
        jpPazz.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spPizza.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT" }));
        spPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spPizzaActionPerformed(evt);
            }
        });
        jpPazz.add(spPizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, -1));

        imgPizza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AdminOP/menu_main.jpg"))); // NOI18N
        jpPazz.add(imgPizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 220, 160));

        spQuantityPizza.setEnabled(false);
        spQuantityPizza.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spQuantityPizzaStateChanged(evt);
            }
        });
        jpPazz.add(spQuantityPizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 110, 20));

        jLabel23.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel23.setText("Quantity ");
        jpPazz.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

        jLabel77.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel77.setText("Price ");
        jpPazz.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        txtPricePizza.setFont(new java.awt.Font("Hiragino Mincho ProN", 0, 14)); // NOI18N
        txtPricePizza.setText("0");
        jpPazz.add(txtPricePizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 110, 20));

        btSavePizza.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSavePizza.setForeground(java.awt.Color.red);
        btSavePizza.setText("Add To Order");
        btSavePizza.setEnabled(false);
        btSavePizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSavePizzaActionPerformed(evt);
            }
        });
        jpPazz.add(btSavePizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 220, -1));

        txtPricePizzaTotal.setEditable(false);
        txtPricePizzaTotal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPricePizzaTotalCaretUpdate(evt);
            }
        });
        txtPricePizzaTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPricePizzaTotalActionPerformed(evt);
            }
        });
        jpPazz.add(txtPricePizzaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 110, -1));

        jLabel83.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel83.setText("Total");
        jpPazz.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        jp.addTab("Pizza", jpPazz);

        jpSaled.setBackground(new java.awt.Color(255, 255, 255));
        jpSaled.setEnabled(false);
        jpSaled.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spSalad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT" }));
        spSalad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spSaladActionPerformed(evt);
            }
        });
        jpSaled.add(spSalad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, -1));

        imgSalad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AdminOP/menu_main.jpg"))); // NOI18N
        jpSaled.add(imgSalad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 220, 160));

        spQuantitySalad.setEnabled(false);
        spQuantitySalad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spQuantitySaladStateChanged(evt);
            }
        });
        jpSaled.add(spQuantitySalad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 130, 20));

        jLabel24.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel24.setText("Quantity ");
        jpSaled.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

        jLabel78.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel78.setText("Price ");
        jpSaled.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        txtPriceSalad.setFont(new java.awt.Font("Hiragino Mincho ProN", 0, 14)); // NOI18N
        txtPriceSalad.setText("0");
        jpSaled.add(txtPriceSalad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 130, 20));

        btSaveSalad.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSaveSalad.setForeground(java.awt.Color.red);
        btSaveSalad.setText("Add To Order");
        btSaveSalad.setEnabled(false);
        btSaveSalad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveSaladActionPerformed(evt);
            }
        });
        jpSaled.add(btSaveSalad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 200, -1));

        txtPriceSaladTotal.setEditable(false);
        txtPriceSaladTotal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPriceSaladTotalCaretUpdate(evt);
            }
        });
        txtPriceSaladTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceSaladTotalActionPerformed(evt);
            }
        });
        jpSaled.add(txtPriceSaladTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 110, -1));

        jLabel84.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 14)); // NOI18N
        jLabel84.setText("Total");
        jpSaled.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        jp.addTab("Salad", jpSaled);

        jPanel4.add(jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 350));

        jpMake.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 360, 360));

        UserName12.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName12.setText("Date");
        UserName12.setToolTipText("");
        jpMake.add(UserName12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 50, 20));
        jpMake.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 180, 20));
        jpMake.add(txtOrderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 160, 20));

        UserName13.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        UserName13.setText("Id");
        UserName13.setToolTipText("");
        jpMake.add(UserName13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, 20));

        getContentPane().add(jpMake, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 670, 390));

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

    private void btMakeReservationtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMakeReservationtActionPerformed

    }//GEN-LAST:event_btMakeReservationtActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btViewReservationtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewReservationtActionPerformed
                BillPayment m = new BillPayment(OrderId,waiter);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
                dispose();
    }//GEN-LAST:event_btViewReservationtActionPerformed

    private void btGrenetOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrenetOrderActionPerformed

        if(!addOrder){
           AddOrderNew();
           jp.setEnabled(true);
           spMainCaurs.setEnabled(true);
        }
    }//GEN-LAST:event_btGrenetOrderActionPerformed

    private void btSingOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSingOutActionPerformed
        WaiterMain m = new WaiterMain();
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_btSingOutActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        CustomerListChose chose = new CustomerListChose(2);
        chose.pack();
        chose.setVisible(true);
        chose.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btSearchActionPerformed

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        CustomerFr fr = new CustomerFr(waiter,2);
        fr.pack();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btNewActionPerformed

    private void btSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearch1ActionPerformed
        DiningTableListChose chose = new DiningTableListChose(2);
        chose.pack();
        chose.setVisible(true);
        chose.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               enbledMenu();

        

    }//GEN-LAST:event_btSearch1ActionPerformed

    private void btNew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNew1ActionPerformed
        DiningTableFr fr = new DiningTableFr(waiter,2);
        fr.pack();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    }//GEN-LAST:event_btNew1ActionPerformed

    private void btSavespMainCaursrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSavespMainCaursrActionPerformed
        try {  
  if(!txtPriceMainCaursTotall.getText().equals("")){
              AddFoods();
              clearDateMainCaurs();
              btSavespMainCaursr.setEnabled(false);
              spQuantityMainCaurs.setEnabled(false);

  }
        } catch (SQLException ex) {
            Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSavespMainCaursrActionPerformed
public void clearDateMainCaurs(){
    Price=0;
    Quntity=0;
    priceTotal=0;
    txtPriceMainCaursTotall.setText("");
    txtPriceMainCaurs.setText("");
    spMainCaurs.setSelectedIndex(-1);
    btSavespMainCaursr.setEnabled(false);
}
public void clearDateDrinks(){
    Price=0;
    Quntity=0;
    priceTotal=0;
    txtPriceDrinksTotal.setText("");
    txtPriceDrinks.setText("");
    spDrinks.setSelectedIndex(-1);
    btSaveDrinks.setEnabled(false);
}
public void clearDateDessert(){
    Price=0;
    Quntity=0;
    priceTotal=0;
    txtPriceDessertTotal.setText("");
    txtPriceDessert.setText("");
    spDessert.setSelectedIndex(-1);
    btSaveDessert.setEnabled(false);
}
public void clearDateSandwich(){
    Price=0;
    Quntity=0;
    priceTotal=0;
    txtPriceSandwichTotall.setText("");
    txtPriceSandwich.setText("");
    spSandwich.setSelectedIndex(-1);
    btSaveSandwich.setEnabled(false);
}
public void clearDatePizza(){
    Price=0;
    Quntity=0;
    priceTotal=0;
    txtPricePizzaTotal.setText("");
    txtPricePizza.setText("");
    spPizza.setSelectedIndex(-1);
    btSavePizza.setEnabled(false);

}
public void clearDateSalad(){
    Price=0;
    Quntity=0;
    priceTotal=0;
    txtPriceSaladTotal.setText("");
    txtPriceSalad.setText("");
    spSalad.setSelectedIndex(-1);
    btSaveSalad.setEnabled(false);
}





    private void spMainCaursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spMainCaursActionPerformed
        foods = (Foods) spMainCaurs.getSelectedItem();
        if (foods != null) {
            txtPriceMainCaurs.setText(foods.getPrice() + "");
            imgMainCaurs.setIcon(Resize(foods.getFoodImg()));
            spQuantityMainCaurs.setEnabled(true);

        }
    }//GEN-LAST:event_spMainCaursActionPerformed

    private void spDrinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spDrinksActionPerformed
         foods = (Foods) spDrinks.getSelectedItem();
        if (foods != null) {
            txtPriceDrinks.setText(foods.getPrice() + "");
            imgDrinks.setIcon(Resize(foods.getFoodImg()));
            spQuantityDrinks.setEnabled(true);

        }       
    }//GEN-LAST:event_spDrinksActionPerformed

    private void btSaveDrinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveDrinksActionPerformed
         try {  
  if(!txtPriceDrinksTotal.getText().equals("")){
              AddFoods();
              clearDateDrinks();
              btSaveDrinks.setEnabled(false);
              spQuantityDrinks.setEnabled(false);

  }
        } catch (SQLException ex) {
            Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSaveDrinksActionPerformed

    private void spDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spDessertActionPerformed
        foods = (Foods) spDessert.getSelectedItem();
        if (foods != null) {
            txtPriceDessert.setText(foods.getPrice() + "");
            imgDessert.setIcon(Resize(foods.getFoodImg()));
            spQuantityDessert.setEnabled(true);


        }
    }//GEN-LAST:event_spDessertActionPerformed

    private void btSaveDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveDessertActionPerformed
    try {  
  if(!txtPriceDessertTotal.getText().equals("")){
              AddFoods();
              clearDateDessert();
              btSaveDessert.setEnabled(false);
              spQuantityDessert.setEnabled(false);
  }
        } catch (SQLException ex) {
            Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSaveDessertActionPerformed

    private void spSandwichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spSandwichActionPerformed
        foods = (Foods) spSandwich.getSelectedItem();
        if (foods != null) {
            txtPriceSandwich.setText(foods.getPrice() + "");

            imgSandwich.setIcon(Resize(foods.getFoodImg()));
            spQuantitySandwich.setEnabled(true);

        }
    }//GEN-LAST:event_spSandwichActionPerformed

    private void btSaveSandwichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveSandwichActionPerformed
        try {  
  if(!txtPriceSandwichTotall.getText().equals("")){
              AddFoods();
              clearDateSandwich();
              btSaveSandwich.setEnabled(false);
              spQuantitySandwich.setEnabled(false);

  }
        } catch (SQLException ex) {
            Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSaveSandwichActionPerformed

    private void spPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spPizzaActionPerformed
         foods = (Foods) spPizza.getSelectedItem();
        if (foods != null) {
            txtPricePizza.setText(foods.getPrice() + "");

            imgPizza.setIcon(Resize(foods.getFoodImg()));
            spQuantityPizza.setEnabled(true);


        }
    }//GEN-LAST:event_spPizzaActionPerformed

    private void btSavePizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSavePizzaActionPerformed
         try {  
  if(!txtPricePizzaTotal.getText().equals("")){
              AddFoods();
              clearDatePizza();
              btSavePizza.setEnabled(false);
              spQuantityPizza.setEnabled(false);

  }
        } catch (SQLException ex) {
            Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSavePizzaActionPerformed

    private void spSaladActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spSaladActionPerformed
        foods = (Foods) spSalad.getSelectedItem();
        if (foods != null) {
            txtPriceSalad.setText(foods.getPrice() + "");

            imgSalad.setIcon(Resize(foods.getFoodImg()));
            spQuantitySalad.setEnabled(true);

        }
    }//GEN-LAST:event_spSaladActionPerformed

    private void btSaveSaladActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveSaladActionPerformed
          try {  
  if(!txtPriceSaladTotal.getText().equals("")){
              AddFoods();
              clearDateSalad();
              btSaveSalad.setEnabled(false);
              spQuantitySalad.setEnabled(false);

  }
        } catch (SQLException ex) {
            Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSaveSaladActionPerformed

    private void txtCustmoerIdCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCustmoerIdCaretUpdate
          coustomerExites=true;
        enbledMenu();
      
    }//GEN-LAST:event_txtCustmoerIdCaretUpdate

    private void txtTableIdCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTableIdCaretUpdate
        tableExites=true;
        enbledMenu();
        
    }//GEN-LAST:event_txtTableIdCaretUpdate

    private void txtTableIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTableIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTableIdActionPerformed

    private void spQuantityMainCaursStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spQuantityMainCaursStateChanged
        Price=0; 
        Quntity=0;
        Quntity = Integer.parseInt(spQuantityMainCaurs.getValue().toString());
        Price += Quntity * Double.parseDouble(txtPriceMainCaurs.getText());
        txtPriceMainCaursTotall.setText(Price+"");
             priceTotal=Double.parseDouble(txtPriceMainCaursTotall.getText());
              System.out.println(priceTotal);

        if(priceTotal<=0){
        spQuantityMainCaurs.setValue(1);}

    }//GEN-LAST:event_spQuantityMainCaursStateChanged
    double priceTotal;
    private void txtPriceMainCaursTotallCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPriceMainCaursTotallCaretUpdate
    
       
        btSavespMainCaursr.setEnabled(true);
        
       
    }//GEN-LAST:event_txtPriceMainCaursTotallCaretUpdate

    private void txtPriceMainCaursTotallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceMainCaursTotallActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceMainCaursTotallActionPerformed

    private void spQuantityDrinksStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spQuantityDrinksStateChanged
        Price=0; 
        Quntity=0;
        Quntity = Integer.parseInt(spQuantityDrinks.getValue().toString());
        Price += Quntity * Double.parseDouble(txtPriceDrinks.getText());
        txtPriceDrinksTotal.setText(Price+"");
        priceTotal=Double.parseDouble(txtPriceDrinksTotal.getText());

        if(priceTotal<=0){
        spQuantityDrinks.setValue(1);}
    }//GEN-LAST:event_spQuantityDrinksStateChanged

    private void txtPriceDrinksTotalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPriceDrinksTotalCaretUpdate
               btSaveDrinks.setEnabled(true);

    }//GEN-LAST:event_txtPriceDrinksTotalCaretUpdate

    private void txtPriceDrinksTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceDrinksTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceDrinksTotalActionPerformed

    private void spQuantityDrinksVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_spQuantityDrinksVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_spQuantityDrinksVetoableChange

    private void txtPriceDrinksTotalCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtPriceDrinksTotalCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceDrinksTotalCaretPositionChanged

    private void txtPriceDessertTotalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPriceDessertTotalCaretUpdate
         btSaveDessert.setEnabled(true);

    }//GEN-LAST:event_txtPriceDessertTotalCaretUpdate

    private void txtPriceDessertTotalCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtPriceDessertTotalCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceDessertTotalCaretPositionChanged

    private void txtPriceDessertTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceDessertTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceDessertTotalActionPerformed

    private void spQuantityDessertStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spQuantityDessertStateChanged
 Price=0; 
        Quntity=0;
        Quntity = Integer.parseInt(spQuantityDessert.getValue().toString());
        Price += Quntity * Double.parseDouble(txtPriceDessert.getText());
        txtPriceDessertTotal.setText(Price+"");
        priceTotal=Double.parseDouble(txtPriceDessertTotal.getText());

        if(priceTotal<=0){
        spQuantityDessert.setValue(1);}
       
    }//GEN-LAST:event_spQuantityDessertStateChanged

    private void txtPriceSandwichTotallCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPriceSandwichTotallCaretUpdate
        btSaveSandwich.setEnabled(true);
    }//GEN-LAST:event_txtPriceSandwichTotallCaretUpdate

    private void txtPriceSandwichTotallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceSandwichTotallActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceSandwichTotallActionPerformed

    private void spQuantitySandwichStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spQuantitySandwichStateChanged
        Price=0; 
        Quntity=0;
        Quntity = Integer.parseInt(spQuantitySandwich.getValue().toString());
        Price += Quntity * Double.parseDouble(txtPriceSandwich.getText());
        txtPriceSandwichTotall.setText(Price+"");
             priceTotal=Double.parseDouble(txtPriceSandwichTotall.getText());
              System.out.println(priceTotal);

        if(priceTotal<=0){
        spQuantitySandwich.setValue(1);}
    }//GEN-LAST:event_spQuantitySandwichStateChanged

    private void txtPricePizzaTotalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPricePizzaTotalCaretUpdate
        btSavePizza.setEnabled(true);
    }//GEN-LAST:event_txtPricePizzaTotalCaretUpdate

    private void txtPricePizzaTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPricePizzaTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPricePizzaTotalActionPerformed

    private void spQuantityPizzaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spQuantityPizzaStateChanged
        Price=0; 
        Quntity=0;
        Quntity = Integer.parseInt(spQuantityPizza.getValue().toString());
        Price += Quntity * Double.parseDouble(txtPricePizza.getText());
        txtPricePizzaTotal.setText(Price+"");
        priceTotal=Double.parseDouble(txtPricePizzaTotal.getText());

        if(priceTotal<=0){
        spQuantityPizza.setValue(1);}
    }//GEN-LAST:event_spQuantityPizzaStateChanged

    private void txtPriceSaladTotalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPriceSaladTotalCaretUpdate
               btSaveSalad.setEnabled(true);

    }//GEN-LAST:event_txtPriceSaladTotalCaretUpdate

    private void txtPriceSaladTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceSaladTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceSaladTotalActionPerformed

    private void spQuantitySaladStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spQuantitySaladStateChanged
        Price=0; 
        Quntity=0;
        Quntity = Integer.parseInt(spQuantitySalad.getValue().toString());
        Price += Quntity * Double.parseDouble(txtPriceSalad.getText());
        txtPriceSaladTotal.setText(Price+"");
        priceTotal=Double.parseDouble(txtPriceSaladTotal.getText());

        if(priceTotal<=0){
        spQuantitySalad.setValue(1);}
    }//GEN-LAST:event_spQuantitySaladStateChanged

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void lbShiftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbShiftMouseClicked

    }//GEN-LAST:event_lbShiftMouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

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
                new OrderMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserName1;
    private javax.swing.JLabel UserName10;
    private javax.swing.JLabel UserName11;
    private javax.swing.JLabel UserName12;
    private javax.swing.JLabel UserName13;
    private javax.swing.JLabel UserName4;
    private javax.swing.JLabel UserName5;
    private javax.swing.JLabel UserName7;
    private javax.swing.JLabel UserName8;
    private javax.swing.JLabel UserName9;
    private javax.swing.JButton btGrenetOrder;
    private javax.swing.JButton btMakeReservationt;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btNew1;
    private javax.swing.JButton btSaveDessert;
    private javax.swing.JButton btSaveDrinks;
    private javax.swing.JButton btSavePizza;
    private javax.swing.JButton btSaveSalad;
    private javax.swing.JButton btSaveSandwich;
    private javax.swing.JButton btSavespMainCaursr;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btSearch1;
    private javax.swing.JButton btSingOut;
    private javax.swing.JButton btViewReservationt;
    private com.toedter.calendar.JDateChooser dtNowDate;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel imgDessert;
    private javax.swing.JLabel imgDrinks;
    private javax.swing.JLabel imgMainCaurs;
    private javax.swing.JLabel imgPizza;
    private javax.swing.JLabel imgSalad;
    private javax.swing.JLabel imgSandwich;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jp;
    private javax.swing.JPanel jpDess;
    private javax.swing.JPanel jpMainC;
    private javax.swing.JPanel jpMake;
    private javax.swing.JPanel jpPazz;
    private javax.swing.JPanel jpSaled;
    private javax.swing.JPanel jpSandwich;
    private javax.swing.JPanel jpdrink;
    private javax.swing.JLabel lbPosition;
    private javax.swing.JLabel lbSalary;
    private javax.swing.JLabel lbShift;
    private javax.swing.JLabel lbType;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JComboBox spDessert;
    private javax.swing.JComboBox spDrinks;
    private javax.swing.JComboBox spMainCaurs;
    private javax.swing.JComboBox spPizza;
    private javax.swing.JSpinner spQuantityDessert;
    private javax.swing.JSpinner spQuantityDrinks;
    private javax.swing.JSpinner spQuantityMainCaurs;
    private javax.swing.JSpinner spQuantityPizza;
    private javax.swing.JSpinner spQuantitySalad;
    private javax.swing.JSpinner spQuantitySandwich;
    private javax.swing.JComboBox spSalad;
    private javax.swing.JComboBox spSandwich;
    public static javax.swing.JLabel txtAddress;
    public static javax.swing.JLabel txtCapacti;
    public static javax.swing.JLabel txtCodeCahar;
    public static javax.swing.JTextField txtCustmoerId;
    public static javax.swing.JLabel txtCustomerName;
    public static javax.swing.JLabel txtDate;
    public static javax.swing.JLabel txtOrderId;
    public static javax.swing.JLabel txtPhone;
    private javax.swing.JLabel txtPriceDessert;
    private javax.swing.JTextField txtPriceDessertTotal;
    private javax.swing.JLabel txtPriceDrinks;
    private javax.swing.JTextField txtPriceDrinksTotal;
    private javax.swing.JLabel txtPriceMainCaurs;
    private javax.swing.JTextField txtPriceMainCaursTotall;
    private javax.swing.JLabel txtPricePizza;
    private javax.swing.JTextField txtPricePizzaTotal;
    private javax.swing.JLabel txtPriceSalad;
    private javax.swing.JTextField txtPriceSaladTotal;
    private javax.swing.JLabel txtPriceSandwich;
    private javax.swing.JTextField txtPriceSandwichTotall;
    public static javax.swing.JTextField txtTableId;
    public static javax.swing.JLabel txtTableNumber;
    // End of variables declaration//GEN-END:variables
}
