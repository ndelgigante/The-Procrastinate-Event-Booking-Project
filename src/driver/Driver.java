package driver;
import events.*; import showing.*; import users.*; import venue.*;
import java.util.Scanner; import java.util.ArrayList; import java.io.IOException; import java.time.*;

public class Driver {
	private static User activeUser;
	private static SearchParam searchParam;
	private static Scanner scanner;
	private static EventManager eventManager;
	private static ShowingManager showingManager;
	private static VenueCollection venueCollection;
	private static UserManager userManager;
	
	// testing data
	private static void initData() {
		Event testEvent = new Event("Despicable Me", MaturityRating.G, "Gru does stuff");
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
		
		Venue testVenue = new Venue("Columbiana Grande");
		testVenue.addRoom(testRoomTemplate);
		testVenue.addRoom(testRoomTemplate2);
		testVenue.addRoom(testRoomTemplate3);
		venueCollection.addVenue(testVenue);
		
		Showing testShowing = new Showing(testEvent, testVenue, 1, LocalDateTime.of(2020, 4, 10, 12, 30));
		Showing testShowing2 = new Showing(testEvent2, testVenue, 1, LocalDateTime.of(2020, 4, 10, 12, 30));
		Showing testShowing3 = new Showing(testEvent3, testVenue, 1, LocalDateTime.of(2020, 4, 10, 5, 30));
		Showing testShowing4 = new Showing(testEvent4, testVenue, 1, LocalDateTime.of(2020, 4, 10, 5, 30));
		Showing testShowing5 = new Showing(testEvent5, testVenue, 1, LocalDateTime.of(2020, 4, 10, 5, 30));
		showingManager.addShowing(testShowing);
		showingManager.addShowing(testShowing2);
		showingManager.addShowing(testShowing3);
		showingManager.addShowing(testShowing4);
		showingManager.addShowing(testShowing5);
		
		userManager.addUser("testuser", new User("123456"));
	}
	
	private static void login() {
		while (activeUser == null) {
			System.out.println("Please select an option:\n"
					+ "1: Log in\n"
					+ "2: Create an account\n"
					+ "3: Continue as a Guest\n"
					+ "4: Exit\n");
			
			switch(scanner.nextLine()) {
				case "1": 
					activeUser = userManager.login();
					break;
				case "2": 
					userManager.createAccount(activeUser);
					break;
				case "3":
					activeUser = new User(null);
					break;
				case "4":
					System.out.println("Have a good day!");
					System.exit(0);
					break;
				default:
					break;	
			}
		}
	}
	
	private static void promptShowings() {
		ArrayList<Showing> searchedShowings = showingManager.getShowings(searchParam);
		while(true) {
			System.out.println("\nSelect the showing you would like to purchase");
			System.out.println("0. Exit");
			
			for(int i=0; i<searchedShowings.size(); ++i) {
				System.out.println(i+1+". " + searchedShowings.get(i).toString());
			}
			
			int selectedShowing = scanner.nextInt();
			if (selectedShowing == 0 || selectedShowing > searchedShowings.size())
				return;
			
			selectedShowing = selectedShowing - 1;
			Showing showingObj = searchedShowings.get(selectedShowing);
			
			int[] seat = showingObj.promptChooseSeat();
			if(seat == null)
				return;
			
			activeUser.getTickets().add(new Ticket(showingObj, seat[0], seat[1]));
		}
	}
	
	private static void promptOptions() throws IOException {
		System.out.println("\nPlease select an option:\n"
				+ "1: View showings\n"
				+ "2: Update search parameters\n"
				+ "3: My Showings\n"
				+ "4: Create event\n"
				+ "5: Create venue\n"
				+ "6: Create showing\n"
				+ "7: Print all events\n"
				+ "8: Print all venues\n"
				+ "9: Print all showings");
		
		String selection = scanner.nextLine(); // can't use a switch -- more complicated logic to handle employee accounts
		
		if (selection.equals("1")) {
			promptShowings();
		}
		else if (selection.equals("2")) {
			// since im writing pretty much all the code i dont have time to collect user input to modify SearchParam
			// TODO: branching menu that lets you edit searchParam attributes
		}
		else if (selection.equals("3")) {
			activeUser.promptShowShowings();
		}
		else if (selection.equals("4")) {
			eventManager.promptCreateEvent();
		}
		else if (selection.equals("5")) {
			venueCollection.promptCreateVenue();
		}
		else if (selection.equals("6")) {
			showingManager.promptCreateShowing(eventManager, venueCollection);
		}
		else if (selection.equals("7")) {
			eventManager.printAllEvents();
		}
		else if (selection.equals("8")) {
			venueCollection.printAllVenues();
		}
		else if (selection.equals("9")) {
			showingManager.printShowings();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// init managers
		eventManager = new EventManager("TODO: json file stuff");
		showingManager = new ShowingManager("TODO: json file stuff");
		venueCollection = new VenueCollection("TODO: json file stuff");
		userManager = new UserManager();
		initData();
	
		searchParam = new SearchParam();
		scanner = new Scanner(System.in);
		
		while(true) {
			login(); 
			while(activeUser!=null) {
				promptOptions();
			}
		}
	}
}
