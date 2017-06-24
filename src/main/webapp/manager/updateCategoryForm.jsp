<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page    isELIgnored="false"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改分类</title>
  </head>
  <body>
   	<br/><br/>
   	<form action="${pageContext.request.contextPath}/manager/CategoryHandler/updateCategory.action" method="post">
   		<table width="500px;">
   			<input type="hidden" name="id" value="${category.id}">
    	<tr>
    		<td>分类名称：</td>
    		<td><input type="text" name="name" value="${category.name}" style="width: 200px"></td>
    	<tr>
    	<tr>
    		<td>分类描述：</td>
    		<td><textarea rows="4" cols="40" name="description">${category.description}</textarea></td>
    	</tr>
    	<tr>
    		<td><a href="${pageContext.request.contextPath}/Mymessage.jsp">取消修改</a></td>
    		<td><input type="submit" value="确认修改"></td>
    	</tr>
    	</table>
   	</form>
  </body>
</html>