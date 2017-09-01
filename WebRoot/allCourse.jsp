<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="entity.Direction" %>
<%@ page import="entity.Sort" %>
<%@ page import="entity.Type" %>
<%@ page import="entity.Course" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	ArrayList<Direction> direction=(ArrayList<Direction>)session.getAttribute("direction");
	ArrayList<Sort> sort=(ArrayList<Sort>)session.getAttribute("sort");
	ArrayList<Type> type=(ArrayList<Type>)session.getAttribute("type");
	ArrayList<Course> course=(ArrayList<Course>)session.getAttribute("courseList");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线学习平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/course.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
	<script type="text/javascript"  src="js/scrolltopcontrol.js"></script>
</head>

<body>
	<!-- 顶部菜单栏 begin -->
	<div>
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
		<!-- 顶部菜单栏 end -->

		<!-- 分类搜索栏 begin -->
		<form method="" action="post">
			<div class="container">
				<ul class="con">
					<%
						if (null == direction){
						%>
							<script type="text/javascript"> location="servlet/AllCourseServlet?op=list";</script>
						<%
						}else {
							out.print("<li>");
							out.print("<b>方向</b>");
							for (int i = 0; i < direction.size(); i++) {
								Direction d = direction.get(i);
					%>
					<a href="servlet/AllCourseServlet?op=getlist&did=<%=i %>"><%=d.getDir_Name()%></a>
					<%
						}
							out.print("</li>");
							out.print("<li>");
							out.print("<b>分类</b>");
							for (int j = 0; j < sort.size(); j++) {
								Sort s = sort.get(j);
					%>
					<a href="servlet/AllCourseServlet?op=getCourseList&sname=<%=s.getSort_Name()%>"><%=s.getSort_Name()%></a>
					<%
						}
							out.print("</li>");
						}
					%>
				</ul>
			</div>
		</form>
		<!-- 分类搜索栏 end -->

		<!-- 
   左侧课程栏 begin
	<div id="div1">
		<span class="jp">
		<div style="display:block;">
    	<ul class="sla">
			<li>
				<span>走进PS的大门</span>
			  	<span class="cr"><img src="images/bk/10.jpg"/></span>
			</li>
			<li>
				<span>机器学习</span>
			 	<span class="cr"><img src="images/bk/8.jpg"/></span>
			</li>
			<li>
				<span>SQL 数据库</span>
		 		<span class="cr"><img src="images/bk/9.jpg"/></span>
			</li>
			<li>
				<span>ThinkPHP 5.0</span>
		 		<span class="cr"><img src="images/bk/7.jpg"/></span>
			</li>
		</ul>
  </div>
  </div>
 左侧课程栏 end
   -->


	<!-- 列出全部的课程 -->
		<%
			if (null == course) {
		%>
		<script type="text/javascript">
			location = "servlet/AllCourseServlet?op=courseList";
		</script>
		<%
			} else {
				out.print("<ul class=" + "con1" + ">");
				for (int i = 0; i < course.size(); i++) {
					Course c = course.get(i);
		%>
		<li><a
			href="video.jsp?courseName=<%=c.getCName()%>&courseContent=<%=c.getCContent()%> ">
				<img src="images/PHP/03.jpg" />
				<p><%=c.getCName()%></p>
		</a></li>
		<%
			}
				out.print("</ul>");
			}
		%>

		<ul class="con1">
			<li><a href="video.jsp"><img src="images/PHP/03.jpg" />
					<p>PHP入门</p></a></li>
		</ul>

		<!-- 底部分页栏 begin -->
	<div id="c1">
		<ul class="cf" id="cf">
			<li><a href="#" style="width:60px;">首页</a></li>
			<li><a href="" style="width:60px;">上一页</a></li>
			<li>
				<a href="">1</a>
				<div class="asd"></div>
			</li>
			<li>
				<a href="">2</a>
				<div class="asd"></div>
			</li>
			<li>
				<a href="">3</a>
				<div class="asd"></div>
			</li>
			<li>
				<a href="">4</a>
				<div class="asd"></div>
			</li>
			<li>
				<a href="">5</a>
				<div class="asd"></div>
			</li>
			<li>
				<a href="">6</a>
				<div class="asd"></div>
			</li>
			<li>
				<a href="">7</a>
				<div class="asd"></div>
			</li>
			<li><a href="" style="width:60px;">下一页</a></li>
			<li><a href="" style="width:60px;" >尾页</a></li>
		</ul>
	</div>
<!-- 底部分页栏 end -->

	<!-- 底部信息栏 begin -->
	<footer class="footer"> 
		<a href="">联系我们</a>
		<a href="">友情链接</a> 
	</footer>
	<!-- 底部信息栏 end -->
</body>
</html>
