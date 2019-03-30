package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.StudentDBconn;
import com.dao.*;
public class CourseDaoImp implements CourseDao{
	public static String cour[]= new String[4];
	@Override
	public boolean SearchCourse(String month, String day, String tname) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
		    StudentDBconn.init();
		    ResultSet rs = StudentDBconn.selectSql(""
		    		+ "select * from Course , Teacher where "
		    		+ "( Teacher.name='xie'"//+tname+
		    		+" and Teacher.id=Course.id and month="+month+" and day="+day+")");		    
		    while(rs.next()){
		    	//int cour[]= new int[4];
		    	for(int i=0;i<4;i++) {
		    		cour[i]=String.valueOf(rs.getInt(4+i));//course表从第四列开始是课程，课程是String型
		    	}
//		    	测试输出成功
//		    	System.out.println("exc finding teacher‘s course in coursedaoimp"
//		    	+cour[0]+cour[1]+cour[2]+cour[3]);
		    	flag=true;
				}
		    StudentDBconn.closeConn();			
	} catch (SQLException e) {
		e.printStackTrace();}
	
	return flag;
}
	@Override
	public boolean SubmitCourse(String month, String day, String name, String course4[]) {
		// TODO Auto-generated method stub
		//测试用例建立一个数组替代course4
				char temp[]= {'1','1','1','1'};
				//com.microsoft.sqlserver.jdbc.SQLServerException: 该语句没有返回结果集。
				//JDBC 就是个sb，这里update本来就没有返回值
				boolean flag = false;
				try {
				    StudentDBconn.init();
				    ResultSet rs = StudentDBconn.selectSql(""	    
				    		+"update Course set course1="+"'"+temp[0]+"',"
				    				+"course2="+"'"+temp[1]+"',"
				    						+"course3="+"'"+temp[1]+"',"
				    								+"course4="+"'"+temp[3]+"'"
				    			+"where( month="+"'"+month+"'"+" and day="+"'"+day+"'" 
				    									
				    								+"and id="+"'"+1998+"'"+")"		
				    		);		    	
				    	flag=true;		    	
				    	 StudentDBconn.closeConn();				    	
						}catch (Exception e) {
				e.printStackTrace();}
			
			return flag;
			}
	

}
