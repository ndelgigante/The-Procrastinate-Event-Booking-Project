package venue;

/**
 * 
 * @author samkellogg
 *
 */
public class Room {
	private RoomTemplate roomTemplate;
	
	public Room(RoomTemplate roomTemplate) {
		this.roomTemplate = roomTemplate;
	}
	
	public SeatAvailability[][] getSeating() {
		return roomTemplate.getSeatingArrangement();
	}
	
	public void setSeatAvailability(SeatAvailability seatAvailability, int x, int y) {
		SeatAvailability[][] temp =	roomTemplate.getSeatingArrangement();
		temp[x][y] = seatAvailability;
		roomTemplate = new RoomTemplate(temp, 0);
	}
}
