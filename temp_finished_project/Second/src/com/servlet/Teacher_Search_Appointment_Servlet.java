package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.StudentDaoImp;
import com.dao.TeacherDao;
import com.dao.TeacherDaoImp;
import com.entity.Sappointment;
import com.entity.Tappointment;

public class Teacher_Search_Appointment_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String tname=request.getParameter("sname");
		
//		StudentDao sd=new StudentDaoImp();
//
//		List<Sappointment> list=sd.getSappointment(sname);
//		
//		
//		System.out.println(list.size());
		TeacherDao td=new TeacherDaoImp();
		List<Tappointment> list=td.getTappointment(tname);
		System.out.println(list.size());
		
		
		
		
		
		
	}

}