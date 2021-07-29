/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import dao.SupplierDAO;

/**
 *
 * @author Ajai Lee
 */
public class Supplier {
   public static boolean addSupplier(String name,String phoneNo,String gstNo,String accountNo,String address,String extra){
       entities.Supplier s = new entities.Supplier(name,address,extra,Long.valueOf(gstNo),Long.valueOf(accountNo),Long.valueOf(phoneNo));
       return SupplierDAO.addSupplier(s);
    }
}
