<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>register jsp</title>
</head>
<body>
<h1>注册</h1>

<%-- ${pageContext.request.contextPath}/RegistServlet  --%>
<%-- <form action="<c:url value='/RegistServlet'/>" method="post"> --%>
<form action="${pageContext.request.contextPath}/RegistServlet" method="post">
用户名：<input type="text" name="username"/><br>
密码：<input type="password" name="password"/><br>
<input type="submit" value="注册"/>
</form>
</body>
</html>