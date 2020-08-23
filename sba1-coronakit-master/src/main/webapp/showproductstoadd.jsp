<%@page import="com.iiht.evaluation.coronokit.model.ProductMaster"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<%-- Required View Template --%>

<br/>
	
	<%
		// fetch the shared data
		List<ProductMaster> products =  (List<ProductMaster>) request.getAttribute("Products");
	%>
	<table border="1" width="100%">
		<thead>
			<th style="background-color:#E74C3C">Product Name</th>
			<th style="background-color:#E74C3C">Product Cost</th>
			<th style="background-color:#E74C3C">Product Description</th>
			<th style="background-color:#E74C3C">Add Links</th>
			<th></th>
		</thead>
		<tbody>
			<% for(ProductMaster product : products) { %>
			<tr>
				<td style="background-color:#F5B7B1"><%=product.getProductName()%></td>				
				<td style="background-color:#F5B7B1"><%=product.getCost()%></td>
				<td style="background-color:#F5B7B1"><%=product.getProductDescription()%></td>
				<td style="background-color:#F5B7B1"><a href="user?action=addnewitem&ProductId=<%=product.getId()%>">Add</a></td>
				</tr>
			<% } %>
		</tbody>
	</table>	
	<br/>
	<br/>
	<br/>
	<br/>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>