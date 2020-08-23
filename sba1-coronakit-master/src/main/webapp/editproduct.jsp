<%@page import="com.iiht.evaluation.coronokit.model.ProductMaster"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Edit Product(Admin)</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<hr />
	<div>
<a href="admin?action=logout "><button style="background-color:#E9967A;margin-left:auto;margin-right:auto;display:block;margin-top:0%;margin-bottom:0%">Logout</button></a>
</div>

	<%-- Required View Template --%>

	<br />
	<%
		// fetch the shared data
	ProductMaster products =( ProductMaster)request.getAttribute("product");
	%>
	<form action="admin?action=updateproduct" method="post">
		<div align="center">
			<div>
				<label><b>Enter Product IdNo </b></label> <input style="background-color:#FAD7A0" type="text" name="pId" value='<%=products.getId()%>' readonly="readonly">
			</div>
			<br/>
			<div>
				<label><b>Enter Product Name</b></label> <input  type="text" name="pname" value='<%=products.getProductName()%>'>
			</div>
			<br/>
			<div>
				<label><b>Enter Product Cost</b></label> <input type="text" name="pcost" value='<%=products.getCost()%>'>
			</div>
			<br />
			<div>
				<label><b>Enter Product Desc</b></label> <input type="text" name="pdesc" value='<%=products.getProductDescription()%>'>
			</div>
			<br/>
			<div>
				<button style="background-color:#FAD7A0;margin-left:auto;margin-right:auto;display:block;margin-top:0%;margin-bottom:0%" >Update Product</button>
			</div>
		</div>
	</form>

	<hr />
	<jsp:include page="footer.jsp" />
</body>
</html>