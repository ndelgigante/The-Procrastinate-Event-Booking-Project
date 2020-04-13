package events;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import driver.MaturityRating;

public class EventManagerTester {

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
	public void testGetEvent() {
		EventManager eventManager = new EventManager(null);
		Event event = new Event ("name",MaturityRating.G, "description");
		eventManager.addEvent(event);
		assertFalse(!(eventManager.getEvent("name").equals(event)));
	}
	
	@Test
	public void testRemoveEvent() {
		EventManager eventManager = new EventManager(null);
		Event event = new Event ("name",MaturityRating.G, "description");
		eventManager.addEvent(event);
		eventManager.removeEvent(event);
		assertNull(eventManager.getEvent("name"));
	}
	
	@Test
	public void testGetEventName() {
		Event event = new Event ("name",MaturityRating.G, "description");
		assertFalse(!(event.getName().equals("name")));		
	}
	
	@Test
	public void testGetEventRating() {
		Event event = new Event ("name",MaturityRating.G, "description");
		assertFalse(!(event.getMaturityRating().equals(MaturityRating.G)));	
	}
	
	@Test
	public void testGetEventDescription() {
		Event event = new Event ("name",MaturityRating.G, "description");
		assertFalse(!(event.getDescription().equals("description")));	
	}
	
	@Test
	public void testAddingAnReview() {
		Event event = new Event ("name",MaturityRating.G, "description");
		Review review = new Review(5, "elaboration");
		event.addReview(review);
		assertFalse(!(event.getReviewAvg()==5));
	}
	
	@Test
	public void testDeletingAnReview() {
		Event event = new Event ("name",MaturityRating.G, "description");
		Review review = new Review(5, "elaboration");
		event.addReview(review);
		event.deleteReview(review);
		assertFalse(!(event.getReviewAvg()==0));
	}
	
	
	@Test
	public void testAverageReview() {
		Event event = new Event ("name",MaturityRating.G, "description");
		Review review1 = new Review(5, "elaboration");
		Review review2 = new Review(1, "elaboration");
		event.addReview(review1);
		event.addReview(review2);
		assertFalse(!(event.getReviewAvg()==((5+1)/2)));
	}
	
	@Test
	public void testGetReviewRating() {
		Review review = new Review(5, "elaboration");
		assertFalse(!(review.getStarRating()==5));
	}
	
	@Test
	public void testGetReviewElaboration() {
		Review review = new Review(5, "elaboration");
		assertFalse(!(review.getElaboration().contentEquals("elaboration")));
	}

}
