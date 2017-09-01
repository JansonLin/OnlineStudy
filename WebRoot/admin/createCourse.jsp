<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8 "%>
<%@ page import="java.io.File"%>
<%@ page import="entity.Direction" %>
<%@ page import="entity.Sort" %>
<%@ page import="entity.Type" %>
<%@ page import="entity.Grade" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	ArrayList<Direction> direction=(ArrayList<Direction>)session.getAttribute("d");
	ArrayList<Sort> sort=(ArrayList<Sort>)session.getAttribute("s");
	ArrayList<Type> type=(ArrayList<Type>)session.getAttribute("t");
	ArrayList<Grade> grade=(ArrayList<Grade>)session.getAttribute("g");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>生成课程</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">
		var dir;
	    var sort;
	    var type;
	   	var grade;
	    function getOptionDir(val){
		    if(val!=null){
		        dir = val; 
		    }else{
		        alert(null);
		    }
		}
		function getOptionSort(val){
		    if(val!=null){
		        sort = val; 
		    }else{
		        alert(null);
		    }
		}
		function getOptionType(val){
		    if(val!=null){
		        type = val; 
		    }else{
		        alert(null);
		    }
		}
		function getOptionGrade(val){
		    if(val!=null){
		        grade = val; 
		    }else{
		        alert(null);
		    }
		}
	    function jump(){
		   location="servlet/CourseServlet?op2=addCourseType&dir="+dir+"&sort="+sort+"&type="+type+"&grade="+grade;
		}
		function create(){
			location="servlet/CourseServlet?op1=createCourse"
			alert("地址");
		}
	</script>
  </head>
  
  <body>
  <input type="button" value="生成课程"  onClick="create();"/>
  
	<p>请选择课程类型</p>
  	<% if(null==direction || null==sort || null==type || null==grade){	%>
  		<script type="text/javascript">location="servlet/CourseServlet?op=getCourseType";</script>
  	<% }else{
		out.print("选择课程方向");
	%><select name="dir" id="dir" onchange="getOptionDir(this.options[this.options.selectedIndex].value)">
	<% for(int i=0;i<direction.size();i++){
			Direction d=direction.get(i);
			out.print("<option value="+(i+1)+">"+d.getDir_Name()+"</option>");
		}
		out.print("</select><br />");
		out.print("选择课程分类");
	%><select name="sort" id="sort" onchange="getOptionSort(this.options[this.options.selectedIndex].value)">		
	<% for(int j=0;j<sort.size();j++){
			Sort s=sort.get(j);
			out.print("<option value="+(j+1)+">"+s.getSort_Name()+"</option>");
		}
		out.print("</select><br />");
		out.print("选择课程类型");
	%><select name="type" id="type" onchange="getOptionType(this.options[this.options.selectedIndex].value)">	
	<% for(int k=0;k<type.size();k++){
			Type t=type.get(k);
			out.print("<option value="+(k+1)+">"+t.getType_Name()+"</option>");
		}
		out.print("</select><br />");
		out.print("选择课程年级");
	%><select name="grade" id="grade" onchange="getOptionGrade(this.options[this.options.selectedIndex].value)">
	<% for(int l=0;l<grade.size();l++){
			Grade g=grade.get(l);
			out.print("<option value="+(l+1)+">"+g.getGrade_Name()+"</option>");
		}
		out.print("</select><br />");
	}
	%>
	<input type="button" value="添加分类" onClick="jump()">
	<hr />
	
	<!-- 添加课程封面 begin -->
	课程封面照片
	<form action="../servlet/CourseServlet?op=addImg" method="post" enctype="multipart/form-data">  
     	请选择上传的图片或文件:<input type="file" name="courseImg"/>
     	<input type="submit" value="上传"/>  
    </form>  
	<!-- 添加课程封面 end -->
  </body>
</html>
