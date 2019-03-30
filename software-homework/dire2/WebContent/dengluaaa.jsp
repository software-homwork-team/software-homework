<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>登录页面</title>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
    <div class="main">
        <h1>
            登录系统
        </h1>
        <!-- <form action="Student_login_Servlet"  method="post"  style="padding-top:-700px;"> -->
            <input type="text" id="id" name="id" value="用户名" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '用户名';}"
            required="required">
            <input type="password" id="pwd" name="pwd" value="Password" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '用户名';}"
            required="required">
            <center><input type="submit" id="button" onclick="ajaxFun()" value="登录"></center>
            <br>
        <!-- </form>-->

        <form action="Student_zhuce.jsp">
            <center><input type="submit" value="注册"></center>
        </form>
    </div>
</body>
</html>
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
    /*$("button").click(function(){
        $.post("Student_login_Servlet",
        {
            id:$("#id").val(),
            pwd:$("#pwd").val()
        },
            function(data,status){
            alert("数据: \n" + data + "\n状态: " + status);
        });
    });*/
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

<style>
body{
    font-family: 'Cabin', sans-serif !important;
	background:url(ft.jpg) 0px 0px;
}
.main{
	width: 35%;
    margin: 8em auto 0;
    padding: 0em 4em 5em;
}
.main h1{
	color: blueviolet;
    text-align: center;
    font-size: 2.5em;
    margin: 0 0 1.5em;
}
.main input[type="text"]{
	outline: none;
    border: 1px solid red;
    background: white;
    border-radius: 5px;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    -o-border-radius: 5px;
    -ms-border-radius: 5px;
    padding: 15px 10px;
    width: 96%;
    font-size: 1.3em;
    color: blue;
    text-align: center;
    font-family: 'Syncopate', sans-serif;
    background-image:url(.../html/banner.jpg);
}
.main input[type="password"]{
	margin:1.5em 0;
	outline: none;
    border: 1px solid red;
    background: white;
    border-radius: 5px;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    -o-border-radius: 5px;
    -ms-border-radius: 5px;
    padding: 15px 10px;
    width: 96%;
    font-size: 1.3em;
    color: blue;
    text-align: center;
    font-family: 'Syncopate', sans-serif;
}
.main input[type="submit"]{
	outline:none;
	border:1px solid red;
	background:rgba(134, 115, 8, 0.116);
	border-radius:20px;
	-webkit-border-radius:10px;
	-moz-border-radius:10px;
	-o-border-radius:10px;
	-ms-border-radius:10px;
	padding:15px 10px;
    width:66%;
	color:blue;
	font-size:1.3em;
	font-family: 'Syncopate', sans-serif;
    cursor:pointer;

}
.main input[type="submit"]:hover{
	background:#fed2ed;
	color:#b47c9f;
	border: 1px solid #FFF;
}
</style>