<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HotelList</title>
</head>
<body>
	<table>
		<tr>
			<th>Hotel ID</th>
			<th>Name</th>
			<th>Website</th>
			<th>Rating</th>
			<th>Review</th>
			<th>Phone Number</th>
			<th>Address</th>
			<th>E-Mail Id</th>
			<th>Country COde</th>
			<th>City</th>
			<th>State</th>
			<th>Country</th>
			<th>Zip Code</th>
			<th>Hotel Photo</th>
		</tr>
		<p:forEach var="hl" items="${sessionScope.hotelList }">
		<tr>
			<td>${hl.hotelId }</td>
			<td>${hl.hotelName }</td>
			<td>${hl.website }</td>
			<td>${hl.rating }</td>
			<td>${hl.review }</td>
			<td>${hl.phoneNo }</td>
			<td>${hl.address }</td>
			<td>${hl.emailId }</td>
			<td>${hl.countrycode }</td>
			<td>${hl.city }</td>
			<td>${hl.state }</td>
			<td>${hl.country }</td>
			<td>${hl.zip }</td>
			<td>${hl.hotelPhoto }</td>
			<td><a href="edit?productId=${hl.hotelId }&name=${hl.hotelName }&brand=${hl.website }&price=${p.price}">Edit</a></td>
			<td><a href="delete?productId=${hl.hotelId }&name=${p.name }&brand=${p.brand}&price=${p.price}">Delete</a></td>
		</tr>
		</p:forEach>
	</table>
</body>
</html>