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
import model.Employee;
import utils.SQLQuery;

public class EmployeeDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public boolean addEmployee(Employee employee) {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.ADD_EMPLOYEE);
			preparedStatement.setString(1, employee.getAccount());
			preparedStatement.setString(2, employee.getDepartment());
			preparedStatement.setString(3, employee.getEmployeeAddress());
			preparedStatement.setString(4, employee.getEmployeeBirthdate());
			preparedStatement.setString(5, employee.getEmployeeEmail());
			preparedStatement.setString(6, employee.getEmployeeName());
			preparedStatement.setString(7, employee.getEmployeePhone());
			preparedStatement.setString(8, employee.getPassword());
			preparedStatement.setBoolean(9, employee.isSex());
			preparedStatement.setBoolean(10, employee.isAdmin());
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

	public List<Employee> ListAllEmployee() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.LIST_ALL_EMPLOYEE);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int employeeId = resultSet.getInt(1);
				String account = resultSet.getString(2);
				String department = resultSet.getString(3);
				String employeeAddress = resultSet.getString(4);
				String employeeBirthdate = resultSet.getString(5);
				String employeeEmail = resultSet.getString(6);
				String employeeName = resultSet.getString(7);
				String employeePhone = resultSet.getString(8);
				String password = resultSet.getString(9);
				boolean sex = resultSet.getBoolean(10);
				boolean admin = false;
				employee = new Employee(employeeId, account, department, employeeAddress, employeeBirthdate,
						employeeEmail, employeeName, employeePhone, password, sex, admin);
				employees.add(employee);
			}
			return employees;
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

	public List<Employee> searchByName(String Name) {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.SEARCH_EMPLOYEE_BY_NAME);
			preparedStatement.setString(1, Name);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int employeeId = resultSet.getInt(1);
				String account = resultSet.getString(2);
				String department = resultSet.getString(3);
				String employeeAddress = resultSet.getString(4);
				String employeeBirthdate = resultSet.getString(5);
				String employeeEmail = resultSet.getString(6);
				String employeeName = resultSet.getString(7);
				String employeePhone = resultSet.getString(8);
				String password = resultSet.getString(9);
				boolean sex = resultSet.getBoolean(10);
				boolean admin = resultSet.getBoolean(11);
				employee = new Employee(employeeId, account, department, employeeAddress, employeeBirthdate,
						employeeEmail, employeeName, employeePhone, password, sex, admin);
				employees.add(employee);
			}
			return employees;
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

	public Employee searchByID(int id) {
		Employee employee = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.SEARCH_EMPLOYEE_BY_ID);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int employeeId = resultSet.getInt(1);
				String account = resultSet.getString(2);
				String department = resultSet.getString(3);
				String employeeAddress = resultSet.getString(4);
				String employeeBirthdate = resultSet.getString(5);
				String employeeEmail = resultSet.getString(6);
				String employeeName = resultSet.getString(7);
				String employeePhone = resultSet.getString(8);
				String password = resultSet.getString(9);
				boolean sex = resultSet.getBoolean(10);
				boolean admin = resultSet.getBoolean(11);
				employee = new Employee(employeeId, account, department, employeeAddress, employeeBirthdate,
						employeeEmail, employeeName, employeePhone, password, sex, admin);
				
			}
			return employee;
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

	public Employee Login(String acc, String pass) {
		Employee employee = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.SEARCH_ADMIN);
			preparedStatement.setString(1, acc);
			preparedStatement.setString(2, pass);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int employeeId = resultSet.getInt(1);
				String account = resultSet.getString(2);
				String department = resultSet.getString(3);
				String employeeAddress = resultSet.getString(4);
				String employeeBirthdate = resultSet.getString(5);
				String employeeEmail = resultSet.getString(6);
				String employeeName = resultSet.getString(7);
				String employeePhone = resultSet.getString(8);
				String password = resultSet.getString(9);
				boolean sex = resultSet.getBoolean(10);
				boolean admin = resultSet.getBoolean(11);
				employee = new Employee(employeeId, account, department, employeeAddress, employeeBirthdate,
						employeeEmail, employeeName, employeePhone, password, sex, admin);

			}
			return employee;

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

	public int getCount() {
		int count = 0;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.COUNT);
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
	
	public List<Employee> searchByDept(String dept) {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLQuery.SEARCH_EMPLOYEE_BY_DEPART);
			preparedStatement.setString(1, dept);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int employeeId = resultSet.getInt(1);
				String account = resultSet.getString(2);
				String department = resultSet.getString(3);
				String employeeAddress = resultSet.getString(4);
				String employeeBirthdate = resultSet.getString(5);
				String employeeEmail = resultSet.getString(6);
				String employeeName = resultSet.getString(7);
				String employeePhone = resultSet.getString(8);
				String password = resultSet.getString(9);
				boolean sex = resultSet.getBoolean(10);
				boolean admin = resultSet.getBoolean(11);
				employee = new Employee(employeeId, account, department, employeeAddress, employeeBirthdate,
						employeeEmail, employeeName, employeePhone, password, sex, admin);
				employees.add(employee);
			}
			return employees;
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


}
