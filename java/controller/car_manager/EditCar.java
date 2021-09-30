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
 * Servlet implementation class EditCar
 */
@WebServlet("/editcar")
public class EditCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParkingDao parkingDao = new ParkingDao();
	private CarDao carDao = new CarDao();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String licensePlate =request.getParameter("liecensePl");
		List<Parkinglot> parkinglots = null;
		parkinglots = parkingDao.ListAllParking();
		request.setAttribute("parking", parkinglots);
		Car car = new Car();
		car = carDao.searchByLiencePlaces(licensePlate);
		request.setAttribute("car", car);
		request.getRequestDispatcher("/views/carbooking/edit_car.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String plate = request.getParameter("licencePlate");
		String carType = request.getParameter("carType");
		String carColor = request.getParameter("carColor");
		String company = request.getParameter("company");
		int parkinglot = Integer.parseInt(request.getParameter("parkinglot"));
		String plateCar = request.getParameter("licensePlates");
		
		Car car = new Car(plate, carColor, carType, company, parkinglot, plateCar);
		carDao.updateCar(car);
		response.sendRedirect(request.getContextPath() + "/listcar");
	}

}
