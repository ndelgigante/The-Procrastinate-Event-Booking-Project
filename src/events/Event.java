package events;
import driver.MaturityRating;

public class Event {
	private String name;
	private MaturityRating maturityRating;
	private double reviewAvg;
	
	public Event() {}

	public String getName() {
		return name;
	}
	
	public MaturityRating getMaturityRating() {
		return maturityRating;
	}
	
	public double getReviewAvg() {
		return reviewAvg;
	}

	public void setName(String name) {
		this.name = name;
	};
	
	
}
