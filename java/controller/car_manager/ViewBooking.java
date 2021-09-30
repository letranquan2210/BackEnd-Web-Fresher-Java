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
import model.Trip;

/**
 * Servlet implementation class ViewBooking
 */
@WebServlet("/view_booking")
public class ViewBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookofficeDao bookofficeDao = new BookofficeDao();
	private DBContext tripDao = new DBContext();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBooking() {
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
		Trip trip = null;
		String officeId = request.getParameter("officeId");
		trip = bookofficeDao.findById(Integer.parseInt(officeId));
		request.setAttribute("booking", trip);
		request.getRequestDispatcher("/views/carbooking/view_booking.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
