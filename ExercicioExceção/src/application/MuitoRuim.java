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
			
			
			
			System.out.println("Enter Check-In Date Update");
			checkin = sdf.parse(sc.next());
			System.out.println("Enter Check-out Date Update");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkin.before(now)  || checkout.before(now)) {
			System.out.println("Error em reservation: Reservation dates for update must be future");
		}
			else if (!checkout.after(checkin) ){
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reservation.updateDates(checkin, checkout);
				System.out.println("Reservation: "+ reservation);
			}
	
		sc.close();

	}

}
}
