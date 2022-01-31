<html>
<head>
    <title>
        Billet
    </title>
</head>
<body>
Crée un Compte : <br/>
<form method="post" action="AddUserExecuteServlet">
    <label>Nom :
    <input type="text" name="user.nom"/><br/></label>
    <label>Mail :
    <input type="text" name="user.mail"/><br/></label>
    <label>Password :
    <input type="text" name="user.password"/><br/></label>
    <input type="submit"/><br/>
    <%= request.getAttribute("error")!=null?request.getAttribute("error"):"" %>
</form>
</body>
</html>



