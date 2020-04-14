package users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import driver.MaturityRating;

class UserManagerTesting {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPassword() {
		User user = new User("password");
		assertFalse(!user.getPassword().equals("password"));
	}
	
	@Test
	public void testGetUserType() {
		User user = new User("password");
		assertFalse(user.getUserType().equals("Guest"));
		
	}
	

}
