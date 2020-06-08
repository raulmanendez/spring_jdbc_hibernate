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
<title>Document</title>
</head>
<body>
	<div id="formsContent">
		<h2>Form</h2>
		<p>
			See the
			<code>muk.controller.DocController</code>
			package for the @Controller code
		</p>
		<form:form method="post" modelAttribute="doc_obj" action="save_doc"
			enctype="multipart/form-data">
			<div class="header">
				<h2>Add Document</h2>
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


			<fieldset id="append_here">
				<legend>Upload Document</legend>
				<p>
					Employee Name::
					<form:input path="emp_name" type="text" />
				</p>
				<p></p>
				<form:errors path="emp_name" cssClass="error" />
				<p>
				<div id="div_for_doc">
					<p>
						Select Document 1::
						<form:input path="multi_doc" type="file" multiple="multiple"/>
					</p>
					<p></p>
					<form:errors path="multi_doc" cssClass="error" />
					<p>
				</div>

			</fieldset>

			<br>

			<button type="button" id="addMore">Add</button>
			<button type="button" id="removeLast">Remove</button>
			<input type="submit" value="Submit">

		</form:form>
	</div>

	<br>

	<fieldset>
		<legend>Existing Document (s)</legend>
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>Employee Name</th>
					<th>File Name</th>
					<th>File Type</th>
					<th>File</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="doc" items="${doc_list_obj }">
					<tr>
						<td>${doc.id }</td>
						<td>${doc.emp_name }</td>
						<td>${doc.doc_name }</td>
						<td>${doc.doc_type }</td>
						<td><img src="get_doc?doc_id=${doc.id }" width="100px"
							height="100px"></td>
						<td><a href="delete_doc?doc_id=${doc.id }">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#addMore").click(function() {
				console.log("add");
				var txt1 = document.createElement("div"); // Create with DOM
				txt1.innerHTML = '<p>Hii There<p>';
				$("#append_here").append(txt1);

			});

			$("#removeLast").click(function() {
				console.log("remove");
			});
		});
	</script>

</body>
</html>