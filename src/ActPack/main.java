/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.runtime.Debug.id;
/**
 *
 * @author hp
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     * 
     */

    public main() {
        initComponents();
        this.setLocationRelativeTo(null);
        refreshThread.start();
    }

    public main(String fname) {
        initComponents();
         jLabel1.setText("welcome " + fname);
         this.setLocationRelativeTo(null);
        refreshThread.start();
    }
 product product_obj = new product();
    conn con = new conn();
    
 Object id = null;
    
    void clearAddProductFields(){
        product.setText(null);
        quantity.setValue(0);
        price.setText(null);
        product.requestFocus();
        label.setText(null);
    }
 Thread refreshThread = new Thread(new Runnable() {     
        @Override
        public void run(){
            try{
                while(true){
                    refresh();
                    //System.out.println("Refresh");
                    Thread.sleep(5000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    });  
final void search(String keyword){
        
        try{
             Class.forName("com.mysql.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost/lincodb"
                    + "?user=root&password=";
            Connection con = DriverManager.getConnection(conURL);
        
            String sql = "SELECT * FROM products WHERE Product_id LIKE ? OR product LIKE ?";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
            
            
            pstmt.setString(1, "%"+keyword+"%");
            pstmt.setString(2, "%"+keyword+"%");
            
            ResultSet rs = pstmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) protable.getModel();
            model.setRowCount(0);
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("Product_id"),rs.getString("product"),rs.getString("qt"),rs.getString("price")});
            }     
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
final void enableAddProductFields(){
        product.setEnabled(true);
        quantity.setEnabled(true);
        price.setEnabled(true);
        clearAddProductFields();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ap = new javax.swing.JDialog();
        product = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        quantity = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        price = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        addquantity = new javax.swing.JButton();
        add = new javax.swing.JToggleButton();
        save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        protable = new javax.swing.JTable();
        search = new javax.swing.JButton();
        txt = new javax.swing.JTextField();
        mainproduct = new javax.swing.JToggleButton();
        addquant = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("PRODUCT:");

        quantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("QUANTITY:");

        price.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("PRICE:");

        addquantity.setText("Add quantity");
        addquantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addquantityActionPerformed(evt);
            }
        });

        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        save.setText("save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout apLayout = new javax.swing.GroupLayout(ap.getContentPane());
        ap.getContentPane().setLayout(apLayout);
        apLayout.setHorizontalGroup(
            apLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(apLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, apLayout.createSequentialGroup()
                        .addGroup(apLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(apLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, apLayout.createSequentialGroup()
                                .addGroup(apLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(43, 43, 43)
                                .addGroup(apLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(apLayout.createSequentialGroup()
                                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(apLayout.createSequentialGroup()
                                        .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(97, 97, 97))
                    .addGroup(apLayout.createSequentialGroup()
                        .addComponent(addquantity)
                        .addGap(49, 49, 49)
                        .addComponent(add)
                        .addGap(50, 50, 50)
                        .addComponent(save)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        apLayout.setVerticalGroup(
            apLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(apLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addGroup(apLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(apLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(apLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(apLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addquantity)
                    .addComponent(add)
                    .addComponent(save))
                .addGap(49, 49, 49))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        protable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCT", "QUANTITY", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        protable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(protable);

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActionPerformed(evt);
            }
        });
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeyReleased(evt);
            }
        });

        mainproduct.setText("ADD PRODUCT");
        mainproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainproductActionPerformed(evt);
            }
        });

        addquant.setText("Add Quantity");
        addquant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addquantActionPerformed(evt);
            }
        });

        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Edit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("CLOSE");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)))
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(mainproduct)
                .addGap(26, 26, 26)
                .addComponent(addquant)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(33, 33, 33)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton2)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search)
                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainproduct)
                    .addComponent(addquant)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jToggleButton2))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String keyword = txt.getText();
        this.search(keyword);

        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtActionPerformed

    private void txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyReleased
        String keyword = txt.getText();
        this.search(keyword);

        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeyReleased

    private void mainproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainproductActionPerformed
        ap.setVisible(true);
        ap.setLocationRelativeTo(rootPane);
        ap.setAlwaysOnTop(true);

        add.setVisible(true);
        save.setVisible(false);
        quantity.setVisible(true);

        this.enableAddProductFields();
        // TODO add your handling code here:
    }//GEN-LAST:event_mainproductActionPerformed

    private void addquantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addquantActionPerformed
        // TODO add your handling code here:
        int row = protable.getSelectedRow();
        if(row != -1){
            ap.setVisible(true);
            ap.setLocationRelativeTo(this);
            ap.setAlwaysOnTop(true);
            save.setVisible(false);
            add.setVisible(false);
            addquant.setVisible(true);

            id = protable.getValueAt(row, 0);
            Object products = protable.getValueAt(row, 1);
            Object quan = protable.getValueAt(row, 2);
            Object pri = protable.getValueAt(row, 3);

            product.setEnabled(false);
            price.setEnabled(false);
            quantity.setEnabled(true);

            product.setText(products.toString());
            label.setText(quan.toString());
            price.setValue(Double.valueOf(pri.toString()));
            quantity.setValue(0);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Please Select a product", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addquantActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selRow = protable.getSelectedRow();
        if (selRow != -1) {
            int column = 0;
            String id = protable
            .getValueAt(selRow, column).toString();
            int ans = JOptionPane.showConfirmDialog(rootPane,
                "Are you sure you want to DELETE this Product?",
                "Delete Confirmation",
                JOptionPane.YES_NO_OPTION);

            if (ans == JOptionPane.YES_OPTION) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String conURL = "jdbc:mysql://localhost/lincodb"
                    + "?user=root&password=";
                    java.sql.Connection con = DriverManager.getConnection(conURL);
                    PreparedStatement pstmt = con.prepareStatement("DELETE FROM products "
                        + "WHERE Product_id = ? ");
                    pstmt.setString(1, id);
                    pstmt.executeUpdate();

                    JOptionPane.showMessageDialog(rootPane, "One Row has Succesfully Deleted");
                    refresh();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please select row to be Deleted!",
                "No Row Selected",
                JOptionPane.WARNING_MESSAGE);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        int table_row = protable.getSelectedRow();
        this.clearAddProductFields();

        if(table_row != -1){
            id = protable.getValueAt(table_row, 0);
            Object products = protable.getValueAt(table_row, 1);
            Object quan = protable.getValueAt(table_row, 2);
            Object pri = protable.getValueAt(table_row, 3);

            product.setText((String) products);
            quantity.setValue(Integer.valueOf((String) quan));
            price.setValue(Double.valueOf((String) pri));

            ap.setVisible(true);
            ap.setLocationRelativeTo(rootPane);
            ap.setAlwaysOnTop(true);
            save.setVisible(true);
            add.setVisible(false);
            addquantity.setVisible(false);

            quantity.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Please Select a product", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void addquantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addquantityActionPerformed
        String pro = product.getText();
        Object qty = quantity.getValue();
        int c = JOptionPane.showConfirmDialog(ap, "Would you like to add\n "+qty+"\n to "+pro+" product?", "Add Quantity", JOptionPane.YES_NO_OPTION);
        if(c == JOptionPane.YES_OPTION){
            int r = product.addquantity(id, qty);
            if(r==1){
                JOptionPane.showMessageDialog(ap, "Quantity Updated");
                ap.setVisible(false);
                this.refresh();

            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_addquantityActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String pro = product.getText();
        int qty = (int) quantity.getValue();
        Object pr = price.getValue();
        String spr = pr.toString();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost/lincodb?"
            + "user=root&password=";

            Connection con = DriverManager.getConnection(conURL);

            PreparedStatement pstmt = con.prepareStatement("insert into products (product,qt,price)"
                + " values (?,?,?);");
            pstmt.setString(1, pro);
            pstmt.setInt(2, qty);
            pstmt.setString(3, spr);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(ap, "Successfully Added ");
            refresh();
            product.setText("");
            quantity.setValue(0);
            price.setText("");
            //==========
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);

        }

        //  pobj.addProduct(pro, qty, pr);        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String newpn = product.getText();
        Object newpr = price.getValue();

        int r = product_obj.editProduct(id, newpn, newpr);
        if(r==1){
            JOptionPane.showMessageDialog(ap, "Product Edit Successfully");
            ap.setVisible(false);
            this.refresh();
        }else{
            JOptionPane.showMessageDialog(ap, "Problem Editing Product", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton add;
    private javax.swing.JButton addquant;
    private javax.swing.JButton addquantity;
    private javax.swing.JDialog ap;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel label;
    private javax.swing.JToggleButton mainproduct;
    private javax.swing.JFormattedTextField price;
    private javax.swing.JTextField product;
    private javax.swing.JTable protable;
    private javax.swing.JSpinner quantity;
    private javax.swing.JButton save;
    private javax.swing.JButton search;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
