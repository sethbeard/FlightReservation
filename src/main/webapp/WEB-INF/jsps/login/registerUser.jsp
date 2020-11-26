<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<h2>User Registration:</h2>
	<pre>
<form action="registerUser" method="post"><br>
First Name: 
<input type="text" name="firstName" /><br>
Last Name:
<input type="text" name="lastName" /><br>
User Name: 
<input type="text" name="email" /><br>
Password: 
<input type="password" name="password" /><br>
Confirm Password:
<input type="password" name="confirmPassword" /><br><br>
<input type="submit" value="register" />

${msg}
	</pre>

	</form>
</body>
</html>