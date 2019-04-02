package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

public class DengluServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		UserDao ud = new UserDaoImpl();
		
		if(ud.login(name, pwd)){
			request.setAttribute("xiaoxi", "ª∂”≠”√ªß"+name);
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}else{
			response.sendRedirect("index.jsp");
		}
	}

}
