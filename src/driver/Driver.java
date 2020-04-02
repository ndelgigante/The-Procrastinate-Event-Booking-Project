package driver;
import events.*; import showing.*; import users.*; import venue.*;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		// init managers
		ShowingManager showingManager = new ShowingManager("TODO: json file stuff");
	
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String input = scanner.nextLine();
			System.out.println("type 0 to exit");
			switch(input) {
				case "0": 
					System.exit(0);			
			}
		}
	}
}
