<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>

	<title>Home</title>

</head>

<style>

	.table{
		width:100%;
		margin-left:10%;
	}
	
	.cabecera{
		width: 100%;
		height:10%;
		background-color:pink;
	}
	
		
	.menuLateral{
		width:10%;
		height:80%;
		background-color:yellow;
		float:left;
	}
	
	.menuLateral a{
	
	  display:block;
	  padding-top:10px;
	  
	}
	
	.pie{
		width:100%;
		height:10%;
		background-color:blue;
		clear:both;
	}
	
    .cuerpo{
    	width:90%;
    	height:80%;
    	background-color:green;
    	float:left;
    	overflow:auto;
    }
   
    .html{
    	background-color:red;
    	width:100%;
    	height:100%;
    }
    
    .body{
    	background-color:purple;
    	width:100%;
    	height:100%;
    }
    

</style>

<body>

<div class="cabecera">
   <p> Cabecera </p>
</div>

<div class="menuLateral">

   <c:url var="home" value="/">
   </c:url>
   
   <a href='<c:out value="${home}"/> '> Home </a>
   <c:forEach items="${listEnlaces}" var="enlace">
	      <c:url var="link" value="${enlace.url}">
	      	<c:if test="${enlace.listParam.size()!=0}">
	           <c:param name="id" value="0" />
	        </c:if>
	      </c:url>
	      <a href='<c:out value="${link}"/> '> ${enlace.name} </a>
   </c:forEach>
   
</div>

<div class="cuerpo">
		
		<p> Nueva Aplicación </p>
		<a href="${flowExecutionUrl}&_eventId=siguiente"> Enlace </a>
		<a href="/firstProject/home?&_eventId=siguiente"> Enlace </a>
		<a href="<c:out value='${flowExecutionUrl}' />&_eventId=siguiente">Cancel</a>
</div>

<div class="pie">
	 <p>Pie de página </p>
</div>

</body>
</html>
