/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import dao.InventoryHome;
import entities.Inventory;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ajai Lee
 */
public class InventoryBE {

    public static Inventory getByProductId(String id) {
        Inventory i = new InventoryHome().findByProductId(id);
        return i;
    }

    public static List<Inventory> getAll() {
        return new InventoryHome().getAll();//To change body of generated methods, choose Tools | Templates.
    }

    public static boolean add(List<Inventory> inventoryList, String purchaseId, String supplierName, Date date, String addedBy, Date addTime) {
        return new InventoryHome().saveOrUpdateProduct(inventoryList, purchaseId, supplierName, date, addedBy, addTime);

    }

}
