<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--<html>
  <head>
    <title>登录注册页面</title>
  </head>
  <body >
     hh
    
  </body>
</html>-->

<html>

<body onload="startTime()">

  <!--  <form action="Student_Search_Servlet.java" method="post"  style="padding-top:-700px;">-->
		<input type="text" name="search" id="search" placeholder="请输入教师姓名">
		<!-- <span onclick="ajaxFun()">搜索</span> -->
		<input type="submit" id="button" onclick="ajaxFun()" value="搜索">



        <center>
            当前时间：<font color="red"><span id="nowDateTimeSpan"></span></font><br>
            <font color="green">
                <p id="distanceTimeP"></p>
            </font>
        </center>

    <table>
        <tr class="t2">
            <td id="id">id</td>
            <td id="名称">名称</td>
            <td id="血量">血量</td>
            <td id="伤害">伤害</td>
            <td><ins onclick="yuyue()" cursor=pointer>预约</ins></td>
        </tr>
        <tr class="t1">
            <td id="id1">1</td>
            <td id="名称1">gareen</td>
            <td>340</td>
            <td>58</td>
            <td><ins onclick="yuyue()" cursor=pointer>预约</ins></td>
        </tr>
        <tr class="t2">
            <td id="id2">2</td>
            <td id="名称2">teemo</td>
            <td>320</td>
            <td>76</td>
            <td><ins onclick="yuyue()" cursor=pointer>预约</ins></td>
        </tr>
        <tr class="t1">
            <td id="id3">3</td>
            <td id="名称3">annie</td>
            <td>380</td>
            <td>38</td>
            <td><ins onclick="yuyue()" cursor=pointer>预约</ins></td>
        </tr>
        <tr class="t2">
            <td id="id4">4</td>
            <td id="名称4">deadbrother</td>
            <td>400</td>
            <td>90</td>
            <td><ins onclick="yuyue()" cursor=pointer>预约</ins></td>
        </tr>
    </table>
</body>

</html>

<head>
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script language="JavaScript">
        function startTime() {
            var today = new Date();//定义日期对象     
            var yyyy = today.getFullYear();//通过日期对象的getFullYear()方法返回年      
            var MM = today.getMonth() + 1;//通过日期对象的getMonth()方法返回年月     
            var dd = today.getDate();//通过日期对象的getDate()方法返回日期       
            var hh = today.getHours();//通过日期对象的getHours方法返回小时     
            var mm = today.getMinutes();//通过日期对象的getMinutes方法返回分钟     
            var ss = today.getSeconds();//通过日期对象的getSeconds方法返回秒     
            // 如果分钟或小时的值小于10，则在其值前加0，比如如果时间是下午3点20分9秒的话，则显示15：20：09     
            MM = checkTime(MM);
            dd = checkTime(dd);
            mm = checkTime(mm);
            ss = checkTime(ss);
            var day; //用于保存星期（getDay()方法得到星期编号）  
            if (today.getDay() == 0) day = "星期日 ";
            if (today.getDay() == 1) day = "星期一 ";
            if (today.getDay() == 2) day = "星期二 ";
            if (today.getDay() == 3) day = "星期三 ";
            if (today.getDay() == 4) day = "星期四 ";
            if (today.getDay() == 5) day = "星期五 ";
            if (today.getDay() == 6) day = "星期六 ";
            document.getElementById('nowDateTimeSpan').innerHTML = yyyy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":" + ss + "   " + day;
            setTimeout('startTime()', 1000);//每一秒中重新加载startTime()方法   
        }

        function checkTime(i) {
            if (i < 10) {
                i = "0" + i;
            }
            return i;
        }

        function setTimer() {
            var targetDate = document.getElementById("target").value;
            var taget = new Date(targetDate);
            var now = new Date();
            var plus = taget.getTime() - now.getTime();//< !--得到的是毫秒-->  
            var day = parseInt(plus / 1000 / 60 / 60 / 24);
            var hour = parseInt(plus / 1000 / 60 / 60) - day * 24;
            var minute = parseInt(plus / 1000 / 60) - parseInt(plus / 1000 / 60 / 60) * 60;
            var second = parseInt(plus / 1000) - parseInt(plus / 1000 / 60) * 60;
            document.getElementById("distanceTimeP").innerHTML = "距离" + targetDate + "还剩" + day + "天" + hour + "时" + minute + "分" + second + "秒";
        }
        setInterval(setTimer, 1000);
        function getValue(name) {
            return document.getElementById(name).value;
        }
        function setValue(id, value) {
            document.getElementById(id).value = value;
        }
        function search(){
        	var a=getValue("search");
        	alert("hhhhhhh");
        }
        function ajaxFun(){
        	var today = new Date();//定义日期对象
        	var a={};
        	a.month=today.getMonth() + 1;
            a.day=today.getDate();
            //a.month=$("#名称").text();        
            //a.day=$("#血量").text();
            a.tname=$("#search").val();
            $.ajax({
                type: "POST",
                url: "Student_Search_Servlet",
                data: a,
                success: function(msg){
                     $.messager.alert('信息','模板保存成功');
                }
            })
        }
        function yuyue(){
        	var today = new Date();//定义日期对象
        	var a={};
        	a.month=today.getMonth() + 1;
            a.day=today.getDate();
            //a.month=$("#名称").text();        
            //a.day=$("#血量").text();
            a.tname=$("#search").val();
            $.ajax({
                type: "POST",
                url: "Student_Submit_Servlet",
                data: a,
                success: function(msg){
                     $.messager.alert('信息','模板保存成功');
                }
            })
        }
    </script>
    <style>
        table {
            width: 80%;
            text-align: center;
            border-collapse: collapse;
            line-height: 200%;

            left: 0;
            top: 0;
            right: 0;
            bottom: 0;
            margin: auto;
        }

        td {
            width: 20%;
        }

        tr {
            border-top: 1px solid lightgray;
            border-bottom: 1px solid lightgray;
        }



        .t1 {
            background: snow;
        }

        .t2 {
            background: white;
        }
        ins{
            cursor:pointer
        }
        ins:hover{
		color:#b47c9f;
		font-style:italic;
		font-weight:bold;
		}
    </style>
</head>
