<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录注册页面</title>
  </head>
  <body >
     <form action="Student_login_Servlet"  method="post"  style="padding-top:-700px;">
		ID：<input type="text" name="id"value=""><br><br>
 		密码：<input type="password" name="pwd"value=""><br><br>
	        <input type="submit"value="登录"name="denglu"><input type="reset"value="重置"><br>
	 </form>
	 <form action="Student_zhuce.jsp">
	 	<input type="submit"value="新用户注册">
     </form>   
  </body>
</html>