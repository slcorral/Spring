'use strict';

myApp.run(['$rootScope', '$templateCache', function($rootScope, $templateCache){

	$templateCache.put('error-messages-default',
			'<div data-ng-message="required">{{"REQUIRED" | translate}}</div>'+
			'<div data-ng-message="minlength" data-ng-if="minlength" data-ng-init="transData = { value : minlength}">{{"MINLENGTH.VALUE" | translate : transData }}</div>'+
			'<div data-ng-message="minlength" data-ng-if="minlength == null">{{"MINLENGTH" | translate }}</div>'+
			'<div data-ng-message="maxlength" data-ng-if="maxlength" data-ng-init="transData = { value : maxlength}">{{"MAXLENGTH.VALUE" | translate : transData }}</div>'+
			'<div data-ng-message="maxlength" data-ng-if="maxlength == null">{{"MAXLENGTH" | translate }}</div>'+					  			 
			'<div data-ng-message="nifValidator">{{"NIF.ERROR" | translate }}</div>'+
			'<div data-ng-message="cifValidator">{{"CIF.ERROR" | translate }}</div>'+
			'<div data-ng-message="inputNumber">{{"NUMBER.ERROR" | translate }}</div>'+
			'<div data-ng-message="inputNumberFormat" data-ng-if="integer == null && decimal == null" >{{"NUMBER.ERROR.FORMAT" | translate }}</div>'+
			'<div data-ng-message="inputNumberFormat" data-ng-if="integer && decimal == null" data-ng-init="transData = { integer : integer}">{{"NUMBER.ERROR.FORMAT.INTEGER" | translate : transData }}</div>'+
			'<div data-ng-message="inputNumberFormat" data-ng-if="integer == null && decimal" data-ng-init="transData = { decima+l : decimal}">{{"NUMBER.ERROR.FORMAT.DECIMAL" | translate : transData }}</div>'+
			'<div data-ng-message="inputNumberFormat" data-ng-if="integer && decimal" data-ng-init="transData = { integer : integer, decimal : decimal}">{{"NUMBER.ERROR.FORMAT.INTEGER.DECIMAL" | translate : transData }}</div>'+
			'<div data-ng-message="inputNumberMin" data-ng-if="min == null">{{"NUMBER.ERROR.MIN" | translate }}</div>'+
			'<div data-ng-message="inputNumberMin" data-ng-if="min" data-ng-init="transData = { value : min}">{{"NUMBER.ERROR.MIN.VALUE" | translate : transData }}</div>'+
			'<div data-ng-message="inputNumberMax" data-ng-if="max == null">{{"NUMBER.ERROR.MAX.ERROR" | translate }}</div>'+
			'<div data-ng-message="inputNumberMax" data-ng-if="max" data-ng-init="transData = { value : max}">{{"NUMBER.ERROR.MAX.VALUE" | translate }}</div>'+
			'<div data-ng-message="identFiscalDNI">{{"DNI.ERROR" | translate }}</div>'+
			'<div data-ng-message="identFiscalNIF">{{"NIF.ERROR" | translate }}</div>'+
			'<div data-ng-message="identFiscalCIF">{{"CIF.ERROR" | translate }}</div>'+
			'<div data-ng-message="identFiscalPAS">{{"PAS.ERROR" | translate }}</div>'+
			'<div data-ng-message="identFiscalTR">{{"TR.ERROR" | translate }}</div>'+
			'<div data-ng-message="identFiscalNIE">{{"NIE.ERROR" | translate }}</div>'
			+'<div ng-message="nombreError">Mensaje de error</div>');
        
}]);