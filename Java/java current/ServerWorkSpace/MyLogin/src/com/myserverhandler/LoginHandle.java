package com.myserverhandler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandle extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
    	if(request.getParameter("uname").equals(request.getParameter("password"))){
    		
    		PrintWriter out= response.getWriter(); 
        	out.println("<h1>Logged in<h1>");
    	}		
	}
	public void doGet(){
		
	}

}
