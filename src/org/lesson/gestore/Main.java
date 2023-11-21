package org.lesson.gestore;


import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.lesson.gestore.event.Event;
import org.lesson.gestore.event.pojo.Concert;
import org.lesson.gestore.event.pojo.EventsProgramm;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//Declaring variables
		String title;
		String date;
		int seats;
		int prenotations = 0;
		int desiredPrenotations = 0;
		int desiredCancellations = 0;
		Scanner in = new Scanner(System.in);
		
		
		/*
		 *** Ho spostato e commentato le ultime due milestone in modo da poterle testare facilmente.
		 *  
		//Getting concert
		double insertedPrice = 35.50;
		String startingHour = "21:15:00";
		  
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime hour = LocalTime.parse(startingHour, formatter);
		BigDecimal price = BigDecimal.valueOf(insertedPrice);
		
		
		Concert concert = new Concert("concerto", "01/02/2024", 20, 0, hour, price);
		System.out.println(concert);
		*/
		
		
		/* Programm List BONUS
		//Getting Events Programm
		Event comics = new Event("CosenzaComics", "25/12/2023", 50, 0);
		Event dance = new Event("Danza", "02/12/2024", 50, 0);

		EventsProgramm program = new EventsProgramm("events");
		
		program.addEvent(comics);
		program.addEvent(dance);
		
		System.out.println(program.getEventsWithDate("02/12/2024"));
		System.out.println(program.getEventsSize());
		System.out.println("Lista completa:\n" + program.showEventsForDate());
		
		program.clearEvents();
		System.out.println("Lista aggiornata:\n" + program.showEventsForDate());
		
		*/
		
		
		
		//Main logic
		System.out.println("Inserisci il titolo della tua festa");
		title = in.nextLine();
		
		System.out.println("Inserisci la data (gg/MM/yyyy)");
		date = in.nextLine();
		
		System.out.println("Inserisci il numero di posti limite");
		seats = Integer.parseInt(in.nextLine());
	
		
		Event event = new Event(title, date, seats, prenotations);
		
		
		
		//Get prenotations 
		System.out.println("Quante prenotazioni vuoi effettuare?");
		desiredPrenotations = Integer.parseInt(in.nextLine());
			
		
		//Prenotate 
		for(int i = 0; i < desiredPrenotations; i++) {
			
			try {
	            
				event.prenotate();
	            
	        } catch (Exception e) {
	            System.out.println("Errore durante la prenotazione: " + e.getMessage());
	        }
			
		}
		
		
		
		//Get cancelled prenotations
		System.out.println("Quante prenotazioni vuoi eliminare?");
		desiredCancellations = Integer.parseInt(in.nextLine());
		
		
		//Cancel prenotations
		for(int i = 0; i < desiredCancellations; i++) {
			
			try {
	            
				event.cancelPrenotation();
	            
	        } catch (Exception e) {
	            System.out.println("Errore durante la prenotazione: " + e.getMessage());
	        }
			
		}
		
		
		
		
		System.out.println(event);
		
		System.out.println("Posti prenotati: " + event.getPrenotation() + " - " + "Posti totali: " + event.getSeats());
		in.close();
	}
	
	

}
