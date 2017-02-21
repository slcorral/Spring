<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui/jquery-ui.min.js"/>"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<link rel="stylesheet"  href="<c:url value="/resources/css/boostrap/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/layout/layout.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/layout/layoutForm.css"/>"/>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/movimiento/movimiento.js"/>"></script>

<script>
	<c:out value="var vectorMovimientos=${vectorMovimientos}" escapeXml="false"/>
</script>

</head>


<body class="body">

<div class="cabecera">
   <p> Cabecera </p>
</div>

<div class="menuLateral">

	<div id="logoEmpresa" class="logoEmpresa">
	   <div id="logo" class="companyImage">
	    <p> Imagen de empresa </p>
	  	</div>
	</div>
	
	<div class="positionMenu">
		<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
			<c:forEach items="${listSection}" var="section">
			    <c:if test="${listSection.isEmpty()==false}">
				    <div class="panel panel-default">
				    	<div class="panel-heading" role="tab" id="headingOne">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" href="#${section.section}" aria-expanded="true" aria-controls="collapseOne">
					           ${section.section}
					        </a>
					      </h4>
				        </div>
					    <div id="${section.section}" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
					      <c:forEach items="${section.listLink}" var="enlace">
						      <div class="panel-body">
						      	 <c:url var="link" value="${enlace.url}">
						      	 	<c:if test="${enlace.hasParam()}">
							           <c:param name="id" value="0" />
							        </c:if>
						      	 </c:url>
						         <a href='<c:out  value="${link}"/> '> ${enlace.name} </a>
					     	 </div>
					      </c:forEach>
					    </div>
					 </div> 
				</c:if> 
			</c:forEach>
		</div>
	</div>
	
</div>

<div class="cuerpo">
	
		<div class="buscador row20">
			<div id="1" class="campoBuscador">
				<p>Entidad Origen: </p>
				<select id="entidadOrigen">
				 <c:forEach items="${listaEntidades}" var="entidad">
				 	<option value="${entidad.id}">
				 		${entidad.name} 
				 	</option>	
				 </c:forEach>
				</select>
			</div>
			
			<div id="2" class="campoBuscador">
				<p>Usuario Origen: </p>
				<input id="usuarioOrigen" type="text">
			</div>
			<div id="3" class="campoBuscador">
				<p>Entidad Destino: </p>
				<select id="entidadDestino">
				 <c:forEach items="${listaEntidades}" var="entidad">
				 	<option value="${entidad.id}">
				 		${entidad.name} 
				 	</option>	
				 </c:forEach>
				</select>
			</div>
			<div id="4" class="campoBuscador">
				<p>Usuario Destino: </p>
				<input id="usuarioDestino" type="text">
			</div>
			<div id="5" class="campoBuscador">
			 <a href="#" id="1" onclick="buscar()"> Buscar  </a>
			</div>
		</div>
		
		<div class="row80" id="fila80">
		<table  id="tableMovimiento" class="table tableNoMargin">
			  <thead id="thead">
			  	   <tr>
				  	   <td>
				  	   	  Cuenta Origen
				  	   </td>
				  	   <td>
				  	      Cuenta Destino
				  	   </td>
			  	     <td>
			  	     	<p> Entidad Origen </p>
			  	     </td>
			  	     
			  	     <td>
			  	     	<p> Usuario Origen </p>
			  	     </td>
			  	     
			  	     <td>
			  	     	<p> Entidad Destino </p>
			  	     </td>
			  	     
			  	     <td>
			  	        <p> Usuario Destino </p>
			  	     </td>
			  	     
			  	     <td>
			  	     	<p> Estado </p>
			  	     </td>
			  	     
			  	   </tr>
			  </thead>
			  <tbody id="bodyMovimiento">
			  <c:forEach items="${movimientos}" var="movimiento">
			  	 	 <tr id="${movimiento.idBd}">
			  	 	 
			  	 	   <td id="${movimiento.idBd}-1-7">
			  	 	      <p id="${movimiento.idBd}-1-8"> ${movimiento.sourceAccount} </p>
			  	 	   </td>
			  	 	   
			  	 	   <td id="${movimiento.idBd}-1-9">
			  	 	     <p id="${movimiento.idBd}-1-11"> ${movimiento.destinationAccount} </p>
			  	 	   </td>
			  	 	   
			  	 	   <td id="${movimiento.idBd}-1-2">
			  	 	      <p id="${movimiento.idBd}-1-2-1"> ${movimiento.sourceBank} </p>
			  	 	   </td>
			  	 	   
			  	 	   <td id="${movimiento.idBd}-1-3">
			  	 	      <p id="${movimiento.idBd}-1-2-2"> ${movimiento.sourceUser} </p>
			  	 	   </td>
			  	 	   
						<td id="${movimiento.idBd}-1-4">
							<p id="${movimiento.idBd}-1-2-3"> ${movimiento.targetUser} </p>
			  	 	    </td> 
			  	 	    
			  	 	    <td id="${movimiento.idBd}-1-5">
			  	 	    	<p id="${movimiento.idBd}-1-2-4"> ${movimiento.targetBank} </p>
			  	 	    </td>
			  	 	    
			  	 	    <td id="${movimiento.idBd}-1-6">
			  	 	    	<p id="${movimiento.idBd}-1-2-5"> ${movimiento.estado} </p>
			  	 	    </td>
			  	 	 </tr>
			  </c:forEach>
			  </tbody>
			  </table>
			  <c:if test="${movimientos.isEmpty()==true}">
			  		<div>
			  			<p> No existen Movimientos </p>
			  		</div>
			  </c:if>	  
		  </div>
		  
		  <div id="paginacion" class="paginacion">
		  
		  	 <div id="btnPrevious" class="btnIzquierdo btnEnabled">
		  	 	<a href="#" onclick="showPreviousPage()">Anterior</a>
		  	 </div>
		  	 
		  	 <div id="btnNext" class="btnDerecho btnEnabled">
		  	 	<a href="#" onclick="showNextPage()">Siguiente</a>
		  	 </div>
		  	 
		  </div>
		  
 </div>


<div class="pie">
	<p> Pie </p>
</div>

</body>
</html>