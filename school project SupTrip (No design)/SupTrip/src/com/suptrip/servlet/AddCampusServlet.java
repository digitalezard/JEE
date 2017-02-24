package com.suptrip.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suptrip.dao.DaoFactory;
import com.suptrip.model.Campus;
import com.suptrip.model.Pays;

import java.util.*;

/**
 * Servlet implementation class AddCampusServlet
 */
@WebServlet("/auth/addCampus")
public class AddCampusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCampusServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				List<Pays> listPays = DaoFactory.getDaoFactory().getPaysDao().getAllPays();
				request.setAttribute("pays", listPays);
				
				RequestDispatcher rd = request.getRequestDispatcher("/Front/auth/addCampus.jsp");
				rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String campusName = request.getParameter("campusName");
		String paysId 	= request.getParameter("paysId");
		List<Pays> listPays = DaoFactory.getDaoFactory().getPaysDao().getAllPays();
		request.setAttribute("pays", listPays);
		
		
		Long PaysLongId = Long.parseLong(paysId);

		Pays p = DaoFactory.getDaoFactory().getPaysDao().findPaysById(PaysLongId);
		
		Campus c = new Campus(campusName, p);
		DaoFactory.getDaoFactory().getCampusDao().addCampus(c);
		
		request.setAttribute("campus", c);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Front/auth/addCampus.jsp");
		rd.forward(request, response);
	}

}
