package controller.employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import model.Employee;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao = new EmployeeDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = request.getParameter("username");
		String pass = request.getParameter("pass");
		String url = "";
		Employee employee = new Employee();
		employee = employeeDao.Login(user, pass);
		if (employee != null) {
			if (employee.isAdmin() == true) {
				url = "/views/employee/employee_manager.jsp";
				session.setAttribute("admin", employee);
			} else {
				url = "/views/carbooking/car_park_manager.jsp";
				session.setAttribute("user", employee);
			}
		} else {
			url = "/views/login.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
