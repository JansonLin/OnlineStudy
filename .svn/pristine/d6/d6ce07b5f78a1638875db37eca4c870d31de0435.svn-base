<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
     function checkPass(){
        var sPwd=document.getElementById("SPwd");
        
         if(sPwd.value == "")
        {
       		alert("密码不能为空!");
       		sPwd.focus();
           return false; 
        }else if(sPwd.value.length>20|| sPwd.value.length<6){
           alert("密码长度必须在6~20位之间");
           sPwd.value="";
           sPwd.focus();
           return false;
        }
        return true; 
     }
     function  CheckValidate(){
     var sPwd=document.getElementById("SPwd");
     var sPwdConfirm=document.getElementById("SPwdConfirm");
     if(sPwd.value!=sPwdConfirm.value){
      /*  document.getElementById("mes").innerHTML="两次密码不一样";
       Confirm.focus();
       return false;  */
        alert("两次密码不一样,请重新输入");
        sPwdConfirm.value="";
        sPwdConfirm.focus();
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
    	<h2>注册</h2> 
       	<div id="error_box"></div>
     	<form action="servlet/LogRegServlet" method="post"  onsubmit="return CheckValidate()">
  			<input type="hidden" name="op" value="reg"  />
  			<div class="input_box"> 
  				用户名:&nbsp;<input type="text" name="SStudentID" id="SStudentID" onblur="return checkUname()" placeholder="请输入正确的学号"/>
  			</div>
  			<div class="input_box"> 
  				密&nbsp;码:&nbsp;<input type="password" name="SPwd" id="SPwd"  onblur="return checkPass()"  placeholder="请输入6~20位的密码"/>
        	</div>
        	<div class="input_box"> 
				确认密码: <input type="password" name="SPwdConfirm" id="SPwdConfirm" /> 
        	</div>
        	<div class="input_box"> 
        		<input type="submit" value="注册" class="btn" name="reg" />
        	</div>
			<a href="log.jsp" style="margin-left: 120px;"> <font size="5" face="微软雅黑" >已有帐号？点击登录</font></a>
     	</form>
	</div>
   
  </body>
</html>
