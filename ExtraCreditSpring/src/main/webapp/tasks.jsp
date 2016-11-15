<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tasks</title>
</head>
<body>
	TaskList:
	<table border=1>
		<thead>
			<th>Name</th>
			<th>Description</th>
			<th>Status</th>
		</thead>
		<tbody>
			<c:forEach items="${taskList}" var="task">
				<tr>
					<td>${task.name}</td>
					<td>${task.description}</td>
					<td>${task.status}</td>
					<form:form method = "post" commandName = "forwardToResource">
						<td><a href="resource?taskId=${task.id}">View Resources</a></td>
					</form:form>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<form:form commandName="tasks" method = "post">
		Name: <form:input path="name"/><br/>
		Description: <form:input path="description"/><br/>
		<input type="submit" value="Save" />
	</form:form>
	
	<form:form method = "post" commandName = "backToHome">
		<a href="index">Home Page</a>
	</form:form>
	
</body>
</html>