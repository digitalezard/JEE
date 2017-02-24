package com.suptrip.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suptrip.dao.DaoFactory;
import com.suptrip.model.Pays;
/**
 * Servlet implementation class AddPaysServlet
 */
@WebServlet("/auth/addPays")
public class AddPaysServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public AddPaysServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Front/auth/addPays.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("PaysName");
		
		Pays p = new Pays();
		p.setCountryName(name);
		
		DaoFactory.getDaoFactory().getPaysDao().addPays(p);
		request.setAttribute("success", "Pays ajouté!");
		
		doGet(request, response);
	}

}
