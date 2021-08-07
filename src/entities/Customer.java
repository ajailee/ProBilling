/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Ajai Lee
 */
@Entity
public class Customer {
    
    @Id
    private String mobileNo;
    private String name;
    private boolean debitOrCredit;
    private double balance;

    public Customer() {
    }

    
    
    
    public Customer(String mobileNo, String name, boolean debitOrCredit, double balance) {
        this.mobileNo = mobileNo;
        this.name = name;
        this.debitOrCredit = debitOrCredit;
        this.balance = balance;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDebitOrCredit() {
        return debitOrCredit;
    }

    public void setDebitOrCredit(boolean debitOrCredit) {
        this.debitOrCredit = debitOrCredit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" + "mobileNo=" + mobileNo + ", name=" + name + ", debitOrCredit=" + debitOrCredit + ", balance=" + balance + '}';
    }
    
    
    
    
}
