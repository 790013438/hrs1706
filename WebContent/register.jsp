<%@ page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<h1>用户注册</h1>
		<hr>
		<div style="color:red; font-size: 12px;">${hint}</div>
		<form action="reg" method="post">
			<input type="text" name="username" placeholder="请输入用户名">
			<br><br>
			<input type="password" name="password" placeholder="请输入密码">
			<br><br>
			<input type="email" name="email" placeholder="请输入邮箱"> 
			<br><br>
			<input type="submit" value="注册">
		</form>
		<a href="login.jsp">返回登录</a>
	</body>
</html>