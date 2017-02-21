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


<div>
	Detalles de Pedido
</div>

<div class="menuLateral">

   <c:url var="home" value="/">
   </c:url>
   
   <a href='<c:out value="${home}"/> '> Home </a>
   
   <c:forEach items="${listEnlaces}" var="enlace">
      <c:url var="link" value="${enlace.url}">
        <c:param name="id" value="0" />
      </c:url>
      <a href='<c:out value="${link}"/> '> ${enlace.name} </a>
      <br>
   </c:forEach>
</div>
   
   
 <div>
   <p> Información del proveedor </p>
 	  <p>Example de desarrollo </p>
 	  <p> Nombre: ${pedido.proveedor.providerName} </p>
 	  
 	  <p> fechaInicio:  ${pedido.requestDate} </p>
 	  <p> fechaFin: ${pedido.deliverDate} </p>
 	  <p> Estado del pedido </p>
 	  
 	  <p> Resto de propiedades </p>
 	  
 </div>
 
<div>

	<p> Listado de productos del pedido </p>
	
	<table>
	
	<c:if test="${pedido.listProduct.size()==0}">
			<tr>
				<td> <p> El pedido no tiene ningun producto asociado. </p> </td>
			</tr>
	</c:if>
	
	<c:if test="${pedido.listProduct.size()>0}">
		 <tr>
		 	<td>
		 		<p> Product </p>
		 	</td>
		 		<p> Cantidad </p>	
		 	<td>
		 	     <p> Acción </p>
		 	</td>
		 </tr>
	</c:if>
	
	 
	 <c:forEach items="${pedido.listProduct}" var="product">
	 
	 	<tr>
	 	   <td>
	 	   	  <p> ${product.name} </p>
	 	   </td>
	 	   
	 	   <td>
	 	   	  <p> cantidad </p>
	 	   </td>
	 	   
	 	   <td>
	 	   	  <p> Precio </p>
	 	   </td>
	 	   <td>
	 	   	  <p> Eliminar </p>
	 	   </td>
	 	   
	 	</tr>
	 </c:forEach>
	
	</table>
	
</div>
 
 <div>
 	Pie
 </div>

</body>
</html>