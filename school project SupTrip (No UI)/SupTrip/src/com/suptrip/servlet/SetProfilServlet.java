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
import com.suptrip.model.Etudiants;

/**
 * Servlet implementation class SetProfilServlet
 */
@WebServlet("/auth/setProfil")
public class SetProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetProfilServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long myidbooster = (Long)(request.getSession().getAttribute("idbooster"));/*On recupère le panier*/
		Etudiants myStudent = DaoFactory.getDaoFactory().getEtudiantDao().findEtudiantById(myidbooster);
		
		Long CampusId = Long.parseLong(request.getParameter("campusId"));
		Campus myCampus = DaoFactory.getDaoFactory().getCampusDao().findCampusById(CampusId);
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String Mail = request.getParameter("mail");
		String Password = request.getParameter("password");
		String errorfN, errorlN, errorEmail;
		    
		if(firstName.length() != 0 && firstName != null)
		{
			if (!firstName.matches("[A-Za-z]+")) {
	    		System.out.println("pas string fN");
	    		errorfN = "votre prenom ne  doit être composé que de lettre";
	    		request.setAttribute("fnErr", errorfN);
	    	}
			else
			{
				errorfN = null;
				
			}
		}
		else
		{
			errorfN = null;
			firstName = myStudent.getFirstName();
		}
		
		if(lastName.length() != 0 && lastName != null)
		{
			if (!lastName.matches("[A-Za-z]+")) {
	    		System.out.println("pas string lN");
	    		errorlN = "votre Nom ne  doit être composé que de lettre";
	    		request.setAttribute("lnErr", errorlN);
	    	}
		    else
		    {
		    	errorlN = null;
		    	
		    }
		}
		else
		{
			errorlN = null;
			lastName = myStudent.getLastName();
		}
		
		if(Mail.length() != 0 && Mail != null)
		{
			if (!Mail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
	    		System.out.println("pas Mail");
	    		errorEmail = "votre email n'est pas valide";
	    		request.setAttribute("MailErr", errorEmail);
	    	}
		    else
		    {
		    	errorEmail = null;
		    }
		}
		else
		{
			errorEmail = null;
			Mail = myStudent.getMail();
		}
		
		if(Password.length() != 0 && Password != null)
		{
			
		}
		else
		{
			Password = myStudent.getMdp();		
		}
		
		if(errorfN != null || errorlN != null || errorEmail != null)
	    {
	    	RequestDispatcher rd = request.getRequestDispatcher("/auth/viewProfil");
			rd.forward(request, response);
	    }
		else 
		{
			myStudent.setCampus(myCampus);
			myStudent.setFirstName(firstName);
			myStudent.setLastName(lastName);
			myStudent.setMail(Mail);
			myStudent.setMdp(Password);
			
			DaoFactory.getDaoFactory().getEtudiantDao().updateEtudiant(myStudent);
			request.getSession().removeAttribute("setprofil");
			request.removeAttribute("MailErr");
			request.removeAttribute("lnErr");
			request.removeAttribute("fnErr");
			RequestDispatcher rd = request.getRequestDispatcher("/auth/viewProfil");
			rd.forward(request, response);
		}
	}

}
