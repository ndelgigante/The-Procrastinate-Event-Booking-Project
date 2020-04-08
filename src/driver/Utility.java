package driver;
import java.util.Scanner;


public class Utility {
	public static MaturityRating promptGetMaturityRating() {
		Scanner scanner = new Scanner(System.in);
		
		String string = scanner.nextLine().toLowerCase();
		switch(string) {
			case "g":
				return MaturityRating.G;
			case "pg":
				return MaturityRating.PG;
			case "pg13":
				return MaturityRating.PG13;
			case "r":
				return MaturityRating.R;
			case "nc17":
				return MaturityRating.NC17;
			default:
				return null;
		}
	}
}
