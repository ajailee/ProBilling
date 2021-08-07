
import backend.InventoryBE;
import backend.ProductBE;
import dao.InvoiceHome;
import dao.UserDAO;
import entities.Brand;
import entities.Category;
import entities.Invoice;
import entities.Product;
import entities.Purchase;
import java.util.Date;
import org.hibernate.SessionFactory;
import utils.NewHibernateUtil;

public class App {

    public static void main(String[] args) {
    Invoice i= new InvoiceHome().findById(2L);
        System.out.println(i);
    }

}
