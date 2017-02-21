<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@  taglib uri="http://localhost/myFunctions" prefix="mt" %>
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
<script type="text/javascript" src="<c:url value="/resources/js/provider/provider.js"/>"></script>

<script>
	<c:out value="var vector=${vector}" escapeXml="false"/>
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
	
	<c:if test="${error.isLogic()}">
		<p>  ${error.getError('providerName')} </p>
	</c:if>
	
	<c:if test="${idProvider>0}">
		<p> El producto esta dado de alta. </p>
		<c:url var="homeLink" value="${home}" />
		<a href='<c:out value="${homeLink}"/>'> Return to Index </a>
	</c:if>
	
	<form:form  modelAttribute="Proveedor" class="expandir">
	
		<ul id="pestanas" class="nav nav-tabs">
			<li>
			 <a  id="bProveedor" href="#proveedor"><span class="glyphicon glyphicon-home"></span> Datos Proveedor</a>
			</li>
			<li>
			  <a id="bDatosBancarios" href="#datosBancarios"><span class="glyphicon glyphicon-arrow-up"></span> Datos Bancarios </a>
			</li>
		    <li>
			  <a  id="dMov" href="#datosMovimientos"><span class="glyphicon glyphicon-arrow-up"></span> Datos Movimientos </a>
			</li>
		</ul>
	
	<div class="expandir tab-content">
		<div id="proveedor" class="expandir tab-pane fade">
				 <div  id="proveedorD" class="columna">
				   <div class="titulo">
				   	    <h3> Datos Proveedor </h3>
				   </div>
					<div id="cProviderName" class="bloqueForm">
						<p id="cPNombre">Nombre:</p>
						<input name="proveedor.providerName" id="providerName" type="text" value="${p.proveedor.providerName}" >
						<c:if test="${error.existError('providerName')}">
							<p> ${error.getError('providerName')} </p>
						</c:if>
					</div>

					<div id="cProviderStreet" class="bloqueForm">
						<p id="cPD">Dirección:</p>
						<input name="proveedor.providerStreet" type="text" id="providerStreet" class="${mt:getCss(p.proveedor)}" value="${p.proveedor.providerStreet}">
						<c:if test="${error.existError('errorStreet')}">
						   <p> ${error.getError('errorStreet')}  </p>
						</c:if>
				    	</div>
				    
				        <div class="bloqueForm">
						<p id="cPed">Codigo de Pedido:</p>
						<input name="proveedor.codigoPedido" type="text"  id="codigoPedido" class="${mt:getCss(p.proveedor)}" value="${p.proveedor.codigoPedido}" >
						<c:if test="${error.existError('codigoPedido')}">
							<p> ${error.getError('codigoPedido')}  </p>
						</c:if>
					</div>
				
					<div class="bloqueForm">
						<p id="cImPed" >Importe  total Pedido:</p>
						<input name="proveedor.importePedido" type="text" id="importePedido" class="${mt:getCss(p.proveedor)}">
						<c:if test="${error.existError('totalPedido')==true}">
								<p> ${error.getError('totalPedido')} </p>
						</c:if>
					</div>
					
					<div class="bloqueForm">
						<p id="cDes">Descripción:</p>
						<input name="proveedor.descripcion" type="text" id="descripcion" class="${mt:getCss(p.proveedor)}" value="${p.proveedor.descripcion}">
					</div>
				</div>
				
				<div  id="dContacto" class="columna">
				
					 <div class="titulo">
					   <h3> Datos de contacto </h3>
					 </div>
					 
					<div class="bloqueForm">
						<p id="cTelef">Telefonos:</p>
						<c:forEach items="${p.proveedor.telefonos}" var="telefono">
							<input class="telefonos" type="text" value="${telefono}"> </input>
						</c:forEach>
						<c:if test="${error.existError('p.proveedor.telefono')}">
							<p> ${error.getError('providerName')} </p>
						</c:if>
					</div>
					
			
					<div class="bloqueForm">
						<p id="cEmail">Email:</p>
						<input name="proveedor.providerStreet" id="email" type="text" class="${mt:getCss(p.proveedor)}" value="${p.proveedor.email}">
						<c:if test="${error.existError('email')}">
						   <p> ${error.getError('email')}  </p>
						</c:if>
						
				    </div>
				    
				    <div class="bloqueForm">
						<p id="cWebS">WebSite </p>
						<input id="paginaWeb" type="text" value="${p.proveedor.paginaWeb}"></input>
						<c:if test="${error.existError('horario')}">
							<p> ${error.getError('horario')}  </p>
						</c:if>
					</div>
				
				</div>
				
				<div id="visitPro" class="columna">
					<div class="titulo">
						<h3> Dias de visita Proveedor </h3>
					</div>
					<div class="bloqueForm">
						<p> Nuevo </p>
					  <c:forEach items="${p.proveedor.diasVisitaProveedor}" var="dia">
					  	 <input type="checkbox" name="chk_group" value="${dia[0]}">
					  	 	${dia[1]}
					  	 </input>
					  </c:forEach>
					</div>
				</div>
			
		</div>
		
		<div id="datosBancarios" class="expandir80 tab-pane fade">
			<div  id="datosB" class="columna">
				<div class="titulo">
				   <h3> Datos B</h3>
				</div>
				<div class="bloqueForm">
					 <p id="datosBanc">  Dato Banc 4: </p>
						<input name="proveedor.importePedido" type="text" class="${mt:getCss(p.proveedor)}">
						<c:if test="${error.existError('totalPedido')==true}">
								<p> ${error.getError('totalPedido')} </p>
						</c:if>
				</div>
				<div class="bloqueForm">
				     <p id="date20"> Date 20: </p>
						<input name="proveedor.importePedido" type="text" class="${mt:getCss(p.proveedor)}">
						<c:if test="${error.existError('totalPedido')==true}">
								<p> ${error.getError('totalPedido')} </p>
						</c:if> 
				</div>
				<div class="bloqueForm">
				 <p id="dateExample"> Date example nuevo: </p>
						<input name="proveedor.importePedido" type="text" class="${mt:getCss(p.proveedor)}">
						<c:if test="${error.existError('totalPedido')==true}">
								<p> ${error.getError('totalPedido')} </p>
						</c:if>
				</div>
			</div>
			
			<div id="datosC" class="columna">
			
			    <div class="titulo">
				   <h3> Datos C</h3>
				</div>
				
				<div class="bloqueForm">
					 <p id="cSept">Campo septimo</p>
						<input name="proveedor.importePedido" type="text" class="${mt:getCss(p.proveedor)}">
						<c:if test="${error.existError('totalPedido')==true}">
								<p> ${error.getError('totalPedido')} </p>
						</c:if>
				</div>
				
				<div class="bloqueForm">
				     <p id="importP">Importe total pedido:</p>
						<input name="proveedor.importePedido" type="text" class="${mt:getCss(p.proveedor)}">
						<c:if test="${error.existError('totalPedido')==true}">
								<p> ${error.getError('totalPedido')} </p>
						</c:if> 
				</div>
				<div class="bloqueForm">
				   <p id="campoPed">Nuevo Pedido</p>
						<input name="proveedor.importePedido" type="text" class="${mt:getCss(p.proveedor)}">
						<c:if test="${error.existError('totalPedido')==true}">
								<p> ${error.getError('totalPedido')} </p>
						</c:if>
				</div>
			</div>
		</div>
		
		<div id="datosMovimientos" class="expandir80 tab-pane fade">
			<div class="panelInformar">
					<div id="cuentas" class="cuentas expandir">
					  <div style="margin-top:10px">
					    <a href="#" id="anadirBank" class="btn btn-primary" onclick="mostrarPanel()"> anadirMovimiento </a>
					    <a href="#" id="submitForm" class="btn btn-primay" onclick="submitForm()"> submitForm</a>
					  </div>		
					   <c:if test="${p.proveedor.existBankAccount()==false}">
					   <div id="containerTabla" class="expandir80N">
					   	<table id="countBankTable" class="table marginTabla">
					   	   <thead>
						   		<tr>
							   		<td>
							   		  <p> CodeAccount </p>
							   		</td>
							   		<td>
							   			<p> EntidadBank </p>
							   		</td>
							   		<td>
							   			<p> Saldo Actual </p>
							   		</td>
							   		<td>
							   		    <p> Acciones </p>
							   		</td>
						   		</tr>
					   		</thead>
					   		<tbody>
						   		<c:forEach items="${p.proveedor.bankAccount}" var="account" >
						   					<tr id="${account.idBd}" class="filaOculta">
							   					<td id="${account.codeAccount}-1-1">
							   						    <a href="#" id="${account.codeAccount}-1-1-1" onclick="showCuenta(this.id)"> ${account.codeAccount} </a>
							   					</td>
							   					
						   						<td id="${account.codeAccount}-1-2">
						   							 <a href="#" id="${account.codeAccount+1}-1-3" onclick="showCuenta(this.id)"> ${account.bankEntity} </a>
						   						</td>
						   						
						   						<td id="${account.codeAccount}-1-3">
						   						     <a href="#" id="${account.codeAccount+1}-3-4" onclick="showCuenta(this.id)"> ${account.currentBalance} </a>
						   						</td>
						   						
						   						<td id="${account.codeAccount}-1-4">
						   					            <a href="#" id="${account.codeAccount+1}-1-6" style="display:inline" onclick="eliminarCuenta(this.id)">
						   							     eliminar 
						   						     </a>
						   						</td>
						   						
						   					</tr>	
						   		</c:forEach>
					   		</tbody>
					   		<c:if test="${p.proveedor.existBankAccount()}">
						   		<div class="centrado">
						   			<p> No existen cuentas bancarias </p>
						   		</div>
					   		</c:if>
					   		</table>
			 			    </div>
			 			    <div class="row5">
					 			 <a class="paginaButton" id="pAtras" href="#" onclick="atras()"> Anterior</a>
					 			 <div id="p-tableAccount" class="containerPages">
					 			 	<div id="p-tableAccount-1" class="page"> <p> 1 </p> </div> 			 	
					 			 </div>
					 			 <a class="paginaButton" id="pSiguiente" href="#" onclick="siguiente()"> Siguiente</a>
			 			    </div>
					   </c:if>
					</div>			
				</div>
		</div>
	</div>
	</form:form>
	
</div>

<div class="pie">
	<p> Pie </p>
</div>

<!--  
tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"
-->

<div class="modal fade" id="exampleModal" >
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