<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/form.css" />" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
<title>Department</title>
</head>
<body>
<div id="formsContent">
		<h2>Form</h2>
		<p>
			See the <code>muk.controller.DepartmentController</code> package for the @Controller code	
		</p>
	<form:form method="post" modelAttribute="department_obj"
		action="save_department">
		<div class="header">
			<h2>Add Department</h2>
			<c:if test="${not empty message}">
				<div id="message" class="success">
					<c:out value="${message}" />
				</div>
			</c:if>
			<s:bind path="*">
				<c:if test="${status.error}">
					<div id="message" class="error">Form has errors</div>
				</c:if>
			</s:bind>
		</div>
		
		<fieldset>
		  		<legend>Department Info</legend>
		<p>
			Department Code::
			<form:input path="dept_code" />
		</p>
		<p>
			<form:errors path="dept_code" cssClass="error" />
		</p>
		<p>
			Department Name::
			<form:input path="department" />
		</p>
		<p>
			<form:errors path="department" cssClass="error" />
		</p>
		<input type="submit" value="Add Department" />
		
		</fieldset>
	</form:form>
	
	</div>

<fieldset>
<legend>Existing Department (s)</legend>
<table border="1">
<thead>
	<tr>
		<th>ID</th>
		<th>Code</th>
		<th>Name</th>
		<th>Delete</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="dept" items="${department_list }">
	<tr>
		<td>${dept.id }</td>
		<td>${dept.dept_code }</td>
		<td>${dept.department }</td>
		<td><a href="delete?dept_id=${dept.id }"> Delete</a></td>
	</tr>
	</c:forEach>
</tbody>
</table>
</fieldset>
</body>
</html>