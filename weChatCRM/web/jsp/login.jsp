<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
<%--     <%
	    String path=request.getContextPath();
	    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	%>
	<base href="<%=basePath%>"> --%>
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
          <div><a class="navbar-brand" href="#" style="font-size:32px;">WeChatCRM</a></div>
        </div>
      </div>
    </nav>

    <div class="container">
	  <%-- <h1 style="color:red;">${param.errorMsg}</h1> --%>
      <form id="loginForm" action="${pageContext.request.contextPath}/LoginServlet" method="post" class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 用户登录</h2>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="loginacct" name="loginacct" placeholder="请输入登录账号" autofocus>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="password" class="form-control" id="userpasswd" name="userpasswd" placeholder="请输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
		  </div>
		  <tr>
		<td height="35" align="center">自动登陆时间</td>
		<td>
		    <input type="radio" name="autologin" value="${60}"/>一分钟
			<input type="radio" name="autologin" value="${60*60*24*5}"/>5天
		</td>
	</tr>
		  
        <div class="checkbox">
          <label>
          <a>忘记密码</a>
          </label>
          <label style="float:right">
            <a href="register.jsp">我要注册</a>
          </label>
        </div>
        <input type="submit" class="btn btn-lg btn-success btn-block" value="登录"/>
      </form>
    </div>
    <script src="../jquery/jquery-2.1.1.min.js"></script>
    <script src="../bootstrap/js/bootstrap.min.js"></script>
	<script src="../layer/layer.js"></script>
  </body>
</html>