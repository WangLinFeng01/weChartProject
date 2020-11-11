<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <%=pageContext.getAttribute("name") %>
     <%=request.getAttribute("name1") %>
     <%=session.getAttribute("name2") %>
     <%=application.getAttribute("name") %>
</body>
</html>