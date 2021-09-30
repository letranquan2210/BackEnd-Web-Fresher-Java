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
 * Servlet implementation class ViewEmployee
 */
@WebServlet("/view_employee")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao = new EmployeeDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("employeeId");
		if (id != null && !id.isEmpty()) {
			Employee employee = employeeDao.searchByID(Integer.parseInt(id));
			if (employee != null) {
				request.setAttribute("employee", employee);
			}
		}
		request.getRequestDispatcher("/views/employee/view_employee.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
