package com.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;
import com.entity.User;
import com.util.DBconn;
import com.util.StudentDBconn;
public class StudentDaoImp implements StudentDao{

	
	@Override
	public boolean login(int id, String pwd) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			    StudentDBconn.init();
				ResultSet rs = StudentDBconn.selectSql("select * from Student where id='"+id+"' and pwd='"+pwd+"'");
				while(rs.next()){
					String s=rs.getString("id");
					int a=Integer.valueOf(s);
					if(a==id && rs.getString("pwd").equals(pwd)){
					//if(rs.getInt("id").equals(id) && rs.getString("pwd").equals(pwd)){
						System.out.println("exc student.login");
						flag = true;
					}
				}
				StudentDBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean register(Student stu) {
		// TODO Auto-generated method stub
		boolean flag = false;
		StudentDBconn.init();
		//妈蛋主键去哪里了
		int i =StudentDBconn.addUpdDel("insert into Student(id,name,pwd,phone) " +
				"values('"+stu.getId()+"','"+stu.getName()+"','"+stu.getPwd()+"','"+stu.getPhone()+"')");
		
		if(i>0){
			flag = true;
		}
		StudentDBconn.closeConn();
		return flag;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		StudentDBconn.init();
		String sql = "delete from Student where id="+id;
		int i =StudentDBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		StudentDBconn.closeConn();
		return flag;
	}

	@Override
	public boolean update(int id, String name, String pwd, String phone) {
		// TODO Auto-generated method stub
		boolean flag = false;
		StudentDBconn.init();
		String sql ="update Student set name ='"+name				
				+"' , phone ='"+phone+"' where id = "+id;
		int i =StudentDBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		StudentDBconn.closeConn();
		return flag;
	}

	@Override
	public Student getStudent() {
		// TODO Auto-generated method stub
		Student stu=new Student();
		try {
			StudentDBconn.init();
			ResultSet rs = DBconn.selectSql("select * from Student where id=160400306");
			//System.out.println(rs);
			while(rs.next()){
				//System.out.println(rs.getInt(1));
				
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setPwd(rs.getString("pwd"));				
				stu.setPhone(rs.getString("phone"));
				//list.add(user);
			}
			StudentDBconn.closeConn();
			///return user;
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		return stu;
	}

}
