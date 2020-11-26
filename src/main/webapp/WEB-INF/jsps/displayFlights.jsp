<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Flights</title>
</head>
<body>
<table>
<tr>
<th>Airline</th>
<th>Departure City</th>
<th>Arrival City</th>
<th>Estimated Departure Time</th>
</tr>
<c:forEach items="${flights}" var="flight">
<tr>
<td>${flight.operatingAirlines}</td>
<td>${flight.departureCity}</td>
<td>${flight.arrivalCity}</td>
<td>${flight.estimateDepartureTime}</td>
<td><a href="showCompleteReservation?flightId=${flight.id}">Book Flight</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>

