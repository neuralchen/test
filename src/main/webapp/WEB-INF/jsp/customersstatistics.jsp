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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/content/css/jquery.datetimepicker.min.css">
<title>信息统计</title>
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
						<li><a href="test">测试专用</a></li>
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
				<li><a href="dologout">注销</a></li>
			</ul>
		</div>
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 col-md-4 col-sm-6 col-xs-6">
				<select id="zonebox" class="form-control" id="zone">
					<option>地区1</option>
					<option>地区2</option>
					<option>地区3</option>
				</select>
			</div>
			<div class="col-lg-2 col-md-4 col-sm-6 col-xs-6">
				<select class="form-control" id="city">
					<option>城市1</option>
					<option>城市2</option>
					<option>城市3</option>
				</select>
			</div>
			<div class="col-lg-2 col-md-4 col-sm-6 col-xs-6">
				<select class="form-control" id="shop">
					<option value="112">店铺1</option>
					<option value="113">店铺2</option>
					<option value="114">店铺3</option>
				</select>
			</div>
			<div class="col-lg-2 col-md-4 col-sm-6 col-xs-6">
				<select class="form-control" id="basis">
					<option value="gender">性别</option>
					<option value="age">年龄</option>
				</select>
			</div>
			<div class="col-lg-2 col-md-4 col-sm-6 col-xs-6">
				<select class="form-control" name="enter" id="inout">
					<option value="In">进入</option>
					<option value="Out">离开</option>
				</select>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-lg-3 col-md-6 col-sm-6">
				<input type="text" value="" id="date_timepicker_start" name="starttime" />
				<span>至</span> <input type="text" value="" id="date_timepicker_end" name="endtime" />
			</div>
			<div class="col-lg-2 col-md-6 col-sm-6" style="font-size: 18px;">
				<select class="form-control" id="timetype">
					<option value="hour">按小时</option>
					<option value="day">按日</option>
					<option value="month">按月</option>
				</select>

			</div>
			<div class="col-lg-1 pull-right">
				<button type="button" class="btn btn-primary" onclick="Submit()">提交查询</button>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-lg-10 col-lg-offset-1">
				<div id="customersbar" style="min-width: 600px; height: 600px"></div>
			</div>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/content/javascript/jquery-3.3.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/content/javascript/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/content/javascript/jquery.datetimepicker.full.min.js"></script>
	<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
	<script src="http://cdn.hcharts.cn/highcharts/modules/exporting.js"></script>

	<script
		src="${pageContext.request.contextPath}/content/javascript/customersbar.js"></script>
</body>
</html>