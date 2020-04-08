package showing;
import events.Event; import events.Review; import venue.*;
import java.time.LocalDateTime;

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
	
	public void print() {
		System.out.println("Event: " + event.getName() + "Venue: "+parentVenue.getName() + "Time: "+time.toString());
	}
}

