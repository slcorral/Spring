var modulo= angular.module("myapp",[]);

modulo.controller("formController",function($scope,$http){
	 $scope.holamundo="poapapsdpasdpapsdas";
	 
	 $scope.objeto={};
	 
	 $scope.sendGet = function(){
		 var objeto= new Object();
		 //objeto.date=new Date("1970/09/09");
		 //objeto.date=new Date("2015-09-12T15:32:29.606Z");
		 //objeto.date=new Date("2015/09/12");
		  //var url="fechas/buscar?date=1970/09/09";
		  var url="fechas/buscar?date=1970-09-09";
		 //var url="fechas/buscar2?date?=2013/01/01T00:00:00";
		 //var url="fechas/buscar2?date="+objeto.date;
		 alert("url "+url);
		 
		 $http.get(url);
	 };
	
	 
	
	 $scope.sendPut = function(){
		 //Ejemplo del put con 
		 alert("antes");
		// $scope.objeto.date=new Date("2015/01/01");
		$scope.objeto.date=new Date("2015-10-10");
		 alert($scope.objeto.date);
		 $scope.objeto.nombre="Nombre";
		 alert("scope 1");
		 return $http.put('fechas/put', $scope.objeto);
		 alert("Scope");
	 };
	 
	 //descargar moment.
	 
	 $scope.momento = function(){
		//moment
		 var valor="2010-05-05";
		 var fecha_moment = moment(valor,"HH:mm:ss");
		 alert("Fecha Moment "+fecha_moment);
		 var fecha_new = new Date(fecha_moment);
		 alert("Fecha Nueva "+fecha_new);
	 };
	 
	 
	  $scope.momento2 = function(){
		 //formatear desde el servidor hasta donde esta
		 var date= new Date();
		 alert("Fecha");
		 alert(date);
		 var fecha_moment = moment(date).format("YYYY-MM-DD");
		 alert("Fecha Modificada "+date);
		 alert(fecha_moment);
	  };
	 
	  $scope.moment3 = function(){
		 var date = new Date();
		 alert("Fecha");
		 alert(date.getTime());
		 var fecha_moment = moment(date).format("YYYY-MM-DD");
		 alert(fecha_moment);
		  
	  };
	 
	  //update
      $scope.moment4 = function(){
		 var date = new Date("2015-09-12");
		 alert("Fecha");
		 alert(date);
		// var fecha_moment = moment(date).format("YYYY-MM-DD");
		 alert(fecha_moment);  
	  };
	  
});




