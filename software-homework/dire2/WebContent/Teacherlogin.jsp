<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录注册页面</title>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
  </head>
  <body >
		ID：<input type="text" name="id"value=""><br><br>
 		密码：<input type="password" name="pwd"value=""><br><br>
	        <input type="submit" onclick="ajaxFun()" value="登录" name="denglu">
	        <input type="reset"value="重置"><br>
	 </form>
	 <form action="Teacher_zhuce.jsp">
	 	<input type="submit"value="新用户注册">
    <script>
    function getValue(id) {
        return document.getElementById(id).value;
    }
    function setValue(id, value) {
        document.getElementById(id).value = value;
    }
    function show(){
        var a=getValue("name");
        setValue("pwd",a);
    }
    function ajaxFun(){
    	var a={};
    	a.id=$("#id").val();
        a.pwd=$("#pwd").val();
        $.ajax({
            type: "POST",
            url: "Student_login_Servlet",
            data: a,
            success: function(msg){
                    $.messager.alert('信息','模板保存成功');
            }
        })
    }
</script>
  </body>
</html>