<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ejbBillet.Billet" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Collection" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Liste des billets</title>
</head>
<body>
Liste des billets : <br/>
<br/>

<table width="90%" >

    <tr>
        <td>Depart</td>
        <td>Arrivee</td>
        <td>Date</td>
        <td>Type</td>
        <td>Prix (€)</td>
        <td>Places disponibles</td>
    </tr>
    <br/>


    <%
        Iterator it = ((Collection)request.getAttribute("chercheBillet")).iterator();
        while(it.hasNext()) {
            Billet billet = (Billet)it.next();
    %>

    <tr>
        <td><%= billet.getDepart() %></td>
        <td><%= billet.getArivee() %></td>
        <td><%= billet.getDate() %></td>
        <td><%= billet.getType() %></td>
        <td><%= billet.getPrix() %></td>
        <td><%= billet.getQuantiteEnStock() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>


