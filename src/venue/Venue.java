package venue;
import java.util.ArrayList;
/**
 * 
 * @author samkellogg
 *
 */
public class Venue {
	private String name;
	private ArrayList<RoomTemplate> rooms;
	
	public Venue(String name){
		this.name = name;
		rooms = new ArrayList<RoomTemplate>();
	}
	
	public void addRoom(RoomTemplate roomTemplate){
		rooms.add(roomTemplate);
	}
	
	public void removeRoom(RoomTemplate roomTemplate) {
		rooms.remove(roomTemplate);
	}
	
	public ArrayList<RoomTemplate> getRooms(){
		return rooms;
	}
	
	public RoomTemplate getRoom(int identifier) {
		return rooms.get(identifier);
	}
	
	public String getName() {
		return name;
	}
	
	public void print() {
		System.out.println("Name: " + name + " NumRooms: " + rooms.size());
	}
}
