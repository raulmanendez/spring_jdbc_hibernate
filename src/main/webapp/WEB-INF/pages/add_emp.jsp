<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/form.css" />" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
<title>Employee</title>
</head>
<body>
	<div id="formsContent">
		<h2>Form</h2>
		<p>
			See the
			<code>muk.controller.EmployeeController</code>
			package for the @Controller code
		</p>
		<form:form method="post" modelAttribute="employee_obj" action="save_employee">
			<div class="header">
				<h2>Add Employee</h2>
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
				<legend>Employee Info</legend>
				
				<p>
					Employee Photo::
					<form:input path="image" type="file" />
				</p>
				<p>
					
				</p>
					<form:errors path="image" cssClass="error" />
				<p>
					Department::
					<form:select path="designation.department.id"
						onchange="getDesignation(this.value)">
						<form:option value="" label="--- Select ---" />
						<form:options items="${department_list}" itemValue="id"
							itemLabel="department" />
					</form:select>
				</p>
				<p>
					<form:errors path="designation.department.id" cssClass="error" />
				</p>
				<p>
					Designation ::
					<form:select path="designation.id" id="emp_designation">
						<form:option value="" label="Select Department First !" />
					</form:select>
				</p>
				<p>
					<form:errors path="designation.id" cssClass="error" />
				</p>
				<p>
					Employee Name::
					<form:input path="Name" />
				</p>
				<p>
					<form:errors path="Name" cssClass="error" />
				</p>

				<p>
					Employee Age::
					<form:input path="age" />
				</p>
				<p>
					<form:errors path="age" cssClass="error" />
				</p>

			</fieldset>

			<c:forEach var="i" begin="0" end="1">

				<fieldset>
					<legend>Employee Address ${i+1}</legend>
					<form:input path="list_address[${i}].addressType" type="hidden"
						value="EmpAddress" />
					<p>
						Address Line 1::
						<form:input path="list_address[${i}].address1" />
					</p>
					<p>
						<form:errors path="list_address[${i}].address1" cssClass="error" />
					</p>
					<p>
						Address Line 2::
						<form:input path="list_address[${i}].address2" />
					</p>
					<p>
						<form:errors path="list_address[${i}].address2" cssClass="error" />
					</p>
				</fieldset>
			</c:forEach>

			<input type="submit" value="Add Employee" />
		</form:form>
	</div>

	<fieldset>
		<legend>Existing Employee (s)</legend>
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>Image</th>
					<th>Department</th>
					<th>Designation</th>
					<th>Employee Name</th>
					<th>Employee Age</th>
					<th>Address 1</th>
					<th>Address 2</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="emp" items="${employee_list }">
					<tr>
						<td>${emp.id }</td>
						<td><img src="get_employee_image?employee_id=${emp.id }"></td>
						<td>${emp.designation.department.department }</td>
						<td>${emp.designation.designation }</td>
						<td>${emp.name }</td>
						<td>${emp.age }</td>

						<c:forEach var="address" items="${emp.list_address }">
							<td>${address }</td>
						</c:forEach>
						<td><a href="delete?emp_id=${emp.id }"> Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>

	<script type="text/javascript">
		function getDesignation(dept_id) {

			$.ajax({
				url : "../dept/get_desig.json?dept_id=" + dept_id,
				success : function(result) {
					$("#emp_designation").html(result);
					//console.log(result);
				},
				error : function() {
					alert("error");
				}
			});
		}
	</script>
</body>
</html>