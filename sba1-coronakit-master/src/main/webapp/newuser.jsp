<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-New User(user)</title>
           <style> 
            h2 { 
                color:green; 
            } 
        </style>  
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<%-- Required View Template --%>
<hr/>

	<h2 align = "center">New User Registration</h2>
	<form action="user?action=insertuser" method="post">
	<div align = "center">
		<div >
			<div style="color:#E67E22"><label for="uname"><b>Name</b></label> </div>
			<div><input type="text" id="uname" name="uname"> </div>
		</div>
		<div>
			<div style="color:#E67E22"><label for="uemail" ><b>Email</b></label> </div>
			<div><input type="text" id="uemail" name="uemail"> </div>
		</div>
		<div>
			<div style="color:#E67E22"><label for="ucontact"><b>Contact Number</b></label> </div>
			<div><input type="text" id="ucontact" name="ucontact"> </div>
		</div>
		<div>
			<div style="color:#E67E22"><label for="uaddress"><b>Delivery Address</b></label> </div>
			<div><input type="text" id="uaddress" name="uaddress"> </div>
		</div>
		<br/>
		<div>
			<div><button style="background-color:#FAD7A0;margin-left:auto;margin-right:auto;display:block;margin-top:0%;margin-bottom:0%">Add User</button>
		</div>
		</div>
	</form>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>