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

/**
 * Servlet implementation class AuthIndexServlet
 */
@WebServlet("/auth/index")
public class AuthIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthIndexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Trip> ListTrip = DaoFactory.getDaoFactory().getTripDao().getAllTrip();
		request.setAttribute("trip", ListTrip);
		List<Campus> ListCampus = DaoFactory.getDaoFactory().getCampusDao().getAllCampus();
		request.setAttribute("listCampus", ListCampus);
		RequestDispatcher rd = request.getRequestDispatcher("/Front/auth/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
