package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.dao.StudentDaoImp;

public class Student_Search_Servlet  extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		
//		StudentDao stu=new StudentDaoImp();
//		
//		if(stu.login(Integer.valueOf(id), pwd)){
//			request.setAttribute("xiaoxi", "��ӭ�û�"+id);
//			request.getRequestDispatcher("/success.jsp").forward(request, response);
//		}else{
//			response.sendRedirect("index.jsp");
//		}
		System.out.println("-------------2---------");
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		String tname=request.getParameter("tname");//tname��ʦ����
		System.out.println(month+day+tname);
		System.out.println(tname);
		System.out.println("-------------1---------");
		/*CourseDao course =new CourseDaoImp();
		if(course.SearchCourse(month, day, tname)) {
			System.out.println("����Ҫ���ذ˽ڿε����");
			System.out.println(CourseDaoImp.cour);//��̬��������String�������γ�
		}
		
		
		String course4[]=new String[4];*/
		//���޸ĺ����ֵע�뵽course4��
		/*
		 * */
		//��ɺ�
		
		
	}

}