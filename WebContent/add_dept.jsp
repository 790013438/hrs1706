<%@ page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<h1>新增部门</h1>
		<hr>
		<div style="color:red; font-size: 12px;">${hint}</div>
		<form action="addDept" method="post">
			<input type="number" max="99" required name="no" placeholder="请输入部门编号">
			<br><br>
			<input type="text" name="name" required placeholder="请输入部门名称">
			<br><br>
			<input type="text"  name="location" required placeholder="请输入部门所在地">
			<br><br>
			<input type="submit" value="确定">
		</form>
		<a href="dept">返回部门列表</a>
	</body>
</html>