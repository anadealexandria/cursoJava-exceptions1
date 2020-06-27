package Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Excecoes.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		if (!checkout.after(checkin)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in dates");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}

	public void updateDates(Date checkin, Date checkout) throws DomainException {
		Date agora = new Date();
		if(checkin.before(agora) || checkout.before(agora)) {
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
		}
		if (!checkout.after(checkin)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in dates");
		}
		this.checkin = checkin;
		this.checkout = checkout;
		
	}

	@Override
	public String toString() {
		return "Reservation: Room " + getRoomNumber() + ", " + " check-in: " + data.format(getCheckin()) + ", check-out: "
				+ data.format(getCheckout()) + ", " + duration() + " nights";
	}
}
