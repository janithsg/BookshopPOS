/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ItemModel;
import model.SupplierModel;

/**
 *
 * @author Janith
 */
public class SupplierController {
    public static boolean addSupplier(SupplierModel sup) throws ClassNotFoundException, SQLException{
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        String sql="insert into Supplier values('"+sup.getSupId()+"','"+sup.getFname()+"','"+sup.getLname()+"',"+sup.getPhone()+",'"+sup.getAddress()+"')"; // Generate the SQL
        
        int res = stm.executeUpdate(sql); // Execute the SQL through the Statement Object
        if (res > 0) {      // Statement returns positive value if SQL is success OR negative( 0 or minus ) value if fails.
            return true;    //  So we return what happened as true or false.
        }
        return false;
    }

 public static boolean updateSupplier(SupplierModel s) throws ClassNotFoundException, SQLException
    {
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        String sql="UPDATE Supplier SET supid='"+s.getSupId()+"',fname='"+s.getFname() +"',lname="+s.getLname()+",phone='"+s.getPhone()+"',address='"+s.getAddress()+"' WHERE supid='"+s.getSupId()+"'";// Generate the SQL
        
        int res = stm.executeUpdate(sql); // Execute the SQL through the Statement Object
        if (res > 0) {      // Statement returns positive value if SQL is success OR negative( 0 or minus ) value if fails.
            return true;    //  So we return what happened as true or false.
        }
        return false;
    }
 
 public static boolean deleteSupplier(SupplierModel s) throws ClassNotFoundException, SQLException
    {
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        String sql="Delete from Supplier WHERE supid='"+s.getSupId()+"'";// Generate the SQL
        
        int res = stm.executeUpdate(sql); // Execute the SQL through the Statement Object
        if (res > 0) {      // Statement returns positive value if SQL is success OR negative( 0 or minus ) value if fails.
            return true;    //  So we return what happened as true or false.
        }
        return false;
    }
 
 public static boolean AddSupplier(SupplierModel sup) throws ClassNotFoundException, SQLException
    {
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        String sql="insert into Supplier values('"+sup.getSupId()+"','"+sup.getFname()+"','"+sup.getLname()+"',"+sup.getPhone()+",'"+sup.getAddress()+"')"; ;// Generate the SQL
        
        int res = stm.executeUpdate(sql); // Execute the SQL through the Statement Object
        if (res > 0) {      // Statement returns positive value if SQL is success OR negative( 0 or minus ) value if fails.
            return true;    //  So we return what happened as true or false.
        }
        return false;
    }
 
 public static ArrayList<SupplierModel> getAllItems() throws SQLException, ClassNotFoundException{
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        String sql="SELECT * FROM Supplier";
        ResultSet rst = stm.executeQuery(sql);
        
        ArrayList<SupplierModel> items=new ArrayList<>();
        
        while(rst.next()){
            items.add(new SupplierModel(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5)));
        }
        
        return items;
    }
 
} 