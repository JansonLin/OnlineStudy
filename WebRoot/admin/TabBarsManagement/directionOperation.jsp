<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Direction" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	ArrayList<Direction> direction=(ArrayList<Direction>)session.getAttribute("direction");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>方向栏设置</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/studentList.css">
	
	<script type="text/javascript">
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
	function addDirection(){
		var value= document.getElementById('add').value;
		location="servlet/TabBarsServlet?op=addDirection&add="+value;
	}
	function confDel(id){
	  	if(confirm("确定要删除吗？")){
	 		location="servlet/TabBarsServlet?op=delDiretion&id="+id;
	  	}
  	}
  	function modify(id){
  		var name = prompt("请输入新的方向","");
  		location="servlet/TabBarsServlet?op=modifyDirection&id="+id+"&name="+name;
  	}
	</script>
  </head>
  
  <body>
	<div class="nav"><span class="icon-font"></span><span>方向栏管理</span><span>&gt</span><span>方向栏列表</a></span></div>
	
	<div id="form-nav">
	<form>
		<span>添加新方向</span><input type="text" name="add" id="add" />&nbsp;
		<input class="btn orange" type="button" value="添加" onClick="addDirection()"/>
	</form>
	</div>	
   
   <div id="main">
   <table cellspacing="0" class="table1" id="table1">
	<thead class="thead1">
    	<tr><th class="th1"><input type="checkbox" name="first" id="sel" class="lab"/></th>
	    	<th>ID</th>
	    	<th>方向名</th>
	    	<th class="th2">操作</th>
	    </tr>
	  </thead>  
		<%
			if(null==direction){
		%><script type="text/javascript">location="servlet/TabBarsServlet?op=directionList";</script>	
		<%
			}else{
				for(int i=0;i<direction.size();i++){
					Direction d=direction.get(i);
		%>
		 <tbody class="tbody1">
					<tr class="ele1">
						<td class="td1"><input type="checkbox" name="first"/></td>
						<td><%=d.getDir_ID()%></td>
						<td><%=d.getDir_Name()%></td>
						<td class="td2">
							<a href="javascript:modify(<%=d.getDir_ID()%>)">修改</a>
					    	<a href="javascript:confDel(<%=d.getDir_ID()%>)">删除</a>
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
