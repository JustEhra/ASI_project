<%@ page import="ejbBillet.Billet" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Liste des billets achetés: <br/>
<br/>
<table width="90%" >

    <tr>
        <td>Depart</td>
        <td>Arrivee</td>
        <td>Date</td>
        <td>Type</td>
        <td>Prix (€)</td>
        <!--<td>Places disponibles</td>-->
    </tr>
    <br/>


    <%
        Iterator it = ((Collection)request.getAttribute("chercheBilletbyUser")).iterator();
        while(it.hasNext()) {
            Billet billet = (Billet)it.next();


    %>
    <td> </td>
    <tr>

        <td><%= billet.getDepart() %></td>
        <td><%= billet.getArivee() %></td>
        <td><%= billet.getDate() %></td>
        <td><%= billet.getType() %></td>
        <td><%= billet.getPrix() %></td>
        <!--todo <td> quantite</td> -->

    </tr>
    <%

        }
    %>
</table>
<br/><br/>
</body>
</html>
