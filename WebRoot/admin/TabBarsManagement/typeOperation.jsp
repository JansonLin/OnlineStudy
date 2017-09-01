<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Type" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	ArrayList<Type> type=(ArrayList<Type>)session.getAttribute("type");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>类型设置</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="css/studentList.css">

	<script>
		window.onload=function(){
		var oTab=document.getElementById('table1');
		var oldColor='';
			for(var i=0;i<oTab.tBodies[0].rows.length;i++){
				oTab.tBodies[0].rows[i].onmouseover=function(){
					oldColor=this.style.background;  
					this.style.background='#CC9999';
				};
				oTab.tBodies[0].rows[i].onmouseout=function(){
					this.style.background=oldColor;   //鼠标移出后恢复原来颜色
				};
				if(i%2){
				oTab.tBodies[0].rows[i].style.background='#CCCC99';	
				}
				else{
					oTab.style.background='#CCFFCC';
				}
			}
		};
		function addType(){
			var value= document.getElementById('add').value;
			location="servlet/TabBarsServlet?op=addType&add="+value;
		}
		function confDel(id){
		  	if(confirm("确定要删除吗？")){
		 		location="servlet/TabBarsServlet?op=delType&id="+id;
		  	}
	  	}
	  	function modify(id){
	  		var name = prompt("请输入新的方向","");
	  		location="servlet/TabBarsServlet?op=modifyType&id="+id+"&name="+name;
	  	}
	</script>
	

  </head>
  
  <body>
	<div class="nav"><span class="icon-font"></span><span>标签栏管理</span><span>&gt</span><span>类型栏列表</span></div>
	
	<div id="form-nav">
		<form>
			<span>添加新类型</span><input type="text" name="add" id="add" />
			<input class="btn orange" type="button" value="添加" onClick="addType()"/>
		</form>
	</div>
	
	<div id="main">
	<table cellspacing="0" class="table1" id="table1">
	<thead class="thead1">
    	<tr class="tab_title">
    	    <th class="th1"><input type="checkbox" name="first" id="sel" class="lab"/></th>
	    	<th>ID</th>
	    	<th>类型名</th>
	    	<th class="th2">操作</th>
	    </tr>
	   </thead> 
		<%
			if(null==type){
		%><script type="text/javascript">location="servlet/TabBarsServlet?op=typeList";</script>	
		<%
			}else{
				for(int i=0;i<type.size();i++){
					Type t=type.get(i);
		%>
		
		<tbody class="tbody1">
					<tr class="ele1">
						<td class="td1"><input type="checkbox" name="first"/></td>
						<td><%=t.getType_ID() %></td>
						<td><%=t.getType_Name() %></td>
						<td class="td2">
							<a href="javascript:modify(<%=t.getType_ID()%>)">修改</a>
					    	<a href="javascript:confDel(<%=t.getType_ID()%>)">删除</a>
					    </td>
				    </tr>
				 </tbody>  
	    <%
	    	}
	    }
	    %>
    </table>
    </div>
  </body>
</html>
