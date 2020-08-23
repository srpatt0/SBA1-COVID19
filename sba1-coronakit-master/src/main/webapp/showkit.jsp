<%@page import="com.iiht.evaluation.coronokit.model.KitDetail"%>
<%@page import="com.iiht.evaluation.coronokit.model.UserMaster"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-My Kit(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<%-- Required View Template --%>

<br/>

<h2 style="color:green" align = "center" >Confirm Order</h2>	
	
<form action="user?action=placeorder" method="post">
			
			<%
		// fetch the shared data
		List<KitDetail> kits =  (List<KitDetail>) session.getAttribute("CartData");
			UserMaster user = (UserMaster) session.getAttribute("UserDetails");
	%>
	<table border="1" width="100%">
		<thead>
			<th style="background-color:#E74C3C">Corona KitId</th>
			<th style="background-color:#E74C3C">Product Id</th>
			<th style="background-color:#E74C3C">Product Name</th>
			<th style="background-color:#E74C3C">Quantity</th>
			<th style="background-color:#E74C3C">Amount</th>			
			<th style="background-color:#E74C3C" > Delete Links</th>
		</thead>
		<tbody>
			<% for(KitDetail kit : kits) { %>
			<tr>
				<td style="background-color:#F5B7B1"><%=kit.getCoronaKitId()%></td>
				<td style="background-color:#F5B7B1"><%=kit.getProductId()%></td>
				<td style="background-color:#F5B7B1"><%=kit.getProductName()%></td>
				<td style="background-color:#F5B7B1"><%=kit.getQuantity()%></td>
				<td style="background-color:#F5B7B1"><%=kit.getAmount()%></td>
				<td style="background-color:#F5B7B1"><a href="user?action=deleteitem&ProductId=<%=kit.getProductId()%>">Delete</a></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	
	<div>
	<br/>
	<br/>
	<a href="user?action=showproducts">Continue Shopping</a>
	<br/>	
	<div align = "center">
	<label for="address" align = "center" style="color:green">Enter Delivery Address</label>
	<br/>
		<input type="text" id="uaddress" name="uaddress" value= <%=user.getDeliveryAddress()%>> </div>
	<br/>
			
			<div><button style="background-color:#FAD7A0;margin-left:auto;margin-right:auto;display:block;margin-top:0%;margin-bottom:0%" >Place order</button>					
	</div>

<br/>
<br/>
<br/>

</form>
	
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>