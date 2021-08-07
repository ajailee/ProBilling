package dao;
// Generated Aug 1, 2021, 11:29:07 AM by Hibernate Tools 5.4.30.Final

import backend.PurchaseBE;
import entities.Inventory;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import utils.NewHibernateUtil;

/**
 * Home object for domain model class Inventory.
 *
 * @see entities.Inventory
 * @author Hibernate Tools
 */
public class InventoryHome {

    private static final Logger logger = Logger.getLogger(InventoryHome.class.getName());

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return NewHibernateUtil.getSessionFactory();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public Long persist(Inventory transientInstance) {
        logger.log(Level.INFO, "persisting Inventory instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            sessionFactory.getCurrentSession().refresh(transientInstance);
            logger.log(Level.INFO, "persist successful");
            return transientInstance.getInventoryId();
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "persist failed", re);
            throw re;
        }

    }

    public void attachDirty(Inventory instance) {
        logger.log(Level.INFO, "attaching dirty Inventory instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            logger.log(Level.INFO, "attach successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "attach failed", re);
            throw re;
        }
    }

    public void attachClean(Inventory instance) {
        logger.log(Level.INFO, "attaching clean Inventory instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            logger.log(Level.INFO, "attach successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "attach failed", re);
            throw re;
        }
    }

    public void delete(Inventory persistentInstance) {
        logger.log(Level.INFO, "deleting Inventory instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            logger.log(Level.INFO, "delete successful");
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "delete failed", re);
            throw re;
        }
    }

    public Inventory merge(Inventory detachedInstance) {
        logger.log(Level.INFO, "merging Inventory instance");
        try {
            Inventory result = (Inventory) sessionFactory.getCurrentSession().merge(detachedInstance);
            logger.log(Level.INFO, "merge successful");
            return result;
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }

    public Inventory findById(java.lang.Long id) {
        logger.log(Level.INFO, "getting Inventory instance with id: " + id);
        try {
            sessionFactory.getCurrentSession().beginTransaction();
            Inventory instance = (Inventory) sessionFactory.getCurrentSession().get("entities.Inventory", id);
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

    public List findByExample(Inventory instance) {
        logger.log(Level.INFO, "finding Inventory instance by example");
        try {
            List results = sessionFactory.getCurrentSession().createCriteria("entities.Inventory")
                    .add(Example.create(instance)).list();
            logger.log(Level.INFO, "find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "find by example failed", re);
            throw re;
        }
    }

    public Inventory findByProductId(String id) {
        logger.log(Level.INFO, "getting Inventory instance with product id: " + id);
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
                sessionFactory.getCurrentSession().beginTransaction();
            }

            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Inventory.class);
            //criteria.createAlias("product", "p");
            criteria.add(Restrictions.eq("product.productId", id));

            Inventory instance = (Inventory) criteria.uniqueResult();
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

    public List<Inventory> getAll() {
        List<Inventory> list = null;

        try {
            NewHibernateUtil.getSession().beginTransaction();

            list = NewHibernateUtil.getSession().createCriteria(entities.Inventory.class).list();
            NewHibernateUtil.getSession().getTransaction().commit();

        } catch (Exception e) {
            System.err.println(e);
        }

        return list;
    }

    public boolean saveOrUpdateProduct(List<Inventory> transientInstanceList, String purchaseId, String supplierName, Date date, String addedBy, Date addTime) {
        logger.log(Level.INFO, "Add Stock To The Inventory");
        entities.Inventory i;
        try {

            for (Inventory transientInstance : transientInstanceList) {

                i = findByProductId(transientInstance.getProduct().getId());
                if (i != null) {
                    i.setBuyingPrice(transientInstance.getBuyingPrice());
                    i.setSellingPrice(i.getSellingPrice());
                    i.setMargine(transientInstance.getMargine());
                    i.setProduct(transientInstance.getProduct());
                    i.setQty(transientInstance.getQty() + i.getQty());
                    sessionFactory.getCurrentSession().beginTransaction();
                    sessionFactory.getCurrentSession().update(i);
                    sessionFactory.getCurrentSession().getTransaction().commit();
                } else {
                    sessionFactory.getCurrentSession().beginTransaction();
                    sessionFactory.getCurrentSession().persist(transientInstance);
                    sessionFactory.getCurrentSession().getTransaction().commit();
                }
                PurchaseBE.addPurchase(purchaseId, supplierName, date, transientInstance.getProduct(), transientInstance.getBuyingPrice(), transientInstance.getSellingPrice(), transientInstance.getMargine(), transientInstance.getQty(), addedBy, addTime);
                logger.log(Level.INFO, "Values Updated SuccessFully");
                System.out.println(transientInstance.getInventoryId());
                // return transientInstance.getInventoryId();
            }

        } catch (RuntimeException re) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            logger.log(Level.SEVERE, "persist failed", re.getMessage());
            throw re;

        }
        return true;
    }

    public void reduceStock(String id, int qty) {
        logger.log(Level.INFO, "Add Stock To The Inventory");
        entities.Inventory i;
        try {
            i = findByProductId(id);
            if (i != null) {
                i.setQty(i.getQty() - qty);
                sessionFactory.getCurrentSession().beginTransaction();
                sessionFactory.getCurrentSession().update(i);
                sessionFactory.getCurrentSession().getTransaction().commit();
            }
        } catch (Exception e) {
        }
        logger.log(Level.INFO, "Values Updated SuccessFully");

    }
}
