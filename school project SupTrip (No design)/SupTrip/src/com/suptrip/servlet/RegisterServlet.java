package com.suptrip.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suptrip.dao.DaoFactory;
import com.suptrip.model.Campus;
import com.suptrip.model.Etudiants;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Campus> listCampus = DaoFactory.getDaoFactory().getCampusDao().getAllCampus();
		request.setAttribute("campus", listCampus);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Front/register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Campus> listCampus = DaoFactory.getDaoFactory().getCampusDao().getAllCampus();
		request.setAttribute("campus", listCampus);
		
		String campusId 	= request.getParameter("campusId");
		String idBooster = request.getParameter("idBooster");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String Mail = request.getParameter("Mail");
		String Mdp = request.getParameter("Mdp");
		String errorfN, errorlN, errorEmail;
		String errorId = null;
		
	    try {
	        long cetid = Long.parseLong(idBooster);
	    } catch (NumberFormatException nfe) {
	        errorId = "votre idbooster ne  doit être composé que de chiffre";
	        request.setAttribute("IdControle", errorId);
	    }
	    
	    if (!firstName.matches("[A-Za-z]+")) {
	    		System.out.println("pas string fN");
	    		errorfN = "votre prenom ne  doit être composé que de lettre";
	    		request.setAttribute("fnErr", errorfN);
	    	}
	    else
	    {
	    	errorfN = null;
	    }
	    
	    if (!lastName.matches("[A-Za-z]+")) {
    		System.out.println("pas string lN");
    		errorlN = "votre Nom ne  doit être composé que de lettre";
    		request.setAttribute("lnErr", errorlN);
    	}
	    else
	    {
	    	errorlN = null;
	    }
	    
	    if (!Mail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
    		System.out.println("pas Mail");
    		errorEmail = "votre email n'est pas valide";
    		request.setAttribute("MailErr", errorEmail);
    	}
	    else
	    {
	    	errorEmail = null;
	    }
	    
	    if(errorId != null || errorfN != null || errorlN != null || errorEmail != null)
	    {
	    	RequestDispatcher rd = request.getRequestDispatcher("/Front/register.jsp");
			rd.forward(request, response);
	    }
	    else
	    {
		Long CampusLongId = Long.parseLong(campusId);
		Long LongIdBooster = Long.parseLong(idBooster);
		
		Campus c = DaoFactory.getDaoFactory().getCampusDao().findCampusById(CampusLongId);
		
		Etudiants e = new Etudiants(LongIdBooster, firstName, lastName, Mail, Mdp, c);
		DaoFactory.getDaoFactory().getEtudiantDao().addEtudiant(e);
		
		request.setAttribute("etudiant", e);
		request.removeAttribute("IdControle");
		request.removeAttribute("MailErr");
		request.removeAttribute("lnErr");
		request.removeAttribute("fnErr");
		RequestDispatcher rd = request.getRequestDispatcher("/Front/login.jsp");
		rd.forward(request, response);
	    }
		
	}

}
