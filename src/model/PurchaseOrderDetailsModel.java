/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Poshitha Ravindu
 */
public class PurchaseOrderDetailsModel {
private String pOrderId;
private String itemId;
private int qty;
private double itemTot;
 
public PurchaseOrderDetailsModel() {
    }

    public PurchaseOrderDetailsModel(String pOrderId, String itemId, int qty, double itemTot) {
        this.pOrderId = pOrderId;
        this.itemId = itemId;
        this.qty = qty;
        this.itemTot = itemTot;
    }

    /**
     * @return the pOrderId
     */
    public String getpOrderId() {
        return pOrderId;
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
