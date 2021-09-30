package controller.car_manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.CarDao;
import model.Car;
import model.Parkinglot;

/**
 * Servlet implementation class ListCar
 */
@WebServlet("/listcar")
public class ListCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDao carDao = new CarDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Parkinglot> cars = null;
		cars = carDao.ListAllCar();
		request.setAttribute("car", cars);
		request.getRequestDispatcher("/views/carbooking/list_car.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Parkinglot> cars = null;
		String searh = request.getParameter("search");
		String option = request.getParameter("filter-option");
		if("plate".equalsIgnoreCase(option)) {
			cars = carDao.searchByLiencePlace(searh);
			request.setAttribute("car", cars);
		}else if("company".equalsIgnoreCase(option)) {
			cars = carDao.searchByCompany(searh);
			request.setAttribute("car", cars);
		}else if("type".equalsIgnoreCase(option)) {
			cars = carDao.searchByCarType(searh);
			request.setAttribute("car", cars);
		}else {
			doDelete(request, response);
		}
		request.getRequestDispatcher("/views/carbooking/list_car.jsp").forward(request, response);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String plate = req.getParameter("liecensePl");
		carDao.deleteCar(plate);
		resp.sendRedirect(req.getContextPath() + "/listcar");
	}

}
