<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    1.jsp  4个作用域
    pageContext:当前页面
    request:一次请求
    sessionContext:一次会话
    applicationContext:全局，所有用户共享
    
       像上面的这种可以直接使用的对象称为jsp的内置对象--jsp_service 方法中的变量一共9个，
       分别是：request,response,out,page,pageContext,session,application==servletContext,config,exception
       <br/>
       page:<%=page %>
       <br/>
       this:<%=this %>
       
    
</body>
</html>