/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Janith
 */
public class OrderModel {
    private String orderId;
    private String orderDate;
    private double tot;
    private String user;
    private ArrayList<OrderDetailModel> list;

    public OrderModel() {
    }

    public OrderModel(String orderId, String orderDate, double tot, String user, ArrayList<OrderDetailModel> list) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.tot = tot;
        this.user = user;
        this.list = list;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @return the tot
     */
    public double getTot() {
        return tot;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the list
     */
    public ArrayList<OrderDetailModel> getList() {
        return list;
    }

    
}
