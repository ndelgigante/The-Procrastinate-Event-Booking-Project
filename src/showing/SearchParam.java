/**
 * Helper class to reduce mandatory parameters in ShowingManager.getShowings()
 */
package showing;
import driver.MaturityRating;

public class SearchParam {
	public SortType sortType;
	public String userSearch; 
	public String venue;
	public double minRating;
	public MaturityRating[] maturityRatingBlacklist;
	
	public SearchParam() {
		sortType = null;
		userSearch = null;
		venue = null;
		minRating = 0.0;
		maturityRatingBlacklist = null;
	};
}
