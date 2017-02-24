package com.suptrip.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suptrip.dao.DaoFactory;
import com.suptrip.model.Trip;

/**
 * Servlet implementation class ShowBagServlet
 */
@WebServlet("/auth/showBag")
public class ShowBagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBagServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("bag") != null)
		{
			String mybag = (String)request.getSession().getAttribute("bag");
			
			String[] trip = mybag.split(",");
			Long id;
			int count = trip.length;
			ArrayList<Trip> listTrip = new ArrayList<Trip>();
			for(int i=0;i<count;i++)
			{
				String trips = trip[i];/**/
				String[] Split = trips.split(";");
				id = Long.parseLong(Split[0]);
				Trip CurrentTrip = DaoFactory.getDaoFactory().getTripDao().findTripById(id);
				listTrip.add(CurrentTrip);
			}
			request.setAttribute("mytriplist", listTrip);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/Front/auth/showBag.jsp");
		rd.forward(request, response);
	}

	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
