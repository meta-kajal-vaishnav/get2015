<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Car Website</title>
		<link rel="stylesheet" href="css/style.css" type="text/css">
	<link rel="stylesheet" href="css/style2.css" type="text/css">
	<script src="autoportal.js"></script>
</head>
<body>
	<div id="header">
	<div>
			<div id="logo">
				<a href="home.jsp"><h1>CAR PORTAL</h1></a>
			</div>
			<span id="welcome">Hi, <%
				if (session.getAttribute("userName") == null)
					out.print("user");
				else
					out.print(session.getAttribute("userName"));
			%></span>
			<ul id="navigation">
				<li><a href="home.jsp">Home</a></li>
				<li>
					<%
						if (session.getAttribute("userName") != null)
							out.write("<a href='CreateCarController'>Create</a>");
					%>
				</li>
				<li>
					<%
						if (session.getAttribute("userName") == null)
							out.write("<a href='LoginController'>Login</a>");
						else
							out.write("<a href='LogoutController'>Logout</a>");
					%>
				</li>
				<li><a href="contact.jsp">Contact</a></li>
			</ul>
		</div>
	</div>
	<div id="contents">
		<div id="adbox">
			
			
			<div id="contactdetail">
			<img src="images/telephone.png" alt="Img"/>
			<center>
			<form action="contact.html" method="post" onsubmit="return validateContact();">
			<h1>Contact</h1>
				<table>
					<tbody>
						<tr>
							<td><label>Name:</label></td>
							<td><input type="text" id="name" required></td>
						</tr> <tr>
							<td><label>E-mail Address:</label></td>
							<td><input type="text" id="email" required></td>
						</tr> <tr>
							<td><label>Telephone Number:</label></td>
							<td><input type="number" id="phone" required></td>
						</tr> <tr>
							<td><label>Subject:</label></td>
							<td><input type="text" id="sub" required></td>
						</tr> <tr>
							<td><label>Message:</label></td>
							<td><textarea></textarea></td>
							</tr>
							<tr>
							<td colspan="2"><center>
							<input type="submit" value="Submit" ></center>
							</td>
							</tr>
					</tbody>
				</table>
				
			</form>
			</center>
			</div>
			</div>
		</div>
	</div>
<div id="footer">
		<div id="articles">
			<div class="header">
				<div class="body">
					<div>
						<div class="section">
							<h3>About us</h3>
							
						</div>
						<div class="section">
							<h3>Latest Blog Posts</h3>
							<ul class="blog">
								<li>

								</li>
								<li>

								</li>
							</ul>
						</div>
						<div class="section">
							<h3>Contact Information</h3>
							<table class="info">
								<tbody>
									<tr>
										<td>Address:</td>
										<td>Sitapura
									</tr> <tr>
										<td>Phone:</td>
										<td>540-754-4081</td>
									</tr> <tr>
										<td>Hours Open:</td>
										<td>Tues- Sundays: 10 am- 9pm</td>
									</tr>
								</tbody>
							</table>
							<h3>Follow us</h3>
							<div id="connect">
								<a href="http://facebook.com/" target="_blank" class="facebook"></a> <a href="http://twitter.com/" target="_blank" class="twitter"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer">
			<form action="index.html" method="post">
				<input type="text" value="Enter email address and get 10% off" class="txtfield" onMouseUp="return false;" onFocus="this.select();">
				<input type="submit" value="SIGNUP" class="btn">
			</form>
			<p>
				© 2015 Auto Portal. All Rights Reserved. <a href="index.html">Privacy Policy</a> <a href="index.html">Terms and Conditions</a>
			</p>
		</div>
	</div>
</body>
</html>