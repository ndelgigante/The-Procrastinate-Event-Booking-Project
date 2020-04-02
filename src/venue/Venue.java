package venue;
import java.util.ArrayList;

public class Venue {
	private String name;
		
	public Venue() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<RoomTemplate> getRooms() { return null; }
	
	// think of identifier as a "room number": eg, Swearingen 2A14
	// this number is a tool to communicate to other parts of the code which roomtemplate to clone

	public RoomTemplate getRoom(int identifier) {
		return null;
	}
	
}
