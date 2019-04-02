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
import com.dao.UserDao;
import com.dao.UserDaoImpl;

public class Delete_Appointment_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		
		String  sname= request.getParameter("sname");
		String  tname= request.getParameter("tname");
		String  month= request.getParameter("month");
		String  day= request.getParameter("day");
		String  coursetime= request.getParameter("coursetime");
		
		StudentDao sd=new StudentDaoImp();
		TeacherDao td=new TeacherDaoImp();
		if (sd.delete(sname, tname, month, day, coursetime)&&td.delete(sname, tname, month, day, coursetime)) {
			System.out.println("取消预约成功");
		}
		
		
	}

}