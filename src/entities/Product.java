/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Ajai Lee
 */
@Entity
public class Product {

    @Id
    @Column(length = 64)
    private String id;
    private String name;
    private String category;
    private String brand;
    private String uom;
    private int gst;
    private int minimumstock;
    private String hsn;

    public Product() {

    }

    public Product(String id, String name, String category, String brand, String uom, int gst, int minimumstock, String hsn) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.uom = uom;
        this.gst = gst;
        this.minimumstock = minimumstock;
        this.hsn = hsn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public int getGst() {
        return gst;
    }

    public void setGst(int gst) {
        this.gst = gst;
    }

    public int getMinimumstock() {
        return minimumstock;
    }

    public void setMinimumstock(int minimumstock) {
        this.minimumstock = minimumstock;
    }

    public String getHsn() {
        return hsn;
    }

    public void setHsn(String hsn) {
        this.hsn = hsn;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", category=" + category + ", brand=" + brand + ", uom=" + uom + ", gst=" + gst + ", minimumstock=" + minimumstock + ", hsn=" + hsn + '}';
    }

}
