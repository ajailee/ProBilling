/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import dao.InventoryHome;
import entities.*;
import dao.InvoiceHome;

/**
 *
 * @author Ajai Lee
 */
public class InvoiceBE {
    public static boolean addInvoice(Invoice i){
        InventoryHome home=new InventoryHome();
         for(Sales s : i.getSales()){
             home.reduceStock(s.getProduct().getId(),s.getQty());
         }
        return new InvoiceHome().persist(i);
    }
    public static String getInvoiceId(){
    Long id= new   InvoiceHome().getInvoiceId();
    return String.valueOf(id);
    }
}
