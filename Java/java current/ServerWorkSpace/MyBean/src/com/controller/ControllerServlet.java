package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.LoginBean;
import com.bean.ShopBean;

public class ControllerServlet extends HttpServlet {
	ServletContext ctx;
	public void init(ServletConfig config){
		this.ctx = config.getServletContext();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = null;
		ShopBean sbean = new ShopBean();
		ArrayList<String> myBooks = new ArrayList<String>();
		String loginParam = request.getParameter("forward");

		RequestDispatcher rd = null;
		if("authentic".equals(loginParam)){
			LoginBean loginBean = new LoginBean(request.getParameter("uname"), request.getParameter("password"));
			boolean login = loginBean.login();
			if(login==true){
				 session = request.getSession();
				if(session.isNew()){
					session.setAttribute("uname", request.getParameter("uname"));
				}
				rd = this.ctx.getRequestDispatcher("/computerbooks.jsp");
			}else{
				rd = this.ctx.getRequestDispatcher("/login.html");
			}
			rd.forward(request, response);	
		}else if("historybooks".equals(loginParam)){
			
			String cbooks[] = request.getParameterValues("cbooks");						
			sbean.addBooks(cbooks);
			rd = this.ctx.getRequestDispatcher("/historybooks.jsp");
			rd.forward(request, response);
			
		}else if("cartpage".equals(loginParam)){
			
			String hbooks[] = request.getParameterValues("hbooks");						
			sbean.addBooks(hbooks);
			myBooks = sbean.getBooks();
			request.setAttribute("books", myBooks);
			rd = this.ctx.getRequestDispatcher("/mycart.jsp");
			rd.forward(request, response);
			
		}else if("logout".equals(loginParam)){				
			request.getSession().invalidate();
			rd = this.ctx.getRequestDispatcher("/login.html");
			rd.forward(request, response);
		}
	}
}
