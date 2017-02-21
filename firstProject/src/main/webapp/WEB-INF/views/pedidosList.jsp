<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="html">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>

	.table{
		width:100%;
		margin-left:10%;
		

	}
	
	.cabecera{
		width: 100%;
		height:10%;
		background-color:pink;
	}
	
		
	.menuLateral{
		width:10%;
		height:80%;
		background-color:yellow;
		float:left;
	}
	
	.menuLateral a{
	
	  display:block;
	  padding-top:10px;
	}
	
	.pie{
		width:100%;
		height:10%;
		background-color:blue;
		clear:both;
	}
	
	
    .cuerpo{
    	width:90%;
    	height:80%;
    	background-color:green;
    	float:left;
    	overflow:auto;
    }
    
    
    .html{
    	background-color:red;
    	width:100%;
    	height:100%;
    }
    
    .body{
    	background-color:purple;
    	width:100%;
    	height:100%;
    }
    

</style>

</head>

<body class="body">

<div class="cabecera">
   <p> Listado de Pedidos </p>
</div>
	
 <div class="menuLateral">
    <c:url var="home" value="/">
	</c:url>
   	<a href='<c:out value="${home}"/> '> Home </a>
   	
   	<c:forEach items="${listEnlaces}" var="enlace">
	      <c:url var="link" value="${enlace.url}">
	        <c:param name="id" value="0" />
	      </c:url>
	      <a href='<c:out  value="${link}"/> '> ${enlace.name} </a>
	 </c:forEach>
 
</div>
	
	
<div class="cuerpo">
   <table class="table">
		<tr>
		    <c:if test="${pedidos.size()==0}" >
				  <td> No existen pedidos asignados </td>			
			</c:if>
			<c:if test="${pedidos.size()!=0}">
					<tr>
					
						<td>
							<p> Nombre </p>
						</td>
						
						<td>
							<p> Direccion </p>
						</td>
						<td>
							<p> dateInic </p>
						</td>
	
						<td>
							<p> dateFin </p>
						</td>
						
					</tr>
			</c:if>
		</tr>
		
		
	    <c:forEach items="${pedidos}" var="pedido">
				<tr>
					<td>
					  <c:url var="providerLink" value="/provider">
					  		<c:param name="id" value="0"/>
					  </c:url>
						<a href='<c:out value="${providerLink}"/>'> ${pedido.proveedor.providerStreet} </a>
					</td>
					
					<td>
						<p>${pedido.proveedor.providerStreet}</p>
					</td>
					
					<td>
						<p>${pedido.requestDate} </p>
					</td>
					
					<td>
						<p>${pedido.deliverDate}</p>					
					</td>
					
					<td>
						<c:url var="pedidoLink" value="/pedido">
                            <c:param name="id" value="0" />
                        </c:url>
                        <a href='<c:out value="${pedidoLink}"/>'> Editar URL </a>
					</td>
					
				</tr>
			</c:forEach>
		</table>
</div>


<div class="pie">
	<p> Footer </p>
</div>
    
</body>
</html>