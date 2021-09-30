package controller.trip;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.DBContext;
import model.Trip;

/**
 * Servlet implementation class ListTripController
 */
@WebServlet("/listTrip")
public class ListTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTripController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBContext db = new DBContext();
		ArrayList<Trip> trips = db.getAllTrip();
		request.setAttribute("trips", trips);
		int i = trips.size();
		request.getRequestDispatcher("/views/trip/trip-list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name =request.getParameter("name");
		String condition ="where" ;
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		if(!year.isEmpty()) {
			
			condition += " year(departureDate) =" + year;
			if(!month.isEmpty()) {
				
				condition += "and month(departureDate) =" + month;
				if(!day.isEmpty()) {
					
					condition += "and day(departureDate) =" + day;
				}	
			}else {
				if(!day.isEmpty()) {
					
					condition += "and day(departureDate) =" + day;
				}
			}
			if(!name.isEmpty()) {
				condition += "and destination like '%"+ name+ "%' ";
			}
			
			
		}
//		else {
//			if(month != null) {
//				
//				condition += " year(departureDate) =" + month;
//				if(day != null) {
//					
//					condition += "and year(departureDate) =" + day;
//				}
//			}else {
//				if(day != null) {
//					
//					condition += " year(departureDate) =" + day;
//				}else {
//					if(name != null) {
//						if(name != null) {
//							condition += " destination like '%"+ name+ "%' ";
//						}else {
//							condition ="";
//						}
//					}
//				}
//			}
//			
//		}
		DBContext db = new DBContext();
		ArrayList<Trip> trips = db.getAllTripBySearch(condition);
		request.setAttribute("trips", trips);
		int i = trips.size();
		request.getRequestDispatcher("/views/trip/trip-list.jsp").forward(request, response);
		
		
		
		
	}

}
