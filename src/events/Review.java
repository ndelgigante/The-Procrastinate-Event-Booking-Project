package events;
import java.util.Scanner;

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
	
	public static Review promptCreateReview() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nHow many stars would you give this event? (0-5)");
		Integer stars = Integer.parseInt(scanner.nextLine());
		
		System.out.println("\nGive an elaboration:");
		String elaboration = scanner.nextLine();
		
		System.out.println("Thank you!");
		
		return new Review(stars, elaboration);
		
	}
}
