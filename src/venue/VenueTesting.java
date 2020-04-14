
package venue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
//import org.junit.Test;

import driver.MaturityRating;
public class VenueTesting {


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
	public void testGetVenue() {
		VenueCollection venueCollection = new VenueCollection(null);
		Venue venue = new Venue("name");
		assertFalse(!(venue.equals(venueCollection.getVenues().get(0))));
	}
	
	@Test
	public void testRemoveVenue() {
		VenueCollection venueCollection = new VenueCollection(null);
		Venue venue = new Venue("name");
		venueCollection.addVenue(venue);
		venueCollection.removeVenue(venue);
		assertFalse(!venueCollection.equals(null));
	}

	@Test
	public void testGetVenues() {
		VenueCollection venueCollection = new VenueCollection(null);
		Venue venue = new Venue("name");
		venueCollection.addVenue(venue);
		assertFalse(!venue.equals(venueCollection.getVenues().get(0)));
	}
	
	@Test
	public void testAddRoom() {
		Venue venue = new Venue("name");
		Room room = new Room(null);
		RoomTemplate roomTemplate = new RoomTemplate(room.getSeating(),0);
		venue.addRoom(roomTemplate);
		assertFalse(!venue.getRoom(0).equals(roomTemplate));
	}
	
	@Test
	public void testRemoveRoom() {
		Venue venue = new Venue("name");
		Room room = new Room(null);
		RoomTemplate roomTemplate = new RoomTemplate(room.getSeating(),0);
		venue.addRoom(roomTemplate);
		venue.removeRoom(roomTemplate);
		assertFalse(!venue.getRooms().equals(null));
	}
	
	@Test
	public void testGetName() {
		Venue venue = new Venue("name");
		assertFalse(!venue.getName().equals("name"));
	}
	
}
