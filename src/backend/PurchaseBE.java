/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import entities.Inventory;
import java.util.Date;
import java.util.List;
import entities.Product;
import entities.Purchase;
import org.hibernate.SessionFactory;
import utils.NewHibernateUtil;

/**
 *
 * @author Ajai Lee
 */
public class PurchaseBE {

    
    public static void addPurchase(String purchaseId, String supplierName, Date date,Product product,double buyingPrice,double SellingPrice,double margine,int qty, String addedBy, Date addTime){
       Purchase p = new Purchase(purchaseId, supplierName, date, product, buyingPrice, SellingPrice, margine, qty, addedBy, addTime);
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().persist(p);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }
}
