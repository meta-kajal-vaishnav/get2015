<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/adminHome.css">
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-ui.js"></script>
<title>View Attendence Page</title>
<link rel="shortcut icon" href="images/icon.ico">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/adminHome.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/subordinates.js"></script>
<style type="text/css">
#prevAttendence td{
 width:200px;
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
        <li><a href="viewAttendence.html">View Attendence</a></li>
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
	<div id="prevAttendence">
	<table border="1">
	<tr>
		<th>Date [yyyy-MM-dd HH:mm]</th>
		<th>Status</th>
	</tr>
		<c:choose>
			<c:when test="${!objOfEmployee.getAttendenceList().isEmpty()}">
				<c:forEach items="${objOfEmployee.getAttendenceList()}" var="attendenceObj">
					<tr>
						<td>
							<fmt:formatDate value="${attendenceObj.getAttendenceDate()}"
							pattern="yyyy-MM-dd HH:mm" var="attendenceDateTime" /> 
							<c:out value="${attendenceDateTime}" />
						</td>
						<td>${attendenceObj.getStatus()}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<label>No Attendence found</label>
			</c:otherwise>
		</c:choose>
		</table>
	</div>
</body>
</html>