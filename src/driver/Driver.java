package driver;
import events.*; import showing.*; import users.*; import venue.*;
import java.util.Scanner;


public class Driver {
	private static User activeUser;
	private static SearchParam searchParam;
	private static Scanner scanner;
	private static EventManager eventManager;
	private static ShowingManager showingManager;
	private static VenueCollection venueCollection;
	private static UserManager userManager;
	
	public static void login() {
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
	
	public static void promptOptions() {
		System.out.println("\nPlease select an option:\n"
				+ "1: View showings\n"
				+ "2: Update search parameters\n"
				+ "3: Create event\n"
				+ "4: Create venue\n"
				+ "5: Create showing\n"
				+ "6: Print all events\n"
				+ "7: Print all venues\n"
				+ "8: Print all showings");
		
		String selection = scanner.nextLine(); // can't use a switch -- more complicated logic to handle employee accounts
		
		if (selection.equals("1")) {
			showingManager.printShowings(searchParam);
		}
		else if (selection.equals("2")) {
			
		}
		else if (selection.equals("3")) {
			eventManager.promptCreateEvent();
		}
		else if (selection.equals("4")) {
			venueCollection.promptCreateVenue();
		}
		else if (selection.equals("5")) {
			showingManager.promptCreateShowing(eventManager, venueCollection);
		}
		else if (selection.equals("6")) {
			eventManager.printAllEvents();
		}
		else if (selection.equals("7")) {
			venueCollection.printAllVenues();
		}
		else if (selection.equals("8")) {
			showingManager.printShowings();
		}
		
	}
	
	public static void main(String[] args) {
		// init managers
		eventManager = new EventManager("TODO: json file stuff");
		showingManager = new ShowingManager("TODO: json file stuff");
		venueCollection = new VenueCollection("TODO: json file stuff");
		userManager = new UserManager();
	
		searchParam = new SearchParam();
		scanner = new Scanner(System.in);
		
		while(true) {
			login(); 
			while(true) {
				promptOptions();
			}
		}
	}
}
