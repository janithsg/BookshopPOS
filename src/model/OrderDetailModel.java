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
public class OrderDetailModel {
    private String orderId;
    private String itemId;
    private int qty;
    private double itemTot;

    public OrderDetailModel() {
    }

    public OrderDetailModel(String orderId, String itemId, int qty, double itemTot) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.qty = qty;
        this.itemTot = itemTot;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @return the itemTot
     */
    public double getItemTot() {
        return itemTot;
    }
    
    
}
