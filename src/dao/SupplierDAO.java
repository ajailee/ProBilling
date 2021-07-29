/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Supplier;
import utils.NewHibernateUtil;

/**
 *
 * @author Ajai Lee
 */
public class SupplierDAO {
    
    public static boolean addSupplier(Supplier s){
        try {
            NewHibernateUtil.getSession().beginTransaction();
            NewHibernateUtil.getSession().save(s);
	    NewHibernateUtil.getSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e);
        }
       
        return false;
        
    }
    
}
