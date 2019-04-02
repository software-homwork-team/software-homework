package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CourseDao;
import com.dao.CourseDaoImp;
import com.dao.StudentDao;
import com.dao.StudentDaoImp;

public class Student_Submit_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		String tname=request.getParameter("tname");//tname��ʦ����
		String position=request.getParameter("position");
		String sname=request.getParameter("sname");//ѧ������
		String coursetime=request.getParameter("number");//һ��ѧ��һ��Լ
		
		
		String course4[]=new String[4];
		//���޸ĺ����ֵע�뵽course4��
		course4[0]="8";course4[1]="8";course4[2]="8";course4[3]="8";
		//��ɺ�
		CourseDao course =new CourseDaoImp();//��һ�����γ̸�д
		if(course.SubmitCourse(month, day, tname, course4)) {
			System.out.println("��ɶ�course����޸�����");
		}
		//����Ҫ�����ݽ�Sappointment�����ѧ��ԤԼ��Ϣ��
		StudentDao student=new StudentDaoImp();
		if(student.Write_Sappointment(sname, tname, month, day, coursetime, position)) {
			System.out.println("��ɶ�Sappointment����޸�����");
		}
		
		
		
		
		
		
		
		
	}

}