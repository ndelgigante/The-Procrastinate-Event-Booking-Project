package venue;
/**
 * 
 * @author samkellogg
 *
 */
public class RoomTemplate {
	private SeatAvailability[][] seatingArrangement;
	private int identifier;
	
	public RoomTemplate(SeatAvailability[][] seatingArrangement, int identifier){
		this.seatingArrangement = seatingArrangement;
		this.identifier = identifier;	
	}
	
	public SeatAvailability[][] getSeatingArrangement(){
		return seatingArrangement;
	}
	
	public SeatAvailability[][] getSeatingArangement() {
		return this.seatingArrangement;
	}
}
