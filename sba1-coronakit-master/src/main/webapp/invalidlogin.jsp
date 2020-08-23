<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invalid Login</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<br/>
<br/>
<div>
<hr/>

	<h2 align="center">Admin Login</h2>
	<form action="admin?action=login" method="post">
	<style> 
 h1 { 
    color:red; 
   } 
  </style> 

<h1 align = "center" > You are not authorized to access the admin portal. Please try again </h1>

		<div align="center">
			<label for="loginid">Enter Login Id</label>
			<input type="text" id="loginid" name="loginid">
		</div>
		<br/>
		<div align="center">
			<label for="password">Enter Password</label>
		<input type="text" id="password" name="password">
		</div>
		<br/>
		<div>		
			<div align="center"><input type="submit" value="Login"> </div>
		</div>
	</form>
</div>
<hr/>
<div>
<a href="user?action=newuser" ><button style="background-color:#E9967A;margin-left:auto;margin-right:auto;display:block;margin-top:0%;margin-bottom:0%" >Create Corona Kit</button></a>
</div>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>