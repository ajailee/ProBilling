package dao;
// Generated Jul 30, 2021, 10:24:44 PM by Hibernate Tools 5.4.30.Final

import entities.Category;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import utils.NewHibernateUtil;

/**
 * Home object for domain model class Category.
 *
 * @see dao.Category
 * @author Hibernate Tools
 */
public class CategoryHome {

    private static final Logger logger = Logger.getLogger(CategoryHome.class.getName());

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return NewHibernateUtil.getSessionFactory();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(Category transientInstance) {
        logger.log(Level.INFO, "persisting Category instance");
        try {
            NewHibernateUtil.getSession().beginTransaction();
            NewHibernateUtil.getSession().persist(transientInstance);
            NewHibernateUtil.getSession().getTransaction().commit();
            logger.log(Level.INFO, "persist successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "persist failed", re);
            throw re;
        }
    }

    public void attachDirty(Category instance) {
        logger.log(Level.INFO, "attaching dirty Category instance");
        try {
            sessionFactory.openSession().beginTransaction();
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
           sessionFactory.getCurrentSession().getTransaction().commit();
            logger.log(Level.INFO, "attach successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "attach failed", re);
            throw re;
        }
    }

    public void attachClean(Category instance) {
        logger.log(Level.INFO, "attaching clean Category instance");
        try {
            sessionFactory.openSession().beginTransaction();
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
          sessionFactory.getCurrentSession().getTransaction().commit();
            logger.log(Level.INFO, "attach successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "attach failed", re);
            throw re;
        }
    }

    public void delete(Category persistentInstance) {
        logger.log(Level.INFO, "deleting Category instance");
        try {
            sessionFactory.openSession().beginTransaction();
            sessionFactory.getCurrentSession().delete(persistentInstance);
             sessionFactory.getCurrentSession().getTransaction().commit();
            logger.log(Level.INFO, "delete successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "delete failed", re);
            throw re;
        }
    }

    public Category merge(Category detachedInstance) {
        logger.log(Level.INFO, "merging Category instance");
        try {
            sessionFactory.openSession().beginTransaction();
            Category result = (Category) sessionFactory.getCurrentSession().merge(detachedInstance);
            sessionFactory.getCurrentSession().getTransaction().commit();
            logger.log(Level.INFO, "merge successful");
            return result;
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }

    public Category findById(java.lang.Integer id) {
        logger.log(Level.INFO, "getting Category instance with id: " + id);
        try {
            sessionFactory.openSession().beginTransaction();
            Category instance = (Category) sessionFactory.getCurrentSession().get("dao.Category", id);
            if (instance == null) {
                logger.log(Level.INFO, "get successful, no instance found");
            } else {
                logger.log(Level.INFO, "get successful, instance found");
            }
            sessionFactory.getCurrentSession().getTransaction().commit();
            return instance;
            
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }

    public List findByExample(Category instance) {
        logger.log(Level.INFO, "finding Category instance by example");
        try {
            sessionFactory.openSession().beginTransaction();
            List results = sessionFactory.getCurrentSession().createCriteria("dao.Category")
                    .add(Example.create(instance)).list();
            logger.log(Level.INFO, "find by example successful, result size: " + results.size());
           sessionFactory.getCurrentSession().getTransaction().commit();
            return results;
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "find by example failed", re);
            throw re;
        }
        finally{
            
        }
    }
    public static List getAllCategory() {
        List<Category> list = null;
        
        try {
            NewHibernateUtil.getSession().beginTransaction();
            
            list = NewHibernateUtil.getSession().createCriteria(entities.Category.class).list();
            NewHibernateUtil.getSession().getTransaction().commit();
            
        } catch (Exception e) {
            System.err.println(e);
        }
        return list;
    }
}
