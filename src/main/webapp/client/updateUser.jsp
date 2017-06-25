<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page    isELIgnored="false"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>用户注册</title>
  </head>
  <body style="background-color: #F5F5DC">
		<form action="${pageContext.request.contextPath}/UserHandler/update.action" method="post">
		 <table align="left">
		 	<input type="hidden" name="id" value="${user.id }">
		   	<tr><td>用户名:</td><td><input type="text" name="username" value="${user.username }" style="width: 200px"></input>
		   	<span class="message">${formBean.errors['username']}${message}</span></td></tr>
		   	<%--${formBean.errors.username} el表达式还可以这样写--%>
		   	<tr><td>密码:</td><td><input type="password" name="password" value="${user.password }" style="width: 200px"></input>
		   	<span class="message">${formBean.errors['password1']}</span></td></tr>
		   	
		   <%--	<tr><td>确认密码:</td><td><input type="password" name="password2" value="${formBean.password2 }" style="width: 200px"></input>
		   	<span class="message">${formBean.errors['password2']}</span></td></tr>--%>
		   	
		   	<tr><td>电话:</td><td><input type="text" name="phone" value="${user.phone }" style="width: 200px"></input>
		   	<span class="message">${formBean.errors['phone']}</span></td></tr>
		   	
		   	<tr><td>生日:</td><td><input type="text" name="birthday" value="${user.birthday }" style="width: 200px"></input>
		   	<span class="message">${formBean.errors['cellphone']}</span></td></tr>
		   	
		   	<tr><td>邮箱:</td><td><input type="text" name="email" value="${user.email }" style="width: 200px"></input>
		   	<span class="message">${formBean.errors['email']}</span></td></tr>
		   	
		   	<tr><td>地址:</td><td><input type="text" name="address" value="${user.address }" style="width: 400px"></input>
		   	<span class="message">${formBean.errors['address']}</span></td></tr>
		   	
		   	<tr><td><input type="submit" value="修改" name="sumbit"></input></td>
		   		<td><input type="reset" value="重置"  name="reset"></input></td>
		   		<td>转到主页:<a href="${pageContext.request.contextPath }/index.jsp">主页</a></td>
		   		<!--<td>重置密码:<a href="${pageContext.request.contextPath }/servlet/ChangePasswordUIServlet">修改密码</a></td> -->
		   	</tr>
		 </table>
		</form>	   
  </body>
</html>