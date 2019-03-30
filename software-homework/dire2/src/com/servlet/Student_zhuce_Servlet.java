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
import com.entity.Student;
import com.entity.User;

public class Student_zhuce_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		System.out.println("you're zhuce ing");
//		User user = new User();
//		user.setId(Integer.valueOf(id));
//		user.setName(name);
//		user.setPwd(pwd);
//		user.setInfo(info);
//		
//		UserDao ud = new UserDaoImpl();
		Student stu=new Student();
		stu.setId(Integer.valueOf(id));
		stu.setName(name);
		stu.setPwd(pwd);
		stu.setPhone(phone);
		
		StudentDao st=new StudentDaoImp();
		
		if(st.register(stu)){
			//request.setAttribute("username", name);
			System.out.println("you finish zhuce");
			request.getRequestDispatcher("/Studentlogin.jsp").forward(request, response);
		}else{
			
			response.sendRedirect("index.jsp");
		}
	}
}