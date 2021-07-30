import dao.UserDAO;
import entities.Brand;
import entities.Category;
import entities.Product;
import entities.User;
import utils.NewHibernateUtil;

public class App {

	public static void main(String[] args) {
		          Category c = new Category();
                          c.setCategory("Electronics");
                          Brand b = new Brand();
                          b.setBrand("M Star");
                          
                          Product p = new Product("1", "test", "Electronics", "M Star", "qty", 5, 10, "123456");
                          
                          NewHibernateUtil.getSession().beginTransaction();
//                          NewHibernateUtil.getSession().save(c);
//                          NewHibernateUtil.getSession().save(b);
                           NewHibernateUtil.getSession().save(p);
                          NewHibernateUtil.getSession().getTransaction().commit();
                          
	}

}
