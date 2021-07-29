/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import dao.SupplierDAO;
import java.util.List;

/**
 *
 * @author Ajai Lee
 */
public class Supplier {
   public static boolean addSupplier(String name,String phoneNo,String gstNo,String accountNo,String address,String extra){
       entities.Supplier s = new entities.Supplier(name,address,extra,gstNo,Long.valueOf(accountNo),Long.valueOf(phoneNo));
       return SupplierDAO.addSupplier(s);
    }

    public static entities.Supplier searchSupplier(String text) {
        return SupplierDAO.searchById(Long.valueOf(text.trim()));//To change body of generated methods, choose Tools | Templates.
    }
    
    public static boolean updateSupplier (String name,String phoneNo,String gstNo,String accountNo,String address,String extra){
       entities.Supplier s = new entities.Supplier(name,address,extra,gstNo,Long.valueOf(accountNo),Long.valueOf(phoneNo));
        return SupplierDAO.upDate(s);
    }

    public static List<entities.Supplier> getAllSupplier() {
        return SupplierDAO.getAllSupplier();
    }

    public static boolean deleteSupplier(String phoneNumber) {
      return SupplierDAO.deleteSupplier(Long.valueOf(phoneNumber));
    }
}
