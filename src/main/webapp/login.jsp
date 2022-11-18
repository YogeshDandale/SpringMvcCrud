<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<center><h1>Logine Page</h1></center>
</head>
<body>
<center>
	<form action="login">
		<table aling="center" border="1">
			<tr><td><h1>UserName : <input type="text" name="uname" ></h1></td></tr>
			<tr><td><h1>Password : <input type="text" name="pass" ></h1></td></tr>
			<tr><td><h1><center><input type="submit" value="login" ></center></h1></td></tr>
		</table>
		<a href="register">New User</a><br>
		<a href="find_by_name">find Data by Name</a>
		
	</form>
	</center>
</body>
</html>