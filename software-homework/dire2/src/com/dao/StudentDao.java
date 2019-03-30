package com.dao;
import java.util.List;

import com.entity.Student;

public interface StudentDao {
	public boolean login(int id,String pwd);
	public boolean register(Student stu);
	
	public boolean delete(int id) ;
	public boolean update(int id,String name, String pwd,String phone);
	public Student getStudent();//ĞÂÔö
}
