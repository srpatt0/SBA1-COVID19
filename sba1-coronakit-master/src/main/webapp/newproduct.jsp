<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Add New Product(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<div>
<a href="admin?action=logout "><button style="background-color:#E9967A;margin-left:auto;margin-right:auto;display:block;margin-top:0%;margin-bottom:0%">Logout</button></a>
</div>
<br/>
<br/>
<%-- Required View Template --%>
<form action="admin?action=insertproduct" method="post">
	<div align= "center">
		<div><label><b>Enter Product Name</b></label> <input type="text" name="pname"></div>
		<br/>
		<div><label><b>Enter Product Cost</b></label> <input type="text" name="pcost"></div>
		<br/>
		<div><label><b>Enter Product Desc</b></label> <input type="text" name="pdesc"></div>
		<br/>
		<button style="background-color:#FAD7A0;margin-left:auto;margin-right:auto;display:block;margin-top:0%;margin-bottom:0%" >Add Product</button>
		</div>
</form>
<%-- Required View Template --%>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>