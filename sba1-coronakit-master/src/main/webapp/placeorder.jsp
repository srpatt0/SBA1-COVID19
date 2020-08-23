<%@page import="com.iiht.evaluation.coronokit.model.KitDetail"%>
<%@page import="com.iiht.evaluation.coronokit.model.UserMaster"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Place Order(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<h1 style="color:green">Here you go.... </h1>
<%-- Required View Template --%>

<br/>
	<h1 style="color:green">Your Corona Kit Order Summary</h1>
	<%
		// fetch the shared data
		List<KitDetail> kits =  (List<KitDetail>) session.getAttribute("CartData");
		UserMaster user = (UserMaster) session.getAttribute("UserDetails");
		double totalAmount = 0;
	%>
	<div align="center" style="color:blue">Order Id : <%=kits.get(0).getCoronaKitId()%></div>
	<br/>
	<div align="center">
	<table border="1" width="100%">
		<thead>
			<th style="background-color:#E74C3C">Product Name</th>
			<th style="background-color:#E74C3C">Quantity</th>
			<th style="background-color:#E74C3C">Amount</th>			
		</thead>
		<tbody>
			<% for(KitDetail kit : kits) { %>
			<tr>
				<td style="background-color:#F5B7B1"><%=kit.getProductName()%></td>
				<td style="background-color:#F5B7B1"><%=kit.getQuantity()%></td>
				<td style="background-color:#F5B7B1"><%=kit.getAmount()%></td>
			</tr>			
			<%
			totalAmount = totalAmount+ kit.getAmount();
			} %>
		</tbody>
	</table>
	<br/>
	<div align="center" style="color:blue">Total order Amount : <%=totalAmount %></div>
	<table>
		<tbody>
			<tr><td style="color:blue">Delivery Details</td>
				<td>
					<table>
						<tr><td  ><%=user.getPersonName()%></td></tr>
						<tr><td ><%=user.getEmail()%></td></tr>
						<tr><td ><%=user.getContactNumber()%></td></tr>
						<tr><td ><%=user.getDeliveryAddress()%></td></tr>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
	</div>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>