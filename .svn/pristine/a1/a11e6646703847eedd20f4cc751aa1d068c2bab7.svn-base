<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="entity.Student"%>
<%
	Student s=new Student();
	s=(Student)session.getAttribute("student");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改学生信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/oper.css">
	
  </head>
  
  <body>
	<div class="nav"><span class="icon-font">&#xe023;</span><span>学生管理</span><span>&gt</span><span>信息修改</span></div>
   	<div id="content">
   	<!-- 学生信息显示begin -->
	<form enctype="multipart/form-data" method="post" action="servlet/StudentServlet?op=update&id=<%=s.getSID()%>">
	
		<table>
		<tr class="depth"><th>学生学号</th><td><input type="text" name="SStudentID" id="SStudentID" class="inputEle" value="<%=s.getSStudentID()%>"/></td></tr>
   		<tr class="shallow"><th>学生姓名</th><td><input type="text" name="SName" id="SName" class="inputEle" value="<%=s.getSName()%>"/></td></tr>
   		<tr class="depth"><th>性别</th><td><input type="text" name="SSex" id="SSex" class="inputEle" value="<%=s.getSSex()%>"/></td></tr>
   		<tr class="shallow"><th>所在系</th><td><input type="text" name="SDepartment" id="SDepartment" class="inputEle" value="<%=s.getSDepartment()%>"/></td></tr>
   		<tr class="depth"><th>班级</th><td><input type="text" name="SClass" id="SClass" class="inputEle" value="<%=s.getSClass()%>"/></td></tr>
   		<tr class="shallow"><th>自我介绍</th><td><input type="text" name="SIntroduction" id="SIntroduction" class="inputEle" value="<%=s.getSIntroduction()%>"/></td></tr>
   		<tr class="depth"><th>邮箱</th><td><input type="text" name="SEmail" id="SEmail" class="inputEle" value="<%=s.getSEmail()%>"/></td></tr>
   		<tr class="shallow"><th>学生照片</th><td><input type="file" name="SImg" id="SImg" class="inputEle" value="<%=s.getSImg()%>"/></td></tr>
   		<tr class="depth"><th>联系方式</th><td><input type="text" name="SContactWay" id="SContactWay" class="inputEle" value="<%=s.getSContactWay()%>"/></td></tr>
   		<tr class="shallow"><td colspan="2"><input type="submit" value="修改" class="btn orange"/></td></tr>
		</table>
	</form>
	<!-- 学生 信息显示end-->
    </div>
  </body>
</html>
