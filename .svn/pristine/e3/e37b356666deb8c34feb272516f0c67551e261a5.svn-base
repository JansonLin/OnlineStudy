<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/logReg.css">

	<script type="text/javascript">
	function checkUname(){
        var aName=document.getElementById("AName");
        
         if(aName.value == "")
        {
       		alert("用户名不能为空!");
       		aName.focus();
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
     	<form action="servlet/AdminLogServlet" method="post"  >
  			<input type="hidden" name="op" value="adminLog"  />
  			<div class="input_box"> 
  				用户名:&nbsp;<input type="text" name="AName" id="AName"  placeholder="请输入正确的管理员账号" onblur="return checkUname()"/>
  			</div>
  			<div class="input_box">
  				密&nbsp;码:&nbsp;<input type="password" name="APwd" id="APwd"  placeholder="请输入6~20位的密码"/>
        	</div>
        	<div class="input_box"> 
        		<input type="submit" value="登录" name="adminLog" id="adminLog" class="btn"  />
        	</div>
     	</form>
	</div>
  </body>
</html>
