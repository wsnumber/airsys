<%@ page language="java" contentType="text/html; charset=utf8"
    import="util.Pager,entity.Account,java.util.List"
	pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>列出账号</title>
<link rel="stylesheet" href="/airsys/assets/cs/main.css">
<script type="text/javascript" src="/airsys/assets/js/user.js"></script>
</head>

<body>
	<h3 align="center">账号信息</h3>
	<hr color="red">
	<center>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>余额</th>
			</tr>
			<c:forEach items="${acts}" var="act">
				<tr>
					<td>${act.id}</td>
					<td>${act.name}</td>
					<td>${act.balance}</td>
					<td>
						<a href="user/${act.id }">查看</a>
						<a href="#" onclick="updateUser(${act.id})">修改</a>
						<a href="#" onclick="deleteUser(${act.id})">删除</a>
						
					</td>
				</tr>
			</c:forEach>
		</table>	
	
	<!-- 
		报错：404找不到user.js 
		为什么？
			Spring MVC 不是好东西，它的原因造成这样结局
			dispacherService 拦截，
			让Spring MVC中核心的Servlet不要拦截形如，js,css,jpg。。。的文件
		怎么做呢？
			修改配置Appconfig类，就能修改
			
		Git : 如何利用Git,开发项目，管理项目
			Linux(centos ubuntu ssolaries redhat 麒麟Linux)
			类Unix
			版本控制软件，监控纯文本文件（word,image,video 二进制文件）
			
			世界上最大的同性网站（全是男人）---GitHub(项目编码，)
		-->
	
	</center>
</body>
</html>

<%-- 
	<%@指令名字  perperty1=value1  perperty2=value2 ... %>  ---- JSP指令 
	<%@page %> 页面指令，可以导入包  <%@taglib %> 可以引入标签库
	${acts}   <==> List<Account> acts = request.getAttribute("acts");
	${act.id}  <==>  act.getId();
	引入标签库的步骤：
	     1.  pom.xml 中引入相应的jstl.jar  :  jsp standard tag library
	     2.  在jsp页面中利用标签指令引入相应的标签
	         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
	     3.  使用相应的标签
	     	 <c:forEach></c:forEach>   <c:if></c:if> 	
	实现前一页，后一页 
--%>