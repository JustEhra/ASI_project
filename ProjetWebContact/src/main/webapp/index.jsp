<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head></head>
<body>
Gestionnaire de contacts
<ul>
    <c:choose>
        <c:when test="${!empty sessionScope.mail}">
            Connected as <a href="UserInterface"/><%=session.getAttribute("username")%> Click to see id</a></br>
            <a href="."/><%session.invalidate();%> Click here to disconnect</a>
        </c:when>
        <c:otherwise>
            <a href="LoginUserFormServlet"/>Connection<br/>
            <a href="AddUserFormServlet"/>Inscription<br/>
        </c:otherwise>
    </c:choose>

    <li/><a href="AddContactFormServlet"/>ajout d'un contact<br/>
    <li/><a href="AddBilletFormServlet"/>ajout d'un billet<br/>
    <li/><a href="ListContactServlet"/>lister les contacts<br/>
    <li/><a href="ChercheBilletFormServlet"/>Chercher des billets<br/>
</ul>
</body>
</html>

