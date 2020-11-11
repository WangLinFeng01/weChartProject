<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%--      <%
        pageContext.setAttribute("name", "apple");
     %>
     <%=pageContext.getAttribute("name") %>
     <%
        request.setAttribute("name1","apple");
     %>
     <%=request.getAttribute("name1") %>
     <%
        session.setAttribute("name2", "apple");
        response.sendRedirect("getPageContext");
     %>
     <%
        request.setAttribute("name1","apple");
     %>
     <jsp:forward page="getPageContext.jsp"></jsp:forward>
     <%=request.getAttribute("name1") %> --%>
     
<%--      <%
       
         application.setAttribute("name", "apple");
         System.out.println(application==request.getServletContext());
         response.sendRedirect("getPageContext");
     
     %> --%>

</body>
</html>