package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;


import model.Account;
import model.Trip;


public class DBContext {

    Connection connection;

    public DBContext() {
        try {
            String username = "sa";
            String password = "123";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Car_Park";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Account getAccByAccountAndPassword(String account,String password){
    	try {
			String sql = "SELECT [account]\r\n"
					+ "      ,[password]\r\n"
					+ "      ,[admin]\r\n"
					+ "  FROM [dbo].[Account] Where account= ? AND password =?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, account);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Account acc = new Account();
				acc.setAccount(account);
				acc.setPassword(password);
				acc.setAdmin(rs.getBoolean("admin"));
				return acc;
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
    }
    
    public void deleteTrip(int id) {
        String sql = "DELETE FROM [dbo].[Trip]\r\n"
        		+ "      WHERE tripId = " + id;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Trip findTripById(int id) {
    	String sql = "SELECT [tripId]\r\n"
    			+ "      ,[bookedTicketNumber]\r\n"
    			+ "      ,[carType]\r\n"
    			+ "      ,[departureDate]\r\n"
    			+ "      ,[departureTime]\r\n"
    			+ "      ,[destination]\r\n"
    			+ "      ,[driver]\r\n"
    			+ "      ,[maximumOnlineTicketNumber]\r\n"
    			+ "  FROM [dbo].[Trip]\r\n"
    			+ "  where tripId = ?";
    	Trip t = new Trip();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            
            
            while (rs.next()) {
                
                t.setTripId(rs.getInt("tripId"));
                t.setBookedTicketNumber(rs.getInt("bookedTicketNumber"));
                t.setCarType(rs.getString("carType"));
                t.setDepartureDate(rs.getDate("departureDate"));
                t.setDepartureTime(rs.getTime("departureTime"));
                t.setDestination(rs.getString("destination"));
                t.setDriver(rs.getString("driver"));
                t.setMaximumOnlineTicketNumber(rs.getInt("maximumOnlineTicketNumber"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
		
		

	}
    public void updateTrip(Trip t,int tripId) {
        String sql = "UPDATE [dbo].[Trip]\r\n"
        		+ "   SET [bookedTicketNumber] = ?\r\n"
        		+ "      ,[carType] = ?\r\n"
        		+ "      ,[departureDate] = ?\r\n"
        		+ "      ,[departureTime] = ?\r\n"
        		+ "      ,[destination] = ?\r\n"
        		+ "      ,[driver] = ?\r\n"
        		+ "      ,[maximumOnlineTicketNumber] = ?\r\n"
        		+ " WHERE tripId = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

              statement.setInt(1, t.getBookedTicketNumber());
              statement.setString(2, t.getCarType());
              statement.setDate(3, t.getDepartureDate());
              statement.setTime(4, t.getDepartureTime());
              statement.setString(5, t.getDestination());
              statement.setString(6, t.getDriver());
              statement.setInt(7, t.getMaximumOnlineTicketNumber());
              statement.setInt(8, tripId);
              statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public ArrayList<Trip> getAllTrip() {
    	 ArrayList<Trip> trips = new ArrayList<>();
    	try {
        String sql = "SELECT [tripId]\r\n"
        		+ "      ,[bookedTicketNumber]\r\n"
        		+ "      ,[carType]\r\n"
        		+ "      ,[departureDate]\r\n"
        		+ "      ,[departureTime]\r\n"
        		+ "      ,[destination]\r\n"
        		+ "      ,[driver]\r\n"
        		+ "      ,[maximumOnlineTicketNumber]\r\n"
        		+ "  FROM [dbo].[Trip]";
       
        
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Trip t = new Trip();
                t.setTripId(rs.getInt("tripID"));
                t.setBookedTicketNumber(rs.getInt("bookedTicketNumber"));
                t.setCarType(rs.getString("carType"));
                t.setDepartureDate(rs.getDate("departureDate"));
                t.setDepartureTime(rs.getTime("departureTime"));
                t.setDestination(rs.getString("destination"));
                t.setDriver(rs.getString("driver"));
                t.setMaximumOnlineTicketNumber(rs.getInt("maximumOnlineTicketNumber"));
                trips.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return trips;
    }
    public ArrayList<Trip> getAllTripBySearch( String condition) {
   	 ArrayList<Trip> trips = new ArrayList<>();
   	try {
       String sql = "SELECT [tripId]\r\n"
       		+ "      ,[bookedTicketNumber]\r\n"
       		+ "      ,[carType]\r\n"
       		+ "      ,[departureDate]\r\n"
       		+ "      ,[departureTime]\r\n"
       		+ "      ,[destination]\r\n"
       		+ "      ,[driver]\r\n"
       		+ "      ,[maximumOnlineTicketNumber]\r\n"
       		+ "  FROM [dbo].[Trip]" + condition;
      
       
           PreparedStatement statement = connection.prepareStatement(sql);
           ResultSet rs = statement.executeQuery();
           while (rs.next()) {
               Trip t = new Trip();
               t.setTripId(rs.getInt("tripID"));
               t.setBookedTicketNumber(rs.getInt("bookedTicketNumber"));
               t.setCarType(rs.getString("carType"));
               t.setDepartureDate(rs.getDate("departureDate"));
               t.setDepartureTime(rs.getTime("departureTime"));
               t.setDestination(rs.getString("destination"));
               t.setDriver(rs.getString("driver"));
               t.setMaximumOnlineTicketNumber(rs.getInt("maximumOnlineTicketNumber"));
               trips.add(t);
           }
       } catch (SQLException ex) {
           Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
       }

       return trips;
   }

    public void addTrip(Trip t) {
        try {
            String sql = "INSERT INTO [dbo].[Trip]\r\n"
            		+ "           ([bookedTicketNumber]\r\n"
            		+ "           ,[carType]\r\n"
            		+ "           ,[departureDate]\r\n"
            		+ "           ,[departureTime]\r\n"
            		+ "           ,[destination]\r\n"
            		+ "           ,[driver]\r\n"
            		+ "           ,[maximumOnlineTicketNumber])\r\n"
            		+ "     VALUES\r\n"
            		+ "           (?\r\n"
            		+ "           ,?\r\n"
            		+ "           ,?\r\n"
            		+ "           ,?\r\n"
            		+ "           ,?\r\n"
            		+ "           ,?\r\n"
            		+ "           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, t.getBookedTicketNumber());
            statement.setString(2, t.getCarType());;
            statement.setDate(3, t.getDepartureDate());
            statement.setTime(4, t.getDepartureTime());
            statement.setString(5, t.getDestination());
            statement.setString(6, t.getDriver());
            statement.setInt(7, t.getMaximumOnlineTicketNumber());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
