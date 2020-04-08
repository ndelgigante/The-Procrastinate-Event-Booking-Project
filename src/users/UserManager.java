package users;
import java.util.HashMap; import java.util.Scanner;

public class UserManager {
	private HashMap<String, User> users;
	
	public UserManager() {
		users = new HashMap<String, User>();
	}
	
	public void addUser(String username, User user) {
		users.put(username, user);
	}
	
	public User login() {
		Scanner scanner = new Scanner(System.in);
		String username;
		String password;
		
		System.out.println("Enter your username");
		username = scanner.nextLine();
		
		System.out.println("Enter your password");
		password = scanner.nextLine();
		
		User user = users.get(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		
		System.out.println("Invalid credentials...");
		return null;
	}
	
	// TODO: expand acount creation to other types of users
	// waiting for jazzmin to code that part...
	// use activeUser to determine if it is an employee/admin account, so they get permissions to make other employee accounts
	public void createAccount(User activeUser) {
		Scanner scanner = new Scanner(System.in);
		String username;
		String password;
		
		System.out.println("Enter your username");
		username = scanner.nextLine();
		
		System.out.println("Enter your password");
		password = scanner.nextLine();
		
		User user = users.get(username);
		if (user != null) {
			System.out.println("Username is already taken");
			return;
		}
		
		user = new User(password);
		users.put(username, user);
		return;
	}
}
