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
<title>Admin Home Page</title>
<link rel="shortcut icon" href="images/icon.ico">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/adminHome.css">
<script src="js/bootstrap.min.js"></script>
<!-- <script src="js/adminHome.js"></script> -->

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
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
      <a class="navbar-brand" href="/MetaHrm/index.html">MetaHrm</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="#">Home</a></li>
        <li class="active"><a href="UserHomePage.html">Punch In/Out</a></li>
        <li><a href="viewAttendence.html?employeeId=${objOfEmployee.getEmployeeId()}">View Attendence</a></li>
        <li><a href="addSubordinates.html">Add Subordinates</a></li>
        <li><a href="viewSubordinates.html">View Subordinates</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<c:if test="${pageContext.request.userPrincipal.name != null}">
			<li>Welcome : ${pageContext.request.userPrincipal.name} | </li>
			<li><a href="javascript:formSubmit()"> Logout</a></li>
		</c:if>
      </ul>
    </div>
  </div>
</nav>





	<br />
	<br />
	<%-- <div class="addEmp">
		<form:form action="/MetaHrm/addEmployee.html" method="post"
			id="empForm" commandName="objOfEmployee" class="form-horizontal">
			<table id="addEmpTable">
				<tr>
					<td><label>Name : </label></td>
					<td><form:input type="text" class="form-control"
							id="employeeName" name="employeeName" path="employeeName"
							placeholder="Enter employee name"
							value="${objOfEmployee.getEmployeeName()}" required="required" /></td>
				</tr>
				<tr>
					<td><label>User Name : </label></td>
					<td><form:input type="text" class="form-control" id="userName"
							name="username" placeholder="Enter user-name" path="username"
							required="required" value="${objOfEmployee.getUsername()}" /></td>
				</tr>
				<tr>
					<td><label>Role : </label></td>
					<td><form:select class="form-control" id="employeeType" multiple="true" path="userRole"
						name="employeeType">
							<!-- <option selected="selected" disabled="disabled" value="select">
								-- Select user type --</option> -->
							<c:forEach items="${userTypeEnum}" var="userType">
								<form:option value="${userType}"/>
							</c:forEach>
					</form:select></td>
				</tr>
				<tr>
					<td><label>Select Supervisors : </label></td>
					<td>
						<div class="input-group input-sm" id="empList">
							<c:choose>
								<c:when test="${!listOfAllEmployees.isEmpty()}">
									<form:select class="form-control" id="supervisor" multiple="true" path="subordinates"
									name="subordinates">
										<c:forEach items="${listOfAllEmployeeBeans}" var="emp">
											<form:option value="${emp.getEmployeeName()}"/>
										</c:forEach>
									</form:select>
								</c:when>
								<c:otherwise>
									<label>No Employees found</label>
								</c:otherwise>
							</c:choose>
						</div>
					</td>
				</tr>
			</table>
			<div class="form-actions">
				<input type="submit" id="addEmpButton" value="Add Employee" class="form-control btn btn-info"
					onClick="addEmployee()" />
			</div>
		</form:form>
	</div> --%>
</body>
</html>