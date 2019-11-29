/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActPack;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.List;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hp
 */
public class product {
  conn con = new conn();
   
    
    public int deleteProduct(Object id){
        int r = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
            
            String sql = "DELETE FROM products WHERE Product_id = ?;";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            
            int newid = Integer.parseInt(id.toString());
            pstmt.setInt(1, newid);
            
            r = pstmt.executeUpdate();
            //System.out.println(pstmt);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
     public int editProduct(Object id, String products, Object pri){
        int r = 0;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
        
        String sql = "UPDATE products SET product = ?, price = ? WHERE Product_id = ?;";
        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
        
        pstmt.setString(1, products);
        float newprice = Float.parseFloat(pri.toString());
        pstmt.setFloat(2, newprice);
        String newid = (String) id;
        pstmt.setString(3, newid);
        
        //System.out.println(pstmt);
        r = pstmt.executeUpdate();
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
  public int addquantity(Object id, Object quantity){
        int r = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
        
            String sql = "UPDATE products SET qt = qt + ? WHERE Product_id = ?;";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
        
            int newqty = Integer.parseInt(quantity.toString());
            pstmt.setInt(1, newqty);
            String newid = id.toString();
            pstmt.setString(2, newid);
            
            r = pstmt.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}

  

