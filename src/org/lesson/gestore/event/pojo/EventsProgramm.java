package org.lesson.gestore.event.pojo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.lesson.gestore.event.Event;

public class EventsProgramm {

	//Declaring variables
	 private String title;
	 private List<Event> events;
	 
	 
	 //Constructor
	 public EventsProgramm(String title) {
		 
		 this.title = title;
	     this.events = new ArrayList<>();
		 
	 }
	 
	 
	 
	 
	 //Functions
	 
	 //Add Event
	 public void addEvent(Event evento) {
	        events.add(evento);
	    }
	 
	 
	 //Get Events with a specific Date
	 public List<Event> getEventsWithDate(String data) {
		 
	        List<Event> eventsWithDate = new ArrayList<>();
	        
	        for (Event event : events) {
	        	
	            if (event.getDate().equals(data)) {
	            	
	                eventsWithDate.add(event);
	            }
	        }
	        return eventsWithDate;
	    }
	 
	
	 //Get Events size
	 public int getEventsSize() {
	        return events.size();
	    }
	 
	 
	 //Clear events List
	 public void clearEvents() {
	        events.clear();
	    }
	 
	 
	 //Show all events
	 public String showEventsForDate() {
		 
	        StringBuilder result = new StringBuilder();
	        events.sort(Comparator.comparingInt(event -> event.getFormattedDate().getYear()));
	        
	        for (Event event : events) {
	            result.append(event.getDate()).append(" - ").append(event.getTitle()).append("\n");
	        }
	        return result.toString();
	    }
	 
	 
	 //ToString
	 
}
