<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head></head>
<body>
Acheter des billets
<ul>
    <c:choose>
        <c:when test="${!empty sessionScope.mail}">
            Connected as <a href="UserInterface"/><%=session.getAttribute("username")%> Click to see id</a></br>
            <c:if test="${sessionScope.administrator}">
                <a href="AddBilletFormServlet"/>Créer des billets<br/>
            </c:if>
            <a href="."/><%session.invalidate();%> Click here to disconnect</a><br/>
        </c:when>
        <c:otherwise>
            <a href="LoginUserFormServlet"/>Connection<br/>
            <a href="AddUserFormServlet"/>Inscription<br/>
        </c:otherwise>
    </c:choose>
    <a href="ChercheBilletFormServlet"/>Chercher des billets<br/>
</ul>
</body>
</html>

