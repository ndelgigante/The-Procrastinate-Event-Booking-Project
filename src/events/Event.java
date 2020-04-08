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
	private double reviewAvg;
	
	public Event(String name, MaturityRating maturityRating, String description) {
		setName(name);
		setRating(maturityRating);
		setDescription(description);
		reviews = new ArrayList<Review>();
		reviewAvg = 0.0;
	}

	public String getName() {
		return name;
		
	}
	
	public MaturityRating getMaturityRating() {
		return maturityRating;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getReviewAvg() {
		return reviewAvg;
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
		averageReviews();
	}
	
	/**
	 * deletes the first occurence of the review in the the reviews arraylist
	 * @param review the review to be deleted
	 */
	public void deleteReview(Review review) {
		reviews.remove(review);
	}
	
	/**
	 * calculates the average star rating from the reviews of the event
	 */
	private void averageReviews() {
		Iterator<Review> iterator = reviews.iterator();
		int count = 0;
		int total = 0;
		while(iterator.hasNext()) {
			Review review = iterator.next();
			count++;
			total = review.getStarRating();
		}
		reviewAvg = total/count;
	}
	
	public void print() {
		System.out.println("Name: "+ name + " MR: " + maturityRating + " Desc: " + description);
	}
}
