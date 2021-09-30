package controller.car_manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDao;
import dao.ParkingDao;
import dao.TicketDao;

/**
 * Servlet implementation class DeleteParkingController
 */
@WebServlet("/delete_parkinglot")
public class DeleteParkingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDao carDao = new CarDao();
	private ParkingDao parkingDao = new ParkingDao();
	private TicketDao ticketDao = new TicketDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteParkingController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int parkId = Integer.parseInt(request.getParameter("parkId"));
		int car = carDao.getCountCar(parkId);
		if (car == 0) {
			parkingDao.delete(parkId);
		}
		response.sendRedirect(request.getContextPath() + "/list_parkinglot");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
