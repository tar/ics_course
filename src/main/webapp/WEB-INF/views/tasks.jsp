<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><spring:message code="tasks.label.title"/></title>
	</head>
<body>
	<label>${username}</label>
	<a href="../it/logout"><spring:message code="all.logout"/></a>
	<c:if test="${!empty tasklist}">
		<table class="data">
			<tr>
				<th><spring:message code="tasks.label.tasktitle"/></th>
				<th><spring:message code="tasks.label.description"/></th>
				<th><spring:message code="tasks.label.owner"/></th>
				<th><spring:message code="tasks.label.employee"/></th>
				<th><spring:message code="tasks.label.completed"/></th>
			</tr>
			<c:forEach items="${tasklist}" var="task">
				<c:if test="${task.getEmployeeID() eq user_id or granted eq '[ROLE_MANAGER]' }">
					<tr>
						<td>${task.getTitle() }</td>
						<td>${task.getDescription()}</td>
						<c:forEach items="${users}" var="user">
							<c:if test="${task.getOwnerID() eq user.id}">
								<td>${user.username}</td>
							</c:if>
						</c:forEach>
				 		<c:forEach items="${users}" var="user">
							<c:if test="${task.getEmployeeID() eq user.id}">
								<td>${user.username}</td>
							</c:if>
						</c:forEach>
						<c:if test="${!task.getCompleted() }">
							<c:if test="${task.getEmployeeID() eq user_id}">
								<td><a href="completeTask/${task.id }"><spring:message code="tasks.label.completeIt"/></a></td>
						</c:if>
						<c:if test="${task.getEmployeeID() ne user_id }">
							<td><spring:message code="tasks.label.uncompletedTask"/></td>
						</c:if>
						</c:if>
						<c:if test="${task.getCompleted() }">
							<td><spring:message code="tasks.label.completedTask"/></td>
						</c:if>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${granted eq '[ROLE_MANAGER]'}">
		<form:form method="post" action="addTask" commandName="newTask">
			<table>
				<tr>
					<td><form:label path="title"><spring:message code="tasks.label.tasktitle"/></form:label></td>
					<td><form:input path="title"/></td>
					<td><form:label path="description"><spring:message code="tasks.label.description"/></form:label></td>			
					<td><form:input path="description" /></td>
					<td>
						<form:select path="employeeID">
							<c:forEach items="${userlist }" var="employee">
								<option value="${employee.getId() }">${employee.getUsername() }  :  ${employee.getSkill() }</option>
							</c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="add" /></td>
				</tr>
			</table>
		</form:form>	
	</c:if>	
</body>
</html> -->
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><spring:message code="tasks.label.title"/></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ttt.css" type="text/css">
		
	</head>
<body>

	<label>${username}</label>
	<a href="../it/logout"><spring:message code="all.logout"/></a>
	<c:if test="${!empty tasklist}">
		<table class="table table-striped table-bordered table-hover ">
			<tr>
				<th><spring:message code="tasks.label.tasktitle"/></th>
				<th><spring:message code="tasks.label.description"/></th>
				<th><spring:message code="tasks.label.owner"/></th>
				<th><spring:message code="tasks.label.employee"/></th>
				<th><spring:message code="tasks.label.completed"/></th>
			</tr>
			<c:forEach items="${tasklist}" var="task">
				<c:if test="${task.getEmployeeID() eq user_id or granted eq '[ROLE_MANAGER]' }">
					<tr>
						<td>${task.getTitle() }</td>
						<td>${task.getDescription()}</td>
						<c:forEach items="${users}" var="user">
							<c:if test="${task.getOwnerID() eq user.id}">
								<td>${user.username}</td>
							</c:if>
						</c:forEach>
				 		<c:forEach items="${users}" var="user">
							<c:if test="${task.getEmployeeID() eq user.id}">
								<td>${user.username}</td>
							</c:if>
						</c:forEach>
						<c:if test="${!task.getCompleted() }">
							<c:if test="${task.getEmployeeID() eq user_id}">
								<td><a href="completeTask/${task.id }"><spring:message code="tasks.label.completeIt"/></a></td>
						</c:if>
						<c:if test="${task.getEmployeeID() ne user_id }">
							<td><spring:message code="tasks.label.uncompletedTask"/></td>
						</c:if>
						</c:if>
						<c:if test="${task.getCompleted() }">
							<td><spring:message code="tasks.label.completedTask"/></td>
						</c:if>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${granted eq '[ROLE_MANAGER]'}">
		<form:form method="post" action="addTask" commandName="newTask">
			<table align="center">
				<tr>
					<td><form:label path="title"><spring:message code="tasks.label.tasktitle"/></form:label></td>
					<td><form:input path="title"/></td>
					
					<td><form:label path="description"><spring:message code="tasks.label.description"/></form:label></td>			
					<td><form:input path="description" /></td>
					
					<td>
						<form:select path="employeeID">
							<c:forEach items="${userlist }" var="employee">
								<option value="${employee.getId() }">${employee.getUsername() }  :  ${employee.getSkill() }</option>
							</c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit" class="btn btn-default"> <spring:message code="tasks.label.add"/></button></td>
				</tr>
			</table>
		</form:form>	
	</c:if>	
</body>
</html> 
