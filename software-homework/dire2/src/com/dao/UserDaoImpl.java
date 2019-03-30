package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.util.DBconn;

public class UserDaoImpl implements UserDao{
	
	public boolean register(User user) {
		boolean flag = false;
		DBconn.init();
		//妈蛋主键去哪里了
		int i =DBconn.addUpdDel("insert into users(id,name,pwd,sex,home,info) " +
				"values('"+user.getId()+"','"+user.getName()+"','"+user.getPwd()+"','"+user.getSex()+"','"+user.getHome()+"','"+user.getInfo()+"')");
		
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
    public boolean login(String name, String pwd) {
		boolean flag = false;
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from users where name='"+name+"' and pwd='"+pwd+"'");
				while(rs.next()){
					if(rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)){
						flag = true;
					}
				}
				DBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<User> getUserAll() {
		List<User> list = new ArrayList<User>();
    	try {
		    DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from users");
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setSex(rs.getString("sex"));
				user.setHome(rs.getString("home"));
				user.setInfo(rs.getString("info"));
				list.add(user);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean update(int id,String name, String pwd,String sex, String home,String info) {
		boolean flag = false;
		DBconn.init();
		String sql ="update users set name ='"+name
				+"' , pwd ='"+pwd
				+"' , sex ='"+sex
				+"' , home ='"+home
				+"' , info ='"+info+"' where id = "+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	public boolean delete(int id) {
		boolean flag = false;
		DBconn.init();
		String sql = "delete  from users where id="+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	public User getUser() {
		User user = new User();
		try {
		    DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from users where id=160400306");
			//System.out.println(rs);
			while(rs.next()){
				System.out.println(rs.getInt(1));
				
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setSex(rs.getString("sex"));
				user.setHome(rs.getString("home"));
				user.setInfo(rs.getString("info"));
				//list.add(user);
			}
			DBconn.closeConn();
			///return user;
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		return user;
		}
};