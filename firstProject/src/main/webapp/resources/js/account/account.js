
var prefixNuevo="N-";
var vectorNuevos;
var vectoModificados;
var vectorBorrados;
var idNuevo=0;
var previousValues;
var currentPropietario;
var altoFila=0;
var numFila=0;
var parentContainer="";
var redimensionar=false;
var calcular=false;
var currentPage=1;
var numPages=0;
var pRedimension=false;
var panelAjustado=false;
//CAPA JAVSCIPT

function prepararVector(){
	vectorNuevos=new Array();
	vectorModificados=new Array();
	vectorBorrados=new Array();
	previousValues=new Array();
}

function javaScript_getPropietarioById(idPropietario){
	
	if(idPropietario!=null && idPropietario!=""){
		var token=idPropietario.split("-");
		if(token[0]=="N"){
			for(var i=0;i<vectorNuevos.length;i++){
				 if(vectorNuevos[i].idBd==idPropietario)
					 return vectorNuevos[i];
			}
		}else{
			for(var i=0;i<vectorModificados.length;i++){
				if(vectorModificados[i].idBd==idPropietario)
					return vectorModifcados[i];
			}
		}
		
	}
	
}


function ajustarParrafo(idBloque,elemento){
	
    if(idBloque!=null && idBloque!="" && elemento!=null && elemento!=""){
    	 var childrenP=$("#"+idBloque+" "+elemento);
    	 var maxLength=0;
    	 childrenP.each(function(index){
    		var width=$(this).outerWidth(true);
    		if(maxLength<width)
    			maxLength=width;
    	 });
    	
    	 childrenP.each(function(index){
     		var width=document.getElementById($(this).attr("id")).offsetWidth;
     		var margin=maxLength-width;
     		$(this).css({"margin-right":margin});
     		margin=0;
     	 }); 	 
    }
}

$(document).ready(function(){
	
	prepararVector();
	$("#accordion div.panel-body").parent().removeClass();
	$("#accordion div.panel-body").parent().addClass(
			"panel-collapse collapse");
	
	$("#pestanas a").click(function(e) {
			e.preventDefault();
			$(this).tab('show');
	});
	
	$("#pestanasSubMenu a").click(function(e) {
		e.preventDefault();
		$(this).tab('show');

	});
	
	$("#pestanasSubMenu a").on('shown.bs.tab', function (e) {
		if(e.target.id=="bsecondOwner")
			reajustar("containerTabla");
		if(e.target.id=="bfirstOwner"){
			if(pRedimension==false){
				pRedimension=true;
				ajustarParrafo("firstOwner","p");
			}
		}
	});
	
	$("#exampleModal").on("shown.bs.modal",function(e){
		if(panelAjustado==false){
			panelAjustado=true;
			ajustarParrafo("datosCuenta","label");
		}
	});

});


function reajustar(idContainerTabla){
	calcularPaginacionInic(idContainerTabla);
	rellenarTabla("tableAccount",vectorNuevos,vectorOwner);
	currentPage=1;
}

function rellenarTabla(idTabla,vNuevo,vOld){
	$("#"+idTabla+" > tbody > tr").remove();
	if(numFila!=null){
		for(var i=0;i<vOld.length && i<numFila;i++)
		    addFilaByPropietario(vOld[i]);
		
		for(var i=0;i<vNuevo.length && i<numFila;i++)
		    addFilaByPropietario(vNuevo[i]);
	}
}


function atras(){
	if(currentPage>1){
		if(currentPage==numPages)
			 enabledSiguiente();
		currentPage--;
		showPage(currentPage);
		if(currentPage==1)
			disabledAtras();
	}
}

function enabledAtras(){
	$("#pAtras").attr("class","paginaButton btnEnabled");
}

function disabledAtras(){
	$("#pAtras").attr("class","paginaButton btnDisabled");
}


function enabledSiguiente(){
	$("#pSiguiente").attr("class","paginaButton btnEnabled");
}

function disabledSiguiente(){
	$("#pSiguiente").attr("class","paginaButton btnDisabled");
}

function siguiente(){
   if(currentPage<numPages){
	   currentPage++;
	   showPage(currentPage);
   }else{
	   disabledSiguiente();
   }
}


function calculaNumFilas(idContainerTabla){
	if(idContainerTabla!=null && idContainerTabla!=""){
		var alto=37;
		altoFila=alto;
		var numero=Math.floor($("#"+idContainerTabla).height()/alto);
		numFila=numero-1;
	}
}


function calcularPaginacionInic(idContainerTabla){
		  calculaNumFilas(idContainerTabla);
		  var numButtons=calculateNumButtons(vectorNuevos,vectorOwner);
		   var width=document.getElementById("p-tableAccount").offsetWidth;
		   var widthButton=21;
		   if(widthButton>0 && width>0){
			   var pages=Math.floor(width/widthButton);
			   var maximun=0;
			   if(numButtons>pages)
				   maximun=pages;
			   else
				   maximun=numButtons;
			   createButtons("p-tableAccount",maximun);   
		  } 
}


function showPage(index){
	if(index!=null && index>0){
		var inic=(index-1)*(numFila);
		var fin=index*numFila;
		removeFilas();
		var index=inic;
		if(inic<vectorOwner.length){
			for(;index<=fin && index<vectorOwner.length;index++)
			    addFilaByPropietario(vectorOwner[index]);
			
			if(index<=fin){
				for(;index<=fin && index<vectorNuevos.length;index++){
					addFilaByPropietario(vectorNuevos[index]);
				}
			}
		}else{
			for(var i=index-vectorOwner.length;i<vectorNuevos.length && index<=fin;i++)
			      addFilaByPropietario(vectorNuevos[i]);
		}
   }
}


function removeFilas(){
	$("#tableAccount > tbody > tr").remove();
}

function createButtons(idContainer,maximun){
	$("#"+idContainer+" > div").remove();
	for(var i=1;i<=maximun;i++){
	     var div=createPage("p-tableAccount",i,i);
	     $("#"+idContainer).append(div);
    }
}


function createPage(parentId,number,idNumber){
    var div="";
	if(parentId!=null && number!=null && idNumber!=null){
        div="<div  onclick='showPage("+number+")' class='page' id="+parentId+"-"+idNumber+">";
		div=div+"<a href='#'>"+number;
		div=div+"</a>";
		div=div+"</div>";
	}
	return div;
}


function getCurrentButtons(){
	var currentButtons=$("#p-tableAccount").children();
	return currentButtons;
}

function calculateNumButtons(vNuevo,vOld){
	var numElements;
	var numButtons=1;
	if(vNuevo!=null && vNuevo instanceof Array  && vOld!=null && vOld instanceof Array){
		  numElements=vNuevo.length+vOld.length;
		  numButtons=numElements/numFila;
		  var enteroNumButtons=Math.floor(numButtons);
		  var decimales=numButtons-enteroNumButtons;
		  if(decimales>0)
			   numButtons=enteroNumButtons+1;
	}
	numPages=numButtons;
	return numButtons;
}


function setTitle(title){
	$("#exampleModalLabel").text(title);
}


function inicializarPanel(){
	$("#DNIPanel").val("");
	$("#firstNamePanel").val("");
	$("#secondNamePanel").val("");
	$("#thirdNamePanel").val("");
	$("#streetPanel").val("");
	$("#houseNumberPanel").val("");
	$("#exampleModal > p.errorPanel").remove();
	previousValues=new Array();
}


function setAddPropietario(){
	$("#operationPanel").unbind('click');
	$("#operationPanel").click(addPropietario);
}


function addPropietario(){
	var valores=extraerValores();
	var errores=checkErrores(valores);
	if(existErrores(errores)){
		assignErrores(errores);
	}else{
		addOwnerToVector(valores);
		addFila(valores);
	}
	$("#exampleModal").modal('hide');
}


function existErrores(errores){
	var encontrado = false;
	for(var i=0;i<errores.length && encontrado==false;i++){
		if(errores[i][0]!=undefined || errores[i][1]!= ""){
			encontrado = true;
		}
	}
	return encontrado;
}


function assignErrores(errores){
	if(errores!=null && errores.length>0){
		var idDiv=$(errores[0][0]).parent().parent();
		if(idDiv!=null){
			$("#"+idDiv).append(errores[0][1]);
		}
	}
}

function checkErrores(valores){
	var errores= new Array();
	if(valores!=null && valores.length>0){
		if(checkValores()){
			for(var i=0;i<valores.length;i++){
				if(valores[i][0]=="DNI"){
					   var error=checkDNI(valores[i][1]);
					   if(error!="")
					     errores.push(error);
				}
				
				if(valores[i][0]=="firstName"){
					var error=checkFirstName(valores[i][1]);
					if(error!="")
					  errores.push(error);
				}
				
				if(valores[i][0]=="secondName"){
					var error=checkSecondName(valores[i][1]);
					if(error!="")
				       errores.push(error);
				}
				
				if(valores[i][0]=="thirdName"){
					var error=checkThirdName(valores[i][1]);
					if(error!="")
						errores.push(error);
				}
				
				if(valores[i][0]=="streetPanel"){
						var error=checkStreet(valores[i][1]);
						if(error!="")
							errores.push(error);
					
				}
				
				if(valores[i][0]=="houseNumberPanel"){
					   var error=checkHouseNumber(valores[i][1]);
					   if(error!="")
						   errores.push(error);
				}
				
			}
		}
	}
	return errores;
}


function checkDNI(dni){
	var error="";
	if(dni!=null && dni!=""){
		if(dni.length>7 && dni.length<11){
		  error=dni;
		}
	}
	return error;
}


function checkFirstName(firstName){
	var error="";
	if(firstName=="")
		error="El error no puede ser vacio";
	return error;
}


function checkSecondName(secondName){
	var error="";
	if(secondName=="")
		error="El primer apellido es obligatorio";
	return error;
}



function checkThirdName(thirdName){
	var error="";
	if(thirdName=="")
		error="El segundo apellido es obligatorio";
	//chequeo de valores numericos.
	return error;
}

function checkStreet(street){
	var error="";
	if(street=="")
		error="La dirección es obligatoria";
	return error;
}

function checkHouseNumber(houseNumber){
	var error="";
	if(houseNumber=="")
	    error="El número de vivienda es obligatorio";
	return error;
}


function checkValores(){
	return true;
}

function addFila(valores){
	
	var fila="";
	if(numFila==0 && redimensionar==true){
		redimensionar=false;
		calculaNumFilas("containerTabla");
	}
	
	if(valores!=null && valores.length>0){
	    fila="<tr id='"+prefixNuevo+idNuevo+"'>";
	    idNuevo++;
		fila=fila+"<td id='"+prefixNuevo+idNuevo+"'>";
		idNuevo++;
		fila=fila+"<a id='"+prefixNuevo+idNuevo+"' href='#' onclick='mostrarPanel(this.id)'>"+valores[0][1]+"</a></td>";
		idNuevo++;
		fila=fila+"<td  id='"+prefixNuevo+idNuevo+"'>";
		idNuevo++;
		fila=fila+"<a id='"+prefixNuevo+idNuevo+"'href='#' onclick='mostrarPanel(this.id)'>"+valores[1][1]+"</a></td>";
		idNuevo++;
		fila=fila+"<td  id='"+prefixNuevo+idNuevo+"'>";
		idNuevo++;
		fila=fila+"<a  id='"+prefixNuevo+idNuevo+"' href='#' onclick='mostrarPanel(this.id)'>"+valores[2][1]+"</a></td>";	
		idNuevo++;
		fila=fila+"<td id='"+prefixNuevo+idNuevo+"'>";
		idNuevo++;
		fila=fila+"<a  id='"+prefixNuevo+idNuevo+"'href='#' onclick='mostrarPanel(this.id)'>"+valores[3][1]+"</a></td>";
		idNuevo++;
		fila=fila+"<td id='"+prefixNuevo+idNuevo+"'>";
		idNuevo++;
		fila=fila+"<a id='"+prefixNuevo+idNuevo+"' href='#' onclick='mostrarPanel(this.id)'>"+valores[4][1]+"</a></td>";
		idNuevo++;
		fila=fila+"<td id='"+prefixNuevo+idNuevo+"'>";
		idNuevo++;
		fila=fila+"<a id='"+prefixNuevo+idNuevo+"' href='#' onclick='mostrarPanel(this.id)'>"+valores[5][1]+"</a></td>";
		idNuevo++;
	}
	

	if($("#tableAccount > tbody > tr").length<numFila)
		$("#tableAccount").append(fila);
	else
		calcularPaginacionInic();
}



function addFilaByPropietario(propietario){
	var fila="";
	if(propietario!=null){
		fila="<tr id='"+propietario.idBd+"'>";
	    idNuevo++;
		fila=fila+"<td id='"+propietario.idBd+idNuevo+"'>";
		idNuevo++;
		fila=fila+"<a id='"+propietario.idBd+idNuevo+"' href='#' onclick='mostrarPanel(this.id)'>"+propietario.DNI+"</a></td>";
		idNuevo++;
		fila=fila+"<td  id='"+propietario.idBd+idNuevo+"'>";
		idNuevo++;
		fila=fila+"<a id='"+propietario.idBd+idNuevo+"'href='#' onclick='mostrarPanel(this.id)'>"+propietario.firstName+"</a></td>";
		idNuevo++;
		fila=fila+"<td  id='"+propietario.idBd+idNuevo+"'>";
		idNuevo++;
		fila=fila+"<a  id='"+propietario.idBd+idNuevo+"' href='#' onclick='mostrarPanel(this.id)'>"+propietario.secondName+"</a></td>";	
		idNuevo++;
		fila=fila+"<td id='"+propietario.idBd+idNuevo+"'>";
		idNuevo++;
		fila=fila+"<a  id='"+propietario.idBd+idNuevo+"'href='#' onclick='mostrarPanel(this.id)'>"+propietario.thirdName+"</a></td>";
		idNuevo++;
		fila=fila+"<td id='"+propietario.idBd+idNuevo+"'>";
		idNuevo++;
		fila=fila+"<a id='"+propietario.idBd+idNuevo+"' href='#' onclick='mostrarPanel(this.id)'>"+propietario.street+"</a></td>";
		idNuevo++;
		fila=fila+"<td id='"+propietario.idBd+idNuevo+"'>";
		idNuevo++;
		fila=fila+"<a id='"+propietario.idBd+idNuevo+"' href='#' onclick='mostrarPanel(this.id)'>"+propietario.houseNumber+"</a></td>";
		idNuevo++;
	}
	
	if($("#tableAccount > tbody > tr").length<numFila)
		$("#tableAccount").append(fila);
	else
		calcularPaginacionInic();
	
	return fila;
}

function setUpdatePropietario(){
	$("#operationPanel").unbind();
	$("#operationPanel").click(updatePropietarioPanel);
}


function updatePropietarioPanel(){
	var valores=extraerValores();
	var modificaciones=checkDiferencias(valores);
	if(modificaciones!=undefined && modificaciones.length>0){
			updateGraphic(modificaciones);
			updateModel(currentPropietario.idBd,modificaciones);
	}
	$("#exampleModal").modal('hide');
}

function updateModel(idPropietario,modificaciones){
	
	if(idPropietario!=null &&  modificaciones!=null && modificaciones.length>0){
		var token=idPropietario.split("-");
		if(token[0]!=null && token[0]=="N"){
			for(var i=0;i<vectorNuevos.length;i++){
				if(vectorNuevos[i].idBd==idPropietario){
					updatePropietarioByVector(vectorNuevos[i],modificaciones);
				}
			}
		}else{
			for(var i=0;i<vectorNuevos.length;i++){
				if(vectorNuevos[i].idBd==idPropietario){
					updatePropietarioByVector(vectorNuevos[i],modificaciones);
				}
			}
		}
	}
}

function updatePropietarioByVector(propietario,valores){
	if(propietario!=null && valores!=null && valores.length>0){
		for(var i=0;i<valores.length;i++){
			if(valores[i][0]=="DNI"){
				propietario.DNI=valores[i][1];
			}
			
			if(valores[i][0]=="firstName"){
				propietario.firstName=valores[i][1];
			}
			
			if(valores[i][0]=="secondName"){
				propietario.secondName=valores[i][1];
			}
			
			if(valores[i][0]=="thirdName"){
				propietario.thirdName=valores[i][1];
			}
			
			if(valores[i][0]=="street"){
				propietario.street=valores[i][1];
			}
			
			if(valores[i][0]=="houseNumber"){
				propietario.houseNumber=valoes[i][1];
			}
		}
	}
}

function updateGraphic(modificaciones){
	if(modificaciones!=null && modificaciones.length>0){
		if(checkModificaciones()){
			var children=$("#"+currentPropietario.idBd+" > td > a");
			for(var i=0;i<modificaciones.length;i++){
			    updateFieldTable(children,modificaciones[i][0],modificaciones[i][1]);
			}
	    }
	}
}


function updateFieldTable(children,fieldName,fieldValue){
	if(children!=null && children.length>0 && fieldName!=null && fieldName!=""
		&& fieldValue!=null && fieldValue!=""){
			if(fieldName=="DNI")
				$(children[0]).text(fieldValue);
			
			if(fieldName=="firstName")
				$(children[1]).text(fieldValue);
			
			if(fieldName=="secondName")
				$(children[2]).text(fieldValue);
			
			if(fieldName=="thirdName")
				$(children[3]).text(fieldValue);
			
			if(fieldName=="street")
				$(children[4]).text(fieldValue);
			
			if(fieldName=="houseNumber")
				$(children[5]).text(fieldValue);
				
	}
}


function checkModificaciones(){
	return true;
}


function checkDiferencias(valores){
	var diferencias=new Array();

	if(currentPropietario!=null && valores!=null && valores.length>0){
		for(var i=0;i<valores.length;i++){	
			if(valores[i][0]=="DNI"){
			    if(valores[i][1]!=currentPropietario.dni){
			    	var valor=new Array(2);
			    	valor[0]="DNI";
			    	valor[1]=valores[i][1];
			    	diferencias.push(valor);
			    }
			}
			
			if(valores[i][0]=="firstName"){
				if(valores[i][1]!=currentPropietario.firstName){
					var valor=new Array(2);
					valor[0]="firstName";
					valor[1]=valores[i][1];
					diferencias.push(valor);
				}
			}
			
			if(valores[i][0]=="secondName"){
				if(valores[i][1]!=currentPropietario.secondName){
					var valor=new Array(2);
					valor[0]="secondName";
					valor[1]=valores[i][1];
					diferencias.push(valor);
				}
			}
			
			if(valores[i][0]=="thirdName"){
				if(valores[i][1]!=currentPropietario.thirdName){
					var valor= new Array(2);
					valor[0]="thirdName";
					valor[1]=valores[i][1];
					diferencias.push(valor);
				}
			}
			
			if(valores[i][0]=="street"){
				if(valores[i][1]!=currentPropietario.street){
					var valor= new Array(2);
					valor[0]="street";
					valor[1]=valores[i][1];
					diferencias.push(valor);
				}
			}
			
			if(valores[i][0]=="houseNumber"){
				if(valores[i][1]!=currentPropietario.houseNumber){
					var valor= new Array(2);
					valor[0]="houseNumber";
					valor[1]=valores[i][1];
					diferencias.push(valor);
				}
			}
		}
	}
	return diferencias;
}

function extraerValores(){
	var valores=new Array();
	valores[0]=new Array(2);
	valores[0][0]="DNI";
	valores[0][1]=$("#DNIPanel").val();
	valores[1]= new Array(2);
	valores[1][0]="firstName";
	valores[1][1]=$("#firstNamePanel").val();
	valores[2]= new Array(2);
	valores[2][0]="secondName";
	valores[2][1]=$("#secondNamePanel").val();
	valores[3]= new Array(2);
	valores[3][0]="thirdName";
	valores[3][1]=$("#thirdNamePanel").val();
	valores[4]= new Array(2);
	valores[4][0]="street";
	valores[4][1]=$("#streetPanel").val();
	valores[5]= new Array(2);
	valores[5][0]="houseNumberPanel";
	valores[5][1]=$("#houseNumberPanel").val();
	return valores;
}

function addOwnerToVector(valores){
	
	if(valores!=null && valores.length>0){
		var propietario=new Object();
		for(var i=0;i<valores.length;i++){
				if(valores[i][0]=="firstName"){
					if(valores[i][1]!=null && valores[i][1]!=""){
						propietario.firstName=valores[i][1];
					}
				}
				
				if(valores[i][0]=="DNI"){
					if(valores[i][1]!=null && valores[i][1]!=""){
						propietario.DNI=valores[i][1];
					}
				}
				
				if(valores[i][0]=="secondName"){
					if(valores[i][1]!=null && valores[i][1]!=""){
						propietario.secondName=valores[i][1];
					}
				}
				
				if(valores[i][0]=="thirdName"){
					if(valores[i][1]!=null && valores[i][1]!=""){
						propietario.thirdName=valores[i][1];
					}
				}
				
				if(valores[i][0]=="street"){
					if(valores[i][1]!=null && valores[i][1]!=""){
						propietario.street=valores[i][1];
					}
				}
				
				if(valores[i][0]=="houseNumber"){
				  if(valores[i][1]!=null && valores[i][1]!=""){
						propietario.houseNumber=valores[i][1];
				  }
			}
		}
		propietario.idBd=prefixNuevo+idNuevo;
		vectorNuevos.push(propietario);
	}
}
	
function cerrarPanel(){
	$("#exampleModal").modal('hide');
}

function mostrarPanelPropietario(){
	setTitle("Propietario");
	inicializarPanel();
	setAddPropietario();
	$("#exampleModal").modal('show');
}


function mostrarPanel(id){
	setTitle("Propietario");
	inicializarPanel();
	setUpdatePropietario();
	var idPropietario = getIdPropietario(id);
	currentPropietario = javaScript_getPropietarioById(idPropietario);
	cargarValoresPanel(currentPropietario);
	$("#exampleModal").modal('show');
}



function cargarValoresPanel(propietario){
	$("#DNIPanel").val(propietario.dni);
	$("#firstNamePanel").val(propietario.firstName);
	$("#secondNamePanel").val(propietario.secondName);
	$("#thirdNamePanel").val(propietario.thirdName);
	$("#streetPanel").val(propietario.street);
	$("#houseNumberPanel").val(propietario.houseNumber);
}



function getIdPropietario(id){
	var idTr=$("#"+id).parent().parent().attr("id");
	return idTr;
}

function aumentar(){
	$("#containerTabla").attr("class","expandirT");
	reajustar("containerTabla");
}

function reducir(){
	$("#containerTabla").attr("class","expandir90");
	reajustar("containerTabla");
}

function cargarValores(propietario){
	if(propietario!=null){
		$("#DNI").val(propietario.idBd);
		$("#firstNamePanel").val(propietario.firstName);
		$("#secondNamePanel").val(propietario.secondName);
		$("#thirdNamePanel").val(propietario.thirdName);
		$("#streetPanel").val(propietario.street);
		$("#houseNumberPanel").val(propietario.houseNumber);
	}
}
