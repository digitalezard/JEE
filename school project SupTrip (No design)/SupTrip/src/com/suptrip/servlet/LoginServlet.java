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


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/Front/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Etudiants> listEtudiants = DaoFactory.getDaoFactory().getEtudiantDao().getAllEtudiants();
		
		String idBooster = (String)request.getParameter("idbooster");
		String pwd = (String) request.getParameter("pwd");
		Etudiants MatchStudent = null;
		Long idb = null;
		String passwd = null;
		
		
		for(Etudiants etud : listEtudiants)
		{
			idb = etud.getIdBooster();
			String idbooster = idb.toString();
			if(idbooster.equals(idBooster))
			{
				MatchStudent = etud;
			}
		}
		
		if(MatchStudent != null)
		{
			
			idb = MatchStudent.getIdBooster();
			String idbooster = idb.toString();
			passwd = MatchStudent.getMdp();
			
			if(idbooster.equals(idBooster) && passwd.equals(pwd)) 
			{
				request.getSession().setAttribute("idbooster", MatchStudent.getIdBooster());
				idb = MatchStudent.getIdBooster();
				
				if(idb == 213975)/*Le projet ne nécessitant pas de compte root, celui ci à été ajouté en dur simplement pour setter les données plus rapidement*/
				{
					request.getSession().setAttribute("root", true);
				}
				else
				{
					request.getSession().setAttribute("root", null);
				}
			}
			else
			{
				
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/auth/index");

	}

}
