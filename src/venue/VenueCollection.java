package venue;
import java.util.ArrayList; import java.util.Scanner;

import events.Event;
/**
 * 
 * @author samkellogg
 *
 */
public class VenueCollection {
	private ArrayList<Venue> venues;
	
	public VenueCollection(String jsonPath) {
		venues = new ArrayList<Venue>();
	}
	
	void addVenue(Venue venue){
		venues.add(venue);
	}
	
	void removeVenue(Venue venue) {
		venues.remove(venue);
	}
	
	public ArrayList<Venue> getVenues(){
		return venues;
	}
	
	public void promptCreateVenue() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the name of the venue");
		String name = scanner.nextLine();
		
		System.out.println("Enter the number of rooms in this venue");
		int numRooms = scanner.nextInt();
		
		if (numRooms < 1) 
			return;
		
		Venue newVenue = new Venue(name);
		
		for (int i=0; i<numRooms; ++i) {
			System.out.println("Enter the number of columns of seats in room "+(i+1));
			int x = scanner.nextInt();
			
			System.out.println("Enter the number of rows of seats in room "+(i+1));
			int y = scanner.nextInt();
			
			SeatAvailability[][] seatingArrangements = new SeatAvailability[x][y];
			
			newVenue.addRoom(new RoomTemplate(seatingArrangements, i));
		}
		
		addVenue(newVenue);
	}
	
	public void printAllVenues() {	
		System.out.println("Venues: -------------------------");
				
		for (Venue venue : venues) {
			venue.print();
		}
	
		System.out.println("---------------------------------");
	}
}
