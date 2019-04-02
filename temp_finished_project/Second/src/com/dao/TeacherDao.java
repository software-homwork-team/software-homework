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
	public Teacher getTeacher();//����
	public String getPosition(String name);//��ѧ������ҳ����ʾ��ʦ�칫�ҵ�λ��
	public List<Tappointment> getTappointment(String tname);
}
