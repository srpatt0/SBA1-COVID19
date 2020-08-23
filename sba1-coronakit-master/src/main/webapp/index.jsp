<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Home</title>
<style>
h2{
color:blue;
}
</style>
</head>
<body>
<div>
<jsp:include page="header.jsp"/>
<hr/>
	<h2 align="center">Admin Login Page</h2>
	<form action="admin?action=login" method="post">
		<div align="center">
			<label for="loginid">Login Id</label>
			<input type="text" id="loginid" name="loginid">
		</div>
		<br/>
		<div align="center">
			<label for="password">Password</label>
		<input type="text" id="password" name="password">
		</div>
		<br/>
		<div>		
			<div align="center"><input type="submit" value="Sign On"> </div>
		</div>
	</form>
</div>
<hr/>
<div>
<a href="user?action=newuser" ><button style="background-color:#FAD7A0;margin-left:auto;margin-right:auto;display:block;margin-top:0%;margin-bottom:0%" >Create COVID-19 Kit</button></a>
</div>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>