package dao;

import entities.User;
import utils.NewHibernateUtil;

public class UserDAO {
	
	
	public static void addUser(User user){
		NewHibernateUtil.getSession().beginTransaction();
		NewHibernateUtil.getSession().save(user);
	    NewHibernateUtil.getSession().getTransaction().commit();
	}

}
