/*
 * (C) Copyright 2020 Fresher Academy
 * @author Admin
 * @date Mar 10, 2020
 * @version 1.0
 */
package utils;

public interface SQLQuery {

	String ADD_EMPLOYEE = "INSERT INTO Employee VALUES(?,?,?,?,?,?,?,?,?,?)";
	String LIST_ALL_EMPLOYEE = "SELECT * FROM Employee";
	String SEARCH_EMPLOYEE_BY_NAME = "SELECT * FROM Employee WHERE employeeName LIKE ?";
	String SEARCH_EMPLOYEE_BY_ID = "SELECT * FROM Employee WHERE employeeId = ?";
	String SEARCH_ADMIN = "SELECT * FROM  Employee where account = ? AND password= ? ";
	String SELECT_TOP = "SELECT TOP 2 *FROM Employee";
	String COUNT = "SELECT COUNT(employeeId) FROM Employee";
	String SEARCH_EMPLOYEE_BY_DEPART = "SELECT * FROM Employee WHERE department LIKE ?";
	String ListEmployee = "SELECT * FROM Employee WHERE employeeId BETWEEN ? AND ?";

	String ADD_PARKING = "INSERT INTO Parkinglot VALUES(?,?,?,?,?)";
	String LIST_ALL_PARKINGLOT = "SELECT * FROM Parkinglot";
	String UPDATE_PARKING = "UPDATE Parkinglot SET [parkName]=?, [parkPlace]=?, [parkArea]=?, [parkPrice]=?, [parkStatus]=? WHERE parkId=?";
	String DELETE_PARKING = "DELETE Parkinglot WHERE parkId=?";
	String FIND_PARKING_BYID = "SELECT * FROM Parkinglot WHERE parkId=?";
	String FIND_PARKING_BYPLACE = "SELECT * FROM Parkinglot WHERE parkPlace = ?";
	String FIND_PARKING_BYNAME = "SELECT * FROM Parkinglot WHERE parkName = ?";

	String ADD_CAR = "INSERT INTO Car VALUES(?,?,?,?,?)";
	String LIST_ALL_CAR = "SELECT c.licensePlate,c.carColor,c.carType,c.company,c.parkId, p.parkName FROM Car c JOIN Parkinglot p ON c.parkId=p.parkId";
	String SEARCH_EMPLOYEE_BY_LIENCEPLACE = "SELECT c.licensePlate,c.carColor,c.carType,c.company,c.parkId, p.parkName FROM Car c JOIN Parkinglot p ON c.parkId=p.parkId WHERE licensePlate=?";
	String SEARCH_EMPLOYEE_BY_COMPANY = "SELECT c.licensePlate,c.carColor,c.carType,c.company,c.parkId, p.parkName FROM Car c JOIN Parkinglot p ON c.parkId=p.parkId WHERE company=?";
	String SEARCH_EMPLOYEE_BY_CARTYPE = "SELECT c.licensePlate,c.carColor,c.carType,c.company,c.parkId, p.parkName FROM Car c JOIN Parkinglot p ON c.parkId=p.parkId WHERE carType=?";
	String UPDATE_CAR = "UPDATE Car SET licensePlate=?, carColor=?, carType=?, company=?,parkId=? WHERE licensePlate=? ";
	String DELETE_CAR = "DELETE Car WHERE licensePlate=?";
	String DELETE_CAR_BYPARKID = "DELETE Car WHERE parkId=?";
	String COUNT_OFCAR = "SELECT COUNT(Car.licensePlate) FROM Car JOIN Parkinglot ON Car.parkId = Parkinglot.parkId WHERE Car.parkId=? ";

	String ADD_BOOKING = "INSERT INTO Bookingoffice VALUES(?,?,?,?,?,?,?)";
	String LIST_ALL_BOOKINGOFFICE = "SELECT b.officeId, b.officeName, t.destination FROM Bookingoffice b JOIN Trip t ON b.tripId = t.tripId";
	String FIND_BOOKING_BYID = "SELECT b.officeId, b.officeName, t.destination, b.officePhone, b.officePlace, b.officePrice, b.startContractDeadline, b.endContractDeadline, b.tripId FROM Bookingoffice b JOIN Trip t ON b.tripId = t.tripId WHERE b.officeId=?";
	String FIND_BYTRIP = "SELECT b.officeId, b.officeName, t.destination FROM Bookingoffice b JOIN Trip t ON b.tripId = t.tripId WHERE t.destination LIKE ? ";
	String FIND_BYBOOKING = "SELECT b.officeId, b.officeName, t.destination FROM Bookingoffice b JOIN Trip t ON b.tripId = t.tripId WHERE b.officeName LIKE ? ";
	String COUNT_BOOKING = "SELECT COUNT(Bookingoffice.officeId) FROM Bookingoffice JOIN Trip ON Bookingoffice.tripId= Trip.tripId WHERE Trip.tripId= ?";

	String LIST_ALL_TRIP = "SELECT * FROM Trip";
	String ADD_TRIP = "INSERT INTO Trip VALUES(?,?,?,?,?,?,?)";
	String FIND_TRIP_BYID = "SELECT * FROM Trip WHERE tripId =?";
	String UPDATE_TRIP = "UPDATE Trip SET carType=?, departureDate=?, departureTime=?, destination=?, driver=?, maximumOnlineTicketNumber=? WHERE tripId=?";
	String DELETE_TRIP = "DELETE Trip WHERE tripId=?";
	String FIND_BY_DES = "SELECT * FROM Trip WHERE destination LIKE ?";
	String FIND_BY_DRIVER = "SELECT * FROM Trip WHERE driver LIKE ?";

	String COUNT_TICKET = "SELECT COUNT(ticketId) FROM Ticket WHERE tripId = ?";
	String LIST_ALL_TICKET = "SELECT t.ticketId, tr.destination, t.customerName, t.licensePlate, t.bookingTime FROM Ticket t JOIN Trip tr ON t.tripId = tr.tripId";
	String DELETE_TICKET = "DELETE Ticket WHERE ticketId =?";
	String DELETE_TICKET_BYTRIP = "DELETE Ticket WHERE tripId =?";
	String SEARCH_BY_TRIP = "SELECT t.ticketId, tr.destination, t.customerName, t.licensePlate, t.bookingTime FROM Ticket t JOIN Trip tr ON t.tripId = tr.tripId WHERE tr.destination LIKE ?";
	String SEARCH_BY_CUSTOMER = "SELECT t.ticketId, tr.destination, t.customerName, t.licensePlate, t.bookingTime FROM Ticket t JOIN Trip tr ON t.tripId = tr.tripId WHERE t.customerName LIKE ?";
	String DELETE_TICKET_BY_PLATE = "DELETE Ticket WHERE liecensePlate =?";
	String COUNT_TICKETOFCAR = "select count(Ticket.licensePlate) from Ticket join Car on Ticket.licensePlate=Car.licensePlate where  Car.licensePlate LIKE ? ";
	String UPDATE_TICKET = "UPDATE Trip SET bookedTicketNumber = ? WHERE tripId=?";

	String ADD_TICKET = "INSERT INTO [dbo].[Ticket] VALUES (?,?,?,?)";
	String SEARCH_BY_LICENSE = "SELECT t.ticketId, tr.destination, t.customerName, t.licensePlate, t.bookingTime FROM Ticket t JOIN Trip tr ON t.tripId = tr.tripId WHERE t.licensePlate LIKE ?";
}
