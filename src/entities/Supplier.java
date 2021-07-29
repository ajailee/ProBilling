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
public class Supplier {
    
    private String name,address,extra;
    private Long gstNo,accountNo;
    @Id
    private Long phoneNo;

    public Supplier(String name, String address, String extra, Long gstNo, Long accountNo, Long phoneNo) {
        this.name = name;
        this.address = address;
        this.extra = extra;
        this.gstNo = gstNo;
        this.accountNo = accountNo;
        this.phoneNo = phoneNo;
    }

  
    
    
    
    
}
