<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<title>Add New Customer</title>
<link type="text/css" rel="stylesheet" 
	  href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet" 
	  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container" >
		
		<h3>Add New Customer</h3>
		<form:form action="saveCustomer" modelAttribute="customer" method="POST" >
			<table>
			
				<tbody>
					<tr>
						<td> <label>First name:</label> </td>
						<td> <form:input type="text" path="firstName" placeholder="What is your first name?" /> </td>
					</tr>
					<tr>
						<td> <label>Last name:</label> </td>
						<td> <form:input type="text" path="lastName" placeholder="What is your last name?" /> </td>
					</tr>
					<tr>
						<td> <label>Email:</label> </td>
						<td> <form:input type="email" path="email" placeholder="What is your email?" /> </td>
					</tr>
					<tr> 	
						<td> <label></label> </td>		
						<td> <input type="submit" value="Save" class="save" /> </td>
						
					</tr>
				</tbody>
			
			</table>	
		</form:form>
		
		
		<div style="clear; both;">
			<p>
				<a href="${pageContext.request.contextPath}/customer/list" >Back to list</a>
			</p>
		</div>
		
	</div>
	
</body>
</html>