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
 * Servlet implementation class EditParkingLot
 */
@WebServlet("/edit_parkinglot")
public class EditParkingLot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParkingDao parkingDao = new ParkingDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditParkingLot() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("parkId");
		Parkinglot parkinglot = new Parkinglot();
		parkinglot = parkingDao.findById(Integer.parseInt(id));
		request.setAttribute("parking", parkinglot);
		request.getRequestDispatcher("/views/carbooking/edit_parkinglot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("parkId"));
		String parkingName = request.getParameter("parkingName");
		String place = request.getParameter("place");
		int area = Integer.parseInt(request.getParameter("area"));
		int price = Integer.parseInt(request.getParameter("price"));
		Parkinglot  parkinglot = new Parkinglot(id, area, parkingName, place, price, "Blank");
		
		parkingDao.update(parkinglot);
		response.sendRedirect(request.getContextPath() + "/list_parkinglot");
		
	}

}
