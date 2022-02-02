<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ejbBillet.Billet" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
        <!--<td>Places disponibles</td>-->
    </tr>
    <br/>


    <%
        Iterator it = ((Collection)request.getAttribute("chercheBillet")).iterator();
        while(it.hasNext()) {
            Billet billet = (Billet)it.next();
            if(billet.getUser() == null)
            {

    %>
    <td> </td>
    <tr>

        <td><%= billet.getDepart() %></td>
        <td><%= billet.getArivee() %></td>
        <td><%= billet.getDate() %></td>
        <td><%= billet.getType() %></td>
        <td><%= billet.getPrix() %></td>
        <!--todo <td> quantite</td> -->

        <c:if test="${!empty sessionScope.mail}">
            <td><form method="get" action="BuyExecuteServlet">
                <input type="hidden" value="<%= billet.getId() %>" name="billet.id"/>
                <input type="submit" value="ACHETER"/>
            </form>
            </td>
        </c:if>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>


