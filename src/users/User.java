package users;
import java.io.IOException;
import java.util.*;
import events.*;

import showing.Showing;

/*
 * Author Jazzmin Graham
 */
public class User {
	private String password;
	private ArrayList<Ticket> tickets;
	
	public User(String password) {
		this.password = password;
		this.tickets = new ArrayList<Ticket>();
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUserType() {
		return "Guest";
	}
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	public void promptShowShowings() throws IOException {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("\nSelect a showing to inspect:");
			System.out.println("0. Exit");
			
			for(int i=0; i<tickets.size(); ++i) {
				Ticket ticket = tickets.get(i);
				System.out.println(i+1+". " + ticket.showing.toString() + " SEAT (" + ticket.seatX + "," + ticket.seatY +")");
			}
			
			Integer selectedTicket = Integer.parseInt(scanner.nextLine()); //fixing bug with scanner
			selectedTicket = selectedTicket - 1;
			Ticket ticket = tickets.get(selectedTicket);
			
			while(true) {
				System.out.println("\nSelect an option:");
				System.out.println("0: Exit");
				System.out.println("1: Print Ticket");
				System.out.println("2: Write Review");
				
				switch(scanner.nextLine()) {
					case "1":
						ticket.printTicket();
						break;
					case "2":
						Event event = ticket.showing.getEvent();
						event.addReview(Review.promptCreateReview());
						break;
					default:
						return;
					
				}
			}
		}
	}

		
	

}
