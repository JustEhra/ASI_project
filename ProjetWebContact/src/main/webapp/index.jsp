<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head></head>
<body>
<h2>Acheter des billets</h2>
<ul>
    <c:choose>
        <c:when test="${!empty sessionScope.mail}">
            Connected as <a href="UserInterface"><%=session.getAttribute("username")%> Click to see id</a></br>
            <c:if test="${sessionScope.administrator}">
                <a href="AddBilletFormServlet">Créer des billets</a><br/>
            </c:if>
        </c:when>
        <c:otherwise>
            <a href="LoginUserFormServlet">Connection</a><br/>
            <a href="AddUserFormServlet">Inscription</a><br/>
        </c:otherwise>
    </c:choose>
    <br/>
    <a href="ChercheBilletFormServlet">Chercher des billets<br/>
        <br/>
    <c:if test="${!empty sessionScope.mail}">
        <a href="DisconnectServlet"> Click here to disconnect</a><br/>
    </c:if>
</ul>
</body>
</html>

