/**
 * 
 * @author samkellogg
 *
 */
public class Room {
	private RoomTemplate roomTemplate;
	Room(RoomTemplate roomTemplate){
		this.roomTemplate = roomTemplate;
	}
	SeatAvailability[][] getSeating(){
		return roomTemplate.getSeatingArrangement();
	}
	void setSeatAvailability(SeatAvailability seatAvailability, int x, int y){
		
		SeatAvailability[][] temp =	roomTemplate.getSeatingArrangement();
		temp[x][y] = seatAvailability;
		roomTemplate = RoomTemplate(temp, 0);
	}
}
