<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page    isELIgnored="false"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>管理员页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  <frameset rows="18%,*">
  		<frame src="${pageContext.request.contextPath}/manager/head.jsp" name="head">
  		<frameset  cols="15%,*">
	  		<frame src="${pageContext.request.contextPath}/manager/left.jsp" name="left">
	 		<frame style="background-color: #F5F5DC" src="" name="right">
 		</frameset>
  </frameset>
</html>