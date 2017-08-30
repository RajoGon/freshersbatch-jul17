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

public class HistoryBooks extends HttpServlet {
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
    			+ "<title>History Books</title>"
    			+"</head>"
    			+ "<body>"
    			+ "<h1>Welcome "+ username+ "</h1>"
    			+ "</body>"
    			+ "</html>"
    			+ "<form action='controller?forward=cartpage' method='post' >"
    			+ "<input type='checkbox' name='hbooks' value='Indian History'> Indian History<br>"
    			+ "<input type='checkbox' name='hbooks' value='Roman History' > Roman History<br>"
    			+ "<input type='checkbox' name='hbooks' value='Greek History' > Greek History<br>"
    			+ "<input type='submit' value='Submit'>"
    			+ "</form>"
    			);
	}
	public void doGet(){
		
	}

}