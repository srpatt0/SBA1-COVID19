<%@page import="com.iiht.evaluation.coronokit.model.ProductMaster"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<%-- Required View Template --%>
<br/>
	<a href="admin?action=newproduct"><button style="background-color:#FAD7A0">Add New Product</button></a>
	<a href="admin?action=logout"><button style="background-color:#FAD7A0">Logout</button></a>
	<br/>
	<%
		// fetch the shared data
		List<ProductMaster> products =  (List<ProductMaster>) request.getAttribute("Products");
	%>
	<br/>
	<br/>
	<table border="1" width="100%">
		<thead>
			<th style="background-color:#DC7633">Product Name</th>
			<th style="background-color:#DC7633">Product Cost</th>
			<th style="background-color:#DC7633">Product Description</th>
			<th style="background-color:#DC7633">Edit Links</th>
			<th style="background-color:#DC7633">Delete Links</th>
		</thead>
		<tbody>
			<% for(ProductMaster product : products) { %>
			<tr>
				<td style="background-color:#F8C471"><%=product.getProductName()%></td>
				<td style="background-color:#F8C471"><%=product.getCost()%></td>
				<td style="background-color:#F8C471"><%=product.getProductDescription()%></td>
				<td style="background-color:#F8C471"><a href="admin?action=editproduct&ProductId=<%=product.getId()%>">Edit</a></td>
				<td style="background-color:#F8C471"><a href="admin?action=deleteproduct&ProductId=<%=product.getId()%>">Delete</a></td>
			</tr>
			<% } %>
		</tbody>
	</table>
<%-- Required View Template --%>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>