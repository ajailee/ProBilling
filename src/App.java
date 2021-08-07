
import backend.InventoryBE;
import backend.ProductBE;
import dao.UserDAO;
import entities.Brand;
import entities.Category;
import entities.Product;
import entities.Purchase;
import java.util.Date;
import org.hibernate.SessionFactory;
import utils.NewHibernateUtil;

public class App {

    public static void main(String[] args) {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Purchase p = new Purchase("123", "ajai", new Date(), new Product("id", "nam", "cat", "bran", "uno", 5, 10, "hsn"), 120, 130, 10, 30, "ajay", new Date());
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().persist(p);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

}
