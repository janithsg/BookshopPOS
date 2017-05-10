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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ItemModel;

/**
 *
 * @author Janith
 */
public class ItemController {
    public static String getNextId(){
        try {
            Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
            Statement stm=con.createStatement(); // Create the Statement - This is a must.
            String sql="SELECT * FROM Stationary ORDER BY itemid DESC LIMIT 1";
            ResultSet rst = stm.executeQuery(sql);
            
            ///////////////////////////// Generate Unique Order ID ////////////////////
            String itemid="";
            String last="S0000";
            
            while(rst.next()){
                last=rst.getString("itemid");
            };
            
            int num=Integer.parseInt(last.replaceAll("\\D+",""));
            num+=1;
            String x=Integer.toString(num);
            
            itemid=x;
            
            for(int i=0;i<=(2-x.length());i++){
                itemid="0"+itemid;
            }
            
            itemid="S"+itemid;
            
            return itemid;
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "S0500";
    }
    
    public static boolean AddItem(ItemModel s) throws ClassNotFoundException, SQLException
    {
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        String sql="insert into Stationary values('"+s.getItemId() +"','"+s.getDesc()+"',"+s.getBuyPrice()+","+s.getSellPrice()+","+s.getQty()+")";// Generate the SQL
        
        int res = stm.executeUpdate(sql); // Execute the SQL through the Statement Object
        if (res > 0) {      // Statement returns positive value if SQL is success OR negative( 0 or minus ) value if fails.
            return true;    //  So we return what happened as true or false.
        }
        return false;
    }
    
     public static boolean DeleteItem(String itemid) throws ClassNotFoundException, SQLException
    {
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        String sql="DELETE FROM Stationary  WHERE itemid='"+itemid+"'";// Generate the SQL
        System.out.println(sql);
        int res = stm.executeUpdate(sql); // Execute the SQL through the Statement Object
        if (res > 0) {      // Statement returns positive value if SQL is success OR negative( 0 or minus ) value if fails.
            return true;    //  So we return what happened as true or false.
        }
        return false;
    }
     
     public static boolean updateItem(ItemModel s) throws ClassNotFoundException, SQLException
    {
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        String sql="UPDATE Stationary SET itemid='"+s.getItemId()+"',description='"+s.getDesc() +"',sellingp="+s.getSellPrice()+",buyingp='"+s.getBuyPrice()+"',qty ='"+s.getQty()+"' WHERE itemid='"+s.getItemId()+"'";// Generate the SQL
        
        int res = stm.executeUpdate(sql); // Execute the SQL through the Statement Object
        if (res > 0) {      // Statement returns positive value if SQL is success OR negative( 0 or minus ) value if fails.
            return true;    //  So we return what happened as true or false.
        }
        return false;
    }
     
    
    public static ArrayList<ItemModel> getAllItems() throws SQLException, ClassNotFoundException{
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        String sql="SELECT * FROM Stationary";
        ResultSet rst = stm.executeQuery(sql);
        
        ArrayList<ItemModel> items=new ArrayList<>();
        
        while(rst.next()){
            items.add(new ItemModel(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getDouble(4),rst.getInt(5)));
        }
        
        return items;
    }
}
