<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource</title>
</head>
<body>

Resource List:
	<table border=1>
		<thead>
			<th>Name</th>
		</thead>
		<tbody>
			<c:forEach items="${resourceList}" var="resource">
				<tr>
					<td>${resource.name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<form:form method = "post" commandName="addResource">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="name"/></td>
				<td><form:errors path="name"></form:errors>
			</tr>
		</table>
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>