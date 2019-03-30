package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.StudentDaoImp;
import com.dao.TeacherDao;
import com.dao.TeacherDaoImp;
import com.entity.Student;
import com.entity.Teacher;

public class Teacher_zhuce_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String position = request.getParameter("position");
		System.out.println(666666);

		
		
		
		Teacher teacher=new Teacher();
		teacher.setId(Integer.valueOf(id));
		teacher.setName(name);
		teacher.setPwd(pwd);
		teacher.setPosition(position);
		
		TeacherDao td =new TeacherDaoImp();
		
		
		if(td.register(teacher)){
			//request.setAttribute("username", name);
			
			request.getRequestDispatcher("/Teacherlogin.jsp").forward(request, response);
		}else{
			
			response.sendRedirect("index.jsp");
		}
	}
}