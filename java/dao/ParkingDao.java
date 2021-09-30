/*
 * (C) Copyright 2020 Fresher Academy
 * @author Admin
 * @date Mar 11, 2020
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
import model.Parkinglot;
import utils.SQLQuery;

public class ParkingDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public boolean addParking(Parkinglot parkinglot) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.ADD_PARKING);
			preparedStatement.setInt(1, parkinglot.getParkArea());
			preparedStatement.setString(2, parkinglot.getParkName());
			preparedStatement.setString(3, parkinglot.getParkPlace());
			preparedStatement.setInt(4, parkinglot.getParkPrice());
			preparedStatement.setString(5, parkinglot.getParkStatus());

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

	public List<Parkinglot> ListAllParking() {
		List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
		Parkinglot parkinglot = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.LIST_ALL_PARKINGLOT);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int parkingId = resultSet.getInt(1);
				int parkArea = resultSet.getInt(2);
				String parkName = resultSet.getString(3);
				String parkPlace = resultSet.getString(4);
				int parkPrice = resultSet.getInt(5);
				String parkStatus = resultSet.getString(6);
				parkinglot = new Parkinglot(parkingId, parkArea, parkName, parkPlace, parkPrice, parkStatus);
				parkinglots.add(parkinglot);
			}
			return parkinglots;
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

	public boolean update(Parkinglot parkinglot) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.UPDATE_PARKING);
			preparedStatement.setString(1, parkinglot.getParkName());
			preparedStatement.setString(2, parkinglot.getParkPlace());
			preparedStatement.setInt(3, parkinglot.getParkArea());
			preparedStatement.setInt(4, parkinglot.getParkPrice());
			preparedStatement.setString(5, parkinglot.getParkStatus());
			preparedStatement.setInt(6, parkinglot.getParkId());

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

	public boolean delete(int id) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareCall(SQLQuery.DELETE_PARKING);
			preparedStatement.setInt(1, id);
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

	public Parkinglot findById(int id) {
		Parkinglot parkinglot = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.FIND_PARKING_BYID);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int parkingId = resultSet.getInt(1);
				int parkArea = resultSet.getInt(2);
				String parkName = resultSet.getString(3);
				String parkPlace = resultSet.getString(4);
				int parkPrice = resultSet.getInt(5);
				String parkStatus = resultSet.getString(6);
				parkinglot = new Parkinglot(parkingId, parkArea, parkName, parkPlace, parkPrice, parkStatus);
				
			}
			return parkinglot;
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
	
	public List<Parkinglot> findByPlace(String place ) {
		Parkinglot parkinglot = null;
		List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.FIND_PARKING_BYPLACE);
			preparedStatement.setString(1, place);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int parkingId = resultSet.getInt(1);
				int parkArea = resultSet.getInt(2);
				String parkName = resultSet.getString(3);
				String parkPlace = resultSet.getString(4);
				int parkPrice = resultSet.getInt(5);
				String parkStatus = resultSet.getString(6);
				parkinglot = new Parkinglot(parkingId, parkArea, parkName, parkPlace, parkPrice, parkStatus);
				parkinglots.add(parkinglot);
			}
			return parkinglots;
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
	
	public List<Parkinglot> findByName(String name) {
		Parkinglot parkinglot = null;
		List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.FIND_PARKING_BYNAME);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int parkingId = resultSet.getInt(1);
				int parkArea = resultSet.getInt(2);
				String parkName = resultSet.getString(3);
				String parkPlace = resultSet.getString(4);
				int parkPrice = resultSet.getInt(5);
				String parkStatus = resultSet.getString(6);
				parkinglot = new Parkinglot(parkingId, parkArea, parkName, parkPlace, parkPrice, parkStatus);
				parkinglots.add(parkinglot);
			}
			return parkinglots;
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
}
