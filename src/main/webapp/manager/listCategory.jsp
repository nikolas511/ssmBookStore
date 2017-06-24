<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page    isELIgnored="false"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示所有分类</title>
  </head>
   <body style="text-align: center">
   	<br/><br/>
   	<table style="border-style:solid;" width="90%">
   		<caption><h2>书籍分类信息</h2></caption>
   		<tr>
   			<td>分类名称</td>
   			<td>分类描述</td>
   			<td>操作</td>
   		</tr>
   		
   		<c:forEach var="category" items="${categories}">
   			<tr>
   				<td>${category.name }</td>
	   			<td>${category.description }</td>
	   			<td>
	   				<a href="${pageContext.request.contextPath }/manager/CategoryHandler/updateCategoryUI.action?id=${category.id}">修改</a>
	   				<a href="${pageContext.request.contextPath }/manager/CategoryHandler/deleteCategory.action?id=${category.id}">删除</a>
	   			</td>
   			</tr>
   		</c:forEach>
   	</table>
   	
  </body>
</html>