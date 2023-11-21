package org.lesson.gestore.event.pojo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.lesson.gestore.event.Event;

public class Concert extends Event{

	//Declaring variables
	LocalTime hour;
	LocalDate date = super.getFormattedDate();
	BigDecimal price;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	DecimalFormat euroFormatter = new DecimalFormat("##,##0.00€");
	
	
	
	//Contructor
	public Concert(String title, String date, int seats, int prenotation, LocalTime hour, BigDecimal price) {
		super(title, date, seats, prenotation);
		
		setHour(hour);
		setPrice(price);
		
	}


	
	//Hour functions
	public LocalTime getHour() {
		return hour;
	}
	public void setHour(LocalTime hour) {
		this.hour = hour;
	}


	
	//get formatted date - hour
	public LocalDateTime getDateHour() {
		
		LocalDateTime combinedDateTime = super.getFormattedDate().atTime(getHour());
		
		return combinedDateTime;
	}
	
	
	
	//Price functions
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	
	//Get formatted price
	public String getFormattedPrice() {
		return euroFormatter.format(getPrice());
	}
	
	
	
	//TO String
	@Override
	public String toString() {
		
		return "Data: " + getDateHour() + " - " + super.getTitle() + " - " + "Prezzo: " + getFormattedPrice();
	}

}
