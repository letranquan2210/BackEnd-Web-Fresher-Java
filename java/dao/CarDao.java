/*
 * (C) Copyright 2020 Fresher Academy
 * @author Admin
 * @date Mar 12, 2020
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
import model.Car;
import model.Parkinglot;
import model.Ticket;
import utils.SQLQuery;

public class CarDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public boolean addCar(Car car) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.ADD_CAR);
			preparedStatement.setString(1, car.getLicensePlate());
			preparedStatement.setString(2, car.getCarColor());
			preparedStatement.setString(3, car.getCarType());
			preparedStatement.setString(4, car.getCompany());
			preparedStatement.setInt(5, car.getParkId());

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

	public List<Parkinglot> ListAllCar() {
		List<Parkinglot> cars = new ArrayList<Parkinglot>();
		Parkinglot parkinglot = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.LIST_ALL_CAR);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String licensePlate = resultSet.getString(1);
				String carColor = resultSet.getString(2);
				String carType = resultSet.getString(3);
				String compamy = resultSet.getString(4);
				int parkId = resultSet.getInt(5);
				String parkName = resultSet.getString(6);
				parkinglot = new Parkinglot(licensePlate, carColor, carType, compamy, parkId, parkName);
				cars.add(parkinglot);
			}
			return cars;
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
	
	public Car searchByLiencePlaces(String licensePlate) {
		Car car = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.SEARCH_EMPLOYEE_BY_LIENCEPLACE);
			preparedStatement.setString(1, licensePlate);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String licensePlates = resultSet.getString(1);
				String carColor = resultSet.getString(2);
				String carType = resultSet.getString(3);
				String compamy = resultSet.getString(4);
				int parkId = resultSet.getInt(5);
				String parkName = resultSet.getString(6);
				car = new Parkinglot(licensePlates, carColor, carType, compamy, parkId, parkName);
				
			}
			return car;
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

	public List<Parkinglot> searchByLiencePlace(String licensePlate) {
		List<Parkinglot> cars = new ArrayList<>();
		Parkinglot car = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.SEARCH_EMPLOYEE_BY_LIENCEPLACE);
			preparedStatement.setString(1, licensePlate);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String licensePlates = resultSet.getString(1);
				String carColor = resultSet.getString(2);
				String carType = resultSet.getString(3);
				String compamy = resultSet.getString(4);
				int parkId = resultSet.getInt(5);
				String parkName = resultSet.getString(6);
				car = new Parkinglot(licensePlates, carColor, carType, compamy, parkId, parkName);
				cars.add(car);
			}
			return cars;
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

	public List<Parkinglot> searchByCompany(String company) {
		List<Parkinglot> cars = new ArrayList<>();
		Parkinglot car = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.SEARCH_EMPLOYEE_BY_COMPANY);
			preparedStatement.setString(1, company);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String licensePlates = resultSet.getString(1);
				String carColor = resultSet.getString(2);
				String carType = resultSet.getString(3);
				String compamy = resultSet.getString(4);
				int parkId = resultSet.getInt(5);
				String parkName = resultSet.getString(6);
				car = new Parkinglot(licensePlates, carColor, carType, compamy, parkId, parkName);
				cars.add(car);
			}
			return cars;
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

	public List<Parkinglot> searchByCarType(String carType) {
		List<Parkinglot> cars = new ArrayList<>();
		Parkinglot car = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.SEARCH_EMPLOYEE_BY_CARTYPE);
			preparedStatement.setString(1, carType);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String licensePlates = resultSet.getString(1);
				String carColor = resultSet.getString(2);
				String carTypes = resultSet.getString(3);
				String compamy = resultSet.getString(4);
				int parkId = resultSet.getInt(5);
				String parkName = resultSet.getString(6);
				car = new Parkinglot(licensePlates, carColor, carType, compamy, parkId, parkName);
				cars.add(car);
			}
			return cars;
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

	public boolean updateCar(Car car) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.UPDATE_CAR);
			preparedStatement.setString(1, car.getLicensePlate());
			preparedStatement.setString(2, car.getCarColor());
			preparedStatement.setString(3, car.getCarType());
			preparedStatement.setString(4, car.getCompany());
			preparedStatement.setInt(5, car.getParkId());
			preparedStatement.setString(6, car.getLicensePlate());

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

	public boolean deleteCar(String liencesPlate) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareCall(SQLQuery.DELETE_CAR);
			preparedStatement.setString(1, liencesPlate);
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
	
	public boolean deleteCarByPark(int parkId) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareCall(SQLQuery.DELETE_CAR_BYPARKID);
			preparedStatement.setInt(1, parkId);
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
	
	public int getCountCar(int parkId) {
		ArrayList<Car> list = new ArrayList();
		int count = 0;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.COUNT_OFCAR);
			preparedStatement.setInt(1, parkId);
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
