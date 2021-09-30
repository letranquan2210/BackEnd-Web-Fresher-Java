package controller.car_manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDao;
import model.Parkinglot;

/**
 * Servlet implementation class AddParkingLot
 */
@WebServlet("/add_parkinglot")
public class AddParkingLot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParkingDao parkingDao = new ParkingDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddParkingLot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/carbooking/add_parkinglot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String url = "";
		String parkingName = request.getParameter("parkingName");
		String place = request.getParameter("place");
		int area = Integer.parseInt(request.getParameter("area"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		
		Parkinglot  parkinglot = new Parkinglot(1, area, parkingName, place, price, "Blank");
		if("add".equalsIgnoreCase(action)) {
			parkingDao.addParking(parkinglot);
			url = "/list_parkinglot";	
		}else {
			url = "/add_parkinglot";
		}
		response.sendRedirect(request.getContextPath() + url);
		
	}

}
