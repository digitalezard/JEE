package com.suptrip.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suptrip.dao.DaoFactory;
import com.suptrip.model.Etudiants;


@WebFilter("/auth/*")
public class AuthenticateFilter implements Filter {

    public AuthenticateFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest 	req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Long idbooster = (Long) req.getSession().getAttribute("idbooster");
	
		
		if(idbooster != null)
		{
			chain.doFilter(request, response);
		}
		else
		{
			res.sendRedirect(req.getContextPath() + "/");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		
	}

}
