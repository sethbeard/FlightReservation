<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Flights</title>
</head>
<body>
<h2>Find Flights</h2>

<form action="findFlight" method="post">
From: 
<input type="text" name="from">
To: 
<input type="text" name="to">
Departure Date (mm-dd-yyyy):
<input type="text" name="departureDate">
<br>
<input type="submit" name="Search">

</form>
</body>
</html>