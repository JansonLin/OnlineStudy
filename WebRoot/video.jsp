<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Video" %>
<%@ page import="entity.DirectoryLists" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	ArrayList<Video> video=(ArrayList<Video>)session.getAttribute("video");
	ArrayList<DirectoryLists> directoryLists=(ArrayList<DirectoryLists>)session.getAttribute("directoryLists");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>课程目录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/video.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
	<script type="text/javascript"  src="js/scrolltopcontrol.js"></script>
	
</head>

<body>
<!-- 顶部菜单栏 begin-->
	<div class="nav">
		<div id="logo" class="logo">
			<a href="index.jsp" target="_self" title="首页"><img
				src="images/22.jpg"></a>
		</div>
		<ul class="nav-as">
			<li><a href="allCourse.jsp">课程</a></li>
			<li><a href="grade.jsp">年级</a></li>
			<li>
				<div class="sea">
					<input name="text" type="text" placeholder="search" class="txt" />
					<input id="btn" type="image" src="images/btn.png">
				</div>
			</li>

			<div class="nav-cs">
				<li><a href="log.jsp">登录</a></li>
				<li><a href="reg.jsp">注册</a></li>
			</div>
		</ul>
	</div>
<!-- 顶部菜单栏 end-->

<!-- 课程名称栏 begin -->
	<div class="vid">
		<div class="vid-play">
			<h2><%=request.getParameter("courseName") %></h2>
			<span><b><a href="">开始学习</a></b></span>
		</div>
	</div>
<!-- 课程名称栏 end-->

<!-- 课程简介栏 begin -->
	<div class="intr">
		<span><%=request.getParameter("courseContent") %></span>
	</div>
<!-- 课程简介栏 end-->

	<ul class="vio"></ul>
	
	<!-- 课程目录栏 begin-->
	<hr align="center">
	<div id="con">
		<%
			if (null == directoryLists)
				response.sendRedirect("servlet/AllCourseServlet?op=DAndVList");
			else {
				out.print("<ul>");
				for (int i = 0; i < directoryLists.size(); i++) {
					DirectoryLists d = directoryLists.get(i);
		%>
		<li><%=d.getDName()%></li>
		<%
			for (int j = 0; j < video.size(); j++) {
						Video v = video.get(j);
						int dirID = d.getDID();
						int vID = v.getVDirectoryListsID();
						if (dirID == vID) {
		%>
		<li><a href="videoPlay.jsp?address=<%=v.getVAddress()%>"><%=v.getVName()%></a></li>
		<%
						out.print( v.getVAddress());
						}
					}
				}
				out.print("</ul>");
				
			}
		%>
	</div>
	<!-- 课程目录栏 end -->
</body>
</html>
