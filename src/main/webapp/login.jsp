<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><spring:message code="login.label.title" /></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ttt.css" type="text/css">
		
	</head>
	<body>
		<h1 align="center"><spring:message code="login.label.title" /></h1>	
		<c:if test="${not empty param.error}">
			<font color="red"><spring:message code="login.label.loginerror" />: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
		</c:if>
		<form method="POST" action="<c:url value="/j_spring_security_check" />">
			<table align="center">
				<tr>
					<td align="right">
						<spring:message code="login.label.login" />
					</td>
					<td>
						<input type="text" name="j_username" />
					</td>
				</tr>
				<tr>
					<td align="right">
						<spring:message code="login.label.password" />
					</td>
					<td>
						<input type="password" name="j_password" />
					</td>
				</tr>
				<tr>
					<td align="right">
						<spring:message code="login.label.remember" />
					</td>
					<td>
						<input type="checkbox" name="_spring_security_remember_me" />
					</td>
				</tr>
		<!-- 		<tr>
					<td colspan="2" align="right">					
						<input type="submit" value="<spring:message code="login.button.submit"/>"/>
						<input type="reset" value="<spring:message code="login.button.reset"/>"/>
					</td>
				</tr>-->
				<tr><td><button type="submit" class="btn btn-default"><spring:message code="login.button.submit"/></button> </td>
				<td><button type="reset" class="btn btn-default" ><spring:message code="login.button.reset"/></button></td></tr> 
		</table>
	</form>
</body>
</html>
