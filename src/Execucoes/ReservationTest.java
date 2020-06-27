package Execucoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.Reservation;
import Excecoes.DomainException;

public class ReservationTest {

	public static void main(String[] args)  {
		Scanner input = new Scanner(System.in);
		Reservation primeiro;
		SimpleDateFormat data1 = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Room number:");
			int roomNumber = input.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy):");
			Date checkin = data1.parse(input.next());
			System.out.println("Check-out date (dd/MM/yyyy):");
			Date checkout = data1.parse(input.next());		
			primeiro = new Reservation(roomNumber, checkin, checkout);
			System.out.println(primeiro.toString());
			
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/MM/yyyy):");
			checkin = data1.parse(input.next());
			System.out.println("Check-out date (dd/MM/yyyy):");
			checkout = data1.parse(input.next());
			
			primeiro.updateDates(checkin, checkout);		
			System.out.println(primeiro.toString());
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
			
		}
		catch(DomainException e){
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		

		input.close();
	}

}
