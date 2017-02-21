<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 <div class="menuLateral">
  
  <c:url var="home" value="/">
  </c:url>
  <a href='<c:out value="${home}"/> '> Home </a>
  
   <c:forEach items="${listEnlaces}" var="enlace">
      <c:url var="link" value="${enlace.url}">
        <c:param name="id" value="0" />
      </c:url>
      <a href='<c:out  value="${link}"/> '> ${enlace.name} </a>
   </c:forEach>
</div>

</body>
</html>