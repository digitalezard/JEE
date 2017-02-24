package com.suptrip.servlet;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suptrip.dao.DaoFactory;
import com.suptrip.model.Campus;
import com.suptrip.model.Trip;

/**
 * Servlet implementation class SearchByCampusServlet
 */
@WebServlet("/auth/searchByCampus")
public class SearchByCampusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByCampusServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Campus> listCampus = DaoFactory.getDaoFactory().getCampusDao().getAllCampus();
		request.setAttribute("listCampus", listCampus);
		RequestDispatcher rd = request.getRequestDispatcher("/Front/auth/searchByCampus.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Trip> listTrip = DaoFactory.getDaoFactory().getTripDao().getAllTrip();
		List<Campus> listCampus = DaoFactory.getDaoFactory().getCampusDao().getAllCampus();
		request.setAttribute("listCampus", listCampus);
		String campusSearch = request.getParameter("campussearch"); 
		ArrayList<Trip> listTripMatch = new ArrayList<Trip>();
		for(Trip CurrentTrip : listTrip)
		{
			String CurrentName = CurrentTrip.getCampus().getCampusName();
			if(campusSearch.equals(CurrentName))
			{
				listTripMatch.add(CurrentTrip);
			}
		}
		
		Long campusId = listTripMatch.get(0).getCampus().getIdCampus();
		request.setAttribute("campsearch", campusId);
		request.setAttribute("tripbycampus", listTripMatch);
		RequestDispatcher rd = request.getRequestDispatcher("/Front/auth/viewTripByCampus.jsp");
		rd.forward(request, response);
		
	}

}
