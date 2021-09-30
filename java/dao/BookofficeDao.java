/*
 * (C) Copyright 2020 Fresher Academy
 * @author Admin
 * @date Mar 10, 2020
 * @version 1.0
 */ 
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Bookingoffice;
import model.Parkinglot;
import model.Trip;
import utils.SQLQuery;

public class BookofficeDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public boolean addBooking(Bookingoffice bookingoffice) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.ADD_BOOKING);
			preparedStatement.setString(1, bookingoffice.getEndContractDeadline());
			preparedStatement.setString(2, bookingoffice.getOfficeName());
			preparedStatement.setString(3, bookingoffice.getOfficePhone());
			preparedStatement.setString(4, bookingoffice.getOfficePlace());
			preparedStatement.setInt(5, bookingoffice.getOfficePrice());
			preparedStatement.setString(6, bookingoffice.getStartContractDeadline());
			preparedStatement.setInt(7, bookingoffice.getTripId());

			int rs = preparedStatement.executeUpdate();
			return rs > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}
	
	public List<Trip> ListAllBooking(){
		List<Trip> trips = new ArrayList<Trip>();
		Trip trip = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.LIST_ALL_BOOKINGOFFICE);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int officeId = resultSet.getInt(1);
				String officeName = resultSet.getString(2);
				String place = resultSet.getString(3);
				trip = new Trip(officeId, officeName, place);
				trips.add(trip);
			}
			return trips;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
	
	public Trip findById(int id) {
		Trip trip = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.FIND_BOOKING_BYID);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int officeId = resultSet.getInt(1);
				String officeName = resultSet.getString(2);
				String tripName = resultSet.getString(3);
				String officePhone = resultSet.getString(4);
				String officePlace = resultSet.getString(5);
				int officePrice = resultSet.getInt(6);
				String fromDate = resultSet.getString(7);
				String toDate = resultSet.getString(8);
				int tripId = resultSet.getInt(9);
				
				trip = new Trip(toDate, officeName, officePhone, officePlace, officePrice, fromDate, tripId, tripName);
				
			}
			return trip;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Trip> findByTrip(String tripName){
		List<Trip> trips = new ArrayList<Trip>();
		Trip trip = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.FIND_BYTRIP);
			preparedStatement.setString(1, tripName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int officeId = resultSet.getInt(1);
				String officeName = resultSet.getString(2);
				String place = resultSet.getString(3);
				trip = new Trip(officeId, officeName, place);
				trips.add(trip);
			}
			return trips;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public List<Trip> findByBooking(String booking) {
		List<Trip> trips = new ArrayList<Trip>();
		Trip trip = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.FIND_BYBOOKING);
			preparedStatement.setString(1, booking);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int officeId = resultSet.getInt(1);
				String officeName = resultSet.getString(2);
				String place = resultSet.getString(3);
				trip = new Trip(officeId, officeName, place);
				trips.add(trip);
			}
			return trips;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
	
	public int getCountBooking (int tripId) {
		int count = 0;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.COUNT_BOOKING);
			preparedStatement.setInt(1, tripId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
}
