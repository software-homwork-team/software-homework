package com.dao;


import java.util.List;

import com.entity.Sappointment;
import com.entity.Tappointment;
import com.entity.Teacher;

public interface TeacherDao {
	public boolean login(int id,String pwd);
	public boolean register(Teacher teacher);
	
	public boolean delete(String sname,String tname,String month,String day,String coursetime) ;
	public boolean update(int id,String name, String pwd,String position);
	public Teacher getTeacher();//新增
	public String getPosition(String name);//在学生搜索页面显示老师办公室的位置
	public List<Tappointment> getTappointment(String tname);
}
