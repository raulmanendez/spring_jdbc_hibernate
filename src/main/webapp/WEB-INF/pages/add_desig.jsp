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
<title>Designation</title>
</head>
<body>
<div id="formsContent">
		<h2>Form</h2>
		<p>
			See the <code>muk.controller.DesignationController</code> package for the @Controller code	
		</p>
	<form:form method="post" modelAttribute="designation_obj" action="save_designation">
		<div class="header">
			<h2>Add Designation</h2>
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
		  		<legend>Designation Info</legend>
		 <p>
			Department::
			<form:select path="department.id">
				 <form:option value="" label="--- Select ---"/>
				 <form:options items="${department_list}" itemValue="id" itemLabel="department" />
			</form:select>
		</p>
		<p>
			<form:errors path="department.id" cssClass="error" />
		</p>
		<p>
			Designation Code::
			<form:input path="desig_code" />
		</p>
		<p>
			<form:errors path="desig_code" cssClass="error" />
		</p>
		<p>
			Designation Name::
			<form:input path="designation" />
		</p>
		<p>
			<form:errors path="designation" cssClass="error" />
		</p>
		<input type="submit" value="Add Designation" />
		
		</fieldset>
	</form:form>
</div>


<fieldset>
<legend>Existing Designation (s)</legend>
<table border="1">
<thead>
	<tr>
		<th>ID</th>
		<th>Department Code</th>
		<th>Department Name</th>
		<th>Designation Code</th>
		<th>Designation Name</th>
		<th>Delete</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="desig" items="${designation_list }">
	<tr>
		<td>${desig.id }</td>
		<td>${desig.department.dept_code }</td>
		<td>${desig.department.department }</td>
		<td>${desig.desig_code }</td>
		<td>${desig.designation }</td>
		<td><a href="delete?desig_id=${desig.id }"> Delete</a></td>
	</tr>
	</c:forEach>
</tbody>
</table>
</fieldset>
</body>
</html>