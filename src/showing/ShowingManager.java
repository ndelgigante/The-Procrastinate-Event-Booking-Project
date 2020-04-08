package showing;
import java.util.ArrayList; import java.util.Iterator; import java.util.Scanner; import java.time.*;
import events.*; import venue.*;

public class ShowingManager {
	private ArrayList<Showing> showings;
	
	public ShowingManager(String jsonPath) {
		showings = new ArrayList<Showing>();
		// import showings from json file
	}
	
	public void addShowing(Showing showing) {
		showings.add(showing);
	}
	
	public void removeShowing(Showing showing) {
		showings.remove(showing);
	}
	
	/**
	 * 
	 * @param searchParam define constraints on search by setting SearchParam attributes
	 */
	public ArrayList<Showing> getShowings(SearchParam searchParam) {
		ArrayList<Showing> searchResults = new ArrayList<Showing>();
		Iterator<Showing> iterator = showings.iterator();
		
		while(iterator.hasNext()) {
			Showing showing = iterator.next();
			
			// check that event's name is similar to the user search
			if(searchParam.userSearch != null && 
					!showing.getEvent().getName().contains(searchParam.userSearch)) {
				continue;
			}
			
			// check that venue search field 
			if(searchParam.venue != null &&
					!showing.getParentVenue().getName().contains(searchParam.venue)) {
				continue;
			}
			
			// verify event's review average is above user's minimum rating
			if(showing.getEvent().getReviewAvg() < searchParam.minRating) {
				continue;
			}
			
			// cut showings that show events with maturity ratings specified by user
			if(searchParam.maturityRatingBlacklist != null) {
				for(int i=0; i<searchParam.maturityRatingBlacklist.length; ++i) {
					if(showing.getEvent().getMaturityRating() == searchParam.maturityRatingBlacklist[i]) 
						continue;
				}
			}
			
			searchResults.add(showing);
		}
		
		return searchResults;
	}
	
	public void promptCreateShowing(EventManager eventManager, VenueCollection venueCollection) {
		Scanner scanner = new Scanner(System.in);
		
		// get event
		System.out.println("Enter the number of the event you would like to show");
		ArrayList<Event> events = eventManager.getEvents();
		int count = 0;
				
		for (Event event : events) {
			count++;
			System.out.println(count+". " + event.getName());
		}
		
		int selected = scanner.nextInt() - 1; // indexed at one for UX, but array still starts at 0
		Event selectedEvent = events.get(selected);
		
		if (selectedEvent == null) {
			System.out.println("An error occured...");
			return;
		}
		
		// get venue
		System.out.println("Enter the number of the venue the showing will take place in");
		ArrayList<Venue> venues = venueCollection.getVenues();
		count = 0;
		
		for (Venue venue : venues) {
			count++;
			System.out.println(count+". " + venue.getName());
		}
		
		selected = scanner.nextInt() - 1;
		Venue selectedVenue = venues.get(selected);
		
		if (selectedVenue == null) {
			System.out.println("An error occured...");
			return;
		}
		
		// get room
		System.out.println("This venue has rooms 0-"+selectedVenue.getRooms().size());
		System.out.println("Enter the room # you would like this showing to take place in:");
		
		int roomIdentifier = scanner.nextInt();
		if (roomIdentifier < 0 || roomIdentifier > selectedVenue.getRooms().size()) {
			System.out.println("Invalid room number entered....");
			return;
		}
		
		// TODO: allow input for time and date
		LocalDateTime time = LocalDateTime.now();
				
		Showing showing = new Showing(selectedEvent, selectedVenue, roomIdentifier, time);
		addShowing(showing);	
	}
	
	
	public void printShowings() {
		printShowings(new SearchParam());
	}
	
	public void printShowings(SearchParam searchParam) {
		ArrayList<Showing> results = getShowings(searchParam);
		for (Showing showing: results) {
			showing.print();
		}
	}
}
