<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Flights</title>
</head>
<body>
		<h2>List OF Flights</h2>
		<table border = "1">
		<tr>	
			<tr>
				<th>AirLines</th>
				<th>Deparature City</th>
				<th>Arrival City</th>
				<th>Deparature Time</th>
				<th>Select Flight</th>
			</tr>
			<c:forEach items = "${findFlights}" var = "findFlights">
				<tr>
				<td>${findFlights.operatingAirlines }</td>
				<td>${findFlights.deparatureCity }</td>
				<td>${findFlights.arrivalCity }</td>
				<td>${findFlights.estimatedDeparatureTime }</td>
				<td><a href ="showCompleteReservation?flightId=${findFlights.id}">select</a></td>
				
			</c:forEach>	
		
		</table>
		
</body>
</html>