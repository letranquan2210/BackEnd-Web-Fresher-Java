package controller.ticket;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import dal.DBContext;
import dao.CarDao;
import dao.TicketDao;
import model.Parkinglot;
import model.Ticket;
import model.Trip;

/**
 * Servlet implementation class AddTicketController
 */
@WebServlet("/addTicket")
public class AddTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDao carDao = new CarDao();
	private TicketDao ticketDao = new TicketDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTicketController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Parkinglot> cars = null;
		cars = carDao.ListAllCar();
		request.setAttribute("cars", cars);

		DBContext db = new DBContext();
		ArrayList<Trip> trips = db.getAllTrip();
		request.setAttribute("trips", trips);

		request.getRequestDispatcher("/views/ticket/add_ticket.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		String action = request.getParameter("action");
		String customerName = request.getParameter("customerName");
		String bookingTime = request.getParameter("bookingTime");
		String bookingTimeSql = bookingTime.concat(":00");
		int tripId = Integer.parseInt(request.getParameter("destination"));
		String licensePlate = request.getParameter("licensePlate");
//		System.out.println(customerName + ", " + bookingTimeSql + ", " + tripId + ", " + licensePlate);
		Ticket tk = new Ticket();
		tk.setCustomerName(customerName);
		tk.setBookingTime(bookingTimeSql);
		tk.setTripId(tripId);
		tk.setLicensePlate(licensePlate);

		if ("add".equalsIgnoreCase(action)) {
			ticketDao.addTicket(tk);
			url = "/listTicket";
		} else {
			url = "/addTicket";
		}
		response.sendRedirect(request.getContextPath() + url);
	}

}
