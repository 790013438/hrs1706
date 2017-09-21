<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h1>${deptName}员工信息</h1>
				<hr>
				<c:if test="${not empty empList}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>职位</th>
							<th>状态</th>
							<th>电话</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${empList}" var="emp">
						<tr id="tr${emp.no}">
							<td>${emp.no}</td>
							<td>${emp.name}</td>
							<td>${emp.sex}</td>
							<td>${emp.job}</td>
							<td>${emp.status ? "在职" : "离职"}</td>
							<td>${emp.tel}</td>
							<td>
								<a href="">删除</a> 
								<a href="">编辑</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				</c:if>
				<a href="dept">返回部门列表</a>
				<a href="add_emp.jsp">新增员工</a>
			</div>
		</div>
	</div>
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>