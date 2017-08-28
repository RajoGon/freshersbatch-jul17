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
import javax.servlet.http.HttpSession;

public class LoginHandle extends HttpServlet {
	ServletContext ctx;
	
	public void init(ServletConfig config){
		this.ctx = config.getServletContext();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		
		String username = request.getParameter("uname");
    	if(request.getParameter("uname").equals(request.getParameter("password"))){
    		
    		RequestDispatcher rd = this.ctx.getRequestDispatcher("/controller?forward=false&loggedin=true&username="+username);
			rd.forward(request, response);
    	}
    	else{
    		RequestDispatcher rd = this.ctx.getRequestDispatcher("/controller?forward=false&loggedin=false");
			rd.forward(request, response);
    	}
	}
	public void doGet(){
		
	}

}
