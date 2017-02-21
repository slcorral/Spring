<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="POST" commandName="form">
	
	<p> Nombre: </p>
	<form:input path="productVector[0].name" />
	<p> Code: </p>
	<form:input path="productVector[0].code" />
	<p> Cantidad: </p>
	<form:input path="productVector[0].cantidad"/>
	<p> Norma: </p>
	<form:input path="productVector[0].norma" />
	
	<p> Nombre 1: </p>
	<form:input path="productVector[1].name" />
	<p> Code 1: </p>
	<form:input path="productVector[1].code" />
	<p> Cantidad 1: </p>
	<form:input path="productVector[1].cantidad"/>
	<p> Norma 1: </p>
	<form:input path="productVector[1].norma" />
	<input type="submit" name="submit" value="Insertar"/>
	
</form:form>

</body>
</html>