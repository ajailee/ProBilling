/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Ajai Lee
 */
@Entity
public class Invoice {

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    private Long invoiceId;
    private String customerNumber;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoiceId")
    private List<Sales> sales; 

    public Invoice() {
    }
    
    

    public Invoice(Long invoiceId, String customerNumber, List<Sales> sales) {
        this.invoiceId = invoiceId;
        this.customerNumber = customerNumber;
        this.sales = sales;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }
    
    
    

}
