<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<!-- <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><spring:message code="it.label.title"/></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ttt.css" type="text/css">
		
	</head>
	<body>
		<label>${username}</label>
		<a href="../it/logout"><spring:message code="all.logout"/></a>
		<c:if test="${!empty itworklist}">
			<table class="table table-striped table-bordered table-hover ">
				<tr>
					<th><spring:message code="it.th.description"/></th>
					<th><spring:message code="it.th.creator"/></th>
					<th><spring:message code="it.th.completed"/></th>
				</tr>
				<c:forEach items="${itworklist}" var="itwork">
					<c:if test="${itwork.getCreatorID() eq user_id or granted eq '[ROLE_IT]' }">
						<tr>
							<td>${itwork.getDescription()}</td>
							<c:forEach items="${users}" var="user">
								<c:if test="${itwork.getCreatorID() eq user.id}">
									<td>${user.username}</td>
								</c:if>
							</c:forEach>							
							<c:if test="${!itwork.getCompleted() }">
								<c:if test="${granted eq '[ROLE_IT]'}">
									<td><a href="complete/${itwork.id }"><spring:message code="it.td.completeIt"/></a></td>
								</c:if>
								<c:if test="${granted ne '[ROLE_IT]' }">
									<td><spring:message code="it.td.uncompleted"/></td>
								</c:if>
							</c:if>				
							<c:if test="${itwork.getCompleted() }">
								<td><spring:message code="it.td.completed"/></td>
							</c:if>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</c:if>
		<form:form method="post" action="addITWork" commandName="newITWork">
			<table align="center">
				<tr>
					<td><form:label path="description"><spring:message code="it.label.description"/></form:label></td>			
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="add" /></td>
				</tr>
			</table>
		</form:form>
	</body>-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><spring:message code="it.label.title"/></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ttt.css" type="text/css">
		
	</head>
	<body>
		<label>${username}</label>
		<a href="../it/logout"><spring:message code="all.logout"/></a>
		<c:if test="${!empty itworklist}">
			<table class="table table-striped table-bordered table-hover ">
				<tr>
					<th><spring:message code="it.th.description"/></th>
					<th><spring:message code="it.th.creator"/></th>
					<th><spring:message code="it.th.completed"/></th>
				</tr>
				<c:forEach items="${itworklist}" var="itwork">
					<c:if test="${itwork.getCreatorID() eq user_id or granted eq '[ROLE_IT]' }">
						<tr>
							<td>${itwork.getDescription()}</td>
							<c:forEach items="${users}" var="user">
								<c:if test="${itwork.getCreatorID() eq user.id}">
									<td>${user.username}</td>
								</c:if>
							</c:forEach>							
							<c:if test="${!itwork.getCompleted() }">
								<c:if test="${granted eq '[ROLE_IT]'}">
									<td><a href="complete/${itwork.id }"><spring:message code="it.td.completeIt"/></a></td>
								</c:if>
								<c:if test="${granted ne '[ROLE_IT]' }">
									<td><spring:message code="it.td.uncompleted"/></td>
								</c:if>
							</c:if>				
							<c:if test="${itwork.getCompleted() }">
								<td><spring:message code="it.td.completed"/></td>
							</c:if>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</c:if>
		<form:form method="post" action="addITWork" commandName="newITWork">
			<table align="center">
				<tr>
					<td><form:label path="description"><spring:message code="it.label.description"/></form:label></td>			
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit" class="btn btn-default"> <spring:message code="tasks.label.add"/></button></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>
