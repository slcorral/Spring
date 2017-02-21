

var idAux=0;
var numFileToPage=0;
var currentIndex=0;
var numPaginas=0;
//variable que contiene el identificador de una celda cualquiera;
var idCeldaResponsiva=0;


$(document).ready(function(){
	
	$("#accordion div.panel-body").parent().removeClass();
	$("#accordion div.panel-body").parent().addClass(
			"panel-collapse collapse");
	
	numFileToPage=addFilaResponsive();
	showRow(numFileToPage,0,7);
	currentIndex=numFileToPage-1;
	numPaginas=vectorMovimientos.length/numFileToPage;
	var decimal=numPaginas-Math.floor(numPaginas);
	numElementLastPag=Math.floor((100*decimal)/numFileToPage);
	numElementLastPag--;
	
});


function showRow(numFilasShow,inic,fin){
	if(numFilasShow!=null && numFilasShow>0 && inic>=0 && fin>=0){
		var count=0;
	     for(var i=0;i<vectorMovimientos.length;i++){
	    	 if(i>=inic && i<=fin){
	    		 if(count<numFilasShow){
	    			 $("#"+vectorMovimientos[i].idBd).css("");
	    			 count++;
	    		 }
	    	 }
	    	 else
	    		$("#"+vectorMovimientos[i].idBd).attr("class","noVisible");
	     }
	}
}


function addFilaResponsive(){
		var arrayCeldas=$("#bodyMovimiento > tr > td");
		var alto=document.getElementById($(arrayCeldas[0]).attr("id")).offsetHeight;
		var numero=Math.floor($("#fila80").height()/alto);
		numero--;
		return numero;
}


function extraerValores(){
	
	var entidadOrigen = $("#entidadOrigen option:selected").val();
	var usuarioOrigen = $("#usuarioOrigen").text();
	var entidadDestino = $("#entidadDestino option:selected").val();
	var usuarioDestino = $("#usuarioDestino").text();
	
	//var camposBusqueda=newcamposBusqueda.entida Object();
	dOrigen=entidadOrigen;
	camposBusqueda.usuarioOrigen=usuarioOrigen;
	camposBusqueda.entidadDestino=entidadDestino;
	camposBusqueda.usuarioDestino=usuarioDestino;
	camposBusqueda.importe=2.0;
	camposBusqueda.state="OK";
	
	return camposBusqueda;
}


function loadMovimientos(movimientos){
	if(movimientos!=null && movimientos instanceof Array){
		if(movimientos.length>0){
		   $("#tableMovimiento > tbody > tr").remove();
		   for(var i=0;i<movimientos.length;i++){
			   addMovimientoTable(movimientos[i]);
		   }
		}
	}
}


function checkArrayMovimientos(movimientos){
	var resultado=true;
	if(movimientos!=null && movimientos instanceof Array){
		if(movimientos.length>0){
			for(var i=0;i<movimientos.length && resultado==true;i++){
				if(movimientos[i]!=null){
					//falta sacar las estructuras de las propiedades
					var movimiento=movimientos[i];
					if(movimiento.idBd!=null && checkNumeric(movimiento.idBd)){
						if(movimiento.sourceUser!=null && checkString(movimiento.sourceUser)){
							  if(movimiento.sourceBank!=null && checkString(movimiento.sourceBank)){
								  if(movimiento.targetUser!=null && checkString(movimiento.targetUser)){
									  if(movimiento.targetBank==null && checkString(movimiento.targetBank)){
										  resultado=true;
									  }
									  else
										 resultado=false;
								  }else
									 resultado=false;  
							  }else
								  resultado=false;
						}else
							resultado=false;
					}else
						resultado=false;
				}else
				     resultado=false;
			}
		}
		
	}
	
	return resultado;
}


function addMovimientoTable(movimiento){
	if(movimiento!=null){
	 if(checkVariablesMovimiento(movimiento)){
	  idAux=movimiento.idBd;
	  var fila="<tr id="+movimiento.idBd+">";
	  idAux++;
	  fila=fila+"<td id='"+movimiento.idBd+"-"+idAux+"'>";
	  fila=fila+movimiento.sourceAccount;
	  fila=fila+"</td>";
	  idAux++;
	  fila=fila+"<td id='"+movimiento.idBd+"-"+idAux+"'>";
	  fila=fila+movimiento.destinationAccount;
	  fila=fila+"</td>";
	  idAux++;
	  fila=fila+"<td id='"+movimiento.idBd+"-"+idAux+"'>";
	  idCeldaResponsiva=idAux;
	  fila=fila+movimiento.sourceBank;
	  fila=fila+"</td>";
	  idAux++;
	  fila=fila+"<td id='"+movimiento.idBd+"-"+idAux+"'>";
	  fila=fila+movimiento.sourceUser;
	  fila=fila+"</td>";
	  idAux++;
	  fila=fila+"<td id='"+movimiento.idBd+"-"+idAux+"'>";
	  fila=fila+movimiento.targetBank;
	  fila=fila+"</td>";
	  idAux++;
	  fila=fila+"<td id='"+movimiento.idBd+"-"+idAux+"'>";
	  fila=fila+movimiento.targetUser;
	  fila=fila+"</td>";
	  idAux++;
	  fila=fila+"<td id='"+movimiento.idBd+"-"+idAux+"'>";
	  fila=fila+movimiento.estado;
	  fila=fila+"</td>";
	  fila=fila+"</tr>";
	  idAux++;
	  $("#tableMovimiento").append(fila);
	 } 
	  
	}
	
}

function showNextPage(){
	
	if(currentIndex!=null  && numFileToPage!=null && currentIndex<vectorMovimientos.length){
		if(checkNumeric(currentIndex) && checkNumeric(numFileToPage)){
			var count=0;
			var auxMovimientos=new Array();
			
			for(var i=currentIndex+1;i<vectorMovimientos.length && count<numFileToPage;i++){
				auxMovimientos.push(vectorMovimientos[i]);
				count++;
				currentIndex++;
			}
			
			if(auxMovimientos.length>0)
			  loadMovimientos(auxMovimientos);
			
			if(currentIndex==vectorMovimientos.length)
			   disabledShowNextPage();
			else {
			  if(activateNextPage())
					enabledShowNextPage();
			  else
				  disabledShowNextPage();
			}
			
		}
	}
	
}


function enabledShowNextPage(){
	$("#btnNext").attr("class","btnDerecho btnEnabled");
}



function activateNextPage(){
	if($("#btnNext").attr("class")=="btnEnabled")
		return false;
	else
		return true;
}
	
function disabledShowNextPage(){
	$("#btnNext").attr("class","btnDerecho btnDisabled");
}

function disabledNext(){
	$("#btnNext").attr("class","btnDerecho btnDisabled");
}


function showPreviousPage(){
	if(currentIndex!=null  && numFileToPage!=null && currentIndex>0){
		if(checkNumeric(currentIndex) && checkNumeric(numFileToPage)){
			var count=0;
			var auxMovimientos=new Array();
			
			//Calculamos si no es exacto en el numero de p�gina
		    if(currentIndex+1==vectorMovimientos.length)
				currentIndex=currentIndex-(numElementLastPag-1);
		    else{
		    	//Calculamos si no estamos al final del numero de p�gina
		    	if(currentIndex+1!=numFileToPage)
		    	   currentIndex=currentIndex-numFileToPage;
		    }
		    
			for(var i=currentIndex;i>=0 && count<numFileToPage;i--){
				auxMovimientos.unshift(vectorMovimientos[i]);
				count++;
				currentIndex--;
			}
			//reverse
			
			loadMovimientos(auxMovimientos);
			if(currentIndex==0)
			    disabledPreviousPage();
			else
				enabledPreviousPage();
		}
	}
	
}


function enabledPreviousPage(){
	$("#btnPrevious").attr("class","btnIzquierdo btnEnabled");
}

function disabledPreviousPage(){
	 $("#btnPrevious").attr("class","btnIzquierdo btnDisabled");
}

function checkVariablesMovimiento(movimiento){
	return true;
}

function checkNumeric(){
	return true;
}

function checkString(variable){
	return true;
}

function checkAjaxStructure(structure){
	
	var resultado=false;
	if(structure.hasOwnProperty("state") && 
	   structure.hasOwnProperty("messageOk") && structure.hasOwnProperty("errorList")
	   && structure.hasOwnProperty("object")){
		//chequeamos el formato
		if(checkFormatState(structure.state) && checkFormatMessageOk(structure.messageOk) && checkErrorList(structure.errorList) && checkListObject())
			resultado=true;
	}
    //falta comprobar que las listas se construyan como objetos.
	return resultado;
}


function checkListObject(){
	return true;
}

function checkErrorList(errorList){
	var resultado=true;
	if(errorList!=null && errorList instanceof Array && errorList.length>0){
		for(var i=0;i<errorList.length && resultado==true ;i++){
			if(errorList[i]!=null && errorList[i] instanceof Array){
				if(errorList[i].length==2){
					for(var j=0;j<errorList[i].length && resultado==true;j++){
						if(errorList[i][j]!=null && checkString(errorList[i][j]))
							resultado=true;
						else
							resultado=false;
					}
				}else
					resultado=false;
			}else
			    resultado=false;
		}
	}
	return resultado;
}

function checkFormatMessageOk(message){
	var resultado=false;
	if(message!=null )
		resultado=false;
	return resultado;
}

function checkFormatState(state){
	var resultado=false;
	if(state!=null && checkString(state)){
		//chequeamos posible formats
		if(state=="OK" || state=="KO")
			resultado=true;
		else
			resultado=false;
	}
	return resultado;
}

function buscar(){
	
	var camposBusqueda=extraerValores();
	
	$.ajax({
		type : "POST",
		cache : false,
		url : "movimientos/buscar",
		dataType : "json",
		data : JSON.stringify(camposBusqueda),
		contentType : "application/json",
		mimeType : "application/json",
		success : function(d) {
				if(d.state=="KO")
				   alert("Hemos recibido un error");
				
				if(d.state=="OK"){
				   alert("Estado OK");
				   vectorMovimientos=d.object;
				   loadMovimientos(vectorMovimientos);
				   showRow(numFileToPage,0,7);
				   currentIndex=numFileToPage-1;
			
				}
		},
		error : function(data, status, er) {
			console.error("example");
			$("#texto").text(er);
		}

	});
		
}