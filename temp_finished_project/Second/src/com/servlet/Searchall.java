package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

public class Searchall extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDao ud = new UserDaoImpl();
		List<User> userAll = ud.getUserAll();
		
		for(int i=0;i<userAll.size();i++) {
			System.out.println(userAll.get(i).getId());
		}
		
		//System.out.println("what is the userall bugs:"+userAll.size());
		//request.setAttribute("userAll", userAll);
		//request.getRequestDispatcher("/showall.jsp").forward(request, response);
		
		
//		UserDao ud = new UserDaoImpl();
//		User u=ud.getUser();
//		System.out.println(u.getInfo());
//		System.out.println(u.getId());
//		System.out.println(u.getHome());
//		System.out.println(u.getName());
//		System.out.println(u.getPwd());
//		System.out.println(u.getSex());
//		request.getRequestDispatcher("/hh.jsp").forward(request, response);
	}
}
