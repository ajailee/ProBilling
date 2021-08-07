package dao;
// Generated Aug 7, 2021, 2:12:16 PM by Hibernate Tools 5.4.30.Final

import entities.Invoice;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import utils.NewHibernateUtil;

/**
 * Home object for domain model class Invoice.
 *
 * @see entities.Invoice
 * @author Hibernate Tools
 */
public class InvoiceHome {

    private static final Logger logger = Logger.getLogger(InvoiceHome.class.getName());

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return NewHibernateUtil.getSessionFactory();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public boolean persist(Invoice transientInstance) {
        logger.log(Level.INFO, "persisting Invoice instance");
        try {
            Transaction tx = sessionFactory.getCurrentSession().getTransaction();
            if (!tx.isActive()) {
                tx.begin();
            }
            sessionFactory.getCurrentSession().persist(transientInstance);
            tx.commit();

            logger.log(Level.INFO, "persist successful");
            return true;
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "persist failed", re);
            return false;
        }
    }

    public void attachDirty(Invoice instance) {
        logger.log(Level.INFO, "attaching dirty Invoice instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            logger.log(Level.INFO, "attach successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "attach failed", re);
            throw re;
        }
    }

    public void attachClean(Invoice instance) {
        logger.log(Level.INFO, "attaching clean Invoice instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            logger.log(Level.INFO, "attach successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "attach failed", re);
            throw re;
        }
    }

    public void delete(Invoice persistentInstance) {
        logger.log(Level.INFO, "deleting Invoice instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            logger.log(Level.INFO, "delete successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "delete failed", re);
            throw re;
        }
    }

    public Invoice merge(Invoice detachedInstance) {
        logger.log(Level.INFO, "merging Invoice instance");
        try {
            Invoice result = (Invoice) sessionFactory.getCurrentSession().merge(detachedInstance);
            logger.log(Level.INFO, "merge successful");
            return result;
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }

    public Invoice findById(java.lang.Long id) {
        logger.log(Level.INFO, "getting Invoice instance with id: " + id);
        try {
            Transaction tx = NewHibernateUtil.begainTransaction();
            Invoice instance = (Invoice) sessionFactory.getCurrentSession().get("entities.Invoice", id);
            if (instance == null) {
                logger.log(Level.INFO, "get successful, no instance found");
            } else {
                logger.log(Level.INFO, "get successful, instance found");
            }
            NewHibernateUtil.endTransaction(tx);
            return instance;
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }

    public List findByExample(Invoice instance) {
        logger.log(Level.INFO, "finding Invoice instance by example");
        try {
            Transaction tx = NewHibernateUtil.begainTransaction();
            List results = sessionFactory.getCurrentSession().createCriteria("entities.Invoice")
                    .add(Example.create(instance)).list();
            logger.log(Level.INFO, "find by example successful, result size: " + results.size());
            NewHibernateUtil.endTransaction(tx);
            return results;
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "find by example failed", re);
            throw re;
        }
    }

    public Long getInvoiceId() {
        logger.log(Level.INFO, "getting Invoice Number");
        try {
            Transaction tx = NewHibernateUtil.begainTransaction();
            Query result = sessionFactory.getCurrentSession().createQuery("Select MAX(invoiceId) from entities.Invoice");
            Long id = (Long) result.uniqueResult();
            if (id == null) {
                return Long.valueOf("000001");
            }
            NewHibernateUtil.endTransaction(tx);
            return id + 1L;
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "find by example failed", re);
            throw re;
        }
    }
}
