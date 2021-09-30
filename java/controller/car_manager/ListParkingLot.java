package controller.car_manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDao;
import model.Parkinglot;

/**
 * Servlet implementation class ListParkingLot
 */
@WebServlet("/list_parkinglot")
public class ListParkingLot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParkingDao parkingDao = new ParkingDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListParkingLot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Parkinglot> parkinglots = null;
		parkinglots = parkingDao.ListAllParking();
		request.setAttribute("parking", parkinglots);
		request.getRequestDispatcher("/views/carbooking/list_parkinglot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("filter-option");
		String search = request.getParameter("search");
		List<Parkinglot> parkinglots = null;
		if("place".equalsIgnoreCase(option)) {
			parkinglots = parkingDao.findByPlace(search);
			request.setAttribute("parking", parkinglots);
		}else if("name".equalsIgnoreCase(option)) {
			parkinglots = parkingDao.findByName(search);
			request.setAttribute("parking", parkinglots);
		}
		request.getRequestDispatcher("/views/carbooking/list_parkinglot.jsp").forward(request, response);
	}

}
