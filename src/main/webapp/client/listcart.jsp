<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page    isELIgnored="false"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>购物车</title>
  </head>
  <body style="text-align: center;background-color: #F5F5DC">
   	<%@include file="/client/head.jsp" %>
   	<table style="border-style:solid;" width="90%">
   		<caption><h2>我的购物车</h2></caption>
   		<tr>
   			<td>书名</td>
   			<td>售价</td>
   			<td>数量</td>
   			<td>小计</td>
   		</tr>
   		<c:forEach items="${cart.map}" var="map">
   			<tr>
   				<td>${map.value.book.bookname}</td>
   				<td>${map.value.book.price}</td>
   				<td>${map.value.number}</td>
   				<td>${map.value.price}*${map.value.number}</td>
   			</tr>
   		</c:forEach>
   			<tr>
   				<td>合计:</td>
   				<td>${cart.totalprice}</td>
   			</tr>
   	</table>
   		<c:if test="${cart!=null}">
   		<a href="${pageContext.request.contextPath }/client/BuyHandler/order.action">结算订单</a>
   		<a href="${pageContext.request.contextPath }/client/BuyHandler/delete.action">删除订单</a>
 		</c:if>
  </body>
</html>