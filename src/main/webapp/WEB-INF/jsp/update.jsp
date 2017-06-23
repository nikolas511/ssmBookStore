<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/3
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/update.action" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <input type="text" name="username" value="${user.username}">
        <input type="text" name="password" value="${user.password}">
        <input type="text" name="birthday" value="${user.birthday}">
        <input type="text" name="email" value="${user.email}">
        <input type="text" name="phone" value="${user.phone}">
        <input type="text" name="address" value="${user.address}">
        <input type="submit" value="提交">
    </form>
</body>
</html>
