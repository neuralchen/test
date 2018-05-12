<%@ page language="java" contentType="text/html; charset=utf-8"
	isELIgnored="false" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/content/img/shop_icon.ico">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/content/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/content/css/heatmap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/content/css/jquery.datetimepicker.min.css">
<title>区域热力图</title>
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
				<li><a href="dologout">注销</a></li>
			</ul>
		</div>
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2">
				<select class="form-control" id="zone">
					<%-- <option value="${info.zoneID }">${info.name}</option> --%>
					<option value="001">华东地区</option>
				</select>
			</div>
			<div class="col-lg-2">
				<select class="form-control" id="city">
					<option value="001">上海</option>
					<option value="001">杭州</option>
					<option value="001">苏州</option>
					<%-- <c:forEach items="${info.cities}" var="item">
						<option value="${item.cityID}">${item.name}</option>
					</c:forEach> --%>
				</select>
			</div>
			<div class="col-lg-2">
				<select class="form-control" id="rankid">
					<option value="666">测试用店铺1</option>
					<option value="111">测试用店铺2</option>
				</select>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-lg-3 col-md-6 col-sm-6">
				<input type="text" value="" id="date_timepicker_start"
					name="starttime" /> <span>至</span> <input type="text" value=""
					id="date_timepicker_end" name="endtime" />
			</div>
			<div class="col-lg-2 col-md-6 col-sm-6" style="font-size: 18px;">
				<select class="form-control" id="timetype">
					<option value="10min">按10分钟</option>
					<option value="hour">按小时</option>
					<option value="day">按日</option>
					<option value="month">按月</option>
				</select>

			</div>
			<div class="col-lg-1 pull-right">
				<button type="submit" class="btn btn-primary" onclick="Confirm()">提交查询</button>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-lg-1 col-lg-offset-4 col-md-1 col-md-offset-4 col-sm-1 col-sm-offset-4 col-xs-2 col-xs-offset-2 text-center">
				<button class="btn btn-default btn-lg" onclick="pre()">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				</button>
			</div>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-4">
				<h4 class="text-center" id="timestamp">未选择时间</h4>
			</div>

			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 text-center">
				<button class="btn btn-default btn-lg" onclick="afte()">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				</button>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-lg-10 col-lg-offset-1 text-center">
				<div id="chart"></div>
			</div>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/content/javascript/jquery-3.3.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/content/javascript/bootstrap.min.js"></script>
	<script src="https://d3js.org/d3.v3.min.js"></script>
	<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
	<script
		src="${pageContext.request.contextPath}/content/javascript/jquery.datetimepicker.full.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/content/javascript/heatmap.js"></script>
</body>
</html>