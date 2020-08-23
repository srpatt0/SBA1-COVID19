<%@page import="com.iiht.evaluation.coronokit.model.KitDetail"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Order Summary(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<%-- Required View Template --%>

<br/>
	<a href="user?action=placeorder"><button>Place Order</button></a>
	<%
		// fetch the shared data
		List<KitDetail> kits =  (List<KitDetail>) session.getAttribute("CartData");
	%>
	<table border="1" width="100%">
		<thead>
			<th>Product Name</th>
			<th>Product Qunatity</th>
			<th>Sub Totalcost</th>
			<th>Amount</th>
			<th></th>
		</thead>
		<tbody>
			<% for(KitDetail kit : kits) { %>
			<tr>
				<td><%=kit.getCoronaKitId()%></td>
				<td><%=kit.getProductId()%></td>
				<td><%=kit.getQuantity()%></td>
				<td><%=kit.getAmount()%></td>
				<td><a href="user?action=deleteitem&ProductId=<%=kit.getProductId()%>">Delete</a></td>
			</tr>
			<% } %>
		</tbody>
	</table>


<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>