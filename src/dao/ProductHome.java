package dao;
// Generated Jul 30, 2021, 10:24:44 PM by Hibernate Tools 5.4.30.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import entities.Product;
import org.hibernate.HibernateException;

import utils.NewHibernateUtil;

/**
 * Home object for domain model class Product.
 *
 * @see dao.Product
 * @author Hibernate Tools
 */
public class ProductHome {

    private static final Logger logger = Logger.getLogger(ProductHome.class.getName());

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return NewHibernateUtil.getSessionFactory();
            } catch (Exception e) {
            logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(Product transientInstance) {
        logger.log(Level.INFO, "persisting Product instance");
        try {
            sessionFactory.getCurrentSession().beginTransaction();
            sessionFactory.getCurrentSession().persist(transientInstance);
            sessionFactory.getCurrentSession().getTransaction().commit();
            logger.log(Level.INFO, "persist successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "persist failed", re);
            throw re;
        }
    }

    public void attachDirty(Product instance) {
        logger.log(Level.INFO, "attaching dirty Product instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            logger.log(Level.INFO, "attach successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "attach failed", re);
            throw re;
        }
    }

    public void attachClean(Product instance) {
        logger.log(Level.INFO, "attaching clean Product instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            logger.log(Level.INFO, "attach successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "attach failed", re);
            throw re;
        }
    }

    public void delete(Product persistentInstance) {
        logger.log(Level.INFO, "deleting Product instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            logger.log(Level.INFO, "delete successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "delete failed", re);
            throw re;
        }
    }

    public Product merge(Product detachedInstance) {
        logger.log(Level.INFO, "merging Product instance");
        try {
            Product result = (Product) sessionFactory.getCurrentSession().merge(detachedInstance);
            logger.log(Level.INFO, "merge successful");
            return result;
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }

    public Product findById(java.lang.String id) {
        logger.log(Level.INFO, "getting Product instance with id: " + id);
        try {
            Product instance = (Product) sessionFactory.getCurrentSession().get("dao.Product", id);
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

    public List findByExample(Product instance) {
        logger.log(Level.INFO, "finding Product instance by example");
        try {
            List results = sessionFactory.getCurrentSession().createCriteria("dao.Product")
                    .add(Example.create(instance)).list();
            logger.log(Level.INFO, "find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "find by example failed", re);
            throw re;
        }
    }

    static public List<Product> getAll() {

        List<Product> list = null;

        try {
            logger.log(Level.INFO, "finding all");
            NewHibernateUtil.getSession().beginTransaction();
            list = NewHibernateUtil.getSession().createCriteria(entities.Product.class).list();
            NewHibernateUtil.getSession().getTransaction().commit();
            logger.log(Level.INFO, "find by all successful, result size: " + list.size());

        } catch (HibernateException re) {
            NewHibernateUtil.getSession().getTransaction().rollback();
            logger.log(Level.SEVERE, "find all failed", re);
            throw re;
        }
        return list;
    }
}
