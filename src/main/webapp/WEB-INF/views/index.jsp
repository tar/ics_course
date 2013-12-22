<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title><spring:message code="index.label.title"/></title>
</head> 
<body>
	<div class="userdiv">
		<label>${username}</label>
		<a href="../it/logout"><spring:message code="all.logout"/></a>
	</div>
	
	<c:if test ="${granted=='[ROLE_EMPLOYEE]'}">
		<a href="/it/tasks"><spring:message code="index.label.myworks"/></a>
	</c:if>
	<c:if test ="${granted=='[ROLE_MANAGER]'}">
		<a href="/it/tasks"><spring:message code="index.label.setworks"/></a>
	</c:if>
	<a href="/it/it"><spring:message code="index.label.it"/></a>
</body>
</html>
-->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title><spring:message code="index.label.title"/></title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ttt.css" type="text/css">
</head> 
<body>

	
	<div class="userdiv">
		<label>${username}</label>
		<a href="../it/logout"><spring:message code="all.logout"/></a>
	</div>
	
	<c:if test ="${granted=='[ROLE_EMPLOYEE]'}">
		<a href="/it/tasks"><button class="btn btn-default"><spring:message code="index.label.myworks"/></button></a>
	</c:if>
	<c:if test ="${granted=='[ROLE_MANAGER]'}">
		<a href="/it/tasks"><button class="btn btn-default"><spring:message code="index.label.setworks"/></button></a>
	</c:if>
	<a href="/it/it"><button class="btn btn-default"><spring:message code="index.label.it"/></button></a>
</body>
</html>