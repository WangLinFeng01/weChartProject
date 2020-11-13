<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>

<html lang="zh-CN">
  <head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${basePath}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${basePath}/css/main.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	table tbody tr:nth-child(odd){background:#F4F4F4;}
	table tbody td:nth-child(even){color:#C00;}
	img:hover{
		margin-bottom:0px; 
	}
	img{
		margin: 10px 7px; 
		background-color:#FFFFF0; 
		transition: margin-bottom 0.8s;
	} 
	.ddd{ 
		padding: 5px;
	    width: 187px;
    	height: 366px;
	    margin: 0px 7px;
		display:inline-block;
		border:1px solid black; 
		background-color:#FFFFF0; 
		display:inline-block;
	}
	</style>
  </head>
   <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <div><a class="navbar-brand" style="font-size:32px;" href="#">微信客服管理系统</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li style="padding-top:8px;">
				<div class="btn-group">
				  <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i>${loginUser.username} <span class="caret"></span>
				  </button>
					  <ul class="dropdown-menu" role="menu">
						<li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
						<li class="divider"></li>
						<li><a href="DispatcherServlet?method=loginPage"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
					  </ul>
			    </div>
			</li>
            <li style="margin-left:10px;padding-top:8px;">
				<button type="button" class="btn btn-default btn-danger">
				  <span class="glyphicon glyphicon-question-sign"></span> 帮助
				</button>
			</li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
			<div class="tree">
				<ul style="padding-left:0px;" class="list-group">
					<li class="list-group-item tree-closed" >
						<a href="main.html"><i class="glyphicon glyphicon-dashboard"></i> 控制面板</a> 
					</li>
					<li class="list-group-item tree-closed">
						<span><i class="glyphicon glyphicon glyphicon-tasks"></i> 客服管理 <span class="badge" style="float:right">5</span></span> 
						<ul style="margin-top:10px;display:none;">
							<li style="height:30px;">
								<a href="${basePath}/registerListServlet"><i class="glyphicon glyphicon-user"></i> 信息维护</a> 
							</li>
							<li style="height:30px;">
								<a href="${basePath}/PictruelimitServlet"><i class="glyphicon glyphicon-king"></i> 图片管理</a> 
							</li>
							<li style="height:30px;">
								<a href="${basePath}/jsp/user/titles.jsp"><i class="glyphicon glyphicon-lock"></i> 用户标签</a> 
							</li>
							<li style="height:30px;">
								<a href="/DispatcherServlet?method=rolePage"><i class="glyphicon glyphicon-king"></i> 活动分析</a> 
							</li>
						</ul>
					</li>

				</ul>
			</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="panel panel-default">
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			  </div>
			  <div class="panel-body">
<form class="form-inline" role="form" style="float:left;">
  <div class="form-group has-feedback">
    <div class="input-group">
      <div class="input-group-addon">查询条件</div>
      <input id="queryText" class="form-control has-success" type="text" placeholder="请输入查询条件">
    </div>
  </div>
  <button id="queryBtn" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
</form>

<br>
  <hr style="clear:both;">
           <hr style="clear:both;">
          <div class="table-responsive">
            <form id="userForm">
            <table class="table  table-bordered">
	              <tbody id="userData">
	              	<c:forEach items="${material}" var="material" varStatus="s">
		              	<div class = "ddd">
							<label>编号：${material.id}</label>
							<a href="${basePath}/ssServlet?imgUrl=${material.imgurl}&theme_name=${material.theme_name}"><button type='submit' style="float:right;width:45px;height:23px; background-color:#FFFFF0;">生成</button></a><br/>
							<label>主题：${material.theme_name}</label>
							<div style = "float:right;">
								<button type='submit'  class='btn btn-primary btn-xs'><i class='glyphicon glyphicon-pencil'></i></button>
								<a href="${basePath}/PictruelimitServlet?method=delect&start_id=${material.id}"><button type='submit'  class='btn btn-danger btn-xs'><i class='glyphicon glyphicon-remove'></i></button></a>
							</div>
							<img alt="没有图片" src="${material.imgurl}" style="width: 164px;height:auto">
						</div>
					</c:forEach> 
	              </tbody>
			  <tfoot>
			     <tr >
				     <td colspan="6" align="center">
						<ul class="pagination">
							<li><a href="${basePath}/PictruelimitServlet?start=${pre}">上一页</a></li>
							<li class=''><a href="${basePath}/PictruelimitServlet?start=0">${pages}/${sum}</a></li>
							<li><a href="${basePath}/PictruelimitServlet?start=${next}">下一页</a></li>
						</ul>
					 </td>
				 </tr>
			  </tfoot>
            </table>
           </form>  
        </div>
	</div>
      </div>
      <div class="panel panel-warning addDiv" style="  width: 445px; margin-left: 238">
	  <div class="panel-heading">新增活动主题和图片</div>
	  <div class="panel-body">
	    	<form method="post" id="addForm" action="${basePath}/materialLoadServlet" enctype="multipart/form-data">
	    		<table class="addTable">
	    			<tr style="background:white">
	    				<td style="margin-left:10">图片主题</td>
	    				<td><input id="name" name="name" type="text" class="form-control" style="margin-left: 20"></td>
	    			</tr>
	    			<tr>
	    				<td>图片</td>
	    				<td>
	    					<input id="categoryPic" accept="image/*" type="file" name="filepath" style="margin-left: 20" />
	    				</td>
	    			</tr>
	    			<tr class="submitTR" style="background:white">
	    				<td colspan="2" align="center">
	    					<button type="submit" class="btn btn-success">提 交</button>
	    				</td>
	    			</tr>
	    		</table>
	    	</form>
	  </div>
    </div>

    <script src="${basePath}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${basePath}/bootstrap/js/bootstrap.min.js"></script>
 	<script src="${basePath}/script/docs.min.js"></script>
 	<script src="${basePath}/layer/layer.js"></script>
 	<script type="text/javascript">
			$(function() {
				$(".list-group-item").click(function() {
					// jquery对象的回调方法中的this关键字为DOM对象
					// $(DOM) ==> JQuery
					if ($(this).find("ul")) { // 3 li
						$(this).toggleClass("tree-closed");
						if ($(this).hasClass("tree-closed")) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
			}); 
		</script>
  </body>
</html>
