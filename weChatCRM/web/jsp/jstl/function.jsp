<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>

<html>
<head>
<title>c:contains 标签实例</title>
</head>
<body>

<%-- 测试输入的字符串是否包含指定的子串
<c:set var="theString" value="I am from runoob"/>

<c:if test="${fn:contains(theString, 'runoob')}">
   <p>找到 runoob<p>
</c:if>

<c:if test="${fn:contains(theString, 'RUNOOB')}">
   <p>找到 RUNOOB<p>
</c:if> --%>


<%-- 测试输入的字符串是否包含指定的子串，大小写不敏感
<c:set var="theString" value="I am from runoob"/>

<c:if test="${fn:containsIgnoreCase(theString, 'runoob')}">
   <p>找到 runoob<p>
</c:if>

<c:if test="${fn:containsIgnoreCase(theString, 'RUNOOB')}">
     <p>找到 RUNOOB<p>
</c:if> --%>


<%-- 	测试输入的字符串是否以指定的后缀结尾
	<c:set var="theString" value="I am from runoob 123"/>

<c:if test="${fn:endsWith(theString, '123')}">
   <p>字符串以 123 结尾<p>
</c:if>

<c:if test="${fn:endsWith(theString, 'unoob')}">
   <p>字符串以 runoob 结尾<p>
</c:if> --%>


<%-- 	跳过可以作为XML标记的字符
	<c:set var="string1" value="This is first String."/>
<c:set var="string2" value="This <abc>is second String.</abc>"/>

<p>使用 escapeXml() 函数:</p>
<p>string (1) : ${fn:escapeXml(string1)}</p>
<p>string (2) : ${fn:escapeXml(string2)}</p>

<p>不使用 escapeXml() 函数:</p>
<p>string (1) : ${string1}</p>
<p>string (2) : ${string2}</p> --%>


<%-- 返回指定字符串在输入字符串中出现的位置
<c:set var="string1" value="This is first String."/>
<c:set var="string2" value="This <abc>is second String.</abc>"/>

<p>Index (1) : ${fn:indexOf(string1, "first")}</p>
<p>Index (2) : ${fn:indexOf(string2, "second")}</p> --%>


<%-- 将数组中的元素合成一个字符串然后输出
<c:set var="string1" value="www runoob com"/>
<c:set var="string2" value="${fn:split(string1, ' ')}" />
<c:set var="string3" value="${fn:join(string2, '-')}" />

<p>字符串为 : ${string3}</p>	 --%>


<%-- 返回字符串长度
<c:set var="string1" value="This is first String."/>
<c:set var="string2" value="This is second String." />

<p>字符串长度 (1) : ${fn:length(string1)}</p>
<p>字符串长度 (2) : ${fn:length(string2)}</p> --%>


<%-- 将输入字符串中指定的位置替换为指定的字符串然后返回
<c:set var="string1" value="I am from google"/>
<c:set var="string2" value="${fn:replace(string1, 
                                'google', 'runoob')}" />

<p>替换后的字符串 : ${string2}</p> --%>


<%-- 将字符串用指定的分隔符分隔然后组成一个子字符串数组并返回
<c:set var="string1" value="www runoob com"/>
<c:set var="string2" value="${fn:split(string1, ' ')}" />
<c:set var="string3" value="${fn:join(string2, '-')}" />

<p>string3 字符串 : ${string3}</p>

<c:set var="string4" value="${fn:split(string3, '-')}" />
<c:set var="string5" value="${fn:join(string4, ' ')}" />

<p>string5 字符串: ${string5}</p> --%>


<%-- 测试输入字符串是否以指定的前缀开始
<c:set var="string" value="Runoob: I am from Runoob."/>
<c:if test="${fn:startsWith(string, 'Google')}">
   <p>字符串以 Google 开头</p>
</c:if>
<br />
<c:if test="${fn:startsWith(string, 'Runoob')}">
   <p>字符串以 Runoob 开头</p> 
</c:if> --%>


<%--    返回字符串的子集
<c:set var="string1" value="This is first String."/>
<c:set var="string2" value="${fn:substring(string1, 5, 15)}" />

<p>生成的子字符串为 : ${string2}</p> --%>


<%-- 返回字符串在指定子串之后的子集
<c:set var="string1" value="This is first String."/>
<c:set var="string2" value="${fn:substringAfter(string1, 'is')}" />

<p>生成的子字符串 : ${string2}</p> --%>


<%-- 返回字符串在指定子串之前的子集
<c:set var="string1" value="This is first String."/>
<c:set var="string2" value="${fn:substringBefore(string1, 
                                            'first')}" />

<p>生成的子字符串 : ${string2}</p> --%>


<%-- 	将字符串中的字符转为小写
	<c:set var="string1" value="I am from RUNOOB"/>
<c:set var="string2" value="${fn:toLowerCase(string1)}" />

<p>字符串为 : ${string2}</p> --%>


<%-- 将字符串中的字符转为大写
<c:set var="string1" value="I am from runoob"/>
<c:set var="string2" value="${fn:toUpperCase(string1)}" />

<p>字符串为 : ${string2}</p> --%>


移除首尾的空白符
<c:set var="string1" value="I am from runoob         "/>
<p>string1 长度 : ${fn:length(string1)}</p>

<c:set var="string2" value="${fn:trim(string1)}" />
<p>string2 长度 : ${fn:length(string2)}</p>
<p>字符串为 : ${string2}</p>
</body>
</html>