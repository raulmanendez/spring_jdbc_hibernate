<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
//System.out.println("I am In the JSP Page.");
%>
${fn:length(designations) }
<c:if test="${action eq 'desig_by_dept_id'}">
	
	<c:choose>
		<c:when test="${fn:length(designations) gt 0}">
			<option value="">Select Designation</option>
	
			<c:forEach var="desig_obj" items="${designations}">
		    	<option value="${desig_obj.id}">${desig_obj.designation}</option>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<option value="">No Designation Found !</option>
		</c:otherwise>
	</c:choose>
</c:if>


