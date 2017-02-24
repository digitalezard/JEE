package com.suptrip.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/auth/addInBag")
public class AddInBagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInBagServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String campusDepart = request.getParameter("campusdepart");
		String itm = id.toString()+";"+ campusDepart +",";
		String bag = (String)request.getSession().getAttribute("bag");
		
		if(bag != null)
		{
			bag = bag + itm;
		}
		else
		{
			bag = itm;
		}
		System.out.println(bag);/**/
		request.getSession().setAttribute("bag", bag);
		RequestDispatcher rd = request.getRequestDispatcher("/Front/auth/redirectChoice.jsp");
		rd.forward(request, response);
	}

}
