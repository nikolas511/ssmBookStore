<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page    isELIgnored="false"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>用户首页</title>
  </head>
   <body>
   		<%@include file="/client/head.jsp"%>
   <div>
   	<div style="border:1px solid; width: 300px;float:left;background-color: #CCFF66">
   		<b>书籍分类:</b>
   			<ul>
   			<c:forEach items="${categories}" var="category">
   				<li><a href='${pageContext.request.contextPath }/client/IndexHandler/index.action?category_id=${category.id}'>${category.name}</a></li><br><br>
   			</c:forEach>	
   			</ul>
   	</div>
   	<div style="border:1px solid; width:1000px;float:right;background-color: #F5F5DC">
   		<div align="center">
   		<div style="color: #A52A2A"><h3><marquee>欢迎光临!</marquee></h3></div>
			<c:if test="${books==null}">
				<h3>对不起,暂时没有该类书籍</h3>
			</c:if>
   		<c:forEach var="book" items="${books}" varStatus="status">
	  				<div id="book">
	  					<div id="info">
	  							<img src="${pageContext.request.contextPath }/images/${book.image}"/><br/>
	  						<b>${book.bookname }</b><br>
	  						${book.author }
	  						${book.price }
	  						<a href="${pageContext.request.contextPath }/client/BuyHandler/buyCart.action?id=${book.id }">加入购物车</a>
	  					<hr>
	  					</div>
	  					<div style="clear: both"></div>
	  				</div>
	  				<c:if test="${status.count%3==0}">
	  					<div style="clear: both"></div>
	  					<br/>
	  				</c:if>
		</c:forEach>
  		</div>
		<!-- 分页功能 此处不实现-->
<%--<c:if test="${pagebean.totalRecord!=0}">
<div align="center">
  <form action="${pageContext.request.contextPath}/client/IndexServlet" method="post">
   共[<b>${pagebean.totalRecord }</b>]条记录,
   <input type="hidden" name="category_id" value="${category_id}">
   每页<input type="text" name="pageSize" value="${pagebean.pageSize }" style="width: 30px" maxlength="2">条,
    <input type="submit" value="确认">
    共[<b>${pagebean.totalPage }</b>]页,
    当前[<b>${pagebean.currentPage }</b>]页
  	</form>
    <form action="${pageContext.request.contextPath}/client/IndexServlet" method="post">
    &nbsp;&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/client/IndexServlet?currentPage=${pagebean.previousPage}&pageSize=${pagebean.pageSize}&category_id=${category_id}">上一页</a>
   		<c:forEach items="${pagebean.pageBar}" var="page">
   			<c:if test="${page==pagebean.currentPage }">
				<font color="red">${page}</font>
   			</c:if>
   			<c:if test="${page!=pagebean.currentPage }">
   			<a href="${pageContext.request.contextPath}/client/IndexServlet?currentPage=${page}&pageSize=${pagebean.pageSize}&category_id=${category_id}">${page}</a>
   			</c:if>
   		</c:forEach>
    <a href="${pageContext.request.contextPath}/client/IndexServlet?currentPage=${pagebean.nextPage}&pageSize=${pagebean.pageSize}&category_id=${category_id}">下一页</a>

    <input type="text" name="currentPage" style="width: 30px"/>
     <input type="hidden" name="category_id" value="${category_id}">
    <input type="hidden" name="pageSize" value="${pagebean.pageSize}">
    <input type="submit" value=" GO " />
   </form>
  		</div>
</c:if>
<c:if test="${pagebean.totalRecord==0}">
	<h3>对不起,暂时没有该类书籍</h3>
</c:if>--%>
   	</div>
   	</div>
   </body>
</html>