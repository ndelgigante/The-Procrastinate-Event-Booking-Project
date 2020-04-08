/**
 * quick and easy storage container for ticket info
 */
package users;
import showing.*;
import java.io.File; import java.io.IOException; import java.io.FileWriter;

public class Ticket {
	public Showing showing;
	public int seatX;
	public int seatY;
	
	public Ticket(Showing showing, int x, int y) {
		this.showing = showing;
		this.seatX = x +1; //convert from 0-index to 1-indexed
		this.seatY = y +1; 
	}
	
	private String convertToTicketFormat(String string) {
		String baseString = "-                               -";
		int numIndices = baseString.length() - 2;
		numIndices = numIndices - string.length();
		numIndices = numIndices/2;
		if(numIndices < 0)
			numIndices = 0;
		
		String newString = "-";
		for (int i=0; i<numIndices; ++i)
			newString = newString + " ";
		
		newString = newString + string;
		
		for (int i=0; i<numIndices; ++i)
			newString = newString + " ";
		
		newString = newString + "-\n";
		return newString;
	}
	
	public void printTicket() throws IOException {
		try {
			int count = 1;
			while(true) {
				File newFile = new File(showing.getEvent().getName() + "(" + count + ")" + ".txt");
				if(newFile.createNewFile()) {
					
					FileWriter fileWriter = new FileWriter(newFile);
					fileWriter.write("      --------------------       \n");
					fileWriter.write("    --                    --     \n");
					fileWriter.write(" ---                        ---- \n");
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write(convertToTicketFormat(showing.getEvent().getName()));
					fileWriter.write("-                               -\n");
					fileWriter.write(convertToTicketFormat(showing.getParentVenue().getName()));
					fileWriter.write(convertToTicketFormat(showing.getTime().toString()));
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write(convertToTicketFormat("SEAT: (" + seatX + "," + seatY + ")"));
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write("-                               -\n");
					fileWriter.write(" ---                        ---- \n");
					fileWriter.write("    --                    --     \n");
					fileWriter.write("      --------------------       \n");
					fileWriter.close();
					System.out.println("Ticket has been printed to your default directory!!!");
					return;
				} else {
					count++;
				}
			}
			
		} catch (IOException e) {
			
		}
	}
}
