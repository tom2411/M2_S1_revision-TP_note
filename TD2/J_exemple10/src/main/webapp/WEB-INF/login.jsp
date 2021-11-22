
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Identification</title>
</head>
<body>
<h1>IDENTIFICATION</h1>
<form method="post">
    <p>Login: <input type="text" name="login" /></p>

    <p>Password: <input type="password" name="password" /></p>
    <p><button type="submit" value="Submit" name="TODO"> Envoyer</button></p>
</form>

<c:if test="${not empty errors}">
    <c:forEach items="${errors}" var="error">
        <span style="color: red">${error}</span>
    </c:forEach>
</c:if>

<jsp:include page="session.jsp"></jsp:include>




</body>

</html>
