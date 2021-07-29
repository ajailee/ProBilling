import dao.UserDAO;
import entities.User;

public class App {

	public static void main(String[] args) {
		User user = new User( "ajay", "lee", true, true, true, true, true, true, true, true, false);
		UserDAO.addUser(user);
	}

}
