<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/logReg.css">

	<script type="text/javascript">
	function checkUname(){
        var sStudentID=document.getElementById("SStudentID");
        
         if(sStudentID.value == "")
        {
       		alert("用户名不能为空!");
       		sStudentID.focus();
           return false; 
        }
        return true; 
     }
     function del(){
       if(confirm("确定要退出吗？"))
       location="";
       return;
     }
  </script>
  </head>
  
  <body>
	<div class="box">
	<input type="button" value="X" style="border-radius:50px; border:1px solid; width:20; height:20; float:right;" onclick="del()"/> 
    	<h2>登录</h2>
       	<div id="error_box"></div>
     	<form action="servlet/LogRegServlet" method="post"  >
  			<input type="hidden" name="op" value="log"  />
  			<div class="input_box"> 
  				用户名:&nbsp;<input type="text" name="SStudentID" id="SStudentID"  placeholder="请输入正确的学号" onblur="return checkUname()"/>
  			</div>
  			<div class="input_box">
  				密&nbsp;码:&nbsp;<input type="password" name="SPwd" id="SPwd"  placeholder="请输入6~20位的密码"/>
        	</div>
        	<div class="input_box"> 
        		<input type="submit" value="登录" name="log" id="log" class="btn"  />
        	</div>
        	<a href="reg.jsp" style="margin-left: 120px;"> <font size="7" face="微软雅黑" ><i>没有帐号？点击注册</i></font></a>
     	</form>
	</div>
  </body>
</html>
