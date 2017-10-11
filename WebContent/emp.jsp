<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!-- subclipse -->
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
				<h1>${dept.name}员工信息</h1>
				<hr>
				<table id="empInfo" class="table table-striped">
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>职位</th>
						<th>状态</th>
						<th>电话</th>
						<th>部门名称</th>
						<th>操作</th>
					</tr>
				</table>
				<div align="center">
					<a id="first">首页</a>&nbsp;&nbsp;	
					<a id="prev">上一页</a>&nbsp;
					<span id="pageInfo"></span>
					<a id="next">下一页</a>&nbsp;&nbsp;
					<a id="last">末页</a>
				</div>
				<a href="dept">返回部门列表</a>
				<a href="add_emp.jsp?dno=${dept.no}">新增员工</a>
			</div>
		</div>
	</div>
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script>
		$(function() {
			loadDataModel(1);
		});
		function loadDataModel(page) {
			$.getJSON("emp", { 'page': page }, function(json) {
				var empList = json.dataModel;
				var prevPage = json.currentPage - 1;
				var nextPage = json.currentPage + 1;
				var lastPage = json.totalPage;
				$("#pageInfo").text(json.currentPage + " / " + json.totalPage);
				if (json.currentPage > 1) {
					$("#first").attr("href", "javascript:loadDataModel(1)");
					$("#prev").attr("href", "javascript:loadDataModel(" + prevPage + ")");
				} else {
					$("#first").removeAttr("href");
					$("#prev").removeAttr("href");
				}
				if (json.currentPage < json.totalPage) {
					$("#next").attr("href", "javascript:loadDataModel(" + nextPage + ")")
					$("#last").attr("href", "javascript:loadDataModel(" + lastPage + ")")
				} else {
					$("#next").removeAttr("href");
					$("#last").removeAttr("href");
				}
				$("#empInfo tr:gt(0)").remove();
				for (var i = 0; i < empList.length; ++i) {
					var emp = empList[i];
					var tr = $("<tr>")
						.append($("<td>").text(emp.no))
						.append($("<td>").append($("<a>")
								.text(emp.name).attr("href", "empDetail?no=" + emp.no)))
						.append($("<td>").text(emp.sex))
						.append($("<td>").text(emp.job))
						.append($("<td>").text(emp.status))				
						.append($("<td>").text(emp.tel))
						.append($("<td>").text(emp.deptName))
						.append($("<td>")
								.append($("<a>").text("编辑").attr("href", "editEmp?no=" + emp.no))
								.append("&nbsp;&nbsp;")
								.append($("<a>").text("删除").attr("href", "delEmp?no=" + emp.no))
						);
					$("#empInfo").append(tr);
				}
			});
		}
	</script>
</body>
</html>