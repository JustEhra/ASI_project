<html>
<meta charset="UTF-8">
<head>
    <title>
        Ajouter un billet.
    </title>
</head>
<body>
<u> Cree un billet : </u><br/><br/>
<form method="post" action="AddBilletExecuteServlet">

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

    Type :
    <select name="billet.type">
        <option value="">Choisir une option</option>
        <option value="non-echangable">Non-Echangable</option>
        <option value="flexible">Flexible</option>
        <option value="premiere_class">Premiere Classe</option>
    </select>
    <br/>
    Date :
    <input type="date" name="billet.date"/>
    Prix :
    <input type="text" name="billet.prix"/><br/>
    Stock :
    <input type="text" name="billet.quantiteEnStock"/><br/>
    <br/>
    <input type="submit"/>
</form>
</body>
</html>


