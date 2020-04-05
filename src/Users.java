import java.util.*;

/*
 * Author Jazzmin Graham
 */
public class Users {
	private String employUser;
	private String custUser;
public Users(String xEmployUser, String xCustUser)
{
	setEmployUser(xEmployUser);
	setCustUser(xCustUser);
}
public String getEmployUser() {
	return employUser;
}
public void setEmployUser(String employUser) {
	this.employUser = employUser;
}
public String getCustUser() {
	return custUser;
}
public void setCustUser(String custUser) {
	this.custUser = custUser;
}
	
	

}
