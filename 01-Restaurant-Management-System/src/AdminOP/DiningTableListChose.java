
package AdminOP;

import BussnuesLogacl.DiningTableBL;

import Model.DiningTable;
import com.formdev.flatlaf.FlatClientProperties;

import com.formdev.flatlaf.FlatLightLaf;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;



public class DiningTableListChose extends javax.swing.JFrame {

  
    private DiningTableBL diningTableBL;
    private DiningTable  diningTable=new DiningTable();
    private int op;
    
    public DiningTableListChose() {
        initComponents();
        diningTableBL=new DiningTableBL();
              tbDiningTable.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbDiningTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
             
                + "separatorColor:$TableHeader.background");
       
        tableDiningTable();
    }
    
    public DiningTableListChose(int op) {
        initComponents();
        diningTableBL=new DiningTableBL();
          tbDiningTable.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tbDiningTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
             
                + "separatorColor:$TableHeader.background");
        this.op=op;
        tableDiningTable();
    }
        
    public void tableDiningTable() {
        DefaultTableModel model = new DefaultTableModel(new Object[]
        {"Id","Number","Code","Capacti"
            }, 0);
        ArrayList<DiningTable> list = diningTableBL.DiningTableArrayList();
        Object rowdata[] = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            rowdata[0] = list.get(i).getTableId();
            rowdata[1] = list.get(i).getTableNumber();
            rowdata[2] = list.get(i).getCodeCharTable();
            rowdata[3] = list.get(i).getCapacit();
            model.addRow(rowdata);
        }

        tbDiningTable.setModel(model);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jpList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDiningTable = new javax.swing.JTable();
        btDelete = new javax.swing.JButton();
        lbName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
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

        jpList.setBackground(new java.awt.Color(51, 51, 51));
        jpList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbDiningTable.setBackground(new java.awt.Color(51, 51, 51));
        tbDiningTable.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDiningTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDiningTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDiningTable);

        jpList.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 300));

        btDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btDelete.setText("Deletee");
        jpList.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 210, 30));

        lbName.setBackground(new java.awt.Color(255, 255, 255));
        lbName.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 36)); // NOI18N
        lbName.setForeground(java.awt.Color.white);
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbName.setText(" Dining Table Chose");
        lbName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNameMouseClicked(evt);
            }
        });
        jpList.add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 50));

        getContentPane().add(jpList, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 480, 380));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Baloo Bhaijaan 2", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(" Dining Table");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 380));

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 30, 380));

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

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       
    }//GEN-LAST:event_jLabel6MouseClicked

    private void lbNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbNameMouseClicked

    private void tbDiningTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDiningTableMouseClicked
        diningTable = new DiningTable();
         DefaultTableModel model = (DefaultTableModel) tbDiningTable.getModel();

        int selectedrow = tbDiningTable.getSelectedRow();
        diningTable.setTableId(Integer.parseInt(model.getValueAt(selectedrow, 0).toString()));
        diningTable.setTableNumber(Integer.parseInt(model.getValueAt(selectedrow, 1).toString()));
        diningTable.setCodeCharTable(model.getValueAt(selectedrow, 2).toString());
        diningTable.setCapacit(Integer.parseInt(model.getValueAt(selectedrow, 3).toString()));
        

       if(op==1){
           ReservationFr.txtId.setText(diningTable.getTableId()+"");
           ReservationFr.txtTableNumber.setText(diningTable.getTableNumber()+"");
           ReservationFr.txtCapacti.setText(diningTable.getCapacit()+"");
           ReservationFr.txtCodeCahar.setText(diningTable.getCodeCharTable()+"");
           dispose();
       }
       else if(op==2){
            OrderMenu.txtTableId.setText(diningTable.getTableId()+"");
            OrderMenu.tableId=diningTable.getTableId();
            OrderMenu.tableExites=true;
            OrderMenu.txtTableNumber.setText(diningTable.getTableNumber()+"");
            OrderMenu.txtCapacti.setText(diningTable.getCapacit()+"");
            OrderMenu.txtCodeCahar.setText(diningTable.getCodeCharTable()+"");
            dispose();
        }
   
    }//GEN-LAST:event_tbDiningTableMouseClicked

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
                new DiningTableListChose().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpList;
    private javax.swing.JLabel lbName;
    private javax.swing.JTable tbDiningTable;
    // End of variables declaration//GEN-END:variables
}
