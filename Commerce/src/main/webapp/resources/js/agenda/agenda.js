var vectorNuevos;
var vectorEventos;
var numFilas = 0;
// Variables para el componente menu.
var currentFase = 1;
var indexFases;
var vBusquedaAsistentes;
var vAsistentesSeleccionados;
var vBusquedaSalas;
var prefixNuevo = "N";
var currentSala;

function prepareVector() {
	vectorNuevos = new Array();
	vectorEventos = new Array();
	indexFases = new Array();
	busquedaAsistentes = new Array();
	vAsistentesSeleccionados = new Array();
}

$(document).ready(
		function() {

			$("#accordion div.panel-body").parent().removeClass();
			$("#accordion div.panel-body").parent().addClass(
					"panel-colontainerlapse collapse");

			prepareVector();
			var vectorFases = new Array();
			vectorFases[0] = new Array();
			vectorFases[0][0] = 1;
			vectorFases[0][1] = "Horario";
			vectorFases[1] = new Array();
			vectorFases[1][0] = 2;
			vectorFases[1][1] = "asistentes";
			vectorFases[2] = new Array();
			vectorFases[2][0] = 3;
			vectorFases[2][1] = "sala";
			prepareFase(vectorFases);

			for (var i = 1; i < 41; i++) {
				var evento = new Object();
				evento.hInic = i;
				evento.nombre = "ejemplo";
				evento.descripcion = "descripcion";
				vectorNuevos.push(evento);
			}

			// reajustar("dia","containerFranjas",vectorNuevos,vectorEventos);
			// $('#carrousel-salas').carousel();
			// $('.carousel').carousel();

			// $("#dph-inic").datepicker();

		});

function ajustarParrafo(idBloque, elemento) {

	if (idBloque != null && idBloque != "" && elemento != null
			&& elemento != "") {

		var childrenP = $("#" + idBloque + " " + elemento);
		var maxLength = 0;
		childrenP.each(function(index) {
			var width = $(this).outerWidth(true);
			if (maxLength < width)
				maxLength = width;
		});

		childrenP
				.each(function(index) {
					var width = document.getElementById($(this).attr("id")).offsetWidth;
					var margin = maxLength - width;
					$(this).css({
						"margin-right" : margin
					});
					margin = 0;
				});
	}
}

function altaEvento(id) {
	ocultar("dia");
	$("#altaEvento").attr("class", "expandir");
}

// Funciones addEventos
function ocultar(idContainer) {
	$("#" + idContainer).attr("class", "dia containerFade");
}

// el primer elemento contiene el indice de la fase,
// el segundo valor contiene el identificador de la capa que contiene la fase.
function prepareFase(valores) {
	for (var i = 0; i < valores.length; i++) {
		indexFases[i] = new Array();
		indexFases[i][0] = valores[i][0];
		indexFases[i][1] = valores[i][1];
	}
}

function getIdByIndexPhase(indexFase) {
	if (indexFase != null && indexFase > 0) {
		for (var i = 0; i < indexFases.length; i++) {
			if (indexFases[i][0] == indexFase) {
				return indexFases[i][1];
			}
		}
	}
}

function checkValores(valores) {
	var error = false;
	if (valores != null && valores instanceof Array) {
		for (var i = 0; i < valores.length && error == false; i++) {
			if (valores[0] == null || valores[0] >= 0)
				error = true;
			if (error == false) {
				if (valores[1] == null || valores[1] == "") {
					error = true;
				}
			}
		}
	} else
		error = true;

	return error;
}

function nextFase() {
	if (currentFase + 1 <= indexFases.length) {
		switchPhase(currentFase, currentFase + 1);
		currentFase++;
	}
}

// Función que devuelve
function volverHorario() {
	inicializarForm();
	$("#altaEvento").attr("class", "expandir containerFade");
	$("#dia").attr("class", "dia");
}

function volverSalas() {
	$("#s-3").carousel('next');
	stateButton(false, "seleccionarSala");
	stateButton(true, "buscarSala");
	currentSala = null;
}

function stateButton(activate, idButton) {
	if (idButton != null && idButton != "") {
		if (activate == true)
			$("#" + idButton).attr("class", "btn btn-primary");
		else
			$("#" + idButton).attr("class", "btn btn-primary fade");
	}
}

function inicializarForm() {
	$("#h-hInic").text("");
	$("#h-hFin").text("");
	$("#a-1").text("");
	$("#s-1").text("");
	$("#s-2").text("");
}

function previousFase() {
	if (currentFase - 1 >= 1) {
		switchPhase(currentFase, currentFase - 1);
		currentFase--;
	}
}

function switchPhase(currentIndex, nextIndex) {
	var currentId = getIdByIndexPhase(currentIndex);
	if (currentId != null && currentId != "")
		$("#" + currentId).attr("class", "containerMenu containerFade");
	var nextId = getIdByIndexPhase(nextIndex);
	if (nextId != null && nextId != "")
		$("#" + nextId).attr("class", "containerMenu");

	if (nextId == "sala") {
		ajustarParrafo("a", "label");
		ajustarParrafo("lista1", "label");
		ajustarParrafo("lista2", "label");
		ajustarParrafo("lista3", "label");
		ajustarParrafo("lista4", "label");
	}

}

function mostrarEvento(id) {

}

function calculaNumFilas(idContainerTabla) {
	if (idContainerTabla != null && idContainerTabla != "") {
		var alto = 58;
		var numero = Math.floor($("#" + idContainerTabla).height() / alto);
		numFila = numero - 1;
	}
}

function calcularPaginacionInic(idContainerTabla, vectorNuevos, vectorEventos) {
	calculaNumFilas(idContainerTabla);
	/**
	 * var numButtons=calculateNumButtons(vectorNuevos,vectorEventos); var
	 * width=document.getElementById("p-tableAccount").offsetWidth; var
	 * widthButton=21; if(widthButton>0 && width>0){ var
	 * pages=Math.floor(width/widthButton); var maximun=0; if(numButtons>pages)
	 * maximun=pages; else maximun=numButtons;
	 * createButtons("p-tableAccount",maximun); }
	 */
}

function reajustar(idContainerHorario, idHorario, vNuevos, vOld) {
	calcularPaginacionInic(idContainerHorario, vNuevos, vOld);
	rellenarHorario(idHorario, vNuevos, vOld);
}

function rellenarHorario(idContainer, vNuevo, vOld) {
	if (idContainer != null && idContainer != "") {
		$("#" + idContainer + " > div ").remove();
		if (numFila != null) {
			for (var i = 0; i < vOld.length && i < numFila; i++)
				addFilaByFranja(idContainer, vOld[i]);

			for (var i = 0; i < vNuevo.length && i < numFila; i++)
				addFilaByFranja(idContainer, vNuevo[i]);
		}
	}
}

function addFilaByFranja(idContainer, evento) {
	if (evento != null && idContainer != null) {
		var franja = createFranja(evento);
		if ($("#" + idContainer + " > div ").length < numFila)
			$("#" + idContainer).append(franja);
		else
			calcularPaginacionInic(idContainerTabla, vectorNuevos,
					vectorEventos);
	}

}

function createFranja(evento) {
	var franja = "";
	if (evento != null) {
		var franja = "<div class='franja'>";
		franja = franja + "<div class='horario'>";
		franja = franja + "<a href='#'>" + evento.hInic + "</a>";
		franja = franja + "</div>";
		franja = franja + "<div class='evento'>";
		franja = franja + "<a href='#'>" + evento.nombre + "</a>";
		franja = franja + "<a href='#'>" + evento.descripcion + "</a>";
		franja = franja + "</div>";
		franja = franja + "</div>";
	}
	return franja;
}

// Buscador Asistentes

function extraerValoresBuscador() {
	var campoBuscador = new Object();
	campoBuscador.name = $("#s-Nombre").val();
	campoBuscador.firstName = $("#s-PrimerA").val();
	campoBuscador.idGroup = $("#s-grupo option:selected").val();
	campoBuscador.idCategory = $("#s-categoria option:selected").val();
	return campoBuscador;
}

function buscarAsistentes() {
	var campoBuscador = extraerValoresBuscador();
	$.ajax({
		type : "POST",
		cache : false,
		url : "agenda/buscarAsistente",
		dataType : "json",
		data : JSON.stringify(campoBuscador),
		contentType : "application/json",
		mimeType : "application/json",
		success : function(d) {
			if (d.state == "KO")
				alert("Hemos recibido un error");

			if (d.state == "OK") {
				if (d.object != null) {
					vBusquedaAsistentes = d.object;
					cb_rellenarAsistentes("tableAsistentesBuscados", d.object);
				}
			}

		},
		error : function(data, status, er) {
			console.error("example");
			$("#texto").text(er);
		}

	});
}

function extraerValoresSala() {

	var busquedaSala = new Object();
	busquedaSala.capacidad = $("#s-2-1-4343").val();
	busquedaSala.planta = $("#s-2-1-422").val();
	busquedaSala.monitor = $("#c-m").val();

	if ($("#c-m").val() == "on")
		busquedaSala.monitor = "true";
	else
		busquedaSala.monitor = "false";

	if ($("#c-conf").val() == "on")
		busquedaSala.conferencia = "true";
	else
		busquedaSala.conferencia = "false";

	if ($("#ch-t").val() == "on")
		busquedaSala.traductor = "true";
	else
		busquedaSala.traductor = "false";
	if ($("#t-tra").val() == "on")
		busquedaSala.traductor2 = "true";
	else
		busquedaSala.traductor2 = "false";

	return busquedaSala;

}

function buscarSala() {
	var busquedaSala = extraerValoresSala();

	$.ajax({
		type : "POST",
		cache : false,
		url : "agenda/busquedaSala",
		dataType : "json",
		data : JSON.stringify(busquedaSala),
		contentType : "application/json",
		mimeType : "application/json",
		success : function(d) {
			if (d.state == "KO")
				alert("Hemos recibido un error");

			if (d.state == "OK") {
				if (d.object != null) {
					vBusquedaSalas = d.object;
					cb_rellenarSalas("tableSalasBuscadas", vBusquedaSalas);
				}
			}

		},
		error : function(data, status, er) {
			console.error("example");
			$("#texto").text(er);
		}

	});

}

function cb_rellenarSalas(idTablaSource, vSource) {
	if (vSource != null && vSource.length > 0) {
		$("#" + idTablaSource + " tbody > tr").remove();
		for (var i = 0; i < vSource.length; i++) {
			addFilaBySala(idTablaSource, vSource[i]);
		}
	}
}

function cb_rellenarAsistentes(idTablaAsistentes, vAsistentes) {
	if (vAsistentes != null && vAsistentes.length > 0) {
		$("#" + idTablaAsistentes + " tbody > tr").remove();
		for (var i = 0; i < vAsistentes.length; i++)
			addFilaByAsistente(idTablaAsistentes, vAsistentes[i]);
	}
}

function addFilaByAsistente(idTablaAsistente, asistente) {
	var fila = crearFila(asistente);
	// control responsivo
	if (fila != null && fila != "")
		$("#" + idTablaAsistente).append(fila);
}

function addFilaBySala(idTablaSala, sala) {
	if (sala != null && idTablaSala != null) {
		var fila = crearFilaSala(sala);
		if (fila != null && fila != "" && idTablaSala != "") {
			$("#" + idTablaSala).append(fila);
		}
	}
}

function crearFilaSala(sala) {

	var fila = "";
	fila = "<tr id='" + sala.idBd + "'>";
	var idAux = sala.idBd + 1;

	fila = fila + "<td>";
	fila = fila + "<a href='#'> " + sala.numSala + "</a>";
	fila = fila + "</td>";

	fila = fila + "<td>";
	fila = fila + "<a href='#'> " + sala.nombre + "</a>";
	fila = fila + "</td>";

	fila = fila + "<td>";
	fila = fila + "<a href='#'> " + sala.capacidad + "</a>";
	fila = fila + "</td>";

	fila = fila + "<td>";
	fila = fila + "<a href='#'> " + sala.planta + "</a>";
	fila = fila + "</td>";

	fila = fila + "<td>";
	fila = fila + "<a href='#' id='" + idAux
			+ "' onclick='mostrarSala(this.id)' >  Mostrar </a>";
	fila = fila + "</td>";

	fila = fila + "</tr>";

	return fila;
}

function crearFilaWithPrefix(prefixNuevo, asistente) {
	var fila = "";
	if (prefixNuevo != null && asistente != null) {
		var index = asistente.idBd;
		fila = "<tr  id='" + prefixNuevo + "-" + index + "'>";
		index++;
		fila = fila + "<td id='" + prefixNuevo + "--" + index + "'>";
		index++;
		fila = fila + "<a  id='" + prefixNuevo + "--" + index + "' href='#'>"
				+ asistente.dni + "</a>";
		fila = fila + "</td>";
		index++;
		fila = fila + "<td id='" + prefixNuevo + "--" + index + "'>";
		index++;
		fila = fila + "<a  id='" + prefixNuevo + "--" + index + "'> "
				+ asistente.name + "</a>";
		fila = fila + "</td>";
		fila = fila + "<td id='" + prefixNuevo + "--" + index + "'>";
		index++;
		fila = fila
				+ "<a id='"
				+ prefixNuevo
				+ "--"
				+ index
				+ "' href='#' onclick='deleteRowSelected(this.id)'> eliminar </a>";
		fila = fila + "</td>";
		fila = fila + "</tr>";
	}
	return fila;
}

function crearFila(asistente) {

	var fila = "<tr  onclick='selectRow(this.id)' id='" + asistente.idBd + "'>";
	fila = fila + "<td>";
	fila = fila + "<a href='#'>" + asistente.dni + "</a>";
	fila = fila + "</td>";
	fila = fila + "<td>";
	fila = fila + "<a href='#'>" + asistente.idCategory + "</a>";
	fila = fila + "</td>";
	fila = fila + "<td>";
	fila = fila + "<a href='#'>" + asistente.idGroup + "</a>";
	fila = fila + "</td>";
	fila = fila + "<td>";
	fila = fila + "<a> " + asistente.name + "</a>";
	fila = fila + "</td>";
	fila = fila + "<td>";
	fila = fila + "<a href='#'> " + asistente.firstName + "</a>";
	fila = fila + "</td>";
	fila = fila + "<td>";
	fila = fila + "<a href='#'> " + asistente.secondName + "</a>";
	fila = fila + "</td>";
	fila = fila + "</tr>";
	return fila;

}

function selectRow(id) {
	if (id != null && id != "") {
		if ($("#" + id).attr("class") == "selected") {

			$("#" + id).attr("class", "");

			vAsistentesSeleccionados.push()

		} else {

			$("#" + id).attr("class", "selected");

		}
	}
}

function getRowSelected(idTabla) {
	var indexSelected = new Array();
	if (idTabla != null) {
		$("#" + idTabla + " > tbody > tr.selected").each(function() {
			indexSelected.push($(this).attr("id"));
		});
	}
	return indexSelected;
}

function transladarSelected() {
	var index = getRowSelected("tableAsistentesBuscados");
	var seleccionados = "";
	if (index != null && index.length > 0) {
		seleccionados = getAsistentesByArrayIndex(index);
		for (var i = 0; i < seleccionados.length; i++){
			if(!existeAsistenteSeleccionado(seleccionados[i].idBd)){
				addFilaSeleccionado(seleccionados[i]);
				vAsistentesSeleccionados.push(seleccionados[i]);
			}
		}
	}
}

function addFilaSeleccionado(asistente) {
	if (asistente != null) {
	    var fila = crearFilaWithPrefix(prefixNuevo, asistente);
		$("#tableSelectedAsistentes").append(fila);
	}
}

function existeAsistenteSeleccionado(idBd) {
	var encontrado = false;
	if (idBd != null && idBd != "") {
		var filas = $("#tableSelectedAsistentes > tbody > tr");
		if (filas != null) {
			for (var i = 0; i < filas.length && encontrado == false; i++) {
				var id = $(filas[i]).attr("id");
				var token = id.split("-");
				if (token[1] == idBd)
					encontrado = true;
			}
		}
	}
	return encontrado;
}

function deleteRowSelected(idBd) {
	var id = $("#" + idBd).parent().parent().attr("id");
	if (idBd != null && idBd != "" && id != null && id != "")
		$("#" + id).remove();
}

function getAsistentesByArrayIndex(index) {
	var asistentes = new Array();
	if (index != null && index.length > 0) {
		for (var i = 0; i < index.length; i++) {
			for (var j = 0; j < vBusquedaAsistentes.length; j++) {
				if (vBusquedaAsistentes[j].idBd == index[i]) {
					asistentes.push(vBusquedaAsistentes[j]);
				}
			}
		}
	}
	return asistentes;
}

function getAsistenteByIndex(index) {
	var asistente = new Array();
	if (index != null && index != "") {
		for (var i = 0; i < vBusquedaAsistentes.length; i++) {
			if (vBusquedaAsistentes[i].idBd == index) {
				asistentes.push(vBusquedaAsistentes[i]);
			}
		}
	}
	return asistente;
}

function activaCarrousel() {
	$("#s-3").carousel('prev');
}

function mostrarSala(id) {

	if (id != null && id != "") {
		var idSala = $("#" + id).parent().parent().attr("id");
		var sala = getSalaById(idSala);
		currentSala = sala;
		if (sala != null) {
			loadSala(sala);
			showSala();
			stateButton(false, "buscarSala");
			stateButton(true, "seleccionarSala");
		}
	} else
		alert("No existe sala asociada");

}

function seleccionarSala() {
	if (currentSala != null) {
		$("#s-seleccionada").val(currentSala.nombre);
	}
}

function loadSala(sala) {
	if (sala != null) {
		$("#sa-nombre").val(sala.nombre);
		$("#s-capacidad").val(sala.capacidad);
		$("#s-planta").val(sala.planta);
		$("#s-monitor").val(sala.monitor);
		$("#s-conferencia").val(sala.monitor);
		$("#s-traductor").val(sala.traductor);
	}
}

function showSala() {
	$("#s-3").carousel('prev');
	$("#s-3").on('slid.bs.carousel', function() {
		ajustarParrafo("colum-Sala1", "label");
		ajustarParrafo("colum-Sala2", "label");
	});
}

function getSalaById(idSala) {
	var sala = null;
	if (idSala != null && idSala != "") {
		var encontrado = false;
		for (var i = 0; i < vBusquedaSalas.length && encontrado == false; i++) {
			if (vBusquedaSalas[i].idBd == idSala) {
				encontrado = true;
				sala = vBusquedaSalas[i];
			}
		}
	}
	return sala;

}

function guardarFase() {
	alert("Guardar Fase");

	// extraemos datosPrimeraFase
	var hInic = $("#dph-inic").val();
	var hFin = $("#dph-fin").val();

	alert("Hora Inic " + hInic);
	alert("Hora Fin " + hFin);

	// Buscamos si tenemos elementos seleccionadas.
	var idFilas = $("#tableSelectedAsistentes tbdoy tr").attr("id");

	alert("Numero de id " + idFilas);

	if (idFilas.length == 0)
		errorFases("asistentes", "Debe de seleccionar al menos un asistente");

	if (idFilas.length > 0){
		SeleccionadosgetAsistentesByArrayIndex(idFilas);
	}

}
