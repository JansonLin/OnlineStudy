<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Course" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	ArrayList<Course> course=(ArrayList<Course>)session.getAttribute("course");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看课程信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
		function confDel(id){
		  	if(confirm("确定要删除吗？")){
		 		location="servlet/CourseServlet?op=delCourse&id="+id;
		  	}
  		}
  		function modify(id){
		 	location="servlet/CourseServlet?op=modifyCourse&id="+id;
  		}
	</script>
  </head>
  
  <body>
	<!-- 多项选择搜索begin -->
	<div class="nav"><span class="icon-font"></span><span>课程管理</span><span>&gt</span><span>课程列表</span></div>
	
	<div class="searchPanel">
   		<select name="select" size="1" class="lab" id="sel" >
   			<option value="1" selected="selected">按年级查找</option>
   			<option value="2">按课程名查找</option>
   			<!-- 还有 -->
   		</select>
   		
   		<input type="text" name="search" id="search" class="inputEle inputSearch">
   		<input type="button" value="查询" id="btnSearch" class="btn orange" Onclick="Search1()"/>
   </div>
  <!-- 多项选择搜索end -->
  
  <!-- 显示学生信息表begin -->
	<table cellspacing="0" class="table1" id="table1">
	<!-- 表头部分begin -->
	<thead class="thead1">
    	<tr><th class="th1"><input type="checkbox" name="first" id="sel" class="lab"/></th>
	    	<th>ID</th>
	    	<th>课名</th>
	    	<th>课程地址</th>
	    	<th>方向</th>
	    	<th>分类</th>
	    	<th>类型</th>
	    	<th>年级</th>
	    	<th>封面</th>
	    	<th>介绍</th>
	    	<th class="th2">操作</th>
	    </tr>
	    </thead>
	    <!-- 表头部分end -->
	    
	    <!-- 表身显示信息部分begin -->
		<%
			if(null==course){
		%><script type="text/javascript">location="servlet/CourseServlet?op=courseList"</script>
		<%
			}else{
				for(int i=0;i<course.size();i++){
					Course c=course.get(i);
		%>
		<tbody class="tbody1">
					<tr class="ele1">
						<td class="td1"><input type="checkbox" name="first"/></td>
						<td><%=c.getCID() %></td>
						<td><%=c.getCName() %></td>
						<td><%=c.getCAddress() %></td>
						<td><%=c.getCDirection() %></td>
						<td><%=c.getCSort() %></td>
						<td><%=c.getCClass() %></td>
						<td><%=c.getCImgAddress() %></td>
						<td><%=c.getCContent() %></td>
						<td class="td2"><a href="javascript:modify(<%=c.getCID()%>)">修改</a>
					    	<a href="javascript:confDel(<%=c.getCID()%>)">删除</a>
					    	<a href="servlet/CourseServlet?op=details&id=<%=c.getCID()%>">查看详情</a>
					    </td>
				    </tr>
			 </tbody>
	    <%
	    	}
	    }
	    %>
    </table>
    <!-- 表身显示信息部分end -->
    
     <!-- 显示学生信息表end -->
     
     <!--  -->
    <script type="text/javascript">
	
	$(function(){
		$(".lab").click(
			function(){
				if(this.checked)
				 $("input:checkbox").attr("checked", "checked");  
				else
				 $("input:checkbox").removeAttr("checked");  
			}
		);
		
		
		$(".ele1").mouseover(
			function(){
				$(this).css("background-color","#e5e5e5"); 
			}			
		);
		$(".ele1").mouseout(				
			function(){
				$(this).css("background-color","#fff"); 
			}
		);
	});

	function Search1(){
		var i=document.getElementById("sel").value;
		var j=document.getElementById("search").value;
		location="servlet/StudentServlet?op=sea&i="+i+"&j="+j;
	}
	
	
	</script>
  </body>
</html>
