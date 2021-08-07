/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import dao.ProductHome;
import entities.Product;
import java.util.List;

/**
 *
 * @author Ajai Lee
 */
public class ProductBE {
    public static List<entities.Product> getAllProduct(){
        return new ProductHome().getAll();
    }

    public static void add(Product p) {
       new ProductHome().persist(p); //To change body of generated methods, choose Tools | Templates.
    }
}
