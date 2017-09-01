<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>视频播放页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link href="css/videoplay.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
	<script type="text/javascript" src="js/scrolltopcontrol.js"></script>
	
	<script type="text/javascript">
		window.onload = function() {
			var oBt1 = document.getElementById('btn1');
			var oText1 = document.getElementById('text2');
			oBt1.onclick = function() {
				oText1.style.display = 'block';
			};
		};
	
		function vidplay() {
			var video = document.getElementById("Video1");
			var button = document.getElementById("play");
			if (video.paused) {
				video.play();		
				button.textContent = "||";
			} else {
				video.pause();		
				button.textContent = ">";
			}
		}
	
		function restart() {
			var video = document.getElementById("Video1");
			video.currentTime = 0;
		}
	
		function skip(value) {
			var video = document.getElementById("Video1");
			video.currentTime += value;
		}
	</script>

</head>

<body>
	<% 
		String address=request.getParameter("address");
		out.print(address);
	 %>
	<div class="container">
		<!-- 播放视频 begin -->
		<div class="vio">
			<div class="text">
				<video id="Video1">
				<source src="demo.mp4" type="video/mp4" /> 
				<source src="demo.ogv" type="video/ogg" />
				</video>
				
				<div id="buttonbar">
					<button id="restart" onclick="restart();">[]</button>
					<button id="rew" onclick="skip(-10)">&lt;&lt;</button>
					<button id="play" onclick="vidplay()">&gt;</button>
					<button id="fastFwd" onclick="skip(10)">&gt;&gt;</button>
				</div>
			</div>
		</div>
		<!-- 播放视频 end -->
		
		<!-- 笔记 begin -->
		<div id="text2">
			<textarea id="text1" wrap="soft"></textarea>
			<input type="button" value="保存" id="btn2">
		</div>
		<!-- 笔记 end -->
	</div>
	
	<!-- 留言 begin -->
	<span class="note"><a href="">留言</a></span>
	<hr align="right" width="80%" />
	<textarea id="text3" wrap="soft"></textarea>
	<!-- 留言end -->
	
</body>
</html>