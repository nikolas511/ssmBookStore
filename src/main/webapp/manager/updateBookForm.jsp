<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page    isELIgnored="false"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>修改书本页面</title>
  </head>
    <body>
    
    <br/><br/>
    <form action="${pageContext.request.contextPath }/manager/BookHandler/update.action" method="post" <%--enctype="multipart/form-data"--%>>
    	<table width="500px">
    	<input type="hidden" name="id" value="${book.id }" >
    	<tr>
    		<td>书名</td>
    		<td><input type="text" name="bookname" value="${book.bookname }"style="width: 200px"></td>
    	<tr>
    	<tr>
    		<td>作者</td>
    		<td><input type="text" name="author" value="${book.author }" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>售价</td>
    		<td><input type="text" name="price" value="${book.price }" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>图片</td>
    		<td><input type="file" name="image"  style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>描述</td>
    		<td><textarea rows="4" cols="40" name="description">${book.description }</textarea></td>
    	</tr>
    	<tr>
    		<td>所属分类</td>
    		<td>
    			<select name="category_id">
    				<c:forEach var="category"  items="${categories}">
    					<option value="${category.id }">${category.name }</option>
    				</c:forEach>
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<td><a href="${pageContext.request.contextPath}/Mymessage.jsp">取消修改</a></td>
    		<td><input type="submit" value="确认修改"></td>
    	</tr>
    	</table>
    </form>
    
  </body>
</html>