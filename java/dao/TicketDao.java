/*
 * (C) Copyright 2020 Fresher Academy
 * @author Admin
 * @date Mar 15, 2020
 * @version 1.0
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.DBConnection;
import dal.DBContext;
import model.Ticket;
import model.Trip;
import utils.SQLQuery;

public class TicketDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public int getCount(int tripId) {
		int count = 0;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.COUNT_TICKET);
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

	public List<Ticket> ListAllTicket() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Ticket ticket = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.LIST_ALL_TICKET);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int ticketId = resultSet.getInt(1);
				String tripDes = resultSet.getString(2);
				String name = resultSet.getString(3);
				String licensePlate = resultSet.getString(4);
				String bookingTime = resultSet.getString(5);
				bookingTime = bookingTime.substring(0, 8);
				ticket = new Ticket(tripDes, ticketId, bookingTime, name, licensePlate);
				tickets.add(ticket);
			}
			return tickets;
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
		return null;

	}

	public List<Ticket> searchByTrip(String tri) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Ticket ticket = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.SEARCH_BY_TRIP);
			preparedStatement.setString(1, tri);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int ticketId = resultSet.getInt(1);
				String trip = resultSet.getString(2);
				String name = resultSet.getString(3);
				String licensePlate = resultSet.getString(4);
				String bookingTime = resultSet.getString(5);
				bookingTime = bookingTime.substring(0, 8);
//				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5));				
				ticket = new Ticket(trip, ticketId, bookingTime, name, licensePlate);
				
				tickets.add(ticket);
			}
			return tickets;
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
		return null;

	}

	public List<Ticket> searchByLicense(String license) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Ticket ticket = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.SEARCH_BY_LICENSE);
			preparedStatement.setString(1, license);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int ticketId = resultSet.getInt(1);
				String trip = resultSet.getString(2);
				String name = resultSet.getString(3);
				String licensePlate = resultSet.getString(4);
				String bookingTime = resultSet.getString(5);
				bookingTime = bookingTime.substring(0, 8);

				System.out.println(ticketId + " " + trip + " " + name + " " + licensePlate + " " + bookingTime);
				
				ticket = new Ticket(trip, ticketId, bookingTime, name, licensePlate);
				
				tickets.add(ticket);
			}
			return tickets;
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
		return null;

	}

	public boolean deleteTicket(int ticketId) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareCall(SQLQuery.DELETE_TICKET);
			preparedStatement.setInt(1, ticketId);
			int result = preparedStatement.executeUpdate();
			return result > 0;
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

	public boolean deleteTicketByTrip(int tripId) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareCall(SQLQuery.DELETE_TICKET_BYTRIP);
			preparedStatement.setInt(1, tripId);
			int result = preparedStatement.executeUpdate();
			return result > 0;
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

	public boolean deleteTicketByPlate(String plate) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareCall(SQLQuery.DELETE_TICKET_BY_PLATE);
			preparedStatement.setString(1, plate);
			int result = preparedStatement.executeUpdate();
			return result > 0;
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

	public int getCountCar(String plate) {
		ArrayList<Ticket> list = new ArrayList();
		int count = 0;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.COUNT_TICKETOFCAR);
			preparedStatement.setString(1, plate);
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

	public boolean updateTrip(Trip trip) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.UPDATE_TICKET);
			preparedStatement.setInt(1, trip.getBookedTicketNumber());
			preparedStatement.setInt(2, trip.getTripId());

			int rs = preparedStatement.executeUpdate();
			return rs > 0;
		}

		catch (SQLException e) {
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
		return false;
	}

	public void addTicket(Ticket tk) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.ADD_TICKET);

			preparedStatement.setString(1, tk.getBookingTime());
			preparedStatement.setString(2, tk.getCustomerName());
			preparedStatement.setString(3, tk.getLicensePlate());
			preparedStatement.setInt(4, tk.getTripId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
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
	}
}
