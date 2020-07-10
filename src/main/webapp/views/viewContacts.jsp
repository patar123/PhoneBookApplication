<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>
	function deleteConfirm() {
		return confirm("Are You Sure, You Want To Delete ?");
	}
</script>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
	
<script>
	$(document).ready(function() {
		$('#contactTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});
</script>
</head>

<body>
	<a href="addContact">+Add Contact</a>
	<h2>All Contacts</h2>

	<table border="1" id="contactTbl">
		<thead>
			<tr>
				<td>Sl No.</td>
				<td>Contact Name</td>
				<td>Contact Email</td>
				<td>Contact Number</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="val" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${val.contactName}</td>
					<td>${val.contactEmail}</td>
					<td>${val.contactNumber}</td>
					<td><a href="editContact?cid=${val.contactId}">Edit</a> | <a
						href="deleteContact?cid=${val.contactId}"
						onclick="return deleteConfirm()">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>