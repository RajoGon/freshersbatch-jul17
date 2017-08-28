package com.myserverhandler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;


public class ControllerServlet extends HttpServlet {
	ServletContext ctx;
	public void init(ServletConfig config){
		this.ctx = config.getServletContext();
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = null;
		session = request.getSession();
		String loginParam = request.getParameter("forward");
		String loginStatus = request.getParameter("loggedin");
		RequestDispatcher rd = null;
		if("authentic".equals(loginParam)){
			 rd = this.ctx.getRequestDispatcher("/login");
			 loginParam = null;
			rd.forward(request, response);	
		}
		else if("true".equals(loginStatus)){			
			String user = request.getParameter("username");			 
    		if(session.isNew()){
    			session.setAttribute("username", user);
    		}    		
			rd = this.ctx.getRequestDispatcher("/computerbooks?username="+session.getAttribute("username"));
			loginStatus = null;
			rd.forward(request, response);
		}
		else if("false".equals(loginStatus)){
			session.invalidate();

			rd = this.ctx.getRequestDispatcher("/login.html");
			loginStatus=null;
			rd.forward(request, response);
		}else if("historybooks".equals(loginParam)){
			String cbooks[] = request.getParameterValues("cbooks");			
		
			request.getSession(false).setAttribute("cbooks", cbooks);

			rd = this.ctx.getRequestDispatcher("/historybooks?username="+request.getSession(false).getAttribute("username"));
			loginStatus=null;
			rd.forward(request, response);
		}else if("cartpage".equals(loginParam)){
			String hbooks[] = request.getParameterValues("hbooks");			
			
			request.getSession(false).setAttribute("hbooks", hbooks);	
			rd = this.ctx.getRequestDispatcher("/cartpage?username="+request.getSession(false).getAttribute("username"));
			loginStatus=null;
			rd.forward(request, response);
		}	
	}
	
}
