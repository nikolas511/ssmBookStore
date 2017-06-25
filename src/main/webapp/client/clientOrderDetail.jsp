<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page    isELIgnored="false"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body style="background-color: #F5F5DC">
   		<%@include file="/client/head.jsp"%>
   		<h3>订单明细</h3>
   		<table style="border-style:solid;" width="90%">
   			<tr>
   				<td>书名</td>
   				<td>售价</td>
   				<td>数量</td>
   				<td>应收货款</td>
   			</tr>
   			<c:forEach items="${clientorder.orderItems}" var="item">
   			<tr>
   				<td>${item.book.bookname}</td>
   				<td>${item.book.price}</td>
   				<td>${item.quantity}</td>
   				<td>${item.quantity}*${item.book.price}</td>
   			</tr>
   			</c:forEach>
   			<tr>
   				<td>总计货款:</td>
   				<td>${clientorder.totalprice }</td>
   			</tr>
   		</table>
   	<table style="border-style:solid;" width="90%">
  		<h3>收货人详细地址</h3>
  		<tr>
  			<td>用户</td>
  			<td>电话</td>
  			<td>生日</td>
  			<td>地址</td>
  			<td>邮箱</td>
  		</tr>
  		
  		<tr>
  			<td>${clientorder.user.username }</td>
  			<td>${clientorder.user.phone }</td>
  			<td>${clientorder.user.birthday }</td>
  			<td>${clientorder.user.address }</td>
  			<td>${clientorder.user.email }</td>
  		</tr>
  	</table>
  </body>
</html>