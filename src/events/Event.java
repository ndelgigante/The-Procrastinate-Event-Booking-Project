package events;
import driver.MaturityRating;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Nicholas Del Gigante, Austin Tindal
 * The event object that has information of the event and reviews that were made about the event
 */
public class Event {
	private String name;
	private MaturityRating maturityRating;
	private String description;
	private ArrayList<Review> reviews;
	
	public Event() {}

	public String getName() {
		return name;
	}
	
	public MaturityRating getMaturityRating() {
		return maturityRating;
	}
	
	public String getDescription() {
		return description;
	}
	
	/**
	 * calculates the average star rating from the reviews of the event
	 * @return the average star rating of the event
	 */
	public double getReviewAvg() {
		Iterator<Review> iterator = reviews.iterator();
		int count = 0;
		int total = 0;
		while(iterator.hasNext()) {
			Review review = iterator.next();
			count++;
			total = review.getStarRating();
		}
		return total/count;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setRating(MaturityRating maturityRating) {
		this.maturityRating = maturityRating;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Adds a review to the reviews arraylist
	 * @param review the review to be added
	 */
	public void addReview(Review review) {
		reviews.add(review);
	}
	
	/**
	 * deletes the first occurence of the review in the the reviews arraylist
	 * @param review the review to be deleted
	 */
	public void deleteReview(Review review) {
		reviews.remove(review);
	}
	
	
}
