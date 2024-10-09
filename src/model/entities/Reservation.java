package model.entities;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;


    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Error in Reservation: Check-out date must be after check-in date");
        }
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new  DomainException("Error in reservation: Reservation dates for update must be future dates");
        } 
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateReservation(Date checkIn, Date checkOut) throws DomainException {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new  DomainException("Error in reservation: Reservation dates for update must be future dates");
        } 
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Error in Reservation: Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room "
        + roomNumber
        + ", check-in: "
        + checkIn
        + ", "
        + ", check-out: "
        + checkOut
        + ", "
        + duration()
        + " nights";
    }

    public Integer getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return this.checkIn;
    }

    public Date getCheckOut() {
        return this.checkOut;
    }
}
