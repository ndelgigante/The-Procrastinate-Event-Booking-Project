/**
 * 
 * @author samkellogg
 *
 */
public class RoomTemplate {
	private SeatAvailability[][] seatingArrangement;
	private int identifier;
	
	RoomTemplate(SeatAvailability[][] seatingArrangement, int identifier){
		this.seatingArrangement = seatingArrangement;
		this.identifier = identifier;	
	}
}
