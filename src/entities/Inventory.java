/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Ajai Lee
 */
@Entity
public class Inventory {
    @Id
    @GeneratedValue
    private Long inventoryId;
    @OneToOne(targetEntity=Product.class,cascade=CascadeType.ALL)  
    private Product product;
    private double buyingPrice;
    private double sellingPrice;
    private double margine;
    private int qty;

    public Inventory(Product product, double buyingPrice, double sellingPrice, double margine, int qty) {
        this.product = product;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.margine = margine;
        this.qty = qty;
    }
    public Inventory(){
        
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getMargine() {
        return margine;
    }

    public void setMargine(double margine) {
        this.margine = margine;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
    
}
