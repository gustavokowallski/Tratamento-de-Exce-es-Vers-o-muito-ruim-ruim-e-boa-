package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;
import models.exceptions.DomainExceptions;

public class Exercicio {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
				System.out.print("RoomNumber");
			int roomNumber = sc.nextInt();
			System.out.println("Enter Check-In Date");
			Date checkin = sdf.parse(sc.next());
			System.out.println("Enter Check-out Date");
			Date checkout = sdf.parse(sc.next());
			
				Reservation reservation = new Reservation(roomNumber, checkin, checkout);
				System.out.println("Reservation" + reservation);
				
				System.out.println("Enter data tp update the reservation");
				System.out.println("Checkin Date: ");
				checkin = sdf.parse(sc.next());
				System.out.println("CheckOut Date: ");
				checkout = sdf.parse(sc.next());
				
				reservation.updateDates(checkin, checkout);
				System.out.println("Datas: " + reservation);
	}
		
		catch (ParseException e) {
			System.out.println("Invalid Date format");
		}
		catch (DomainExceptions e) {
			System.out.println("Error" + e.getMessage());
		}
		sc.close();
}
}
