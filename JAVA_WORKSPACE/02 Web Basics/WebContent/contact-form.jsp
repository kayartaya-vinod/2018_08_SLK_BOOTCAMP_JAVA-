<%@ include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">

	<div class="col-sm-3"></div>

	<div class="col-sm-6">
		<h3 class="text-center">
			<c:if test="${title==null}">
			Add a new contact details
			</c:if>
			<c:if test="${title!=null}">
			${title }
			</c:if>
			
		</h3>

		<form action="./add-contact" method="POST" class="form-horizontal">
			<input type="hidden" name="id" value="${ct.id}" >
		
			<div class="row">
				<label for="firstname" class="control-label col-sm-4"> Firstname </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" 
						id="firstname" name="firstname" value="${ct.firstname}">
				</div>
			</div>
			
			<div class="row">
				<label for="lastname" class="control-label col-sm-4"> Lastname </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" 
						id="lastname" name="lastname" value="${ct.lastname}">
				</div>
			</div>
			
			<div class="row">
				<label class="control-label col-sm-4"> Gender </label>
				<div class="col-sm-8">
					<label><input type="radio" name="gender" value="Male" ${ct.male?"checked":"" } > Male</label>
					<label><input type="radio" name="gender" value="Female" ${ct.male? "" :"checked" }> Female</label>
				</div>
			</div>
			
			<div class="row">
				<label for="email" class="control-label col-sm-4"> Email </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" 
						id="email" name="email" value="${ct.email}">
				</div>
			</div>
			
			<div class="row">
				<label for="phone" class="control-label col-sm-4"> Phone </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" 
						id="phone" name="phone"  value="${ct.phone}">
				</div>
			</div>
			
			<div class="row">
				<label for="address" class="control-label col-sm-4"> Address </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" 
						id="address" name="address" value="${ct.address}">
				</div>
			</div>
			
			<div class="row">
				<label for="city" class="control-label col-sm-4"> City </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" 
						id="city" name="city" value="${ct.city}">
				</div>
			</div>
			
			<div class="row">
				<label for="state" class="control-label col-sm-4"> State </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" 
						id="state" name="state" value="${ct.state}">
				</div>
			</div>
			
			<div class="row">
				<label for="pincode" class="control-label col-sm-4"> Pincode </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" 
						id="pincode" name="pincode" value="${ct.pincode}">
				</div>
			</div>
			
			<div class="row">
				<label for="country" class="control-label col-sm-4"> Country </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" 
						id="country" name="country" value="${ct.country}">
				</div>
			</div>
			
			<div class="row">
				<label for="birthDate" class="control-label col-sm-4"> Date of birth </label>
				<div class="col-sm-8">
					<input type="date" class="form-control" 
						id="birthDate" name="birthDate" value="${ct.birthDate}">
				</div>
			</div>
			
			<div class="row">
				<label class="control-label col-sm-4"> </label>
				<div class="col-sm-8">
					<button class="btn btn-primary">
						<c:if test="${title==null}">
						Add new contact
						</c:if>
						<c:if test="${title!=null}">
						Update contact
						</c:if>
					</button>
				</div>
			</div>
			
			
		</form>

	</div>

	<div class="col-sm-3"></div>

</div>

<%@ include file="footer.jsp"%>