package model;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;

public class Trip extends Bookingoffice{
	private int tripId;
	private int bookedTicketNumber;
	private String carType;
	private Date departureDate;
	private Time departureTime;
	protected String destination;
	private String driver;
	private int maximumOnlineTicketNumber;
	public Trip() {
		super();
	}
	
	public Trip(String destination) {
		this.destination = destination;
	}
	
	public Trip(int bookedTicketNumber, int tripId) {
		super();
		this.tripId = tripId;
		this.bookedTicketNumber = bookedTicketNumber;
	}
	
	public Trip(String endContractDeadline, String officeName, String officePhone, String officePlace, int officePrice,
			String startContractDeadline, int tripId, String destination) {
		super(endContractDeadline, officeName, officePhone, officePlace, officePrice, startContractDeadline, tripId);
		this.destination = destination;
	}
	
	public Trip(int tripId, int bookedTicketNumber, String carType, Date departureDate, Time departureTime,
			String destination, String driver, int maximumOnlineTicketNumber) {
		super();
		this.tripId = tripId;
		this.bookedTicketNumber = bookedTicketNumber;
		this.carType = carType;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.destination = destination;
		this.driver = driver;
		this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
	}
	
	public Trip(int officeId, String officeName, String destination) {
		super(officeId, officeName);
		this.destination = destination;
	}


	public int getTripId() {
		return tripId;
	}


	public void setTripId(int tripId) {
		this.tripId = tripId;
	}


	public int getBookedTicketNumber() {
		return bookedTicketNumber;
	}
	public void setBookedTicketNumber(int bookedTicketNumber) {
		this.bookedTicketNumber = bookedTicketNumber;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public int getMaximumOnlineTicketNumber() {
		return maximumOnlineTicketNumber;
	}
	public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
		this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
	}
	
}
