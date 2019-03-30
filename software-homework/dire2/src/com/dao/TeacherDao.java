package com.dao;


import com.entity.Teacher;

public interface TeacherDao {
	public boolean login(int id,String pwd);
	public boolean register(Teacher teacher);
	
	public boolean delete(int id) ;
	public boolean update(int id,String name, String pwd,String position);
	public Teacher getTeacher();//ĞÂÔö
}
