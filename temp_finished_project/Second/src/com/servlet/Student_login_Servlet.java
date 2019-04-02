package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.StudentDaoImp;
import com.dao.UserDao;
import com.dao.UserDaoImpl;

public class Student_login_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		StudentDao stu=new StudentDaoImp();
		
		if(stu.login(Integer.valueOf(id), pwd)){
			request.setAttribute("xiaoxi", "ª∂”≠”√ªß"+id);
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}else{
			response.sendRedirect("index.jsp");
		}
	}

}
