<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
<link type="text/css" rel="stylesheet" 
	  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
<link type="text/css" rel="stylesheet" 
	  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
		<a href="${pageContext.request.contextPath}/customer/addform" >Add New Customer</a>
	
	
	<div id="container">
		<div id="content">
		
			<input type="button" value="Add Customer"  
			   onclick="window.location.href='showAddForm'; return false; " 
			   class="add-button"	/>
			   
			<form:form action="searchCustomer" method="GET" >
				Search Customer: <input type="text" name="theSearchName" />
				<input type="submit" value="Search" class="add-button" />
			</form:form>   
		    
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="customer" items="${customers}">
					<c:url var="updateLink" value="/customer/showUpdateForm">
						<c:param name="customerId" value="${customer.id}"></c:param>
					</c:url>
					<c:url var="deleteLink" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${customer.id}"></c:param>
					</c:url>
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td> <a href="${updateLink}">Update</a> | <a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to'
										+'delete this customer?'))) return false;" >Delete</a></td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>
	
	

</body>
</html>