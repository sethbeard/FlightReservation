<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Flight</title>
</head>
<body>
 
<h2>Complete Reservation</h2>
Airline: ${flight.operatingAirlines}
Departure City: ${flight.departureCity}
Arrival City: ${flight.arrivalCity}
Departure Date: ${flight.dateOfDeparture}

<form action="completeReservation" method="post">
<h2>Passenger Details:</h2>

First Name: <input type="text" name="passengerFirstName"/>
Last Name: <input type="text" name="passengerLastName"/>
Email: <input type="text" name="passengerEmail"/>
Phone: <input type="text" name="passengerPhone"/>



<h2> Card Details:</h2>
Name On Card: <input type="text" name="nameOnTheCard"/>
Card Number: <input type="text" name="cardNumber"/>
Expiration Date: <input type="text" name="expirationDate"/>
CVC Number: <input type="text" name="securityCode"/>
<input type="hidden" name="flightId" value="${flight.id }">
<br>
<input type="submit" value="confirm">
</form>
</body>
</html>