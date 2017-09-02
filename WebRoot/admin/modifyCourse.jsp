<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="entity.Course" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	Course c = new Course();
	c = (Course) session.getAttribute("course");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改课程信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  </head>
  
  <body>
	<div class="nav">
		<span class="icon-font"></span><span>课程管理</span><span>&gt</span><span>课程信息修改</span>
	</div>
	<div id="content">
		<form enctype="multipart/form-data" method="post" action="servlet/CourseServlet?op=updateCourse&id=<%=c.getCID()%>">
			<table>
				<tr>
					<th>课程名称</th>
					<td><input type="text" name="CName" id="CName" class="inputEle"
						value="<%=c.getCName()%>" /></td>
				</tr>
				<tr>
					<th>课程地址</th>
					<td><input type="text" name="CAddr" id="CAddr"
						class="inputEle" value="<%=c.getCAddress()%>" /></td>
				</tr>
				<tr>
					<th>课程方向</th>
					<td><input type="text" name="CDir" id="CDir" class="inputEle"
						value="<%=c.getCDirection()%>" /></td>
				</tr>
				<tr>
					<th>课程分类</th>
					<td><input type="text" name="CSort" id="CSort"
						class="inputEle" value="<%=c.getCSort()%>" /></td>
				</tr>
				<tr>
					<th>课程所属年级</th>
					<td><input type="text" name="CClass" id="CClass"
						class="inputEle" value="<%=c.getCClass()%>" /></td>
				</tr>
				<tr>
					<th>课程类型</th>
					<td><input type="text" name="CType" id="CTypev"
						class="inputEle" value="<%=c.getCType()%>" /></td>
				</tr>
				<tr>
					<th>课程封面地址</th>
					<td><input type="file" name="CImgAddr" id="CImgAddr"
						class="inputEle" value="<%=c.getCImgAddress()%>" /></td>
				</tr>
				
				<tr>
					<th>课程简介</th>
					<td><input type="text" name="CContent" id="CContent"
						class="inputEle" value="<%=c.getCContent()%>" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="修改" class="btn" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
