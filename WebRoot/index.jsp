<%@ page import="entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Direction" %>
<%@ page import="entity.Sort" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	ArrayList<Direction> direction=(ArrayList<Direction>)session.getAttribute("d");
	ArrayList<Sort> sort=(ArrayList<Sort>)session.getAttribute("s");
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线学习平台</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" charset="utf-8" language="JavaScript" src="js/logReg.js"></script>
	<link href="css/index.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<link rel="stylesheet" href="css/app.css">
	<link rel="stylesheet" type="text/css" href="css/logReg.css">
	
     
     

	
	<%
		Student student = (Student)session.getAttribute("student");
	%>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</head>

<body>
	<div id="mmm">
		<div class="nav">
			<div id="logo" class="logo">
				<a href="index.jsp" target="_self" title="首页"><img
					src="images/20.jpg"></a>
			</div>

			<ul class="nav-as">
				<li><a href="allCourse.jsp">课程</a></li>
				<li><a href="grade.jsp">年级</a></li>
				<li>
					<div class="sea">
						<span class="sea1"> <input class="put" name="text"
							type="text" placeholder="search" id="search" />
						</span> <input type="button" id="btn1"
							style="background:url(images/btn.png)" />
					</div>
				</li>
				<div class="nav-cs">
					<%
		   		if(student==null){
			%>
					<div>
						<li><a id="showtext" onClick="showlog('log','showtext')">登录</a></li>
						<li><a id="showtext" onClick="showreg('reg','showtext')">注册</a></li>
					</div>

					<!-- 登录 begin -->
					<div class="abcd" id="log">
						<input type="button" id="button" value="X" class="btn"
							style=" border-radius:50px; border:1px solid ; width:25px; height:25px; float:right;"
							onClick="del()" />
						<h2>登录</h2>

						<div id="error_box"></div>
						<form action="servlet/LogRegServlet" method="post"
							onsubmit="return checkLog(this)">
							<input type="hidden" name="op" value="log" />
							<div class="input_box">
								用户名:&nbsp;<input type="text" name="SStudentID" id="SStudentID"
									placeholder="请输入正确的学号" />
							</div>
							<div class="input_box">
								密&nbsp;码:&nbsp;<input type="password" name="SPwd" id="SPwd"
									placeholder="请输入6~20位的密码" />
							</div>
							<br />
							<div class="input_box1">
								<input type=submit name="submit" id="txt" value="登录"
									onClick="changeColor()">
							</div>
							<a id="showtext" onClick="showreg('reg','showtext')"
								style="margin-left: 110px;"> <font size="5" face="隶书"
								style="color: black;">没有帐号？点击注册</font></a>
						</form>
					</div>
					<!-- 登录 end -->

					<!-- 注册 begin -->
					<div class="abcd" id="reg">
						<input type="button" id="button" value="X" class="btn"
							style="border-radius:50px; border:1px solid; width:25px; height:25px; float:right;"
							onClick="del()" />
						<h2>注册</h2>

						<div id="error_box"></div>
						<form action="servlet/LogRegServlet" method="post"
							onsubmit="return checkReg(this)">
							<input type="hidden" name="op" value="reg" />
							<div class="input_box">
								用户名:&nbsp;<input type="text" name="SStudentID1" id="SStudentID1"
									placeholder="请输入正确的学号" />
							</div>
							<div class="input_box">
								密&nbsp;码:&nbsp;<input type="password" name="SPwd1" id="SPwd1"
									onblur="return checkPass()" placeholder="请输入6~20位的密码" />
							</div>
							<div class="input_box">
								确认密码: <input type="password" name="SPwdConfirm1"
									id="SPwdConfirm1" />
							</div>
							<div class="input_box1">
								<input type=submit name="submit" id="txt1" value="注册"
									onClick="changeColor1()">
							</div>

						</form>
					</div>
					<!-- 注册 end -->
					<!-- <div name="a1" onClick="div('a1');" class="title">
					<img alt="个人信息" src="images/20.jpg" />
				</div> -->
					<!-- 			 	<div name="a1" onClick="div('a1');" class="title">
					<img alt="个人信息" src="images/20.jpg" />
				</div>
 -->
					<%}else{ %>
					<div>
						<li><a> <span
								style="margin-top: 20px;margin-right: 60px;"> <img
									src="images/user.png" width="50px" height="50px">
							</span>
						</a></li>
					</div>
					<%
						}
					%>
				</div>

			</ul>
		</div>

<!-- 
		<div class="main">
			<div class="box">
				<ul class="box-as">
				
					<li class="box-pos"><label class="box-es"><a href="#">前端开发</a><font>&gt</font></label>
						<ul class="box-ul" style="background:url(images/16.jpg);">
							<li>基础：<a href="">html/css</a>/<a href="">javaScript</a>/<a
								href="">jQuery</a>/
							</li>
							<li>进阶：<a href="#">html5</a>/<a href="">CSS</a>/<a href="">Node.js</a>/<a
								href="">Ajax</a> /<a href="">Vue.js</a>/
							</li>
							<li>其他：<a href="#">前端工具</a></li>
						</ul>
					</li>

					<li class="box-pos"><label class="box-es"><a href="#">后端开发</a><font>&gt
						</font></label>
						<ul class="box-ul" style="background:url(images/15.jpg);">
							<li>基础：<a href="">Java</a>/<a href="">PHP</a>/<a href="">Python</a>/<a
								href="">C</a>/<a href="">C++</a>/<a href="">C#</a>/<a href="">Ruby</a>/
							</li>
						</ul></li>

					<li class="box-pos"><label class="box-es"><a href="#">移动开发</a><font>&gt
						</font></label>
						<ul class="box-ul" style="background:url(images/14.jpg);">
							<li>基础：<a href="">Android</a>/<a href="">ios</a>/
							</li>
						</ul></li>

					<li class="box-pos"><label class="box-es"><a href="#">数据库</a><font>&gt
						</font></label>
						<ul class="box-ul" style="background:url(images/13.jpg);">
							<li>基础：<a href="#">MySQL</a>/<a href="">SQL Server</a>/
							</li>
						</ul></li>

					<li class="box-pos"><label class="box-es"><a href="#">云计算&大数据
						</a><font>&gt </font></label>
						<ul class="box-ul" style="background:url(images/12.jpg);">
							<li>基础：<a href="#">大数据</a>/<a href="">云计算</a>/
							</li>
						</ul></li>
					<li class="box-pos"><label class="box-es"><a href="#">运维&测试
						</a><font>&gt </font></label>
						<ul class="box-ul" style="background:url(images/11.jpg);">
							<li>基础：<a href="#">测试</a>/<a href="">Linux</a>/
							</li>
						</ul></li>

					<li class="box-pos"><label class="box-es"><a href="#">UI设计</a><font>&gt</font></label>
						
						<ul class="box-ul" style="background:url(images/10.jpg);">
							<li>基础：<a href="#">动画动效</a>/<a href="">APPUI设计</a>/</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
 -->

	<!-- 主框架测试 begin -->
	<div class="main">
	<div class="box">
	<form method="" action="post">
	<ul class="box-as">
		<%
			if (null == direction){
		%>
				<script type="text/javascript"> location="servlet/IndexServlet?op=listDirection";</script>
		<%
			}else {
				int img=16;
				for (int i = 0; i < direction.size(); i++) {
					Direction d = direction.get(i);
		%>
					<li class="box-pos">
					<label class="box-es">
					<a href="servlet/AllCourseServlet?op=getlist&did=<%=i %>"><%=d.getDir_Name()%></a>
					<font>&gt</font>
					</label>
		<%
					for (int j = 0; j < sort.size(); j++) {
						Sort s = sort.get(j);
		%>
						<ul class="box-ul" style="background:url(images/<%=img %>.jpg);"><li>
						<a href="servlet/AllCourseServlet?op=getCourseList&sname=<%=s.getSort_Name()%>"><%=s.getSort_Name()%></a>
		<%
						out.print("</li>");
						out.print("</ul>");
						out.print("</li>");
						
					}
					img--;	
				}
			}
		%>
	</ul>
	</form>
	</div>
	</div>
	<!-- 主框架测试 end -->
	
	
	<!-- 轮播图 begin -->
	<div class="slider">
		<div class="slider-img">
			<ul class="slider-img-ul">
				<%
					for(int i=23;i<30;i++){
				 %>
				<li><a href="#"><img src="images/<%=i %>.jpg"></a></li>
				<%} %>
			</ul>
		</div>
	</div>
	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/xSlider.js"></script>
	<!-- 轮播图 end -->

  </body>
</html>
