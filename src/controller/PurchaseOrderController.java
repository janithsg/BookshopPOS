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
import model.PurchaseOrderDetailsModel;
import model.PurchaseOrderModel;

/**
 *
 * @author Poshitha Ravindu
 */
public class PurchaseOrderController {
    public static String creatNewId(){
       try {
            Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
            Statement stm=con.createStatement(); // Create the Statement - This is a must.
            String sql="SELECT * FROM Purchases ORDER BY purchid DESC LIMIT 1";
            ResultSet rst = stm.executeQuery(sql);
            
           //Creating a new PurchaseId
            String purchaseId="";
            String end="P000000";
            
            while(rst.next()){
                end=rst.getString("purchid");
            };
            
            int num=Integer.parseInt(end.replaceAll("\\D+",""));//methna mko wenne
            num+=1;
            String a=Integer.toString(num);
            
            purchaseId=a;
            
            for(int i=0;i<=(6-a.length());i++){
                purchaseId="0"+purchaseId;
            }
            
            purchaseId="P"+purchaseId;
            
            return purchaseId;
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "A000500"; 
    }
   public static boolean addNewPurchaseOrder(PurchaseOrderModel pOrder){
       try{
        ArrayList<PurchaseOrderDetailsModel> list;
        Connection con=DBConnection.getDBConnection().getConnection();
        Statement stm=con.createStatement(); 
        String sql="insert into Purchases values('"+pOrder.getpOrderId()+"','"+pOrder.getpOrderDate()+"','"+pOrder.getpOrderTot()+"')"; 
       
         int res = stm.executeUpdate(sql); 
        if (res > 0) { 
           list=pOrder.getList();
           for(PurchaseOrderDetailsModel detail:list){
               sql="insert into PurchaseDetails values('"+pOrder.getpOrderId()+"','"+detail.getItemId()+"',"+detail.getQty()+","+detail.getItemTot()+")"; 
               stm.executeUpdate(sql);
           }  
           return true;
        }
        return false;
       }
       catch (SQLException e){}
       catch (ClassNotFoundException ex){}
       return false;
   } 
   
   public static ArrayList<PurchaseOrderModel> getAllPOs() throws SQLException, ClassNotFoundException{
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        
        String sql="SELECT * FROM Purchases";
        ResultSet rst = stm.executeQuery(sql);
        
        ArrayList<PurchaseOrderModel> pos=new ArrayList<>();
        
        while(rst.next()){
            pos.add(new PurchaseOrderModel(rst.getString(1),rst.getString(2),rst.getDouble(3),null));
        }

        return pos;
    }
   
   public static ArrayList<PurchaseOrderDetailsModel> getAllDetails(String key) throws SQLException, ClassNotFoundException{
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        
        String sql="SELECT * FROM PurchaseDetails where purchid='"+key+"'";
        ResultSet rst = stm.executeQuery(sql);
        
        ArrayList<PurchaseOrderDetailsModel> pos=new ArrayList<>();
        
        while(rst.next()){
            pos.add(new PurchaseOrderDetailsModel(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4)));
        }

        return pos;
    }
}
