<%@ page language="java" contentType="text/html; charset=utf-8"
	isELIgnored="false" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆系统</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/content/img/shop_icon.ico">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/content/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/content/css/login.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row  login-head">
			<div class="col-lg-10 col-lg-push-1">
				<h1>
					<strong>AI Retail 智能零售系统</strong>
				</h1>
			</div>
		</div>
		<div class="row ">
			<div class="login-wrap">
				<img class="login-back"
					src="${pageContext.request.contextPath}/content/img/bgimg.png">
				<div class="login-area text-center">
					<h2 class="form-header">用户登陆</h2>
					<form action="${pageContext.request.contextPath}/dologin"
						method="post" id="loginform">
						<div class="form-area">
							<input class="form-control" type="text" name="userlabel" id="userlabel" placeholder="账号">
						</div>
						<div class="form-area">
							<input class="form-control" type="password" name="passwd" id="passwd" placeholder="密码">
						</div>
						<div class="form-area">
							<span class="warn-info">${failMsg}</span>
						</div>
						<div class="checkbox form-area">
							<label><input type="checkbox" name="rememberme">记住我</label>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="##">忘记密码？</a>
						</div>
						<div class="form-area">
							<button class="btn btn-primary" type="button" onclick="Confirm()">登陆</button>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/content/javascript/jquery-3.3.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/content/javascript/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/content/javascript/login.js"></script>
</body>
</html>