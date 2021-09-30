package controller.trip;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.DBContext;
import model.Trip;

/**
 * Servlet implementation class AddTripController
 */
@WebServlet("/addTrip")
public class AddTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTripController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/trip/add_trip.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Trip t = new Trip();
		String time = request.getParameter("departureTime") + ":00";
		Time timesql = Time.valueOf(time);
		t.setDepartureTime(timesql);
		// listTript.setTripId(2);
		t.setDestination(request.getParameter("destination"));
		t.setDriver(request.getParameter("driver"));
		t.setCarType(request.getParameter("carType"));
		t.setMaximumOnlineTicketNumber(Integer.parseInt(request.getParameter("maximumTicketNo")));
		t.setDepartureDate(Date.valueOf(request.getParameter("departureDate")));
		// response.getWriter().println(timesql);
		t.setBookedTicketNumber(0);
		DBContext db = new DBContext();
		db.addTrip(t);

		response.sendRedirect("listTrip");
	}

}
