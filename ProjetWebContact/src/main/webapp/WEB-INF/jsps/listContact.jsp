<%@ page import="ejbAgenda.Contact" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Collection" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Liste des contacts</title>
</head>
<body>
Liste des contacts : <br/>
<br/>
<br/>
<table width="90%" >
    <%
        Iterator it = ((Collection)request.getAttribute("listContacts")).iterator();
        while(it.hasNext()) {
            Contact contact = (Contact)it.next();
    %>
    <tr>
        <td><%= contact.getPrenom() %></td>
        <td><%= contact.getNom() %></td>
        <td><%= contact.getAddresse() %></td>
        <td><%= contact.getVille() %></td>
        <td><%= contact.getCodePostal() %></td>
        <td><%= contact.getTelephone() %></td>
        <td><%= contact.getMobile() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>


