<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>
        Billet
    </title>
</head>
<body>
Connection : <br/>

<form method="post" action="LoginExecuteServlet">
    Mail :
    <input type="text" name="user.mail"/><br/>
    Password :
    <input type="text" name="user.password"/><br/>
    <input type="submit"/>
</form>
<p>
    <%= request.getAttribute("error")!=null?request.getAttribute("error"):"" %>
</p>
</body>
</html>



