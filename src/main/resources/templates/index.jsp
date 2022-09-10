<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">  
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="save" method="post">
		<table>
			<tr>
				<td><label for="faculty-id">Id</label></td>
				<td><input type="text" name="id"></input></td>
			</tr>
			<tr>
				<td><label for="faculty-name">Faculty Name</label></td>
				<td><input type="text" name="name"></input></td>
			</tr>
			<tr>
				<td><label for="address">Address</label></td>
				<td><input type="text" name="address"></input></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>