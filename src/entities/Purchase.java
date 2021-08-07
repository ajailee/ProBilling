/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Ajai Lee
 */
@Entity
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private int Id;
    private String purchaseId;
    private String supplierName;
    private Date purchaseDate;
    @OneToOne
    @JoinColumn(name = "productId")
    private Product product;
    private double buyingPrice;
    private double sellingPrice;
    private double margine;
    private int qty;
    private String addedBy;
    private Date addedTime;

    public Purchase() {
    }

    public Purchase(String purchaseId, String supplierName, Date purchaseDate, Product product, double buyingPrice, double sellingPrice, double margine, int qty, String addedBy, Date addedTime) {
        this.purchaseId = purchaseId;
        this.supplierName = supplierName;
        this.purchaseDate = purchaseDate;
        this.product = product;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.margine = margine;
        this.qty = qty;
        this.addedBy = addedBy;
        this.addedTime = addedTime;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
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

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Date addedTime) {
        this.addedTime = addedTime;
    }

}
