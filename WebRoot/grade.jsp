<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<link rel="stylesheet" type="text/css" href="css/grade.css">
    <script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
	<script>
	window.onload=function()
	{
		var oDiv=document.getElementById('c1');
		var aUl=oDiv.getElementsByTagName('ul');
		var aLi=oDiv.getElementsByTagName('a');
		var aDiv=oDiv.getElementsByTagName('div');
			
			for(var i=0;i<aDiv.length;i++){ 
				aLi[i+2].index=i;
				aLi[i].onmouseover=function(){
				
				for(var i=0;i<aDiv.length;i++){ 
					 aDiv[this.index].style.display='';
				}
					  aDiv[this.index].style.display='block';
				
				};
			}
		
		};
</script>

<script>
window.onload=function(){
	var oDiv=document.getElementById('div1');
	var aBtn=oDiv.getElementsByTagName('input');
	var aDiv=oDiv.getElementsByTagName("div");
			
	
		for(var i=0;i<aBtn.length;i++){
			 aBtn[i].index=i;
		
			aBtn[i].onclick=function(){
			
				//	 alert('你好');
				for(var i=0;i<aBtn.length;i++){
					aBtn[i].className='';
					aDiv[i].style.display='';
				}
					this.className='active';
					aDiv[this.index].style.display='block';
			};
			
		}
};
</script>
</head>
<body>
<script type="text/javascript"  src="js/scrolltopcontrol.js"></script>
  <div>
	<div class="nav">
    <div id="logo" class="logo"><a href="index.jsp" target="_self" title="首页"><img src="images/22.jpg"></a></div>
		<ul class="nav-as">
			<li><a href="allCourse.jsp">课程</a></li>
			<li><a href="grade.jsp">年级</a></li>
			<li>
			  <div class="sea">
        <input name="text" type="text" placeholder="search" class="txt" "/>		
		<input id="btn" type="image" src="images/btn.png">	      
			  </div>
			</li>
		
		<div class="nav-cs">
			<li><a href="log.jsp">登录</a></li>
			<li><a href="reg.jsp">注册</a></li>
		</div></ul>
  </div>
  <div class="container">
		<ul class="con">
			<li id="b"><b>年级：</b><a href="">全部</a><a href="#d1">大一</a><a
				href="#d2">大二</a><a href="#d3">大三</a><a href="#d4">大四</a></li>
			<li><b>方向：</b><a href="">全部</a><a href="">前端开发</a><a href="">后端开发</a><a
				href="">移动开发</a><a href="">数据库</a><a href="">云计算&大数据</a><a href="">运维&测试</a><a
				href="">UI设计</a></li>
			<li><b>分类：</b><a href="">全部</a><a href="">HTML/CSS</a><a
				href="">后端开发</a><a href="">javaScript</a><a href="">数据库</a><a
				href="">云计算&大数据</a><a href="">运维&测试</a><a href="">UI设计</a></li>
		</ul>
		
		<!-- 左侧课程栏 begin -->
		<!-- <div id="div1">
			<span class="jp"> <input type="button" value="精品推荐"
				class="active" id="cd" /> <input type="button" value="猜你喜欢"
				id="cd" /></span>
			<div style="display:block;">
				<ul class="sla">
					<li><span>框架设计与APP设计</span> <span class="cr"><img
							src="images/bk/5.jpg" /></span></li>

					<li><span>机器学习</span> <span class="cr"><img
							src="images/bk/5.jpg" /></span></li>
					<li><span>SQL 数据库</span> <span class="cr"><img
							src="images/bk/5.jpg" /></span></li>
					<li><span>ThinkPHP 5.0</span> <span class="cr"><img
							src="images/bk/5.jpg" /></span></li>
				</ul>
			</div>
			<div>
				<ul class="sla">
					<li><span>11框架设计与APP设计</span> <span class="cr"><img
							src="images/bk/5.jpg" /></span></li>

					<li><span>11机器学习</span> <span class="cr"><img
							src="images/bk/5.jpg" /></span></li>
					<li><span>11SQL 数据库</span> <span class="cr"><img
							src="images/bk/5.jpg" /></span></li>
					<li><span>11ThinkPHP 5.0</span> <span class="cr"><img
							src="images/bk/5.jpg" /></span></li>
				</ul>
			</div>
		</div> -->
		<!-- 左侧课程栏 end -->
		
<ul class="con1">
  <li><img src="images/c/4.jpg"/><p>HBase入门</p></li>
  <li><img src="images/Audroid/15.jpg"/><p>HBase入门</p></li>
  <li><img src="images/big data/5.jpg"/><p>HBase入门</p></li>
  <li><img src="images/c++/2.jpg"/><p>HBase入门</p></li>
  <li><img src="images/big data/3.jpg"/><p>HBase入门</p></li>
  <li><img src="images/cc/25.jpg"/><p>HBase入门</p></li>
  <li><img src="images/cloud/4.jpg"/><p>HBase入门</p></li>
  <li><img src="images/cloud/2.jpg"/><p>HBase入门</p></li>
 </ul> 
 <ul class="con2">
 <p id="d1"><h3>大一课程</h3></p>
  <li><img src="images/c/7.jpg"/><p>HBase入门</p></li>
  <li><img src="images/c/2.jpg"/><p>HBase入门</p></li>
  <li><img src="images/UI/6.jpg"/><p>HBase入门</p></li>
  <li><img src="images/UI/2.jpg"><p>HBase入门</p></li>
  <li><img src="images/UI/4.jpg"/><p>HBase入门</p></li>
  	<p id="d2"><h3>大二课程</h3></p>
  <li><img src="images/java/2.jpg"/><p>HBase入门</p></li>
  <li><img src="images/c++/3.jpg"/><p>HBase入门</p></li>
  <li><img src="images/MySQL/1.jpg"/><p>HBase入门</p></li>
  <li><img src="images/SQLServer/1.jpg"/><p>HBase入门</p></li>
  <li><img src="images/css/4.jpg"/><p>HBase入门</p></li>
  	<p id="d3"><h3>大三课程</h3></p>
  <li><img src="images/Audroid/16.jpg"/><p>HBase入门</p></li>
  <li><img src="images/big data/2.jpg"/><p>HBase入门</p></li>
  <li><img src="images/big data/4.jpg"/><p>HBase入门</p></li>
  <li><img src="images/cloud/3.jpg"/><p>HBase入门</p></li>
  <li><img src="images/cloud/1.jpg"/><p>HBase入门</p></li>
  <p id="d4"><h3>大四课程</h3></p>
  <li><img src="images/JavaScript img/2.jpg"/><p>HBase入门</p></li>
  <li><img src="images/JavaScript img/4.jpg"/><p>HBase入门</p></li>
  <li><img src="images/jQ img/1.jpg"/><p>HBase入门</p></li>
  <li><img src="images/jQ img/3.jpg"/><p>HBase入门</p></li>
  <li><img src="images/python/2.jpg"/><p>HBase入门</p></li>
 </ul> 
 </div>
		<!-- 分页 begin -->
		<div id="c1">
			<ul class="cf" id="cf">
				<li><a href="#" style="width:60px;">首页</a></li>
				<li><a href="" style="width:60px;">上一页</a></li>
				<li><a href="">1</a>
					<div class="asd"></div></li>
				<li><a href="">2</a>
					<div class="asd"></div></li>
				<li><a href="">3</a>
					<div class="asd"></div></li>
				<li><a href="">4</a>
					<div class="asd"></div></li>
				<li><a href="">5</a>
					<div class="asd"></div></li>
				<li><a href="">6</a>
					<div class="asd"></div></li>
				<li><a href="">7</a>
					<div class="asd"></div></li>
				<li><a href="" style="width:60px;">下一页</a></li>
				<li><a href="" style="width:60px;">尾页</a></li>

			</ul>
		</div>
		<!-- 分页 end -->

		<footer class="footer"> <a href="">联系我们</a><a href="">友情链接</a> </footer>
		
	</div>
  </body>
</html>