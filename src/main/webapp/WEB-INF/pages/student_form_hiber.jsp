<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<title>muk.forms.hibernate</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
</head>
<body>
	<div id="formsContent">
		<h2>Form</h2>
		<p>
			See the <code>muk.controller.StudentHibernateController</code> package for the @Controller code	
		</p>
		<form:form id="form" method="post" modelAttribute="student_bean" cssClass="cleanform" action="process_action">
			<div class="header">
		  		<h2>Form</h2>
		  		<c:if test="${not empty message}">
					<div id="message" class="success"><c:out value="${message}"/></div>
		  		</c:if>
		  		<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="error">Form has errors</div>
		  			</c:if>
		  		</s:bind>
			</div>
		  	<fieldset>
		  		<legend>Personal Info</legend>
		  		<form:label path="student_name">
		  			Name <form:errors path="student_name" cssClass="error" />
		 		</form:label>
		  		<form:input path="student_name" />
		  		
		  		<form:label path="student_class">
		  			Class <form:errors path="student_class" cssClass="error" />
		 		</form:label>
		  		<form:input path="student_class" />
	
		  		<form:label path="student_age">
		  			Age <form:errors path="student_age" cssClass="error" />
		 		</form:label>
		  		<form:input path="student_age" />
		  		
		  		<form:label path="dob">
		  			DOB <form:errors path="dob" cssClass="error" />
		 		</form:label>
		  		<form:input type="date" path="dob" />
		  	</fieldset>
	
			<p><button type="submit">Submit</button></p>
		</form:form>
	</div>
</body>
</html>