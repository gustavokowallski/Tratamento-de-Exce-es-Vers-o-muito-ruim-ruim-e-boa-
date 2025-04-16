package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class MuitoRuim {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("RoomNumber");
		int roomNumber = sc.nextInt();
		System.out.println("Enter Check-In Date");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Enter Check-out Date");
		Date checkout = sdf.parse(sc.next());
		if (!checkout.after(checkin)){
			System.out.println("Erroer in reservation: Check-out date must be after check-in date");
			
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation" + reservation);
			
			String error = reservation.updateDates(checkin, checkout); // cria uma variavel error, que vai recber o metódo updateDates.
			if (error != null) {	// se o erro for diferente de nullo, ele vai mostrar a mensagem do erro em string que nos configuramos no Reservation
				System.out.println("Error in reservation: " + error); 
			}
			else {
				System.out.println("Reservation" + reservation); // se a condição for falsa, ele retorna realizando o metódo de dar update nas classe.
			}
			
			}
	
		sc.close();

	}

}

