package controller.trip;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.DBContext;
import model.Trip;

/**
 * Servlet implementation class UpdateTripController
 */
@WebServlet("/updateTrip")
public class UpdateTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTripController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  
		  DBContext db = new DBContext();
		  Trip t = db.findTripById(Integer.parseInt( request.getParameter("tripId")));
		  
		  request.setAttribute("tripId", t.getTripId());
		  request.setAttribute("destination", t.getDestination());
		  Time time = t.getDepartureTime();
		  SimpleDateFormat s = new SimpleDateFormat("HH:mm");
		  String timefomat = s.format(time);
		  
		  request.setAttribute("departureTime", timefomat);
		  request.setAttribute("driver", t.getDriver());
		  request.setAttribute("carType", t.getCarType());
		  request.setAttribute("maximumTicketNumber", t.getMaximumOnlineTicketNumber());
		  Date d = t.getDepartureDate();
		  request.setAttribute("departureDate", t.getDepartureDate());
		  
	      request.getRequestDispatcher("/views/trip/update-trip.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		  Trip t = new Trip();
	      String time = request.getParameter("departureTime")+":00";
	      Time timesql =  Time.valueOf(time);
	      t.setDepartureTime(timesql);
	      int id = Integer.parseInt( request.getParameter("tripId"));
	      //listTript.setTripId(2);
	      t.setDestination(request.getParameter("destination"));
	      t.setDriver(request.getParameter("driver"));
	      t.setCarType(request.getParameter("carType"));
	      t.setMaximumOnlineTicketNumber( Integer.parseInt( request.getParameter("maximumTicketNo")));
	      t.setDepartureDate(Date.valueOf(request.getParameter("departureDate")));
	      //response.getWriter().println(timesql);
	      t.setBookedTicketNumber(0);
	      
	      DBContext db = new DBContext();
	      
	      db.updateTrip(t,id);
	      
	      response.sendRedirect("listTrip");
	      
	}

}
