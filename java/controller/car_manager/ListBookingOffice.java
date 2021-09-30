package controller.car_manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookofficeDao;
import model.Trip;

/**
 * Servlet implementation class ListBookingOffice
 */
@WebServlet("/list_bookingoffice")
public class ListBookingOffice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookofficeDao bookofficeDao = new BookofficeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBookingOffice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Trip>  trips = null;
		trips = bookofficeDao.ListAllBooking();
		request.setAttribute("office", trips);
		request.getRequestDispatcher("/views/carbooking/list_booking.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("filter-option");
		String search = request.getParameter("search");
		List<Trip> trips = null;
		if("trip".equalsIgnoreCase(option)) {
			trips = bookofficeDao.findByTrip(search);
			int i = trips.size();
			request.setAttribute("office", trips);
		}
		if("bookingOffice".equalsIgnoreCase(option)) {
			trips = bookofficeDao.findByBooking(search);
			int i = trips.size();
			request.setAttribute("office", trips);
		}
		request.getRequestDispatcher("/views/carbooking/list_booking.jsp").forward(request, response);
	}

}
