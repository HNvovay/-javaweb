<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>公寓管理系统</title>

<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/detail.css">
<link rel="SHORTCUT ICON" href="images/Apartment.ico"/>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<div class="login">
	<h1>公寓管理系统</h1>
	<form action="LoginServlet" method="post">
		<input type="text" name="userName" placeholder="用户名" required="required" />
		<input type="password" name="userPassword" placeholder="密码" required="required" />
		<input type="submit" value="登录">
		<input type="button" value="注册" onclick="window.location.href='register.jsp'">
	</form>
</div>

</form>
</body>
</html>