package org.lesson.gestore.event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {

	
	//Declaring variables
	private String title;
	private String date;
	private int seats;
	private int prenotation = 0;
	LocalDate currentDate = LocalDate.now();
	LocalDate formattedDate = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	
	//Constructor
	public Event (String title, String date, int seats, int prenotation) {
		
		
		setTitle(title);
		setDate(date);
		setSeats(seats);
		setPrenotation(prenotation);
		
		getFormattedDate();
		
	}
	

	
	//Title functions
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}



	
	//Date functions
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}



	
	//Seats functions
	public int getSeats() {
		return seats;
	}
	private void setSeats(int seats) {
		this.seats = seats;
	}


	
	
	//Prenotation functions
	public int getPrenotation() {
		return prenotation;
	}
	private void setPrenotation(int prenotation) {
		this.prenotation = prenotation;
	}
	
	
	
	
	
	
	//Other functions
	
	//Prenotate function
	public void prenotate() throws Exception {
		
		
		if(getFormattedDate().isBefore(currentDate)) {
			throw new Exception("L'evento è terminato");
			
		} else if (getPrenotation() >= getSeats()){
			throw new Exception("Non ci sono più posti disponibili per l'evento");
			
		} else {
			setPrenotation(prenotation + 1);
			
		}
		 
		
	}
	
	
	//Cancel prenotation
	
	public void cancelPrenotation() throws Exception {
		
		if(getFormattedDate().isBefore(currentDate)) {
			throw new Exception("L'evento è terminato");
			
		} else if(getPrenotation() <= 0) {
			throw new Exception("Non ci sono posti prenotati");
			
		} else {
			setPrenotation(prenotation - 1);
			
		}
		
		
	}
	
	
	
	//Formatting function
	public LocalDate getFormattedDate() {
		
		return this.formattedDate = LocalDate.parse(getDate(), formatter);
		
	}
	
	
	
	//TO String
	@Override
	public String toString() {
		
		
		return getTitle() + " - " + getFormattedDate();
	}
	
	
}
