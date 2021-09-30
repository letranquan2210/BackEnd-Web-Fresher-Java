package controller.car_manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDao;
import dao.TicketDao;

/**
 * Servlet implementation class DeleteCarController
 */
@WebServlet("/delete_car")
public class DeleteCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CarDao carDao = new CarDao();  
    private TicketDao ticketDao = new TicketDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String licensePlate = request.getParameter("liecensePl");
		int count = ticketDao.getCountCar(licensePlate);
		if(count==0) {
			carDao.deleteCar(licensePlate);			
		}
		response.sendRedirect(request.getContextPath() + "/listcar");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
