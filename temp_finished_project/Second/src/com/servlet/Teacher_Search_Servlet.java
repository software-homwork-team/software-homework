package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CourseDao;
import com.dao.CourseDaoImp;

public class Teacher_Search_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		String tname=request.getParameter("tname");//tname��ʦ����
		
		CourseDao course =new CourseDaoImp();
		if(course.SearchCourse(month, day, tname)) {
			System.out.println("����Ҫ���ذ˽ڿε����");
			System.out.println(CourseDaoImp.cour);//��̬��������String�������γ�
		}
		
		
		String course4[]=new String[4];
		//���޸ĺ����ֵע�뵽course4��
		/*
		 * */
		//��ɺ�
		
		
	}

}