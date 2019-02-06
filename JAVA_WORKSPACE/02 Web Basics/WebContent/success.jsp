<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="alert alert-success">
	<h1 class="text-center">
		<c:choose>
			<c:when test="${param.x==1}">
				New contact added successfully!
			</c:when>
			
			<c:otherwise>
				Contact detailed updated successfully!
			</c:otherwise>
		</c:choose>
	</h1>
</div>

<%@ include file="footer.jsp" %>