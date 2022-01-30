<%--
  Created by IntelliJ IDEA.
  User: Cro
  Date: 2022/01/30
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
   String temp = (String) request.getAttribute("toPrint");
%>
<h1><%= temp %> </h1>
</body>
</html>
