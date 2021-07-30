/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import dao.BrandHome;
import java.util.List;

/**
 *
 * @author Ajai Lee
 */
public class BrandBE {
   public static List getAllBrand(){
        return BrandHome.getAllBrand();
    }
    
}
