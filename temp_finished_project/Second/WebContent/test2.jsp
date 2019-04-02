<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录注册页面</title>
  </head>
  <body >
     <form action="Student_Submit_Servlet"  method="post"  style="padding-top:-700px;">
		month：<input type="text" name="month"value="3"><br><br>
 		day：<input type="text" name="day"value="1"><br><br>
 		sname：<input type="text" name="sname"value="wang"><br><br>
 		tname：<input type="text" name="tname"value="xie"><br><br>
 		coursetime：<input type="text" name="coursetime"value="7"><br><br>
 		position：<input type="text" name="coursetime"value="北509"><br><br>
 		
	        <input type="submit"value="提交"name="denglu"><input type="reset"value="重置"><br>
	 </form>
	 <!--    <form action="Student_zhuce.jsp">     -->
	 <form action="Student_Submit_Servlet">
	 	<input type="submit"value="新用户注册">
     </form>
    
  </body>
</html>