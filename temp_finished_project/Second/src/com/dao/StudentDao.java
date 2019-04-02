package com.dao;
import java.util.List;

import com.entity.Sappointment;
import com.entity.Student;
import com.entity.User;

public interface StudentDao {
	public boolean login(int id,String pwd);
	public boolean register(Student stu);
	
	public boolean delete(String sname,String tname,String month,String day,String coursetime) ;
	public boolean update(int id,String name, String pwd,String phone);
	public Student getStudent();//ÐÂÔö
	public boolean Write_Sappointment
	(String sname,String tname,String month,String day,String coursetime,String position);//Ð´Sappointment
	public List<Sappointment> getSappointment(String sname);
	
}
