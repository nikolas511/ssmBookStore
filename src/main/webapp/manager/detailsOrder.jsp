<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page    isELIgnored="false"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body >
   		<h3>订单明细</h3>
   		<table style="border-style:solid;" width="90%">
   			<tr>
   				<td>书名</td>
   				<td>售价</td>
   				<td>数量</td>
   				<td>应收货款</td>
   			</tr>
   			<c:forEach items="${order.orderItems}" var="item">
   			<tr>
   				<td>${item.book.bookname}</td>
   				<td>${item.book.price}</td>
   				<td>${item.quantity}</td>
   				<td>${item.quantity}*${item.book.price}</td>
   			</tr>
   			</c:forEach>
   			<tr>
   				<td>总计货款:</td>
   				<td>${order.totalprice }</td>
   			</tr>
   		</table>
   	<table style="border-style:solid;" width="90%">
  		<h3>收货人详细地址</h3>
  		<tr>
  			<td>用户</td>
  			<td>电话</td>
  			<td>手机</td>
  			<td>地址</td>
  			<td>邮箱</td>
  		</tr>
  		
  		<tr>
  			<td>${order.user.username }</td>
  			<td>${order.user.phone }</td>
  			<td>${order.user.birthday }</td>
  			<td>${order.user.address }</td>
  			<td>${order.user.email }</td>
  		</tr>
  	</table>
  	<c:if test="${order.state==false}">
  		<a href="${pageContext.request.contextPath }/manager/OrderHandler/updateState.action?id=${order.id}">确认发货</a>
  	</c:if>
  </body>
</html>