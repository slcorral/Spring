<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	
	<p> Example de listado de productos </p>
	
	<c:if test="${listProduct.size()==0}">
		<p> Example </p>
	</c:if>
	
	<c:forEach items="${listProduct}" var="product">
			<p> ${product.name} </p>
			
			<c:if test="${product.name == 'b'}">
				<p> Nombre con b  </p>
		    </c:if>
		    
		    <c:if test="${product.name == 'a'}">
		    	<p> Nombre con a </p>
		    </c:if>
		    
	</c:forEach>
	
</body>
</html>