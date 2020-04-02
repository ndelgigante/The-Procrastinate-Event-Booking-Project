package events;

public class Review {
	private int starRating;
	private String elaboration;
	
	public Review(int starRating, String elaboration) {
		setStarRating(starRating);
		setElaboration(elaboration);
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	public String getElaboration() {
		return elaboration;
	}

	public void setElaboration(String elaboration) {
		this.elaboration = elaboration;
	}
}
