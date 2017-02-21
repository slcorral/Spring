<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
	.cabecera{
	 width: 100%;
	 height: 100%;
	}
	
	.tabla{
		width: 80%;
		height:60%;
		overflow: auto;
	}

</style>
</head>

<body>
	
	<p> Example de listado de productos </p>
	
	<c:if test="${storeList.size()==0}">
		<p> Example </p>
	</c:if>
	
	<c:forEach items="${storeList}" var="store">
			<p> ${store.almacen} </p>
			<p> ${store.idCompany} </p>	 
	</c:forEach>
	
</body>

</html>