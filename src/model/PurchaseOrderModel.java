/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Poshitha Ravindu
 */
public class PurchaseOrderModel {
   private String pOrderId;
   private String pOrderDate;
   private double pOrderTot;
   private ArrayList<PurchaseOrderDetailsModel> list;
   
   public PurchaseOrderModel() {
    }

    public PurchaseOrderModel(String pOrderId, String pOrderDate, double pOrderTot, ArrayList<PurchaseOrderDetailsModel> list) {
        this.pOrderId = pOrderId;
        this.pOrderDate = pOrderDate;
        this.pOrderTot = pOrderTot;
        this.list = list;
    }
    /**
     * @return the pOrderId
     */
    public String getpOrderId() {
        return pOrderId;
    }

    /**
     * @return the pOrderDate
     */
    public String getpOrderDate() {
        return pOrderDate;
    }

    /**
     * @return the pOrderTot
     */
    public double getpOrderTot() {
        return pOrderTot;
    }

    /**
     * @return the list
     */
    public ArrayList<PurchaseOrderDetailsModel> getList() {
        return list;
    }

    
}
