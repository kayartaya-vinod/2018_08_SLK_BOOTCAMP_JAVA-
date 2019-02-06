<%@ include file="header.jsp"%>

<!-- this is a HTML comment -->
<%-- this is a JSP comment --%>

<%-- include the JSTL core tags reference using the taglib directive --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<c:forEach items="${contacts}" var="ct">
		<tr>
			<td>
			${ct.male?"Mr.":"Ms." }
			${ct.firstname} ${ct.lastname}
			
			<%-- URLs /edit-contact and /delete-contact do not exist. Its part of assignment. --%>
			<span class="pull-right action-links">
				<a href="./edit-contact?id=${ct.id}"><span class="fa fa-pencil"></span></a>
				<a href="javascript:confirmAndDelete(${ct.id})" ><span class="fa fa-trash-o"></span></a>
			</span>
			
			</td>
			<td>${ct.email}</td>
			<td>${ct.phone}</td>
			<td>${ct.city}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<script>
function confirmAndDelete(id) {
	
	swal({
		  title: "Are you sure?",
		  text: "Your will not be able to recover this imaginary file!",
		  type: "warning",
		  showCancelButton: true,
		  confirmButtonClass: "btn-danger",
		  confirmButtonText: "Yes, delete it!",
		  closeOnConfirm: false
		},
		function(){
			// redirect the page to ./delete-contact?id=${ct.id}
			window.location.href="./delete-contact?id=" + id;
		  //swal("Deleted!", "Your imaginary file has been deleted.", "success");
		});
}
</script>

<%@ include file="footer.jsp"%>











