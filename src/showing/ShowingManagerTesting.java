package showing;
import events.Event; import events.Review; import venue.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


class ShowingManagerTesting {
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
	public void testAddShowing() {
		ShowingManager showingManager = new ShowingManager(null);
		Showing showing = new Showing(null, null, 0, null);
		showingManager.addShowing(showing);
		assertFalse(!showingManager.getShowings(null).equals(showing));
	}
	
	@Test
	public void testRemoveShowing() {
		ShowingManager showingManager = new ShowingManager(null);
		Showing showing = new Showing(null, null, 0, null);
		showingManager.addShowing(showing);
		showingManager.removeShowing(showing);
		assertFalse(!showingManager.getShowings(null).equals(null));
	}
	
	

}
