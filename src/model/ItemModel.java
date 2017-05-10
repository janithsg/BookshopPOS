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
public class ItemModel {
    private String itemId;
    private String desc;
    private double buyPrice;
    private double sellPrice;
    private int qty;

    public ItemModel() {
    }

    public ItemModel(String itemId, String desc, double buyPrice, double sellPrice, int qty) {
        this.itemId = itemId;
        this.desc = desc;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.qty = qty;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @return the buyPrice
     */
    public double getBuyPrice() {
        return buyPrice;
    }

    /**
     * @return the sellPrice
     */
    public double getSellPrice() {
        return sellPrice;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }
    
}
