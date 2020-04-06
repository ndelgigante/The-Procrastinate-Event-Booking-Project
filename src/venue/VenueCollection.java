import java.util.ArrayList;
/**
 * 
 * @author samkellogg
 *
 */
public class VenueCollection {
	private ArrayList<Venue> venues;
	
	VenueCollection(String jsonPath) {
		venues = new ArrayList<Venue>();
	}
	void addVenue(Venue venue){
		venues.add(venue);
	}
	void removeVenue(Venue venue) {
		venues.remove(venue);
	}
	ArrayList<Venue> getVenues(){
		return venues;
}
	
	
}
