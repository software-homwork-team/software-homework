package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.Student;
import com.entity.Teacher;
import com.util.DBconn;
import com.util.StudentDBconn;

public class TeacherDaoImp implements TeacherDao{

	@Override
	public boolean login(int id, String pwd) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			    StudentDBconn.init();
				ResultSet rs = StudentDBconn.selectSql("select * from Teacher where id='"+id+"' and pwd='"+pwd+"'");
				
				while(rs.next()){
					String s=rs.getString("id");
					int a=Integer.valueOf(s);
					if(a==id && rs.getString("pwd").equals(pwd)){
						System.out.println("exc teeacher.login");
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
	public boolean register(Teacher teacher) {
		// TODO Auto-generated method stub
		boolean flag = false;
		StudentDBconn.init();
		//妈蛋主键去哪里了
		int i =StudentDBconn.addUpdDel("insert into Teacher(id,name,pwd,position) " +
				"values('"+teacher.getId()+"','"+teacher.getName()+"','"+teacher.getPwd()+"','"+teacher.getPosition()+"')");
		
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
		String sql = "delete from Teacher where id="+id;
		int i =StudentDBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		StudentDBconn.closeConn();
		return flag;
	}

	@Override
	public boolean update(int id, String name, String pwd, String position) {
		// TODO Auto-generated method stub
		boolean flag = false;
		StudentDBconn.init();
		String sql ="update Teacher set name ='"+name				
				+"' , position ='"+position+"' where id = "+id;
		int i =StudentDBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		StudentDBconn.closeConn();
		return flag;
	}

	@Override
	public Teacher getTeacher() {
		// TODO Auto-generated method stub
		Teacher teacher=new Teacher();
		try {
			StudentDBconn.init();
			ResultSet rs = DBconn.selectSql("select * from Teacher where id=1");
			//System.out.println(rs);
			while(rs.next()){
				//System.out.println(rs.getInt(1));
				
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				teacher.setPwd(rs.getString("pwd"));				
				teacher.setPosition(rs.getString("position"));
				//list.add(user);
			}
			StudentDBconn.closeConn();
			///return user;
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		return teacher;
	}

}
