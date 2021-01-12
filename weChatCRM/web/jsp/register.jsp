<%@page pageEncoding="UTF-8"%>

<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
	<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/font-awesome.min.css">
	<link rel="stylesheet" href="../css/login.css">
	<style>

	</style>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <div><a class="navbar-brand" href="#" style="font-size:32px;">MES-System</a></div>
        </div>
      </div>
    </nav>

    <div class="container">
	  <%-- <h1 style="color:red;">${param.errorMsg}</h1> --%>
      <form id="loginForm" action="${pageContext.request.contextPath}/registerServlet" method="post" class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i>用户注册</h2>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="loginacct" name="loginacct" placeholder="请输入注册账号" autofocus>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="password" class="form-control" id="userpasswd" name="userpasswd" placeholder="请输入注册密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
		  	<div class="form-group has-success has-feedback">
			<input type="email" class="form-control" id="email" name="email" placeholder="请输入邮箱地址" style="margin-top:10px;">
			<span class="glyphicon glyphicon-email form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
		  </div>
		  <input type="submit" class="btn btn-lg btn-success btn-block" value="注册"/>
      </form>
    </div>
    <script src="../jquery/jquery-2.1.1.min.js"></script>
    <script src="../bootstrap/js/bootstrap.min.js"></script>
	<script src="../layer/layer.js"></script>
  </body>
</html>