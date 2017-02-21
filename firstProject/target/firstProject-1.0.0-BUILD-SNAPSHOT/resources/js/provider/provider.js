//Glogal Functions
var sourceVector;
var idPaginator = "#paginacion";
var previousNameCuenta = "";
var previousEntidad = "";
var previousSaldoCuenta = "";
var idAccount = "";
var modeloCuentas;
var id = 100;
var idRow = 0;
var tokenNewElement="N";
var prefixNew = tokenNewElement+"-";
var idNuevo = 0;
var deletedAccount;
var newAccount;
var modifiedAccount;
var panelAjustadoP=false;
var panelAjustadoB=false;
var panelAjustadoPe=false;
var altoFila=0;
var numFila=0;
var numPages=0;

var vectorProveedor = [{
	idProvider : 22,
	providerName : "Hola Mundo",
	providerStreet : "Calle numeo 1",
	codigoPedido : "00001",
	importePedido : 11111,
	fechaInicio : "01/01/2015",
	fechaEntrega : "01/02/2015",
	responsableEntrega : "Empresa A",
	descripcion : "Descripcion de ejemplo"
} ];

var vectorMovimiento = {
	sourceUser : "111",
	sourceBank : "22",
	targetUser : "33",
	targetBank : "444"
};

// Variables para el modal panel.
var cuenta = "Account";
var saldo = "Balance";
var entidad = "entidades";



function savePreviousValues(valores) {
	previousNameCuenta = valores[0];
	previousSaldoCuenta = valores[1];
	previousEntidad = valores[2];
}

// Método que controla el borrado grafico y desactivado de la paginación.

function savedDeletedAccount(paramIdRow) {
	var success = false;
	if (paramIdRow != null) {
		if (checkNewAccount(paramIdRow)==false) {
			removeUpdateRow(paramIdRow);
			addDeletedRow(paramIdRow);
			success = true;
		} else{
			success = true;
			deleteRowNewAccount(paramIdRow);
		}

	}
	return success;
}

function deleteRowNewAccount(paramIdRow) {

	var foundAccount = false;
	if (paramIdRow != null) {
		for (var i = 0; i < newAccount.length && foundAccount == false; i++) {
			if (newAccount[i].idBd == paramIdRow) {
				foundAccount = true;
				if(i<=newAccount.length-1)
					newAccount.splice(i,i+1);	
				else
					newAccount.splice(i,i);
			}
		}
	}

	return foundAccount;
}

function checkNewAccount(paramIdRow) {
	var foundAccount = false;
	
	if(paramIdRow!=null && paramIdRow==""){
	   var token=paramIdRow.split("-");
	   if(token[0]==tokenNewElement)
		   return true;
	   else
		   return false;
	}
	
	return foundAccount;
}

function removeUpdateRow(paramIdRow) {
	if (paramIdRow != null) {
		for (var i = 0; i < modifiedAccount.length; i++) {
			if (modifiedAccount[i].idBd == paramIdRow){
					modifiedAccount.splice(i,i+1);	
			}
		}
	}
}

function addDeletedRow(paramIdRow) {
	if (deletedAccount != null && deletedAccount instanceof Array) {
		deletedAccount.push(paramIdRow);
	}
}

function savedNewAccount(values) {

	if (values != null && values instanceof Array && values.length > 0) {
		// chequeamos la matriz de dos valores
		// chekqueamos si el objeto account
		var account = new Object();
		
		for (var i = 0; i < values.length; i++) {
			if (values[i][0] == "Account")
				account.Account = values[i][1];
			if (values[i][0] == "entidad")
				account.entidad = values[i][1];
			if (values[i][0] == "Balance")
				account.Balance = values[i][1];
		}
		
		account.idBd=values["idBd"];
		// Buscar valores repetidos.
		addNewAccount(account);
	}
}

function addNewAccount(account) {
	if (account != null) {
		newAccount.push(account);
	}
}

function addUpdateAccount(account) {
	if (account != null)
		modifiedAccount.push(account);
}

// Algoritmo
// comprobamos que el valor exista en una de las dos listas
//
function savedUpdatingAccount(idCuenta, values) {
	if (idCuenta != null && values != null && values instanceof Array) {
		if (values.length > 0) {
			// check de parametros recibidos.
			// chequeamos que las propiedades recibidas en el values existen
			// Ejemplo queremos dar de alta una Cuenta y nos
			var results = findAccountById(idCuenta);
			for (var i = 0; i < values.length; i++) {
					if (values[i][0] == "Account")
						results[1].Account = values[i][1];
					if (values[i][0] == "entidad")
						results[1].entidad = values[i][1];
					if (values[i][0] == "Balance")
						results[1].Balance = values[i][1];
			}
			if(results[0]==false)
				 addUpdateAccount(results[1]);	
		}
	}
}

function findAccountById(idCuenta) {
	//Primera posición valor boolean
	//Nos indica si es true que lo hemos encontrado en el modifiedVlaues.
	//false si no lo hemos encontrado en modifiedValues
	var results = new Array();
	if (idCuenta != null) {
		if (newAccount != null && modifiedAccount != null) {
			// Bloqueamos newAccount y modifiedAccount
			var token=idCuenta.split("-");
			if(token!=null || token.length>0){
				if(token[0]==tokenNewElement){
					//Buscamos elemento en newAccount
					for(var i=0;i<newAccount.length;i++){
					    if(newAccount[i].idBd==idCuenta){
					    	results[0]=true;
					    	results[1]=newAccount[i];
							return results;
						}
					}
					
				}else{
					
					var foundElement=false;
					for(var i=0;(i<vector.length || modifiedAccount.length) && foundElement==false;i++){
						
						if(i<modifiedAccount.length){
							if(modifiedAccount[i].idBd=idCuenta){
								foundElement= true;
								results[0]= true;
								results[1]= modifiedAccount[i];
								return results;
							}
						}
						
						if(i<vector.length && foundElement==false){
							if(vector[i].idBd==idCuenta){
								foundElement=true;
								results[0]=false;
								results[1]=vector[i];
								return results;
							}
						}
						
					}
					
				}
				
			}
						
		}
		
	}

	return results;
}

function checkIdAccount(account, idCuenta) {
	var equal = false;
	// instance of Account
	if (account != null && idCuenta != null) {
		if (account.idBd == idCuenta)
			equal = true;
	}
	return equal;
}

function checkDuplicatedAccount(account) {
	encontrado = false;
	for (var i = 0; i < newAccount.length && encontrado == false; i++) {
		// exceptiones si la propiedad Account no existe.
		if (account.Account == account.Account)
			encontrado = true;
	}
	return encontrado;
}



function checkNumeric(idRow) {
	// check if idRow is numeric
	return true;
}

function extraerModificaciones(valores) {

	var resultados = new Array();
	for (var i = 0; i < valores.length; i++) {
		

		if (valores[i][0] == "Account" && valores[i][1] != previousNameCuenta) {
			resultados.push(new Array(2));
			resultados[resultados.length-1][0] = "Account";
			resultados[resultados.length-1][1] = valores[i][1];
		}

		if (valores[i][0] == "entidad" && valores[i][1] != previousEntidad) {
			resultados.push(new Array(2));
			resultados[resultados.length-1][0] = "entidad";
			resultados[resultados.length-1][1] = valores[1][1];
		}

		if (valores[i][0] == "Balance" && valores[i][1] != previousSaldoCuenta) {
			resultados.push(new Array(2));
			resultados[resultados.length-1][0] = "Balance";
			resultados[resultados.length-1][1] = valores[i][1];
		}
	}

	return resultados;
}

function extraerValores() {

	var resultados = new Array(3);

	var nameCuenta = $("#Account").val();
	var entidad = $("#entidades > option:selected").attr("value");
	var saldoCuenta = $("#Balance").val();

	resultados[0] = new Array(2);
	resultados[0][0] = "Account";
	resultados[0][1] = nameCuenta;

	resultados[1] = new Array(2);
	resultados[1][0] = "entidad";
	resultados[1][1] = entidad;

	resultados[2] = new Array(2);
	resultados[2][0] = "Balance";
	resultados[2][1] = saldoCuenta;

	return resultados;
}

// Método que a partir de un array de [NombrePropiedad,Valor]
// determinamos que propiedades tienen errores.
// devolveremos una matriz vacia en caso de que no tengamos errores.
// devolvremos una matriz con [NombrePropiedad,Message Error]
function checkErrores(resultados) {
	var messagesError = new Array(3);
	messagesError[0] = new Array(2);
	messagesError[1] = new Array(2);
	messagesError[2] = new Array(2);

	var error = "";

	if (resultados != null && resultados.length > 0) {
		// chequera los valores distintos de null.
		for (var i = 0; i < resultados.length; i++) {
			error = "";
			if (resultados[i][0] == "Account") {
				error = checkAccount(resultados[i][1]);
				if (error != "") {
					messagesError[i][0] = "Account";
					messagesError[i][1] = error;
				}
			}

			if (resultados[i][0] == "entidad") {
				error = checkEntidad(resultados[i][1]);
				if (error != "") {
					messagesError[i][0] = "entidad";
					messagesError[i][1] = error;
				}

			}

			if (resultados[i][0] == "Balance") {
				error = checkBalance(resultados[i][1]);
				if (error != "") {
					messagesError[i][0] = "Balance";
					messagesError[i][1] = error;
				}
			}

		}
	}

	return messagesError;

}

function existErrors(messagesError) {
	var existError = false;
	// checkFormat.
	for (var i = 0; i < messagesError.length && existError == false; i++) {
		if (messagesError[i][1] != "" && messagesError[i][1] != undefined) {
			existError = true;
		}
	}

	return existError;
}

function checkAccount(valor) {
	var errorAccount = "";

	if (valor == "") {
		errorAccount = "El número de cuenta es obligatorio";
		return errorAccount;
	}

	if (valor.length > 10) {
		errorAccount = "El número de cuenta debe tener menos de 10 dígitos";
		return errorAccount;
	}

	return errorAccount;
}

function checkEntidad(valor) {

	var errorEntidad = "";
	if (valor == "") {
		errorEntidad = "Debes de seleccionar una entidad";
		return errorEntidad;
	}

	if (valor.length > 2 && valor.length < 20) {
		errorEntidad = "La entidad debe tener mas valores";
		return errorEntidad;
	}

	return errorEntidad;

}

function assignError(error) {
	// throw null Pointer
	var divId = $("#" + error[0]).parent().attr('id');
	if (divId != "") {
		if ($("#" + divId + " p.errorPanel").length == 0)
			$("#" + divId).append("<p class='errorPanel'>" + error[1] + "</p>");
		else
			$("#"+divId+" p.errorPanel").text(error[1]);
	}
}

function checkBalance(valor) {

	var errorBalance = "";

	if (valor == "") {
		errorBalance = "Debe de tener un valor";
		return errorBalance;
	}

	if (valor < 0) {
		errorBalance = "El importe debe de ser mayor que cero";
		return errorBalance;
	}

	return errorBalance;
}

function assignErrors(messagesErrors) {
	// throw Exception
	if (messagesErrors == null || messagesErrors.length == 0)
		return;
	// throw Exception

	for (var i = 0; i < messagesErrors.length; i++) {
		if (messagesErrors[i][0] == cuenta)
			assignError(messagesErrors[i]);

		if (messagesErrors[i][0] == saldo)
			assignError(messagesErrors[i]);

		if (messagesErrors[i][0] == entidad)
			assignError(messagesErrors[i]);
	}
}

function almacenarValor(id, valor) {
	$(id).val(valor);
}

function eliminarCuenta(idElement) {
	deleteRowById(idElement);
}

function guardarCuenta() {
	borrarErrores("exampleModal");
	var valores = extraerValores();
	messagesError = checkErrores(valores);
	
	if (existErrors(messagesError))
		assignErrors(messagesError);
	else {
		addBankAccount(valores);
		cerrarPanel();
	}
	
}

function borrarErrores(idPanel){
	
	if(idPanel!=null && idPanel!="")
	   $("#"+idPanel+" p.errorPanel").remove();
	
}

function actualizarCuenta() {
	borrarErrores("exampleModal");
	var valores = extraerValores();
	var modifiedValues = extraerModificaciones(valores);
	if (idRow != null) {
		// No se encuentran los errores.
		messagesError = checkErrores(modifiedValues);
		if (existErrors(messagesError)) {
			assignErrors(messagesError);
		} else {
			updateBankAccount(idRow, modifiedValues);
			updateRowById(idRow, modifiedValues);
			$("#exampleModal").modal('hide');
		}
	}

}

function mostrarCuenta(valores) {
	inicializarPanel();
	setTitle("Cuentas");
	savePreviousValues(valores);
	setPanelAccount(valores[0]);
	setPanelEntidades(valores[1]);
	setBalance(valores[2]);
	setUpdateMethod();
	$("#exampleModal").modal('show');
}

function mostrarPanel() {
	setTitle("Cuentas");
	setAcceptMethod();
	$("#exampleModal").modal('show');
}

function setAcceptMethod() {
	// Extraemos todos parametros
	$("#operationPanel").unbind( "click");
	$("#operationPanel").text("Almacenar Cuenta");
	$("#operationPanel").click(guardarCuenta);
}

function setUpdateMethod() {
	$("#operationPanel").unbind( "click" );
	$("#operationPanel").text("Modificar Cuenta");
	$("#operationPanel").click(actualizarCuenta);
}

function setPanelAccount(valor) {
	$("#Account").val(valor);
}

function setPanelEntidades(valor) {
	$("#entidades option").each(function(index) {
		if ($(this).attr("value") == valor)
			$(this).attr("selected", "selected");
	});
}

function setBalance(valor) {
	$("#Balance").val(valor);
}

function setTitle(title) {
	if (title != null)
		$("#exampleModalLabel").text(title);
	else
		$("#exampleModalLabel").text("Title");
}

function cerrarPanel() {
	$("#exampleModal").modal('hide');
	inicializarPanel();

}

function inicializarPanel() {
	$("#Account").val("");
	$("#Bancaria").val("");
	$("#Balance").val("");
	$("p.errorPanel").remove();
}

function inicializarEntidades() {
	setSelectBox();
}

function setSelectBox() {
	var options = "";
	options = options + "<option value='C1'> Caja Mar</option>";
	options = options + "<option value='C2'> Santander </option>";
	$("#entidades").append(options);

}

function addBankAccount(valores) {
	if (valores == null || valores.length == 0)
		return true;
	var fila = addFila(valores);
	$("#countBankTable").append(fila);
	savedNewAccount(valores);
	asignarPanelTabla();
}

function updateBankAccount(idCuenta, values) {
	// checkLogicInformaion
	if (idCuenta != null && values != null && values.length > 0) {
		savedUpdatingAccount(idCuenta, values);
	}

}

function deleteRowById(idElement) {

	if (idElement != null) {
		// bloqueamos la ejecución.
		var deletedRow = lookForRow(idElement);
		if (deletedRow != undefined) {
			if (savedDeletedAccount(deletedRow)) {
				$("#" + deletedRow).remove();
			}
		}
	}

}

function lookForRow(idElement) {
	var deletedRow = -1;
	if (idElement != null) {
		deletedRow = $("#" + idElement).parent().parent().attr('id');
	}
	return deletedRow;
}

function setErrores(messages) {
	// Panel tenemos los siguientes errores
	// Propenso para usar reflexión
	// chequeo de la información de errores que las dos listas deben de existir
	// Proceso para hacero con reflexión
	if (messages != null && messages.length > 0) {
		var foundError = false;
		for (var i = 0; i < messages.length && foundError == false; i++) {
			if (messages[i] == "Account") {
				setErrorAccount(messages[i][0]);
			}

			if (messages[i] == "entidades") {
				setErrorEntidad(messages[i][0]);
			}

			if (messages[i] == "Balance") {
				setErrorSaldoCuenta(messages[i][0]);
			}

		}
	}
}

function setErrorAccount(messageError) {
	if (messageError != null && messageError.length > 0) {
		// Debe de ser un mensaje de texto.
		if ($("#panelErrorAccount").show() == false)
			createErrorNode();
		// asignación responsiva al mensaje.
		$("#panelErrorAccount").attr("display", "");
		$("#panelErrorAccount").text(messageError);
	}
}

function createErrorNode() {

}

function setErrorEntidad(messageError) {
	if (messageError != null && messageError.length > 0) {
		if ($("#panelErrorEntidad").show() == 0)
			createErrorNode();
		$("#panelErrorEntidad").attr("display", "");
		$("#panelErrorEntidad").text(messageError);
	}
}

function setErrorBalance(messageError) {
	if (messageError != null && messageError.length > 0) {
		if ($("#panelErrorBalance").show() == false)
			createErrorNode();

		$("#panelErrorBalance").attr("display", "");
		$("#panelErrorBalance").text(messageError);
	}
}

function setErrorSaldoCuenta(messageError) {
	if (messageError != null && messageError.length > 0) {

	}
}



// Aprendido, para realizar una actualización de valores debes de acompañar el
// campo que has actualizado
// y el valor.
// restricciones en el array de valores de values la primera posición debe de
// ser el identificador
// jQuery realiza la comprobación mediante id, jqueryID
// idRow es el contenedor que almacena todos los elementos.
function updateRowById(idRow, values) {

	if (idRow != null && values != null && values.length > 0) {
		var actualizar = true;
		for (var i = 0; i < values.length && actualizar == true; i++) {
			if (values[i] == null || values[i] == "") {
				// chequea si existe la propiedad que estamos buscando
				actualizar = false;
			} else {
				if (values[i][0] == null || values[i][0] == "") {
					// chequeo de tipo y de rango de valores de la asignación
					actualizar = false;
				}
			}
		}
		// comprobación de que existan los valores
		if (actualizar) {
			// Esta estructura es feisim
				for(var i=0;i<values.length;i++){
					if(values[i][0]=="Account"){
						$("#"+idRow+" td:nth-child(1)").children().each(function (index){
							if(index==0){
								$(this).text(values[i][1]);
								return;
							}
						});
						
					}
					
					if(values[i][0]=="entidades"){
						$("#"+idRow+" td:nth-child(2)").children().each(function (index){
							if(index==0){
								$(this).text(values[i][1]);
								return;
							}
						});
					}
					
					if(values[i][0]=="Balance"){
						$("#"+idRow+" td:nth-child(3)").children().each(function (index){
							if(index==0){
								$(this).text(values[i][1]);
								return;
							}
						});
					}
				}

			}
		}

}



function addFilaByMovimiento(movimiento){
	
	var fila = "<tr id=" + movimiento.idBd + ">";
	idNuevo++;
	var aux = idNuevo + 1;

	fila = fila + "<td id=" + prefixNew + aux + "><a id="
			+ (prefixNew + (aux + 1)) + " href='#' onclick='showCuenta(this.id)'>" + movimiento.Account + "</a></td>";
	aux = aux + 2;
	fila = fila + "<td id=" + prefixNew + aux + "><a id="
			+ (prefixNew + (aux + 1)) + " href='#'>" + movimiento.Balance + "</a></td>";
	aux = aux + 2;
	fila = fila + "<td id=" + prefixNew + aux + "><a id="
			+ (prefixNew + (aux + 1)) + " href='#'>" + movimiento.entidad + "</a></td>";
	aux = aux + 2;
	fila = fila
			+ "<td><p id="
			+ (prefixNew + aux)
			+ "  onclick='eliminarCuenta(this.id)'> Eliminar cuenta </p>";
	fila = fila + "</td>";
	fila = fila + "</tr>";
	aux = aux + 2;
	id = aux;
	idNuevo = aux;
	
	if($("#countBankTable > tbody > tr").length<numFila)
		$("#countBankTable").append(fila);
	else
		calcularPaginacionInic("containerTabla");
	
	return fila;

}


function addFila(valores) {

	if (valores == null || valores.length == 0)
		return true;

	var cuenta = "";
	var entidad = "";
	var importe = "";

	for (var i = 0; i < valores.length; i++) {
		if (valores[i][0] == "Account")
			cuenta = valores[i][1];
		if (valores[i][0] == "entidad")
			entidad = valores[i][1];
		if (valores[i][0] == "Balance")
			importe = valores[i][1];
	}
	
	valores["idBd"]=prefixNew+idNuevo;
	
	var fila = "<tr id=" + prefixNew + idNuevo + ">";
	idNuevo++;
	var aux = idNuevo + 1;

	fila = fila + "<td id=" + prefixNew + aux + "><a id="
			+ (prefixNew + (aux + 1)) + " href='#' onclick='showCuenta(this.id)'>" + cuenta + "</a></td>";
	aux = aux + 2;
	fila = fila + "<td id=" + prefixNew + aux + "><a id="
			+ (prefixNew + (aux + 1)) + " href='#'>" + entidad + "</a></td>";
	aux = aux + 2;
	fila = fila + "<td id=" + prefixNew + aux + "><a id="
			+ (prefixNew + (aux + 1)) + " href='#'>" + importe + "</a></td>";
	aux = aux + 2;
	fila = fila
			+ "<td><p id="
			+ (prefixNew + aux)
			+ "  onclick='eliminarCuenta(this.id)'> Eliminar cuenta </p>";
	fila = fila + "</td>";
	fila = fila + "</tr>";
	aux = aux + 2;
	id = aux;
	idNuevo = aux;
	return fila;
}



function getInformationAccount(id) {
	var nombre = 0;
	var codigo = 0;
	var importe = 0;
	idRow = $("#" + id).parent().parent().attr('id');
	$("#" + idRow + " a").each(function(index) {
		if (index == 0)
			nombre = $(this).text();
		if (index == 1)
			codigo = $(this).text();
		if (index == 2)
			importe = $(this).text();
	});

	var valores = new Array(3);
	valores[0] = nombre;
	valores[1] = codigo;
	valores[2] = importe;
	return valores;
}

// Sección Paginacion
function setPagina(pageIndex) {
	numElementToShow = 2;
	var foundElement = extractElement(pageIndex, sourceVector, 3);
	populateTable(foundElement, numElementToShow);
}

function extractElement(pageIndex, sourceVector, numElementToShow) {
	var foundElement = null;
	if (pageIndex != null && pageIndex > 0 && pageIndex < sourceVector.length
			&& numElementToShow != null && numElementToShow > 0) {
		// limits
		foundElement = new Array(numElementToShow);
		var limit = (pageIndex * numElementToShow) - 1;
		var inic = ((pageIndex - 1) * numElementToShow);
		var j = 0;
		if (limit < sourceVector.length) {
			for (var i = inic; i <= limit; i++) {
				foundElement[j] = sourceVector[i];
				j++;
			}
		}

	}

	return foundElement;
}

function eraseTable(idTable) {
	$("#" + idTable + " tbody tr").remove();
}

function populateTable(vector, numElementToShow) {
	if (vector != null && vector.length > 0
			&& vector.length <= numElementToShow) {
		if (!existElementNull(vector)) {
			eraseTable("countBankTable");
			for (var i = 0; i < vector.length; i++) {
				addBankAccount(vector[i]);
			}
			asignarEventos();
		}
	}
}

function existElementNull(vector) {
	var nullElement = false;
	if (vector != null) {
		for (var i = 0; i < vector.length; i++) {
			if (vector[i] == null)
				nullElement = true;
		}
	}
	return nullElement;
}

function checkPagination(idTabla) {
	if (idTabla != null) {
		if ($("#" + idTabla + " > tr").length == 0) {
		}
	}
}

function switchActiveState(index) {
	if (index != null) {
		$("#paginacion > li.active").removeClass();
		$("#" + index).parent().addClass("active");
	}
}

function disabledRows(id) {
	if (id != null) {
		var index = $("#" + id).parent().index();

		if (index - 1 == 0) {
			$("#paginacion :first-child").removeClass();
			$("#paginacion :first-child").addClass("disabled");
			return;
		}

		var last = $("#paginacion > li").length;
		if ((index + 1) == last - 1) {
			$("#paginacion :last-child").removeClass();
			$("#paginacion :last-child").addClass("disabled");
			return;
		}

		if (index > 0 && index < last - 1) {
			$("#paginacion :first-child").removeClass();
			$("#paginacion :first-child").addClass("");
			$("#paginacion :last-child").removeClass();
			$("#paginacion :last-child").addClass("");
			return;
		}
	}
}

// Fin sección paginación
function responsivaTablas() {

}

// Funciones responsivas
function mostrarFilasTablas() {
	var numFilas = 3;
	$("#countBankTable tr").each(function(index) {
		if (index < numFilas + 1)
			$(this).removeClass();
	});
}

function asignarPanelTabla() {

	var length = $("#countBankTable tr td a").length;
	var index = 0;
	$("#countBankTable tr td a").click(function(e) {

		if (index >= (length - 2) && index < length) {
			if (index == length - 2) {
				$("#" + e.target.id).click(function() {
					metodoModificar(e.target.id);
				});
			}

			if (index == length - 1) {
				$("#" + e.target.id).click(function() {
					deleteRowById(e.target.id);
				});
			}

		} else {
			var valores = getInformationAccount(e.target.id);
			mostrarCuenta(valores);
		}

		index++;

	});
}

function showCuenta(idElemento){
	var valores = getInformationAccount(idElemento);
	mostrarCuenta(valores);
}

// Sección etiquetas
function crearTabs() {
	$("#pestanas a").click(function(e) {
		e.preventDefault();
		$(this).tab('show');
			
	});
	
	$("#pestanas a").on('shown.bs.tab',function(e){
		
		if(e.target.id=="bProveedor"){
			if(panelAjustadoP==false){
				panelAjustadoP=true;
				ajustarParrafo("proveedorD","p");
				ajustarParrafo("dContacto","p");
				ajustarParrafo("visitPro","p");
			}
		}
		
		if(e.target.id=="bDatosBancarios"){
			if(panelAjustadoB==false){
				panelAjustadoB=true;
				ajustarParrafo("datosB","p");
				ajustarParrafo("datosC","p");
			}
		}
		
		if(e.target.id=="dMov"){
		   alert("Ajustar Tabla");
		   reajustar("containerTabla","countBankTable",newAccount,vector);
		}

	});
	
}

function prepareVector() {
	deletedAccount = new Array();
	modifiedAccount = new Array();
	newAccount = new Array();
}



function calcularPaginacionInic(idContainerTabla){
	  calculaNumFilas(idContainerTabla);
	  var numButtons=calculateNumButtons(newAccount,vector);
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

function calculaNumFilas(idContainerTabla){
	var alto=37;
	altoFila=alto;
	var numero=Math.floor($("#"+idContainerTabla).height()/alto);
	numFila=numero-1;
}

function calculateNumButtons(vN,vOld){
	var numElements;
	var numButtons=1;
	if(vN!=null && vN instanceof Array  && vOld!=null && vOld instanceof Array){
		  numElements=vN.length+vOld.length;
		  numButtons=numElements/numFila;
		  var enteroNumButtons=Math.floor(numButtons);
		  var decimales=numButtons-enteroNumButtons;
		  if(decimales>0)
			   numButtons=enteroNumButtons+1;
	}
	numPages=numButtons;
	alert("Numero buttons  "+numButtons);
	return numButtons;
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

function removeFilas(idTable){
	if(idTable!=null && idTable!=""){
		$("#"+idTable+ " > tbody > tr").remove();
	}
}


function sendAjax() {
	$.ajax({
		type : "POST",
		cache : false,
		url : "provider/ajaxMovimiento",
		dataType : "json",
		data : JSON.stringify(vectorMovimiento),
		contentType : "application/json",
		mimeType : "application/json",
		success : function(data) {
			alert("id Proveedor" + data);
		},
		error : function(data, status, er) {
			alert("Anadir Movimiento");
			console.error("example");
			console.error(er);
		}

	});

}

function ajaxSimple() {

	$.ajax({
		type : "POST",
		cache : false,
		url : "provider/ajaxMovimiento",
		dataType : "json",
		data : JSON.stringify(vectorMovimiento),
		contentType : "application/json",
		mimeType : "application/json",
		success : function(data) {
			alert("respuesta enviada");
		},
		error : function(data, status, er) {
			alert("Simple");
			console.error("example");
			alert(data);
			alert(status);
			alert(er);
			Console.log(er);
			$("#texto").text(er);
		}
	});

}

function comprimir(accordion) {
	if (accordion != null && accordion != "") {
		$("#" + accordion).removeClass();
		$("#" + accordion).addClass("panel-collapse collapse");
	}
}


function showMessageOk(){
	inicializarMessageOk();
	setTitle("Almacenar Cuenta");
	setMessage("Proveedor modificado correctamente");
	$("#panelOk").modal('show');
}


function inicializarMessageOk(){
	$("#titleOk").text("");
	$("#messageOk").text("");
}

function setTitle(text){
	$("#titleOk").text(text);
}

function setMessage(text){
	if(text!=null && text!=""){
		$("#messageOk").text(text);
	}
}


function buildInformation() {
    var provider = getProvider();
	var completedInformation = {
		 proveedor:provider,	
		 deletedProviders:deletedAccount,
		 newBankAccount:[],
		 updateBankAccount:[]
	};
	
	return JSON.stringify(completedInformation);
}


function getProvider(){
	
	var provider= new Object();
	provider.providerName=$("#providerName").val();
	provider.providerStreet=$("#providerStreet").val();
	provider.codigoPedido=$("#codigoPedido").val();
	provider.importePedido=$("#importePedido").val();
	provider.responsableEntraga=$("#responsableEntrega").val();
	provider.descripcion=$("#descripcion").val();
	return provider;
}


function submitForm() {

	var vector=buildInformation();
	$.ajax({
		type : "POST",
		cache : false,
		url : "provider/submitForm",
		dataType : "json",
		data : vector,
		contentType : "application/json",
		mimeType : "application/json",
		success : function(d) {
			
			if(d.state=="KO"){
				for(var i=0;i<d.errorList.length;i++){
					var error=d.errorList[i];
					var resultado=new Array();
					resultado[0]=error.key;
					resultado[1]=error.value;
					assignError(resultado);
				}
			}
			
			if(d.state=="OK"){
				showMessageOk();
			}
			
		},
		error : function(data, status, er) {
			alert("Simple");
			console.error("example");
			alert(data);
			alert(status);
			alert(er);
			$("#texto").text(er);
		}

	});

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
    		var id=$(this).attr("id");
    		if(id!=null){
	     		var width=document.getElementById(id).offsetWidth;
	     		var margin=maxLength-width;
	     		$(this).css({"margin-right":margin});
	     		margin=0;
    	     }
     	 }); 	 
    }
}

$(document).ready(
		function() {
			$("#accordion a").click(
					function(e) {
						var idCollapse = $("#" + e.target.id).attr("href");
						if (idCollapse != null && idCollpase != "") {
							$("div.panel-body").children().parent().each(
									function(index) {
										comprimir("#accordion");
									});
							$("#" + idCollapse).addClass(
									"panel-collapse collapse in");
						}
			});

			prepareVector();

			$("#accordion div.panel-body").parent().removeClass();
			$("#accordion div.panel-body").parent().addClass(
					"panel-collapse collapse");

			crearTabs();
			$("#anadirCuenta").click(function(e) {
				mostrarPanel();
			});

			$("#paginacion li a").click(function(e) {
				switchActiveState(e.target.id);
				disabledRows(e.target.id);
				if (e.target.id != null) {
					setPagina(e.target.id);
				}
			});

			mostrarFilasTablas();
			sourceVector = new Array(50);
			for (var i = 0; i < 23; i++) {
				var auxVector = new Array(4);
				auxVector[0] = "a" + i;
				auxVector[1] = "Nuevo";
				auxVector[2] = "111";
				sourceVector[i] = auxVector;
			}

		});