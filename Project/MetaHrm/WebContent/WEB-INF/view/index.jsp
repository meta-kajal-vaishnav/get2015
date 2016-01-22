<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-ui.js"></script>
<title>Index page</title>
<link rel="shortcut icon" href="images/icon.ico">
<link rel="stylesheet" href="css/font-awesome.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/index.js"></script>
</head>
<body>
	<div class="login-form">
		<h3>Login with Username and Password</h3>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<c:url value="/j_spring_security_check" var="loginUrl" />
		<form:form action="${loginUrl}" class="form-horizontal" method='POST'> 
			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>  --%>