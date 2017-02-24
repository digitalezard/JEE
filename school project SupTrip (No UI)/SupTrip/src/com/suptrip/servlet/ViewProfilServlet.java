package com.suptrip.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suptrip.model.Campus;
import com.suptrip.model.Etudiants;
import com.suptrip.dao.DaoFactory;
/**
 * Servlet implementation class ViewProfilServlet
 */
@WebServlet("/auth/viewProfil")
public class ViewProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProfilServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long myidbooster = (Long)(request.getSession().getAttribute("idbooster"));/*On recupère le panier*/
		Etudiants myStudent = DaoFactory.getDaoFactory().getEtudiantDao().findEtudiantById(myidbooster);
		List<Campus> CampusList = DaoFactory.getDaoFactory().getCampusDao().getAllCampus();
		request.getSession().setAttribute("listCampus", CampusList);
		request.getSession().setAttribute("student", myStudent);
		if(request.getParameter("setProfil") != null)
		{
			String SetProfil = request.getParameter("setProfil");
			request.getSession().setAttribute("setprofil", SetProfil);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/Front/auth/viewProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
