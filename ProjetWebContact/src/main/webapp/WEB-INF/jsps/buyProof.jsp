<%@ page import="ejbBillet.Billet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Achat</title>
</head>
<body>
<% Billet billet = (Billet)request.getAttribute("billet");%>
Vous avez acheté le billet suivant </br>
<table width="90%" >
    <tr>
        <td>Depart</td>
        <td>Arrivee</td>
        <td>Date</td>
        <td>Type</td>
        <td>Prix (€)</td>
    </tr>
    <tr>
        <td><%= billet.getDepart() %></td>
        <td><%= billet.getArivee() %></td>
        <td><%= billet.getDate() %></td>
        <td><%= billet.getType() %></td>
        <td><%= billet.getPrix() %></td>
    </tr>
</table>
</body>
</html>
