<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="post" modelAttribute="student_object" action="student_add_data">
<h3>Student Information System</h3>
<p>Name::<form:input path="student_name"/></p>
<p><form:errors path="student_name" cssClass="error"/></p>   
<p>Class::<form:input path="student_class"/></p>
<p><form:errors path="student_class" cssClass="error"/></p>   
<p>Age::<form:input path="student_age"/></p>
<p><form:errors path="student_age" cssClass="error"/></p>   

<input type="submit" value="Save Student"/>
</form:form>


<table border="1">
<thead>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Class</th>
		<th>Age</th>
	</tr>
</thead>

<tbody>
	<c:forEach var="student" items="${list_stud }">
	<tr>
		<td>${student.id }</td>
		<td>${student.student_name }</td>
		<td>${student.student_class }</td>
		<td>${student.student_age }</td>
	</tr>
	</c:forEach>
</tbody>

</table>
</body>
</html>