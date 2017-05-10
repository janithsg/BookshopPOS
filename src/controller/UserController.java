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
import model.UserModel;

/**
 *
 * @author Janith
 */
public class UserController {

    public static ArrayList<UserModel> getAllUsers() throws SQLException, ClassNotFoundException {
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm; // Create the Statement - This is a must.
        stm = con.createStatement();
        String sql="SELECT * FROM Users";
        ResultSet rst = stm.executeQuery(sql);
        
        ArrayList<UserModel> users=new ArrayList<>();
        
        while(rst.next()){
            users.add(new UserModel(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5)));
        }
        
        return users;
    }

    public static Boolean AddUser(UserModel user) throws ClassNotFoundException, SQLException {
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        String sql="insert into Users values('"+user.getUname()+"',(SELECT PASSWORD('"+user.getPwd()+"')),'"+user.getFname()+"','"+user.getLname()+"','"+user.getPhone()+"',1)";// Generate the SQL

        int res = stm.executeUpdate(sql); // Execute the SQL through the Statement Object
        if (res > 0) {      // Statement returns positive value if SQL is success OR negative( 0 or minus ) value if fails.
            return true;    //  So we return what happened as true or false.
        }
        return false;
    }
    
    public static boolean DeleteUser(String uname) throws ClassNotFoundException, SQLException
    {
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        String sql="DELETE FROM Users  WHERE username='"+uname+"'";// Generate the SQL

        int res = stm.executeUpdate(sql); // Execute the SQL through the Statement Object
        if (res > 0) {      // Statement returns positive value if SQL is success OR negative( 0 or minus ) value if fails.
            return true;    //  So we return what happened as true or false.
        }
        return false;
    }

    public static Boolean updateUser(UserModel user) throws ClassNotFoundException, SQLException {
        Connection con=DBConnection.getDBConnection().getConnection(); // Get the Connection to the Database
        Statement stm=con.createStatement(); // Create the Statement - This is a must.
        String sql="UPDATE Users SET username='"+user.getUname()+"' password=(SELECT PASSWORD('"+user.getPwd()+"')) fname='"+user.getFname()+"' lname='"+user.getLname()+"' phone='"+user.getPhone()+"' utype=1 WHERE username='"+user.getUname()+"'";// Generate the SQL
        System.out.println(sql);
        int res = stm.executeUpdate(sql); // Execute the SQL through the Statement Object
        if (res > 0) {      // Statement returns positive value if SQL is success OR negative( 0 or minus ) value if fails.
            return true;    //  So we return what happened as true or false.
        }
        return false;
    }
    
    public static Boolean verifyUser(String uname, String pwd) throws ClassNotFoundException, SQLException{
        String sql="SELECT * FROM Users WHERE username='" + uname + "' AND passwrd=(SELECT PASSWORD('" + pwd + "'));";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        
        if(rst.next()){
            return true;
        }
        
        return false;
    }
}
