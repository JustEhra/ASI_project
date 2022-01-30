<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>

<%@ page import="javax.swing.text.html.HTML" %>
<html>
<head></head>
<body>
Gestionnaire de contacts
<ul>
    <c:choose>
        <c:when test="${session.getAttribute('username') != null}">
            Connected as ""
        </c:when>
        <c:otherwise>
            <a href="UserInterface"/>Connection</a><br />
        </c:otherwise>
    </c:choose>

    <li/><a href="AddContactFormServlet"/>ajout d'un contact</a><br/>
    <li/><a href="AddBilletFormServlet"/>ajout d'un billet</a><br/>
    <li/><a href="ListContactServlet"/>lister les contacts</a><br/>
</ul>
</body>
</html>

