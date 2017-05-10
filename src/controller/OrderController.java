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
import model.OrderDetailModel;
import model.OrderModel;

/**
 *
 * @author Janith
 */
public class OrderController {
    public static String getNextID(){
        try {
            Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
            Statement stm=con.createStatement(); // Create the Statement - This is a must.
            String sql="SELECT * FROM Orders ORDER BY orderid DESC LIMIT 1";
            ResultSet rst = stm.executeQuery(sql);
            
            ///////////////////////////// Generate Unique Order ID ////////////////////
            String orderId="";
            String last="A000000";
            
            while(rst.next()){
                last=rst.getString("orderId");
            };
            
            int num=Integer.parseInt(last.replaceAll("\\D+",""));
            num+=1;
            String x=Integer.toString(num);
            
            orderId=x;
            
            for(int i=0;i<=(6-x.length());i++){
                orderId="0"+orderId;
            }
            
            orderId="A"+orderId;
            
            return orderId;
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "A000500";
    }
    
    public static boolean addOrder(OrderModel order) throws ClassNotFoundException, SQLException{
        ArrayList<OrderDetailModel> list;
        Connection con=DBConnection.getDBConnection().getConnection();
        Statement stm=con.createStatement(); 
        String sql="insert into Orders values('"+order.getOrderId()+"','"+order.getOrderDate()+"',"+order.getTot()+",'"+"root"+"')"; 
        
        int res = stm.executeUpdate(sql); 
        
        if (res > 0) { 
           list=order.getList();
           for(OrderDetailModel detail:list){
               sql="insert into OrderDetails values('"+order.getOrderId()+"','"+detail.getItemId()+"',"+detail.getQty()+","+detail.getItemTot()+")"; 
               stm.executeUpdate(sql);
           }  
           return true;
        }
        return false;
    }
    
    
}
