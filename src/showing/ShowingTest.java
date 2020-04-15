package showing;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import driver.MaturityRating;
import events.Event;
import events.EventManager;
import users.User;
import users.UserManager;
import venue.RoomTemplate;
import venue.SeatAvailability;
import venue.Venue;
import venue.VenueCollection;

class ShowingTest {
	private static User activeUser;
	private static SearchParam searchParam;
	private static Scanner scanner;
	private static EventManager eventManager;
	private static ShowingManager showingManager;
	private static VenueCollection venueCollection;
	private static UserManager userManager;
	
	private static Venue testVenue;
	private static Event testEvent;
	

	@BeforeEach
	public void before() throws Exception {
		eventManager = new EventManager("TODO: json file stuff");
		showingManager = new ShowingManager("TODO: json file stuff");
		venueCollection = new VenueCollection("TODO: json file stuff");
		userManager = new UserManager();
		
		testEvent = new Event("Despicable Me", MaturityRating.G, "Gru does stuff");
		Event testEvent2 = new Event("Despicable Me 2", MaturityRating.G, "Cash grab for minions fans");
		Event testEvent3 = new Event("Despicable Me 3", MaturityRating.G, "The minions take over the world");
		Event testEvent4 = new Event("Frozen 2", MaturityRating.G, "Elsa and Anna go on an adventure");
		Event testEvent5 = new Event("The Jungle Book", MaturityRating.PG, "Elsa and Anna go on an adventure");
		eventManager.addEvent(testEvent);
		eventManager.addEvent(testEvent2);
		eventManager.addEvent(testEvent3);
		eventManager.addEvent(testEvent4);
		eventManager.addEvent(testEvent5);
		
		SeatAvailability[][] availTemp = new SeatAvailability[5][5];
		
		RoomTemplate testRoomTemplate = new RoomTemplate(availTemp, 1);
		RoomTemplate testRoomTemplate2 = new RoomTemplate(availTemp, 2);
		RoomTemplate testRoomTemplate3 = new RoomTemplate(availTemp, 3);
		
		testVenue = new Venue("Columbiana Grande");
		testVenue.addRoom(testRoomTemplate);
		testVenue.addRoom(testRoomTemplate2);
		testVenue.addRoom(testRoomTemplate3);
		venueCollection.addVenue(testVenue);
		
		//Showing testShowing = new Showing(testEvent, testVenue, 1, LocalDateTime.of(2020, 4, 10, 12, 30));
		Showing testShowing2 = new Showing(testEvent2, testVenue, 1, LocalDateTime.of(2020, 4, 10, 12, 30));
		Showing testShowing3 = new Showing(testEvent3, testVenue, 1, LocalDateTime.of(2020, 4, 10, 5, 30));
		Showing testShowing4 = new Showing(testEvent4, testVenue, 1, LocalDateTime.of(2020, 4, 10, 5, 30));
		Showing testShowing5 = new Showing(testEvent5, testVenue, 1, LocalDateTime.of(2020, 4, 10, 5, 30));
		//showingManager.addShowing(testShowing);
		showingManager.addShowing(testShowing2);
		showingManager.addShowing(testShowing3);
		showingManager.addShowing(testShowing4);
		showingManager.addShowing(testShowing5);
		
		userManager.addUser("testuser", new User("123456"));
	}

	@Test
	public void testSettersGetters() {
		assert(testEvent!=null);
		assert(testVenue!=null);
		
		int roomIdentifier = 1;
		
		Showing testShowing = new Showing(testEvent, testVenue, roomIdentifier, LocalDateTime.of(2020, 4, 10, 12, 30));
		
		LocalDateTime testTime =  LocalDateTime.of(2020, 4, 10, 12, 30);
		
		assert(testShowing.getEvent().equals(testEvent));
		//assert(testShowing.getParentVenue.equals(testVenue)); // this getter does not exist
		assert(testShowing.getRoom().getTemplate().getIdentifier() == roomIdentifier + 1); // indexes different internally
		assert(testShowing.getTime().equals(testTime));
	}
}
