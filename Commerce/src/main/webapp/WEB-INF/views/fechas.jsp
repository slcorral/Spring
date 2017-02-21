<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@  taglib uri="http://localhost/myFunctions" prefix="mt" %>

<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="<c:url value="/resources/js/angular/angular.1.4.3.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/fechas/fechas.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/moment/moment.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/moment/moment-with-locale.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/libs/bootstrap/ui-bootstrap-tpls-0.12.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/libs/bootstrap/datepicker.js"/>"></script>

</head>

<body ng-app="myapp">

<div ng-controller="formController">
	<p> Formulario donde estamos </p>
	
	<div>
	   <p> {{holamundo}} </p>
	</div>
	
	<button ng-click="sendGet()">Enviar Get</button>
	<button ng-click="sendPut()">Enviar Put</button>
	<button ng-click="momento()"> Momento</button>
	<button ng-click="momento23()"> Momeento2</button>
	<button ng-click="moment3()">Moment3</button>
	<button ng-click="moment4()">Momment4</button>
	
</div>

<!--  
<form name="myForm" ng-submit="onSubmit()">
    <input type="number" ng-model="price" name="price_field" ng-pattern="/^[0-9]{1,7}$/" required>
    <span ng-show="myForm.price_field.$error.pattern">Not a valid number!</span>
    <input type="submit" value="submit"/>
</form>


<form name="myForm">
    <input type="number" ng-model="price" ng-pattern="/^[0-9]{1,7}$/">
    <span ng-show="myForm.price_field.$error.pattern">Holaaaaaaaa</span>
    <input type="submit" value="submit"/>
</form>


<form name="Form">
      <input type="text" ng-model="hola" ng-pattern="/a-zA-Z/" />
      <input type="text" ng-pattern="/0-9/" />
      <input type="text" ng-pattern="/a-zA-Z0-9/" /> 
</form>
-->

<form name="myForm">
    <input type="text" ng-model="price" name="price_field" ng-pattern="/[ICP]/" required>
	    <span ng-show="myForm.price_field.$error.pattern">No es un valor validoooooo!</span>
	    <div ng-class="{'error-req': myForm.price_field.$error.pattern}">
    </div>
    <input type="submit" value="submit"/>
</form>


</body>
</html>