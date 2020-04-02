package showing;
import events.Event; import events.Review; import venue.Room; import venue.*;

public class Showing {
	private Event event;
	private Room room; 
	private Venue parentVenue;
	
	public Showing(Event event, Venue parentVenue, int roomIdentifier) {
		setEvent(event);
		setParentVenue(parentVenue);
		initRoom(roomIdentifier);
	}
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Room getRoom() {
		return room;
	}
	public Venue getParentVenue() {
		return parentVenue;
	}
	public void setParentVenue(Venue parentVenue) {
		this.parentVenue = parentVenue;
	}
	
	private void initRoom(int roomIdentifier) {
		RoomTemplate roomTemplate = parentVenue.getRoom(roomIdentifier);
		room = new Room(roomTemplate);
	}
	
}

