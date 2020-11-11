<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>c:out 标签实例</title>
</head>
<body>
<%--     <h1>&lt;c:out&gt; 实例</h1>
        <c:out value="&lt要显示的数据对象（未使用转义字符）&gt" escapeXml="true" default="默认值"></c:out><br/>
          <c:out value="&lt要显示的数据对象（使用转义字符）&gt" escapeXml="false" default="默认值"></c:out><br/>
    <c:out value="${null}" escapeXml="false">使用的表达式结果为null，则输出该默认值</c:out><br/> --%>
    
    
<%--     set
    <c:set var="salary" scope="session" value="${2000*2}"/>
    <c:out value="${salary}"/> --%>
    	
    
<%--     remove移除数据
    <c:set var="salary" scope="session" value="${2000*2}"/>
    <p>salary 变量值: <c:out value="${salary}"/></p>
    <c:remove var="salary"/>
    <p>删除 salary 变量后的值: <c:out value="${salary}"/></p> --%>
    
    
<%--      处理产生错误的异常状况
   <c:catch var ="catchException">
   <% int x = 5/0;%>
   </c:catch>

   <c:if test = "${catchException != null}">
   <p>异常为 : ${catchException} <br />
     发生了异常: ${catchException.message}</p>
   </c:if> --%>
   
<%--    if判断表达式
   <c:set var="salary" scope="session" value="${2000*2}"/>
   <c:if test="${salary > 2000}">
   <p>我的工资为: <c:out value="${salary}"/><p>
   </c:if> --%>
   
<%--    <c:choose>标签与Java switch语句的功能一样，用于在众多选项中做出选择
   <c:set var="salary" scope="session" value="${2000*2}"/>
   <p>你的工资为 : <c:out value="${salary}"/></p>
<c:choose>
    <c:when test="${salary <= 0}">
       太惨了。
    </c:when>
    <c:when test="${salary > 1000}">
       不错的薪水，还能生活。
    </c:when>
    <c:otherwise>
        什么都没有。
    </c:otherwise>
</c:choose> --%>

<%-- <c:choose>标签与Java switch语句的功能一样，用于在众多选项中做出选择
<c:set var="salary" scope="session" value="${2000*2}"/>
<p>你的工资为 : <c:out value="${salary}"/></p>
<c:choose>
    <c:when test="${salary <= 0}">
       太惨了。
    </c:when>
    <c:when test="${salary > 1000}">
       不错的薪水，还能生活。
    </c:when>
    <c:otherwise>
        什么都没有。
    </c:otherwise>
</c:choose> --%>


<%-- <c:choose>标签与Java switch语句的功能一样，用于在众多选项中做出选择
<c:set var="salary" scope="session" value="${2000*2}"/>
<p>你的工资为 : <c:out value="${salary}"/></p>
<c:choose>
    <c:when test="${salary <= 0}">
       太惨了。
    </c:when>
    <c:when test="${salary > 1000}">
       不错的薪水，还能生活。
    </c:when>
    <c:otherwise>
        什么都没有。
    </c:otherwise>
</c:choose>	 --%>


<%-- <c:import>标签提供了所有<jsp:include>行为标签所具有的功能，同时也允许包含绝对URL
<c:import var="data" url="http://www.runoob.com"/>
<c:out value="${data}"/> --%>


<%-- <c:forEach>标签是更加通用的标签，因为它迭代一个集合中的对象
<c:forEach var="i" begin="1" end="5">
   Item <c:out value="${i}"/><p>
</c:forEach> --%>


<%-- <c:forTokens>标签通过指定分隔符将字符串分隔为一个数组然后迭代它们
<c:forEach var="i" begin="1" end="5">
   Item <c:out value="${i}"/><p>
</c:forEach> --%>


<%-- <c:param>标签用于在<c:url>标签中指定参数，而且与URL编码相关。
在<c:param>标签内，name属性表明参数的名称，value属性表明参数的值。
    <h1>&lt;c:param&gt; 实例</h1>
    <c:url var="myURL" value="main.jsp">
        <c:param name="name" value="Runoob"/>
        <c:param name="url" value="www.runoob.com"/>
    </c:url>
      <a href="/<c:out value="${myURL}"/>">
 使用 &lt;c:param&gt; 为指定URL发送两个参数。</a> --%>
 
 
<%--  <c:redirect>标签通过自动重写URL来将浏览器重定向至一个新的URL，它提供内容相关的URL，并且支持c:param标签
 <c:redirect url="http://www.runoob.com"/> --%>
 
 
<%--  <c:url>标签将URL格式化为一个字符串，然后存储在一个变量中。

这个标签在需要的时候会自动重写URL。

var属性用于存储格式化后的URL。

<c:url>标签只是用于调用response.encodeURL()方法的一种可选的方法。它真正的优势在于提供了合适的URL编码，包括<c:param>中指定的参数。
     <h1>&lt;c:url&gt实例 Demo</h1>
    <a href="<c:url value="http://www.runoob.com"/>">
     这个链接通过 &lt;c:url&gt; 标签生成。
    </a> --%>
</body>
</html>