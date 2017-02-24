package com.suptrip.servlet;

import java.io.IOException;
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

@WebServlet("/auth/addTrip")
public class AddTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddTripServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Campus> listCampus = DaoFactory.getDaoFactory().getCampusDao().getAllCampus();
		request.setAttribute("campus", listCampus);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Front/auth/addTrip.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tripName = request.getParameter("tripName");
		String campusId 	= request.getParameter("campusId");
		String content = request.getParameter("tripContent");
		String dateDepart = request.getParameter("DateDepart");
		String dateRetour = request.getParameter("DateRetour");
		
		List<Campus> listCampus = DaoFactory.getDaoFactory().getCampusDao().getAllCampus();
		request.setAttribute("campus", listCampus);
		
		
		Long CampusLongId = Long.parseLong(campusId);

		Campus c = DaoFactory.getDaoFactory().getCampusDao().findCampusById(CampusLongId);
		
		Trip t = new Trip(tripName, content, c, dateDepart, dateRetour);
		DaoFactory.getDaoFactory().getTripDao().addTrip(t);
		
		request.setAttribute("trip", t);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Front/auth/addTrip.jsp");
		rd.forward(request, response);
	}

}
