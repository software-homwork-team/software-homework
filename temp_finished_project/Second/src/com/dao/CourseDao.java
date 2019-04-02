package com.dao;

public interface CourseDao {
	public boolean SearchCourse(String month,String day,String name);
	public boolean SubmitCourse(String month,String day,String name,String course4[]);
}
