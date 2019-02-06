<%@ include file="header.jsp"%>

<%@page import="com.slk.training.entity.Contact"%>
<%@page import="java.util.List"%>

<%
	List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
%>

<table
	class="table table-striped table-bordered table-hover table-condensed">
	<thead>
		<tr>
			<th>Name</th>
			<th>Email address</th>
			<th>Phone number</th>
			<th>City</th>
		</tr>
	</thead>
	<tbody>
		<%
			for (Contact c : contacts) {
		%>
		<tr>
			<td><%=c.getFirstname()%> <%=c.getLastname()%></td>
			<td><%=c.getEmail()%></td>
			<td><%=c.getPhone()%></td>
			<td><%=c.getCity()%></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>

<%@ include file="footer.jsp"%>