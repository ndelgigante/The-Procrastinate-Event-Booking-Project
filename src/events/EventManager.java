package events;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * 
 * @author Nicholas Del Gigante
 * contains the collection of events and can manipulate it
 */
public class EventManager {
	private ArrayList<Event> events;
	
	public EventManager(String jsonPath) {
		events = new ArrayList<Event>();
		// import Events from json file
	}
	
	public void addEvent(Event event) {
		events.add(event);
	}
	
	public void removeEvent(Event event) {
		events.remove(event);
	}
	
	public ArrayList<Event> getEvents() {
		return events;
	}
	
	/**
	 * return the event that has the same name as the one in the parameter 
	 * @param name name of the event being searched for
	 * @return the event that has the same name that is searched for
	 */
	public Event getEvent(String name) {
		Iterator<Event> iterator = events.iterator();
		while(iterator.hasNext()) {
			Event event = iterator.next();
			if (event.getName().equals(name)) {
				return event;
			}
		}
		return null;
	}

}
