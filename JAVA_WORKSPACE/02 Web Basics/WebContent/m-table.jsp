<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Multiplication Table</title>
</head>
<body>

	<h1>Multiplication Table</h1>

	<hr />
	
	<%
	
	int num = 123;
	
	for(int i=1; i<=10; i++) {
		out.println(num + " X " + i + " = " + (num*i) + "<br>");
	}
	
	%>

</body>
</html>