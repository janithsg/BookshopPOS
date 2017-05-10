/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Janith
 */
public class UserModel {
    private String uname;
    private String pwd;
    private String fname;
    private String lname;
    private String phone;

    public UserModel() {
    }

    public UserModel(String uname, String pwd, String fname, String lname, String phone) {
        this.uname = uname;
        this.pwd = pwd;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
    }

    /**
     * @return the uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    
    
}
