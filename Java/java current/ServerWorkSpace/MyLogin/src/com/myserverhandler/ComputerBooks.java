package com.myserverhandler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComputerBooks extends HttpServlet {
	ServletContext ctx;
	public void init(ServletConfig config){
		this.ctx = config.getServletContext();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
    	String username = request.getParameter("username");
    	PrintWriter out = response.getWriter();
    	out.println("<html>"
    			+ "<head>"
    			+ "<meta charset='ISO-8859-1'>"
    			+ "<title>Computer Books</title>"
    			+"</head>"
    			+ "<body>"
    			+ "<h1>Welcome "+ username+ "</h1>"
    			+ "</body>"
    			+ "</html>"
    			+ "<form action='controller?forward=historybooks' method='post' >"
    			+ "<input type='checkbox' name='cbooks' value='C'> C<br>"
    			+ "<input type='checkbox' name='cbooks' value='C++' > C++<br>"
    			+ "<input type='checkbox' name='cbooks' value='Java' > Java<br>"
    			+ "<input type='submit' value='Submit'>"
    			+ "</form>"
    			);
	}
	public void doGet(){
		
	}

}
