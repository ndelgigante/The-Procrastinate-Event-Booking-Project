package showing;
import java.util.ArrayList; import java.util.Iterator;

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
}
