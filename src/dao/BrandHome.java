package dao;
// Generated Jul 30, 2021, 10:24:44 PM by Hibernate Tools 5.4.30.Final

import entities.Brand;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import utils.NewHibernateUtil;

/**
 * Home object for domain model class Brand.
 * @see dao.Brand
 * @author Hibernate Tools
 */
public class BrandHome {

	private static final Logger logger = Logger.getLogger(BrandHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return NewHibernateUtil.getSessionFactory();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Brand transientInstance) {
		logger.log(Level.INFO, "persisting Brand instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Brand instance) {
		logger.log(Level.INFO, "attaching dirty Brand instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(Brand instance) {
		logger.log(Level.INFO, "attaching clean Brand instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(Brand persistentInstance) {
		logger.log(Level.INFO, "deleting Brand instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public Brand merge(Brand detachedInstance) {
		logger.log(Level.INFO, "merging Brand instance");
		try {
			Brand result = (Brand) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public Brand findById(java.lang.Integer id) {
		logger.log(Level.INFO, "getting Brand instance with id: " + id);
		try {
			Brand instance = (Brand) sessionFactory.getCurrentSession().get("dao.Brand", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List findByExample(Brand instance) {
		logger.log(Level.INFO, "finding Brand instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("dao.Brand").add(Example.create(instance))
					.list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
        
        public static List getAllBrand() {
        List<Brand> list = null;
        
        try {
            NewHibernateUtil.getSession().beginTransaction();
            
            list = NewHibernateUtil.getSession().createCriteria(entities.Brand.class).list();
            NewHibernateUtil.getSession().getTransaction().commit();
            
        } catch (Exception e) {
            System.err.println(e);
        }
        return list;
    }
}
