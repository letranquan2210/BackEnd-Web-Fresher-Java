package controller.car_manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDao;
import dao.ParkingDao;
import model.Car;
import model.Parkinglot;

/**
 * Servlet implementation class AddCar
 */
@WebServlet("/addcar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParkingDao parkingDao = new ParkingDao();
	private CarDao carDao = new CarDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCar() {
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
		request.getRequestDispatcher("/views/carbooking/add_car.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		String action = request.getParameter("action");
		String plate = request.getParameter("licensePlate");
		String carType = request.getParameter("carType");
		String carColor = request.getParameter("carColor");
		String company = request.getParameter("company");
		int parkinglot = Integer.parseInt(request.getParameter("parkinglot"));
		Car car = new Car(plate, carColor, carType, company, parkinglot);
		if("add".equalsIgnoreCase(action)) {
			carDao.addCar(car);
			url = "/listcar";
		}else {
			url = "/addcar";
		}
		response.sendRedirect(request.getContextPath() + url);
	}

}
