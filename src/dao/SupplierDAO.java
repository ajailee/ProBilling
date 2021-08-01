/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Supplier;
import java.util.List;
import utils.NewHibernateUtil;

/**
 *
 * @author Ajai Lee
 */
public class SupplierDAO {
    
    public static boolean addSupplier(Supplier s) {
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
    
    public static Supplier searchById(Long text) {
        Supplier s = null;
        try {
            NewHibernateUtil.getSession().beginTransaction();
            s = NewHibernateUtil.getSession().get(Supplier.class, text);
            NewHibernateUtil.getSession().getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        }
        return s;
    }
    
    public static boolean upDate(Supplier s) {
        try {
            NewHibernateUtil.getSession().beginTransaction();
            NewHibernateUtil.getSession().update(s);
            NewHibernateUtil.getSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
        //To change body of generated methods, choose Tools | Templates.
    }
    
    @SuppressWarnings("deprecation")
    public static List<Supplier> getAllSupplier() {
        List<Supplier> list = null;
        
        try {
            NewHibernateUtil.getSession().beginTransaction();
            
            list = NewHibernateUtil.getSession().createCriteria(entities.Supplier.class).list();
            NewHibernateUtil.getSession().getTransaction().commit();
            
        } catch (Exception e) {
            System.err.println(e);
        }
        return list;
    }
    
    public static boolean deleteSupplier(Long valueOf) {
        try {
            
            NewHibernateUtil.getSession().beginTransaction();
            Supplier obj = NewHibernateUtil.getSession().load(entities.Supplier.class, valueOf);
            NewHibernateUtil.getSession().delete(obj);
            NewHibernateUtil.getSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }
    
}
