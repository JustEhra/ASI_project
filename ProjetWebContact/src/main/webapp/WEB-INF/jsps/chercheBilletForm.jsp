<html>
<meta charset="UTF-8">
<head>
    <title>
        Chercher un billet
    </title>
</head>
<body>
<u> Chercher un billet </u><br/><br/>
<form method="post" action="ChercheBilletExecuteServlet">

    Depart :
    <select name="billet.depart">
        <option value="">Choisir une option</option>
        <option value="Paris">Paris</option>
        <option value="Londre">Londre</option>
        <option value="Berlin">Berlin</option>
        <option value="Copenhague">Copenhague</option>
        <option value="Prague">Prague</option>
    </select>
    Arrivee :
    <select name="billet.arivee">
        <option value="">Choisir une option</option>
        <option value="Paris">Paris</option>
        <option value="Londre">Londre</option>
        <option value="Berlin">Berlin</option>
        <option value="Copenhague">Copenhague</option>
        <option value="Prague">Prague</option>
    </select>
    Date :
    <input type="date" name="billet.date"/>
    <input type="submit"/>
</form>
</body>
</html>



