package com.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Sappointment;
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

	@Override//删除Sappointment中的内容
	public boolean delete(String sname,String tname,String month,String day,String coursetime) {
		// TODO Auto-generated method stub
		boolean flag = false;
		StudentDBconn.init();
//		String sql = "delete from Student where id="+id;
		String sql="delete from Sappointment where sname='"+sname+"'and tname='"+tname
				+"'and month='"+month+"'and day='"+day+"'and coursetime='"+coursetime+"'";
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

	@Override
	public boolean Write_Sappointment(String sname, String tname, String month, String day, String coursetime,
			String position) {
		// TODO Auto-generated method stub
		boolean flag = false;
//		try {
		StudentDBconn.init();
		//妈蛋主键去哪里了
		int i =StudentDBconn.addUpdDel("insert into Sappointment(month,day,sname,tname,position,coursetime) " +
				"values('"+month+"','"+day+"','"+sname+"','"+tname+"','"+position+"','"+coursetime+"')");
		
		if(i>0){
			flag = true;
		}
		StudentDBconn.closeConn();
//		}catch (Exception e)
//		{System.out.println("fuck appointment");}
		return flag;
		
	}

	@Override
	public List<Sappointment> getSappointment(String sname) {
		// TODO Auto-generated method stub
		List<Sappointment> list = new ArrayList<Sappointment>();
    	try {
    		StudentDBconn.init();
    		String sql="select * from Sappointment where sname='"+sname+"'";
			ResultSet rs = StudentDBconn.selectSql(sql);
			while(rs.next()){

				Sappointment sappointment=new Sappointment();
				sappointment.setCoursetime(rs.getString("coursetime"));
				sappointment.setDay(rs.getString("day"));
				sappointment.setMonth(rs.getString("month"));
				sappointment.setSname(rs.getString("sname"));
				sappointment.setPosition(rs.getString("position"));
				
				sappointment.setTname(rs.getString("tname"));
				list.add(sappointment);

			}
			StudentDBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
