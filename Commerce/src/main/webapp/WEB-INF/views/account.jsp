<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@  taglib uri="http://localhost/myFunctions" prefix="mt" %>

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
<script type="text/javascript" src="<c:url value="/resources/js/account/account.js"/>"></script>

<script type="text/javascript">
	<c:out value="var vectorOwner=${vectorOwner}" escapeXml="false"/>
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
		
		 <ul id="pestanas" class="nav nav-tabs">
			<li>
			 <a href="#datosCuenta"><span class="glyphicon glyphicon-home"></span>Datos Proveedor</a>
			</li>
			<li>
			  <a href="#owners"><span class="glyphicon glyphicon-arrow-up"></span> Propietarios </a>
			</li>
			<li>
			  <a href="#movimientos"><span class="glyphicon glyphicon-asterisk"></span> Movimientos</a>
			</li>
		</ul>
		 
	  <div class="expandirContent tab-content">
	
		 <div id="datosCuenta" class="expandir tab-pane fade">
		     <p>Datos Personas </p>
		 </div>
		 
		 <div id="owners" class="expandir tab-pane fade">
		     <ul id="pestanasSubMenu" class="nav nav-tabs">
		     	<li>
		     	   <a  id="bfirstOwner" href="#firstOwner"><span class="glyphicon glyphicon-home"></span>Primer Propietario</a>
		     	</li>
		     	<li>
		     	  <a  id="bsecondOwner" href="#secondOwner"><span class="glyphicon glyphicon-home"></span>Segundos Propietarios</a>
		     	</li>
		     </ul>
		  <div class="expandirContent tab-content">
		 	 <div id="firstOwner" class="tab-pane fade">
		 		<div class="columna">
		 		  <div class="titulo">
		 		  	<h3> Datos Primer Propietario </h3>
		 		  </div>
		 		  <div class="bloqueForm">
		 	      	<p id="pDni"> DNI: </p>
		 	      	<input id="dni" type="text"  />  
		 	      </div>
		 	      
		 	      <div id="BfirstName" class="bloqueForm">
		 	      	 <p id="tfirstName"> Nombre: </p>
		 	      	 <input id="firstName"  type="text"/>
		 	      </div>
		 	      
		 	      <div id="BfirstSurName" class="bloqueForm">
		 	      	<p id="bfirstSurName1"> Primer Apellido: </p>
		 	      	<input id="firstSurName" type="text"/>
		 	      </div>
		 	      
		 	      <div id="BsecondSurName" class="bloqueForm">
		 	        <p id="BsecondSurName1"> Segundo Apellido: </p>
		 	        <input id="secondSurName"  type="text"/>
		 	      </div>
		 	      
		 	      <div  id="Bstreet" class="bloqueForm">
		 	      	<p id="Bstreet1"> Calle: </p>
		 	      	<input  id="street" type="text"/>
		 	      </div>
		 	      
		 	      <div id="BhouseNumber" class="bloqueForm">
		 	      	<p id="BhousNumber1"> Numero: </p>
		 	      	<input id="houseNumber" type="text"/>
		 	      </div>
		 	      
		 		</div>
		     </div>
		     
		     <div id="secondOwner" class="expandir tab-pane fade">
		      <a href="#" onclick="aumentar()"> Calcular paginacion </a>
		      <a href="#" onclick="reducir()"> Calcular reducir </a>
		     	<p> the owner's table </p>
		     	<a href="#" onclick="mostrarPanelPropietario()"> Anadir FirstName </a>
		     	<div id="containerTabla" class="expandir90">
		     	<table id="tableAccount" class="table tableAncho">
		 			 <thead>
			 	 		<tr>
				 	 		<td>
				 	 			<p> DNI </p>
				 	 		</td>
				 	 		<td>
				 	 			<p> FirstName </p>
				 	 		</td>
				 	 		<td>
				 	 			<p> SecondName </p>
				 	 		</td>
				 	 		
				 	 		<td>
				 	 			<p> ThirdName </p>
				 	 		</td>
				 	 		
				 	 		<td>
				 	 			<p> Street </p>
				 	 		</td>
				 	 		
				 	 		<td>
				 	 			<p> House Number </p>
				 	 		</td>
			 	 	    </tr>
		 	         </thead>
				 	 <tbody>
				 	   <c:forEach items="${listOwner}" var="owner">
					 	 	<tr onclick="mostrarPanel(this.id)" id="${owner.idBd}">
					 	 		<td id="${owner.idBd}-1" class="celda">
					 	 			<p id="${owner.idBd}-1-1"> ${owner.DNI} </p>
					 	 		</td>
					 	 		
					 	 		<td id="${owner.idBd}-2" class="celda">
					 	 			<p id="${owner.idBd}-2-1"> ${owner.firstName} </p>
					 	 		</td>
					 	 		
					 	 		<td id="${owner.idBd}-3" class="celda">
					 	 			<p id="${owner.idBd}-3-1"> ${owner.firstSurName} </p>
					 	 		</td>
					 	 		
					 	 		<td id="${owner.idBd}-4" class="celda">
					 	 			<p id="${owner.idBd}-4-1"> ${owner.secondSurName} </p>
					 	 		</td>
					 	 		
					 	 		<td id="${owner.idBd}-5" class="celda">
					 	 			<p id="${owner.idBd}-5-1"> ${owner.street} </p>
					 	 		</td>
					 	 		
					 	 		<td id="${owner.idBd}-6" class="celda">
					 	 			<p id="${owner.idBd}-6-1"> ${owner.houseNumber} </p>
					 	 		</td>					 	 		
					 	 	</tr>
				 	 	</c:forEach>
				 	 </tbody>
		 			</table>
		 			</div>
		 			
		 			<div class="row5">
			 			 <a class="paginaButton" id="pAtras" href="#" onclick="atras()"> Anterior</a>
			 			 <div id="p-tableAccount" class="containerPages">
			 			 	<div id="p-tableAccount-1" class="page"> <p> 1 </p> </div> 			 	
			 			 </div>
			 			 <a class="paginaButton" id="pSiguiente" href="#" onclick="siguiente()"> Siguiente</a>
		 			</div>
		 			
		 		</div>
			 </div>
		 </div>
		 
		 <div id="movimientos" class="expandir tab-pane fade">
		 	<p> Movimientos asociados a la cuenta </p>
		 </div>
		 
	   </div>   
	</div>
	
	<div class="pie">
		<p> Pie </p>
	</div>
	
	
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel"></h4>
      </div>
      <div class="modal-body">
       <div  id="datosCuenta" class="datosCuenta">
		
			<div class="bloqueForm" id="B1">
				<label id="m-Dni">DNI:</label>
				<input type="text"  id="DNIPanel" />
			</div>
			
			<div class="bloqueForm" id="B2">
				<label id="m-First">First Name:</label>
				<input type="text"  id="firstNamePanel" />
			</div>
			
			<div class="bloqueForm" id="B3">
				<label id="m-Second">Second Nameeeeeeeeeee:</label>
				<input type="text"  id="secondNamePanel" />
			</div>
			
			<div class="bloqueForm" id="B4">
				<label id="m-Third">Third Name:</label>
				<input type="text"  id="thirdNamePanel" />
			</div>
			
			<div class="bloqueForm" id="B5">
				<label id="m-Street">Street:</label>
				<input type="text"  id="streetPanel" />
			</div>
			
			<div class="bloqueForm" id="B6">
				<label id="m-House">House Number:</label>
				<input type="text" id="houseNumberPanel" />
			</div>
		
		</div>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="operationPanel">Almacenar cuenta</button>
        <button type="button" class="btn btn-default" id="closePanel"  onclick="cerrarPanel()">Close</button>
      </div>
      
    </div>
  </div>
</div>
</body>
</html>