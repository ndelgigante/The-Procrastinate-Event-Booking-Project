package users;
import java.util.*;

/*
 * Author Jazzmin Graham
 */
public class User {
	private String password;
	
	public User(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUserType() {
		return "Guest";
	}

		
	

}
