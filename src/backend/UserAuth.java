/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.NewHibernateUtil;

/**
 *
 * @author Ajai Lee
 */
public class UserAuth {
    
    static User user;
    private static Transaction transaction;
    
  public static boolean login(String name,String password){
        try (Session session = NewHibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
             transaction = session.beginTransaction();
            // get an user object
            user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", name)
                .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    } 
    
}
