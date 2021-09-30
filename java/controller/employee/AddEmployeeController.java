package controller.employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.EmployeeDao;
import model.Employee;

/**
 * Servlet implementation class AddEmployeeController
 */
@WebServlet("/add_employee")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao = new EmployeeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/employee/add_employee.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		String employeeName = request.getParameter("fullName");
		String employeePhone = request.getParameter("phoneNumber");
		String employeeBirthdate = request.getParameter("date");
		boolean sex = "male".equalsIgnoreCase((String) request.getParameter("sex"));
		String employeeAddress = request.getParameter("address");
		String employeeEmail = request.getParameter("email");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String department = request.getParameter("department");
		
		Employee employee = new Employee(account, department, employeeAddress, employeeBirthdate, employeeEmail, employeeName, employeePhone, password, sex);
		String action = request.getParameter("action");
		if("add".equalsIgnoreCase(action)) {
			employeeDao.addEmployee(employee);
			url = "/list_employee";
		}else if("reset".equalsIgnoreCase(action)) {
			url = "/add_employee";
		}else {
			url ="/views/employee/employee_manager.jsp";
		}
		response.sendRedirect(request.getContextPath() + url);
		
	}

}
