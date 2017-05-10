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
public class SupplierModel {
    private String supId;
    private String fname;
    private String lname;
    private int phone;
    private String address;

    public SupplierModel() {
    }
    
    public SupplierModel(String supId, String fname, String lname, int phone, String address) {
        this.supId = supId;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * @return the supId
     */
    public String getSupId() {
        return supId;
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
    public int getPhone() {
        return phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    
    
}
