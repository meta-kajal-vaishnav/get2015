<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/adminHome.css">
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-ui.js"></script>
<title>View Subordinates Page</title>
<link rel="shortcut icon" href="images/icon.ico">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/adminHome.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/subordinates.js"></script>
<style type="text/css">
#viewEmpTable td{
	width:100px;
}
#viewEmpTable a{
	width:70px;
}
</style>
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
				<li><a href="viewAttendence.html?pageNumber=0">View
						Attendence</a></li>
				<li><a href="addSubordinates.html">Add Subordinates</a></li>
				<li><a href="viewSubordinates.html">View Subordinates</a></li>
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
	<div class="input-group input-sm" id="empList">
		<label>Subordinates : </label><br /> <br />
		<table id="viewEmpTable">
			<c:choose>
				<c:when test="${!listOfAllEmployeeBeans.isEmpty()}">
					<c:forEach items="${listOfAllEmployeeBeans}" var="emp">
						<tr>
							<td>${emp.getEmployeeName()}</td>
							<td><a
								href="/MetaHrm/viewEmployeeDetails.html?username=${emp.getUsername()}"
								id="empDetailView">View</a></td>
							<td><a
								href="/MetaHrm/deleteEmployee.html?employeeId=${emp.getEmployeeId()}"
								id="empDetailDelete">Delete</a></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<label>No Subordinates Found</label>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
	<div id="empDetail">
	<form:form method="POST" commandName="employeeBean"
		id="detailForm" action="/MetaHrm/editDetails.html">
	<table border="1">
	<tr>
			<th>Employee id: </th>
			<td><form:input path="employeeId" value="${employeeBean.getEmployeeId()}"/></td>
		</tr>
		<tr>
			<th>Employee Name : </th>
			<td><form:input path="employeeName" value="${employeeBean.getEmployeeName()}"/></td>
		</tr>
		<tr>
			<th>Username : </th>
			<td><form:input path="username" value="${employeeBean.getUsername()}"/></td>
		</tr>
	</table>
	<input style="width: 120px; margin-left: 50px;" type="submit"
			id="editDetail" class="btn btn-block btn-primary btn-default"
			value="Edit" >  <!-- onClick="editDetail()" -->
	<a  style="width: 120px; margin-left: 50px;" href="/MetaHrm/deleteEmployee.html?employeeId=${emp.getEmployeeId()}" class="btn-danger form-control btn btn-default "
	id="empDetailDelete">Delete</a>
	</form:form>
	</div>
</body>
</html>