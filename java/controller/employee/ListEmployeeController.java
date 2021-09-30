package controller.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;

/**
 * Servlet implementation class ListEmployeeController
 */
@WebServlet("/list_employee")
public class ListEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao = new EmployeeDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employees = null;
		employees =employeeDao.ListAllEmployee();
		request.setAttribute("employee", employees);
		request.getRequestDispatcher("/views/employee/list_employee.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("search");
		String filter = request.getParameter("filter-option");
		List<Employee> employees = null;
		if("name".equalsIgnoreCase(filter)) {
			employees = employeeDao.searchByName(name);
			request.setAttribute("employee", employees);			
		}
		if("department".equalsIgnoreCase(filter)) {
			employees = employeeDao.searchByDept(name);
			request.setAttribute("employee", employees);
		}
		request.getRequestDispatcher("/views/employee/list_employee.jsp").forward(request, response);
	}

}
