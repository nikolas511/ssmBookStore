<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page    isELIgnored="false"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="background-color: #CCFF99">
 	<div style="margin-left: 40%;float: left;">
		&nbsp&nbsp&nbsp<h1>在线书店</h1>
   		<a href="${pageContext.request.contextPath }/index.jsp">首页</a>
   		&nbsp&nbsp<a href="${pageContext.request.contextPath}/client/listcart.jsp">查看购物车</a>
   		&nbsp&nbsp<a href="${pageContext.request.contextPath}/client/UserOrderHandler/listOrder.action">查看订单</a>
  	</div>
  <div style="float: right;">
		<c:if test="${user==null}">
		<form action="${pageContext.request.contextPath }/UserHandler/login.action" method="post" >
 			用户名：<input type="text" name="username" style="width: 50px">
 			密码：<input type="password" name="password" style="width: 50px">
 			<input type="submit" value="登陆">
 			<input type="button" value="注册" onclick="window.open('${pageContext.request.contextPath }/client/register.jsp')">
		</form>
		</c:if>
		<c:if test="${user!=null}">
			欢迎你:${user.username }
			<a href="${pageContext.request.contextPath }/UserHandler/quit.action">注销</a>
			<a href="${pageContext.request.contextPath }/UserHandler/updateUI.action?id=${user.id}">修改信息</a>
			<c:if test="${user.username=='admin'}">
			<input type="button" value="管理员" onclick="window.open('${pageContext.request.contextPath }/manager.jsp')">
			</c:if>
		</c:if>
	</div>
	<div style="clear: both"></div><!-- 用于禁止左右两端出现浮动对象 -->
</div>
<hr>