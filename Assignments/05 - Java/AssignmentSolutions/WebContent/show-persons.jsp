<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:if test="${fn:length(persons)>0}">

	<h3>Details of your contacts are...</h3>

	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Delete?</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${persons}" var="p">
				<tr>
					<td>${p.firstname}${p.lastname}</td>
					<td>${p.phone}</td>
					<td>${p.email}</td>
					<td><a href="delete-person?id=${p.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</c:if>