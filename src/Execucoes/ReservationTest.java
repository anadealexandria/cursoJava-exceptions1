package Execucoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.Reservation;

public class ReservationTest {

	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		Reservation primeiro;
		SimpleDateFormat data1 = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number:");
		int roomNumber = input.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy):");
		Date checkin = data1.parse(input.next());
		System.out.println("Check-out date (dd/MM/yyyy):");
		Date checkout = data1.parse(input.next());
		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			primeiro = new Reservation(roomNumber, checkin, checkout);
			System.out.println(primeiro.toString());
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/MM/yyyy):");
			checkin = data1.parse(input.next());
			System.out.println("Check-out date (dd/MM/yyyy):");
			checkout = data1.parse(input.next());
			
			String error =	primeiro.updateDates(checkin, checkout);
			if(error != null) {
				System.out.println(error);
			}else {
			System.out.println(primeiro.toString());
			}

		}

		input.close();
	}

}
