package com.suptrip.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suptrip.dao.DaoFactory;
import com.suptrip.model.Trip;
import com.suptrip.model.Commandes;
import com.suptrip.model.Etudiants;

/**
 * Servlet implementation class ProceedOrderServlet
 */
@WebServlet("/auth/proceedOrder")
public class ProceedOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProceedOrderServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mybag = (String)request.getSession().getAttribute("bag");
		String[] trip = mybag.split(",");
		Long id;
		Long idbooster = (Long)request.getSession().getAttribute("idbooster");
		Etudiants myEtudiant = DaoFactory.getDaoFactory().getEtudiantDao().findEtudiantById(idbooster);
		
		ArrayList<Commandes> OrderList = new ArrayList<Commandes>();
		for(int i=0;i<trip.length;i++)
		{
			String CurrentTrip = trip[i];
			String[] Split = CurrentTrip.split(";");
			id = Long.parseLong(Split[0]);
			
			String CampusDepart = Split[1];
			Trip thatTrip = DaoFactory.getDaoFactory().getTripDao().findTripById(id);
			Commandes myCommande = new Commandes(myEtudiant, thatTrip, CampusDepart);
			DaoFactory.getDaoFactory().getCommandesDao().addCommande(myCommande);
			OrderList.add(myCommande);
		}
		request.getSession().setAttribute("Order", OrderList);
		request.getSession().removeAttribute("bag");
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Front/auth/proceedOrder.jsp");
		rd.forward(request, response);
	}

}
