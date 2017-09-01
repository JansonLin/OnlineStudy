<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="entity.Student" %>
<%	Student s=new Student();
	s=(Student)session.getAttribute("student");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看学生详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" type="text/css" href="css/StudentDetails.css">

  </head>
  
  <body>
	<div class="nav"><span class="icon-font"></span><span>学生管理</span><span>&gt</span><span>查看学生详情</span></div>
   <!--管理员查看时显示学生信息表begin -->
   	<div id="content">
	<form class="form1" enctype="multipart/form-data" method="post" action="admin/StudentManagement/studentList.jsp">
		<table class="table2">
			<tr><th>学生学号</th><td>
			<input type="text" name="SStudentID" id="SStudentID" class="inputEle" value="<%=s.getSStudentID()%>" readonly="true"/></td></tr>
	   		<tr><th>学生姓名</th><td>
	   		<input type="text" name="SName" id="SName" class="inputEle" value="<%=s.getSName()%>" readonly="true"/></td></tr>
	   		<tr><th>性别</th><td>
	   		<input type="text" name="SSex" id="SSex" class="inputEle" value="<%=s.getSSex()%>" readonly="true"/></td></tr>
	   		<tr><th>所在系</th><td>
	   		<input type="text" name="SDepartment" id="SDepartment" class="inputEle" value="<%=s.getSDepartment()%>" readonly="true"/></td></tr>
	   		<tr><th>班级</th><td>
	   		<input type="text" name="SClass" id="SClass" class="inputEle" value="<%=s.getSClass()%>" readonly="true"/></td></tr>
	   		<tr><th>自我介绍</th><td>
	   		<input type="text" name="SIntroduction" id="SIntroduction" class="inputEle" value="<%=s.getSIntroduction()%>" readonly="true"/></td></tr>
	   		<tr><th>学生照片所在路径</th><td><input type="image" name="SImg" id="SImg" class="inputEle" value="<%=s.getSImg()%>" readonly="true"/>
	   		</td></tr>
	   		<tr><th>学生照片</th><td><img alt="" src="<%=s.getSImg()%>" height=600px width=400px>
	   		<tr><th>联系方式</th><td>
	   		<input type="text" name="SContactWay" id="SContactWay" class="inputEle" value="<%=s.getSContactWay()%>" readonly="true"/></td></tr>
	   		</td></tr>
	   		<tr><td colspan="2"><input type="submit" value="返回" class="btn"/></td></tr>
		</table>
	</form>
    </div>
     <!--管理员查看时显示学生信息表end -->
  </body>
</html>
