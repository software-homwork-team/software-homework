package com.util;

import java.sql.*;

public class StudentDBconn {
	static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";	
	static ResultSet rs = null;
	static PreparedStatement ps =null;
	static String dbsource="jdbc:sqlserver://localhost:1433;databaseName=First_web";
							//jdbc:sqlserver://localhost:1433;databaseName=
	static Connection  conn = null;
	public static void init(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dbsource,"sa","123456");
		} catch (Exception e) {
			System.out.println("init [SQL���������ʼ��ʧ�ܣ�]");
			e.printStackTrace();
		}
	}
	
	
	public static int addUpdDel(String sql){
		int i = 0;
		try {
			PreparedStatement ps =  conn.prepareStatement(sql);
			i =  ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql���ݿ���ɾ���쳣");
			e.printStackTrace();
		}
		
		return i;
	}
	public static ResultSet selectSql(String sql){
		try {
			ps =  conn.prepareStatement(sql);
			rs =  ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("sql���ݿ��ѯ�쳣");
			e.printStackTrace();
		}
		return rs;
	}
	public static void closeConn(){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("sql���ݿ�ر��쳣");
			e.printStackTrace();
		}
	}
}
