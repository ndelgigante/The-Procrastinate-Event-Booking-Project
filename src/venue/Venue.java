import java.util.ArrayList;
/**
 * 
 * @author samkellogg
 *
 */
public class Venue {
	private String name;
	private ArrayList<RoomTemplate> rooms;
	
	Venue(String name){
		this.name = name;
		rooms = new ArrayList<RoomTemplate>();
	}
	void addRoom(RoomTemplate roomTemplate){
		rooms.add(roomTemplate);
	}
	void removeRoom(RoomTemplate roomTemplate) {
		rooms.remove(roomTemplate);
	}
	ArrayList<RoomTemplate> getRooms(){
		return rooms;
	}
	RoomTemplate getRoom(int identifier) {
		return rooms.get(identifier);
	}
}
