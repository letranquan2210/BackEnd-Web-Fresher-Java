package controller.car_manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.DBContext;
import dao.BookofficeDao;
import model.Bookingoffice;
import model.Trip;

/**
 * Servlet implementation class AddBookingOffice
 */
@WebServlet("/add_bookingoffice")
public class AddBookingOffice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookofficeDao bookofficeDao = new BookofficeDao();
	private DBContext tripDao = new DBContext();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookingOffice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Trip> trips = null;
		trips = tripDao.getAllTrip();
		request.setAttribute("trip", trips);
		request.getRequestDispatcher("/views/carbooking/add_booking.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String url = "";
		Bookingoffice bookingoffice = null;
		String bookingOfficeName = request.getParameter("bookingOfficeName");
		int trip = Integer.parseInt(request.getParameter("trip"));
		String phoneNumber = request.getParameter("phoneNumber");
		String place = request.getParameter("place");
		int price = Integer.parseInt(request.getParameter("price"));
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		bookingoffice = new Bookingoffice(toDate, bookingOfficeName, phoneNumber, place, price, fromDate, trip);
		if("add".equalsIgnoreCase(action)) {
			bookofficeDao.addBooking(bookingoffice);
			url="/list_bookingoffice";
		}else {
			url = "/add_bookingoffice";
		}
		response.sendRedirect(request.getContextPath() + url);	
		
	}

}
