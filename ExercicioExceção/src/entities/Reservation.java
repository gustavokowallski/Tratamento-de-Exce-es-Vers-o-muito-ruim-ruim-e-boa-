package entities;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import models.exceptions.DomainExceptions;

import java.text.SimpleDateFormat;
public class Reservation {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer number;
	private Date checkIn;
	private Date checkout;
	
	public Reservation() {
		
	}

	public Reservation(Integer number, Date checkIn, Date checkout) throws DomainExceptions {
		if (!checkout.after(checkIn) ){
			throw new DomainExceptions  ("Error in reservation: Check-out date must be after check-in date"); 
		}

		this.number = number;
		this.checkIn = checkIn;
		this.checkout = checkout;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	

	public Date getCheckout() {
		return checkout;
	}

	
	
	public long duration() {
		long diff = checkout.getTime() - checkIn.getTime(); // isso pega a diferença entre as datas em milissegundos,
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // transforma os valores em dias, os valores que estão em milisegundos
		
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainExceptions { 
		
		Date now = new Date();
		if (checkIn.before(now)  || checkout.before(now)) {
			throw new DomainExceptions ("Error em reservation: Reservation dates for update must be future");
	}
		if (!checkout.after(checkIn) ){
			throw new DomainExceptions  ("Error in reservation: Check-out date must be after check-in date"); 
		}
	
		
		
		this.checkIn = checkIn;
		this.checkout = checkOut;
		
	}
	
	@Override
	public String toString() {
			return " Room "
					+number
					+" Check-In:  "
					+ sdf.format(checkIn)
					+" Check-Out "
					+ sdf.format(checkout)
					+" Nights: "
					+ duration();
					
	}
}
