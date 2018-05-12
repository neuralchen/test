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
<title>测试用页面</title>
</head>
<body>
    <br />
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
			<label>时间戳选择：</label>
				<input type="text" value="" id="date_timepicker" name="starttime" />
			</div>
		</div>
		<br />
		<hr />
		<h2>进出客人数据测试：</h1>
		<div class="row">
			<div class="col-lg-2">
				<select class="form-control" id="mode">
					<option value="in">进入的客人</option>
					<option value="out">出去的客人</option>
				</select>
			</div>
			<div class="col-lg-2">
				<textarea id="face_pic" style="height:200px;"></textarea>
			</div>
			<div class="col-lg-2">
				<select class="form-control" id="gender">
					<option value="Female">女</option>
					<option value="Male">男</option>
				</select>
			</div>
			<div class="col-lg-2">
				<select class="form-control" id="age">
					<option value="1">20岁以下</option>
					<option value="2">21-30岁</option>
					<option value="3">31-40岁</option>
					<option value="4">41-50岁</option>
					<option value="5">51-60岁</option>
					<option value="6">61岁及以上</option>
				</select>
			</div>
			<div class="col-lg-2" >
				<textarea id="whole_body_pic" style="height:200px;"></textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-lg-3">
				<button class="btn btn-primary" onclick="send()">顾客数据提交</button>
			</div>
		</div>

		<br />
		<hr />
		<h2>热力图数据测试：</h1>
		<div class="row">
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="1,1" value="1" min="1">
			</div>
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="1,2" value="1" min="1">
			</div>
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="1,3" value="1" min="1">
			</div>
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="1,4" value="1" min="1">
			</div>
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="1,5" value="1" min="1">
			</div>
		</div>
		<div class="row">
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="2,1" value="1" min="1">
			</div>
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="2,2" value="1" min="1">
			</div>
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="2,3" value="1" min="1">
			</div>
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="2,4" value="1" min="1">
			</div>
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="2,5" value="1" min="1">
			</div>
		</div>
		<div class="row">
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="3,1" value="1" min="1">
			</div>
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="3,2" value="1" min="1">
			</div>
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="3,3" value="1" min="1">
			</div>
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="2,4" value="1" min="1">
			</div>
			<div class="col-lg-1">
				<input class="form-control heatmap" type="number" placeholder="2,5" value="1" min="1">
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-lg-3">
				<button class="btn btn-primary" onclick="heatmapsend()">热力图数据提交</button>
			</div>
		</div>
		<br />
		<hr/>

		<div>
			<h1 id="result">未获取结果</h1>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/content/javascript/jquery-3.3.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/content/javascript/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/content/javascript/jquery.datetimepicker.full.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/content/javascript/test.js"></script>
</body>
</html>