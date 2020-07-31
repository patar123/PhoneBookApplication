<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	$(document).ready(function(e) {
		$("#contactEmail").blur(function(event) {
			$("#dupEmail").html("");
			var emailId = $("#contactEmail").val();
			$.ajax({
				url : 'validateEmail?email=' + emailId,
				success : function(abc) {
					if (abc == 'Duplicate') {
						$("#dupEmail").html("Email already registered");
						$("#contactEmail").focus();
					}
				}
			});
		});
	});
</script>


<script type="text/javascript">
	function checkClientValidation() {
		var result = ValidateForm();
		if (result) {
			var form = document.getElementById("registration");
			form.submit();
		}
	}

	function ValidateForm() {
		document.getElementById("showHints").innerText = "";
		document.getElementById("showHints1").innerText = "";
		document.getElementById("showHints2").innerText = "";

		var ret = true;
		if (document.getElementById("contactName").value == "") {
			document.getElementById("showHints").innerText += "* Contact Name is Required.\n";
			ret = false;
		}
		var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z\-\.])+\.([A-Za-z]{2,4})$/;
		if (reg.test(contactEmail.value) == false) {
			document.getElementById("showHints1").innerHTML += "* Enter Valid Email Id.\n";
			ret = false;
		}
		var number = /^\d{10}$/;
		if (number.test(document.getElementById("contactNumber").value) == false) {
			document.getElementById("showHints2").innerHTML += "* Enter a Valid Number.\n";
			ret = false;
		}
		return ret;
	}
</script>

</head>
<body>

	<p>
		<font color="green">${sucMsg }</font>
	</p>

	<p>
		<font color="red">${errMsg }</font>
	</p>

	<h2>Save Contact</h2>
	<form:form action="saveContact" modelAttribute="contact" method="post"
		id="registration">
		<table>
			<tr>
				<form:hidden path="contactId" />
				<td>Contact Name :</td>
				<td><form:input path="contactName" id="contactName" /> <font
					color="red">
						<div id="showHints"></div>
				</font></td>

			</tr>
			<tr>
				<td>Contact Email :</td>
				<td><form:input path="contactEmail" id="contactEmail" /> <font
					color='red'>
						<div id="dupEmail"></div>
				</font> <font color="red">
						<div id="showHints1"></div>
				</font></td>

			</tr>
			<tr>
				<td>Contact Number :</td>
				<td><form:input path="contactNumber" id="contactNumber" /> <font
					color="red">
						<div id="showHints2"></div>
				</font></td>
			</tr>
			<tr>
				<td><input type="reset" value="RESET"></td>
				<td><input type="button" value="Register"
					onclick="checkClientValidation()"></td>
			</tr>
		</table>
	</form:form>

	<a href="viewContact">Show All Contact</a>
</body>
</html>