package com.tcs.ilp.tsis.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.tsis.model.Login;
import com.tcs.ilp.tsis.dao.InventoryDao;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
		response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
		response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
		response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
		 
		RequestDispatcher rd = null;
		ServletContext ctx = null;
		ctx = getServletContext();
		 		 
		HttpSession session = request.getSession(false);	

		if(request.getParameter("login")!=null && session.getAttribute("username")==null){
			 
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//Here The LoginDAO and Validate
			Login login = new Login();
			login.setUsername(username);
			login.setPassword(password);
			System.out.println("Hello Establish Login");
			Login validlogin = null;
			try {
				if((validlogin=InventoryDao.validateInvManager(login))!=null)
				{
					System.out.println("Established and came");
					HttpSession session1 = request.getSession(true);	 
					
					session1.setAttribute("username", validlogin.getUsername());
					session1.setAttribute("role", validlogin.getRole());
					
					response.sendRedirect("/Project/JspPages/Home.jsp");	 
				}
				else
				{
					 
					response.sendRedirect("/Project/JspPages/login.jsp?valid=false");
					
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			 
		}	
		else
		{
			
			if(session!=null)
			{			 
				session.invalidate();
			}
			response.sendRedirect("/Project/JspPages/login.jsp");
			 
		 }
	}

}
