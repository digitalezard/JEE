package com.suptrip.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ShowTripServlet
 */
@WebServlet("/auth/showTrip")
public class ShowTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTripServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				List<Trip> listTrip = DaoFactory.getDaoFactory().getTripDao().getAllTrip();
				List<Campus> listCampus = DaoFactory.getDaoFactory().getCampusDao().getAllCampus();
				ArrayList<Trip> listTripByCampus = new ArrayList<Trip>();
				for(Campus CurrentCampus : listCampus)
				{
					Long CurrentIdCampus = CurrentCampus.getIdCampus();
					for(Trip CurrentTrip : listTrip)
					{
						Long CurrentIdCampusTrip = CurrentTrip.getCampus().getIdCampus();
						if(CurrentIdCampusTrip == CurrentIdCampus)
						{
							listTripByCampus.add(CurrentTrip);
						}
					}
				}
				request.setAttribute("trip", listTripByCampus);
				request.setAttribute("listcampus", listCampus);
				RequestDispatcher rd = request.getRequestDispatcher("/Front/auth/showTrip.jsp");
				rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
