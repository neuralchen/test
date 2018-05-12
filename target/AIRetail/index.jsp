<%@ page language="java" contentType="text/html; charset=utf-8"
	isELIgnored="false" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/content/img/shop_icon.ico">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/content/css/bootstrap.min.css">
<title>欢迎使用AI Retail系统</title>
</head>
<body style="background-color: lightgray;">
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#header-navbar"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">AI Retail System</a>
		</div>

		<div class="collapse navbar-collapse" id="header-navbar">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">系统功能<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="report">客流报表</a></li>
						<li><a href="customers">信息统计</a></li>
						<li><a href="heatmap">区域热力图</a></li>
						<li><a href="#">动态人流</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">店铺层级管理</a></li>
						<li><a href="#">店铺平面图管理</a></li>
						<li><a href="#">用户管理</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">用户名<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">个人信息</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul></li>
				<li><a href="#">注销</a></li>
			</ul>
		</div>
	</div>
	<!-- /.container-fluid --> </nav>

	<script
		src="${pageContext.request.contextPath}/content/javascript/jquery-3.3.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/content/javascript/bootstrap.min.js"></script>
</body>
</html>