package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CourseDao;
import com.dao.CourseDaoImp;

public class Student_Submit_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		String tname=request.getParameter("tname");//tname老师名字
		
//		CourseDao course =new CourseDaoImp();
//		if(course.SearchCourse(month, day, tname)) {
//			System.out.println("这里要返回八节课的情况");
//			System.out.println(CourseDaoImp.cour);//静态变量返回String数组代表课程
//		}
		System.out.println(month+day+tname);
		System.out.println("------1---------");
		/*String course4[]=new String[4];
		//将修改后的数值注入到course4中
		course4[0]="8";course4[1]="8";course4[2]="8";course4[3]="8";
		//完成后
		CourseDao course =new CourseDaoImp();//下一步将课程改写
		if(course.SubmitCourse(month, day, tname, course4)) {
			System.out.println("完成对course表的修改啦啦");
		}*/
		
	}

}