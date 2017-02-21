<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@  taglib uri="http://localhost/myFunctions" prefix="mt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>"></script>

<link rel="stylesheet"  href="<c:url value="/resources/css/boostrap/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/layout/layout.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/layout/layoutForm.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/layout/agenda.css"/>"/>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/agenda/agenda.js"/>"></script>



<script type="text/javascript">
		<c:out value="var hInic=${Day.hInic}"/>
		<c:out value="var hFin=${Day.hFin}"/>
		<c:out value="var vectorEventos=${vectorEventos}" escapeXml="false"/>
		<c:out value="var day=${modelDay}" escapeXml="false" />
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


<div id="cuerpo" class="cuerpo">
       	<div id="dia" class="dia">
	          <div  id="titleDay" class="titleDay">
	            <a href="#"> Anterior </a>
	            <a href="#"> 30/10/2015 </a>
	            <a href="#"> Siguiente </a>
	          </div>
	          
	          <div id="containerFranjas" class="containerFranjas">
		       	  <c:forEach  var="i" begin="${Day.hInic}" end="${Day.hFin}">
			       		<div id="F-${i}" class="franja">
					       <div id="FH-${i}" class="horario">
					         <a href="#"> ${i}</a>
					       </div>	
					       <c:set var="evento" scope="request" value="${Day.getEventByinicH(i)}"/>
					       <c:choose>
							   	<c:when test="${evento!=null}">
							       <div id="${evento.idBd}" class="evento" onclick="mostrarEvento(this.id)">
								       <p> ${evento.nombre}</p>
								       <p> ${evento.descripcion}</p>
								    </div>
							    </c:when>
							    
				    			<c:otherwise>
				        			<div id="FD-${i}" class="evento" onclick="altaEvento(this.id)">
								       <p> Disponible</p>
								    </div>
		    			 		</c:otherwise>
		    			 		
    					   </c:choose>
					   	</div>
				  </c:forEach>
			  </div>
		</div>
		
		<div id="altaEvento" class="expandir containerFade">
			 
			 <div id="fases" class="menuFases">
			    <div id="Fa-22" class="subMenuFases">
			       <button  class="btn btn-primary" onclick="volverHorario()"> Volver </<button>
			       <button  class="btn btn-primary margin" onclick="guardarForm()"> Guardar </<button> 
			    </div>
			    
			    <div id="Fa-23" class="subMenuFases">
			    	<a href="#" onclick="previousFase()"> Anterior </a>
			    </div>
			    
			    <div id="Fa-1" class="subMenuFases">
			    	<a href="#"> Datos Persona </a>
			    </div>
			    
			    <div id="Fa-2" class="subMenuFases">
			       <a href="#"> Horario  </a>
			    </div>
			    
			    <div id="Fa-3" class="subMenuFases">
			    	<a href="#"> Asistentes </a> 
			    </div>
			    
			    <div id="Fa-24" class="subMenuFases">
			    	<a href="#" onclick="nextFase()"> Siguiente </a>
			    </div>
			    
			 </div>
			 
			 <div id="Horario" class="containerMenu">
			   <h3> Horario: </h3>  
			  
			   
			   <a id="h-hInic"> Hora Inic </a> <input id="dph-inic" type="text"></input>
			   <a id="h-hFin"> Hora Fin </a> <input id="dph-fin" type="text"></input>
			 </div>
			 
			 <div id="asistentes" class="containerMenu containerFade">
			 	<h3> Asistentes </h3>
			 	
			 	<div id="selectedAsistentes" class="expandir23">
			 	<p> Listado de asistentes seleccionados </p>
			 	    <table id="tableSelectedAsistentes" class="table">
			 	      <thead>
			 	      	<tr>
			 	      		<td>
			 	      		   <a href='#'> DNI </a>
			 	      		</td>
			 	      		<td>
			 	      			<a href='#'>  Nombre </a>
			 	      		</td>
			 	      		<td>
			 	      			<a href='#'> Acción </a>
			 	      		</td>
			 	      	</tr>
			 	      </thead>
			 	      <tbody>
			 	        
			 	      </tbody>
			 	    </table>
			 	</div>
			 	
			 	<div id="asistentesSeleccionados" class="expandir77">
			 	   <a href='#' onclick="transladarSelected()"> Listado de asistentes </a>
			 	   <div class="menuFases">
				 	    <div id="s-grupos" class="subMenuFases">
						 	    <c:choose>
								 	 <c:when test="${listGrupos.size()>0}">
								 	 <select id="s-grupo">
									 	  <c:forEach items="${listGrupos}" var="grupo">
									 	     <option value="${grupo.idBd}">${grupo.groupName}</option>
									 	  </c:forEach>
									  </select>
								 	 </c:when>
							 	  	<c:otherwise>
							 	  		<select>
									      <option value="">No Grupos</option>
									    </select>
					    			</c:otherwise>
						 	  	</c:choose>	
					     </div>
					    <div id="s-categorias" class="subMenuFases">
					 	  	<c:choose>
						 	  		<c:when test="${listCategorias.size()>0}">
						 	  		   <select id="s-categoria">
						 	  			 <c:forEach items="${listCategorias}" var="categoria">
						 	  			 	<option value="${categoria.idBd}"> ${categoria.categoryName} </option>
						 	  			 </c:forEach>
						 	  		  </select>
						 	  		</c:when>
						 	  		<c:otherwise>
						 	  		    <select>
						 	  		       <option value=""> No Categoria </option>
						 	  		    </select>
						 	  		</c:otherwise>
					 	  	</c:choose>
				 	   </div>
				 	  
				 	  <div id="s-nombre" class="subMenuFases20">
				 	  	 <p> Nombre: </p>
				 	  	 <input id="s-Nombre" type="text"/>
				 	  </div>
				 	  
				 	  <div id="p-Apellido" class="subMenuFases20">
				 	     <p> Primer Apellido: </p>
				 	  	 <input id="s-PrimerA" type="text"/>
				 	  </div>
				 	  
				 	  <div id="p-Button" class="subMenuFases">
				 	  	<a href="#" id="p-Button-1" onclick="buscarAsistentes()">Buscar </a>
				 	  </div>
				 	  
			 	  </div>  
			 	   <div id="containerAsistentes">
				 	  <table id="tableAsistentesBuscados" class="table expandir">
				 	   		<thead>
				 	   			<tr>
				 	   				<td>
				 	   					DNI
				 	   				</td>
				 	   				<td>
				 	   					Categoria
				 	   				</td>
				 	   				<td>
				 	   					Grupo
				 	   				</td>
				 	   				<td>
				 	   					Nombre
				 	   				</td>
				 	   				<td>
				 	   					firstName
				 	   				</td>
				 	   				<td>
				 	   					secondName
				 	   				</td>
				 	   				<td>
				 	   				
				 	   				</td>
				 	   			</tr>
				 	   		</thead>
				 	   		<tbody>
				 	   		  <tr>
					 	   		  <td>
					 	   		  	 CELL PADING 1
					 	   		  </td>
					 	   		  <td>
					 	   		  	 CELL PADING 2
					 	   		  </td>
					 	   		  <td>
					 	   		  	 CELL PADING 3
					 	   		  </td>
					 	   		   <td>
					 	   		  	 CELL PADING 4
					 	   		  </td>
					 	   		   <td>
					 	   		  	 CELL PADING 5
					 	   		  </td>
					 	   		  <td>
					 	   		  	 CELL PADING 6
					 	   		  </td>
				 	   		  </tr>
				 	   		</tbody>
				 	   	</table>
			 	    <div id="p-containerAsistentes">
			 	    	<p> Paginacion </p>
			 	    </div>
			 	</div>
			 	</div>
			 </div>
			 
			 <div id="sala" class="containerMenu containerFade">
			 	<h3> Sala </h3>
			 	<button id="buscarSala" class="btn btn-primary" onclick="buscarSala()"> Buscar Sala </button>
			 	<button id="seleccionarSala" class="btn bnt-primary fade" onclick="seleccionarSala()"> Seleccionar sala</button>
			 	
			 	<div id="s-0" class="expandir20" style="margin-top:10px">
			 	
				 	<div id="s-1" class="slot20">
				 		<label> Nombre Sala: </label> 
				 		<input  id="s-seleccionada" type="text" disabled/>
				 	</div>
				 	
				 	<div id="s-2" class="slot80">
				 	
				 	 <div id="s-2-1" class="slot20">
				 	 	<div id="a">
					 		<label id="s-2-1-3343"> Capacidad: </label>
					 		<select id="s-2-1-4343">
					 			<option value="10">>10</option>
					 			<option value="15">>15</option>
					 			<option value="20">>20</option>
					 			<option value="25">>25</option>
					 		</select>
					    	<br>
					 		<label id="s-2-1-322"> Planta: </label>
					 		<select id="s-2-1-422">
					 			<option value="1">1</option>
					 			<option value="2">2</option>
					 			<option value="3">3</option>
					 			<option value="4">4</option>
					 		</select>
						</div>
					 </div>
					 	<div id="s-2-2" class="slot20">
					 		<ul id="lista1" class="lista">
						 		<li>
							 		<label id="lista1-m"> Monitor:</label>
							 		<input id="c-m" type="checkbox">
							 	</li>
							 	<li>
							 		<label id="lista1-c"> Conferencia:</label>
							 		<input id="c-conf" type="checkbox">
						 		</li>
					 		</ul>
					 	</div>
					 	<div id="s-2-3" class="slot20">
					 		<ul id="lista2" class="lista">
						 		    <li>
								 		<label id="lista2-m"> Monitor:</label>
								 		<input id="m-monit" type="checkbox">
							 		</li>
							 		<li>
								 		<label id="lista2-p"> Proyector:</label>
								 		<input id="ch-p2" type="checkbox">
							 		</li>
						 	</ul>
					 	</div>
					 	
					 	<div id="s-2-4" class="slot20">
					 		<ul id="lista3" class="lista">
					 			<li>
							 		<label id="lista1-t"> Traductor:</label>
							 		<input id="ch-t" type="checkbox">
						 		</li>
						 	    <li>
							 		<label id="lista1-t2"> Traductor2:</label>
							 		<input id="t-tra" type="checkbox">
						 		</li>	
					 		</ul>
					 	</div>
					 	
					 	<div id="s-2-5" class="slot20">
					 	   <ul id="lista4" class="lista">
					 			<li>
								 		<label id="lista2-po"> Portatil:</label>
								 		<input id="ch-por" type="checkbox">
							 	</li>
							 	<li>
								 		<label id="lista2-em"> Example:</label>
								 		<input id="ch-exa" type="checkbox">
							 	</li>
					 		</ul>
					 	</div>
				 	</div>
				 	
			 	</div>
			 	
			 	<div id="s-3" class="expandir80 carousel slide">
			 	
			 	<div id="carrousel-salas" class="carousel-inner" role="listbox">
			 		<div id="s-5" class="item active">
			 			<p> Salas encontradas </p>
			 			<table id="tableSalasBuscadas" class="table">
			 			 <thead>
			 			  <tr>
			 			  	<td>
			 			  	   <a href='#'> Num Sala </a>
			 			  	</td>
			 			  	 
			 			  	<td>
			 			  	   <a href='#'> Sala  </a>
			 			  	</td>
			 			  		
			 			  	<td>
			 			  	   <a href='#'> Capacidad </a>
			 			  	</td>
			 			  	   
			 			  	<td>
			 			  	   <a href='#'> Planta </a>
			 			  	</td>
			 			  	<td>
			 			  		<a href='#'> Acción </a>
			 			  	</td>
			 			  				 			 
			 			  </tr>
			 			 </thead>
			 			 <tbody>
			 			 	<tr>
			 			 		<td>
			 			 			Sin asignación
			 			 		</td>
			 			 		
			 			 		<td>
			 			 			Sin Asignación
			 			 		</td>
			 			 		
			 			 		<td>
			 			 			Sin asignación
			 			 		</td>
			 			 		
			 			 		<td>
			 			 			Sin asignación
			 			 		</td>
			 			 	</tr>
			 			 </tbody>
			 			</table>
			 		</div>
			 		
			 		
			 		<div id="s-6"  class="item">
			 	     <div><a href='#' onclick="volverSalas()"> Volver </a> </div>
			 		   <div class="columna" id="colum-Sala1">
			 		        <div class="bloqueForm">
					 			<label id="l-nombre">Nombre: </label>
					 			<input id="sa-nombre" type="text" />
				 			</div>
			 				<div class="bloqueForm">
					 			<label id="l-capacidad">Capacidad: </label>
					 			<input id="s-capacidad" type="text" />
				 			</div>
			 				<div class="bloqueForm">
					 			<label id="l-planta">Planta:</label>
					 			<input id="s-planta" type="text" />
				 			</div>
			 		   </div>
			 		   
			 		   <div class="columna" id="colum-Sala2">
			 		   
			 		   	   <div class="bloqueForm">
					 		    <label id="l-monitor">Monitor:</label>
					 			<input id="s-monitor" type="text" />
				 			</div>
				 			
				 			<div class="bloqueForm">
					 			<label id="l-confe">Conferencia:</label>
					 			<input id="s-conferencia" type="text" />
				 			</div>
				 			
				 			<div class="bloqueForm">
					 			<label id="l-tra">Traductor:</label>
					 			<input id="s-traductor" type="text" />
				 			</div>
				 			
				 			<div class="bloqueForm">
					 			<label id="l-sala">Sala:</label>
					 			<input id="s-sala" type="text" />
				 			</div>
			 			</div>
			 		
			 			
			 		</div>
			 	
			 	</div>
			 		
			 	</div>
			 	
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
       <div class="datosCuenta">
		
			<div class="bloqueForm" id="B1">
				<label> Numero Cuenta: </label>
				<input type="text"  id="Account" name="newBankAccount[0].codeAccount" />
				<c:if test="${error.existError('errorNumeroCuenta')}">
			     <p> ${error.getError('errorNumeroCuenta')}  </p>
				</c:if>
			</div>
			
			<div class="bloqueForm" id="B2">
				<label> Entidad Bancaria: </label>
				<select id="entidades" style="margin-left:10px"name="newBankAccount[0].bankEntity">
					<option value="C1"> <p>Caja Mar 1 </p></option>
					<option value="C2"> <p> Santander </p></option>
				</select>
				<c:if test="${error.existError('errorEntidadBancaria')}">
				   <p> ${error.getError('errorEntidadBancaria')}  </p>
				</c:if>
			</div>
			
			<div class="bloqueForm" id="B3">
				<label> Saldo Actual: </label>
				<input type="text" style="margin-left:41px" id="Balance"name="newBankAccount[0].currentBalance" />
				<c:if test="${error.existError('errorSaldoActual')}">
				   <p> ${error.getError('errorSaldoActual')}  </p>
				</c:if>
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


<div class="modal fade" id="panelOk" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="titleOk"></h4>
      </div>
      <div class="modal-body">	
		<p id="messageOk">  </p>
      </div>
    </div>
  </div>
</div>

</body>
</html>