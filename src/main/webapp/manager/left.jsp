<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page    isELIgnored="false"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>左侧栏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-color: #CCCCFF">
   		<ul>
   			<li><b>分类管理</b><br>
   				&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath}/manager/addCategory.jsp" target="right">添加分类</a><br>
   				&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath}/manager/CategoryHandler/getAllCategory.action"  target="right">查看分类</a><br>
   			</li>
   			<li><b>图书管理</b><br>
   				&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath}/manager/BookHandler/addUI.action"  target="right">添加图书</a><br>
   				&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath}/manager/BookHandler/getAll.action"  target="right">查看图书</a><br>
   			</li>
   			<li><b>订单管理</b><br>
   				&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath}/manager/OrderHandler/getAll.action?state=false"  target="right">待处理订单</a><br>
   				&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath}/manager/OrderHandler/getAll.action?state=true"  target="right">已发货订单</a><br>
   			</li>
   		</ul>
  </body>
</html>