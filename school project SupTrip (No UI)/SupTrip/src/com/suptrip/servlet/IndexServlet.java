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
import com.suptrip.model.Etudiants;
import com.suptrip.model.Trip;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Trip> listTrip = DaoFactory.getDaoFactory().getTripDao().getAllTrip();
		List<Etudiants> listEtudiant = DaoFactory.getDaoFactory().getEtudiantDao().getAllEtudiants();
		int nbrTrip = listTrip.size();
		int nbrStudent = listEtudiant.size();
		request.setAttribute("statTrip", nbrTrip);
		request.setAttribute("statStud", nbrStudent);
		RequestDispatcher rd = request.getRequestDispatcher("/Front/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
