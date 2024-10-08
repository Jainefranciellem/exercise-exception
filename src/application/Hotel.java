package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Hotel {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy)");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy)");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in Reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println(reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy)");
			Date checkinUpdate = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy)");
			Date checkoutUpdate = sdf.parse(sc.next());

			String error = reservation.updateReservation(checkinUpdate, checkoutUpdate);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println(reservation);
			}
		}

		sc.close();
	}

}
