package showing;
import events.Event; import events.Review; import venue.*;
import java.time.LocalDateTime; import java.util.Scanner;

public class Showing {
	private Event event;
	private Room room; 
	private Venue parentVenue;
	private LocalDateTime time;
	
	public Showing(Event event, Venue parentVenue, int roomIdentifier, LocalDateTime time) {
		setEvent(event);
		setParentVenue(parentVenue);
		initRoom(roomIdentifier);
		setTime(time);
	}
	
	public Event getEvent() {
		return event;
	}
	
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Venue getParentVenue() {
		return parentVenue;
	}
	
	public void setParentVenue(Venue parentVenue) {
		this.parentVenue = parentVenue;
	}
	
	public LocalDateTime getTime() {
		return this.time;
	}
	
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	public Room getRoom() {
		return room;
	}
	
	/**
	 * @param integer representing room template's position in parent venue array
	 */
	private void initRoom(int roomIdentifier) {
		RoomTemplate roomTemplate = parentVenue.getRoom(roomIdentifier);
		room = new Room(roomTemplate);
	}
	
	public int[] promptChooseSeat() {
		Scanner scanner = new Scanner(System.in);
		SeatAvailability[][] seating = room.getSeating();
		int yDim = seating[0].length;
		int xDim = seating.length;
		
		System.out.println("Seating chart:");
		printSeats();
		
		System.out.println("Choose your seat");
		
		System.out.println("Enter the x coordinate (1-" + xDim + ")");
		int x = scanner.nextInt() - 1;
		
		System.out.println("Enter the y coordinate (1-" + yDim + ")");
		int y = scanner.nextInt() - 1;
		
		//scanner.close();
		
		SeatAvailability selectedSeat = seating[x][y];
		if(selectedSeat != null && selectedSeat.equals(SeatAvailability.Reserved)) { // null == not taken 
			System.out.println("That seat is already taken!");
			return null;
		}
		
		seating[x][y] = SeatAvailability.Reserved;
		int[] arr = {x,y};
		return arr;
	}
	
	public String toString() {
		return "Event: " + event.getName() + " Venue: "+parentVenue.getName() + " Time: "+time.toString();
	}
	
	public void printSeats() {
		SeatAvailability[][] seating = room.getSeating();
		int yDim = seating[0].length;
		int xDim = seating.length;
		
		for (int y=0; y<yDim; ++y) {
			for(int x=0; x<xDim; ++x) {
				SeatAvailability availability = seating[x][y];
				if(availability == null || availability.equals(SeatAvailability.Available))
					System.out.print("-");
				else
					System.out.print("*");
			}
			System.out.print("\n");
		}
	}
	
	public void print() {
		System.out.println(toString());
	}
}

