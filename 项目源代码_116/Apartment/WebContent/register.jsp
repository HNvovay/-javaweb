<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/login.css">
<link rel="SHORTCUT ICON" href="images/Apartment.ico"/>
<title>注册界面</title>
</head>
<body>
<div class="login">
	<h1>你需要填写以下信息</h1>
	<form action="UserServlet" method="post">
		<input type="text" name="userName" placeholder="用户名" required="required" />
		<input type="text" name="userPassword" placeholder="密码" required="required" />
		<input type="text" name="userNumber" placeholder="联系电话" required="required" />
		<input type="hidden" name="User" value="register">
		<input type="submit" value="注册">
	</form>
</div>
</body>
</html>