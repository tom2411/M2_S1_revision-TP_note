<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- la taglib pour afficher entre autres les messages d'erreur...) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Identification</title>
</head>
<body>
<h1>IDENTIFICATION</h1>
<!-- on utilise form:form qui vient de spring mvc et on précise le modelAttribute. Sinon ls messages d'erreur ne sont pas traités -->
<form:form method="post" action="${pageContext.request.contextPath}/login"  modelAttribute="user">
    <p><form:label path="login">login</form:label> <form:input type="text" path="login"/></p>
    <p><form:label path="password">mot de passe</form:label> <form:input type="password" path="password"/></p>
    <p><button type="submit">Envoyer</button></p>
    <!-- pour les messages d'erreur globaux au formulaire (pour des messages relatifs à un champ on précise avec "path=") -->
    <form:errors cssStyle="color: red;"></form:errors>
</form:form>


<c:import url="session.jsp"></c:import>

</body>
</html>
