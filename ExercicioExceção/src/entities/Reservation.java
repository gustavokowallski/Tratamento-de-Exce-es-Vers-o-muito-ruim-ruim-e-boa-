package entities;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
public class Reservation {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer number;
	private Date checkIn;
	private Date checkout;
	
	public Reservation() {
		
	}

	public Reservation(Integer number, Date checkIn, Date checkout) {

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
	
	public String updateDates(Date checkIn, Date checkOut) { // metódo para trocar as datas
		
		Date now = new Date();
		if (checkIn.before(now)  || checkout.before(now)) {
		return "Error em reservation: Reservation dates for update must be future";
	}
		if (!checkout.after(checkIn) ){
			return "Error in reservation: Check-out date must be after check-in date"; 
		}
		//se o programa der erro, vai parar a execução e mostrar uma dessas mensagens, se ele respeitar as condições, vai para a lógica abaixo:
		
		
		this.checkIn = checkIn;
		this.checkout = checkOut;
		return null; // retornar nullo se o metódo der certo
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
