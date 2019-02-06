<%@ include file="header.jsp"%>

<h3>Welcome to Phonebook App version 1.0</h3>

<form class="form-horizontal" action="./search-contacts">

	<div class="form-group row">
		<label class="col-sm-2">Enter city</label>
		<div class="col-sm-5">
			<input class="form-control" type="search" name="city"
				placeholder="city...">
		</div>
		<div class="col-sm-4">
			<button class="btn btn-primary">Search</button>
		</div>
	</div>
	
</form>

<%@ include file="footer.jsp"%>