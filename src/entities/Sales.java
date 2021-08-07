/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.annotation.processing.Generated;
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
public class Sales {

    @Id
    @GeneratedValue
    private Long salesId;
    private Long invoiceId;
    @OneToOne
    @JoinColumn(name = "productId")
    private Product product;
    private int qty;
    private int discount;
    private double subTotal;

    public Sales() {
    }

    public Sales(Long invoiceId, Product product, int qty, int discount, double subTotal) {
        this.invoiceId = invoiceId;
        this.product = product;
        this.qty = qty;
        this.discount = discount;
        this.subTotal = subTotal;
    }

    public Long getSalesId() {
        return salesId;
    }

    public void setSalesId(Long salesId) {
        this.salesId = salesId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "Sales{" + "salesId=" + salesId + ", invoiceId=" + invoiceId + ", product=" + product + ", qty=" + qty + ", discount=" + discount + ", subTotal=" + subTotal + '}';
    }
    

}
