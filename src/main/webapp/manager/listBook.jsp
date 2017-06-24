<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page    isELIgnored="false"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
   <body style="text-align: center">
   	<br/><br/>
   	<table style="border-style:solid;" width="90%">
   		<caption><h2>书籍信息</h2></caption>
   		<tr>
   			<td>书名</td>
   			<td>价格</td>
   			<td>作者</td>
   			<td>图片地址</td>
   			<td>描述</td>
   		</tr>
   		
   		<c:forEach var="book" items="${books}">
   			<tr>
   				<td>${book.bookname }</td>
   				<td>${book.price }</td>
   				<td>${book.author }</td>
   				<td>${book.image }</td>
	   			<td>${book.description }</td>
	   			<td>
	   				<a href="${pageContext.request.contextPath }/manager/BookHandler/updateUI.action?id=${book.id}">修改</a>
	   				<a href="${pageContext.request.contextPath }/manager/BookHandler/delete.action?id=${book.id}">删除</a>
	   			</td>
   			</tr>
   		</c:forEach>
   	</table>
   	
  </body>
</html>