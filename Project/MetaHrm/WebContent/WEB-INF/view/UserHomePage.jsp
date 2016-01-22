<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="css/index.css"> -->
<script src="js/jquery-1.10.2.min.js"></script>
<title>User Home Page</title>
<link rel="shortcut icon" href="images/icon.ico">
<link rel="stylesheet" href="css/font-awesome.min.css">
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/moment.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#lastPunchIn").html("").hide();
	});

	function setDateAndTime() {
		$("#lastPunchIn").val(new Date());
		return true;
	}

	function addAttendence() {
		if (setDateAndTime()) {
			if ($("#punchInOut").val() == "In") {
				// get the form values
				$.ajax({
					type : "POST",
					url : "addAttendence.html",
					data : $('#attendenceForm').serialize(),
					success : function(response) {
						$('#lastPunchInOut').html("Last punch in time: ");
						$("#lastPunchIn").show();
						$("#punchInOut").val("Out");
					},
					error : function(e) {
						alert('Error: ');
					}
				});
			} else if ($("#punchInOut").val() == "Out") {
				$('#lastPunchInOut').html("");
				$("#lastPunchIn").html("").hide();
				$("#punchInOut").val("In");
			}
		}
	}
</script>
</head>
<body>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/MetaHrm/index.html">MetaHrm</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="#">Home</a></li>
				<li class="active"><a href="UserHomePage.html">Punch In/Out</a></li>
				<li><a href="viewAttendence.html?pageNumber=0">View Attendence</a></li>
				<%--  <c:if test="${objOfEmployee.getUserRole().contains('ROLE_ADMIN')}"> --%>
				<!-- <li><a href="subordinates.html">Subordinates</a></li>  -->
				<%-- </c:if> --%>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<li>Welcome : ${pageContext.request.userPrincipal.name} |</li>
					<li><a href="javascript:formSubmit()"> Logout</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	</nav>
	<br />
	<br />
	<form:form method="POST" commandName="attendenceBean"
		id="attendenceForm" action="">
		<h3>Punch In/Out</h3>
		<br />
		<br />
		<table>
			<tr>
				<td><label>Date</label></td>
				<td><fmt:formatDate value="<%=new java.util.Date()%>"
						pattern="MM/dd/yyyy" var="currentDate" /> <c:out
						value="${currentDate}" /></td>
			</tr>
			<tr>
				<td><label>Time</label></td>
				<td><fmt:formatDate value="<%=new java.util.Date()%>"
						pattern="HH:mm" var="currentTime" /> <c:out
						value="${currentTime}" /></td>
			</tr>
		</table>
		<input style="width: 120px; margin-left: 50px;" type="button"
			id="punchInOut" class="btn btn-block btn-primary btn-default"
			value="In" onClick="addAttendence()">
		<label id="lastPunchInOut"></label>
		<form:input id="lastPunchIn" path="attendenceDate"
			value="${LastPunchInDate}" />
	</form:form>
	<br />
	<br />
</body>
</html>