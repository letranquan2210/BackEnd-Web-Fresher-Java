package controller.ticket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TicketDao;
import model.Trip;

/**
 * Servlet implementation class DeleteTicketController
 */
@WebServlet("/deleteTicket")
public class DeleteTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TicketDao ticketDao = new TicketDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTicketController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		System.out.println(ticketId);
		ticketDao.deleteTicket(ticketId);
		
		response.sendRedirect(request.getContextPath() + "/listTicket");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
