
<!DOCTYPE html>
<% long voitureId = (long)request.getAttribute("voitureId"); %>
<% String voitureMarque = (String)request.getAttribute("voitureMarque"); %>
<% String voitureModel = (String)request.getAttribute("voitureModel"); %>
<% double voiturePrix = (double)request.getAttribute("voiturePrix"); %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Recherche</title>
    </head>
    <body>
        <form action="/demo/get-one" method="get">
            <div>
                <title>Donnez l'id de la voiture</title>
                <label for="id-in">id</label><br>
                <input type="number" name="id" id="id-in">
            </div>
            <button type="submit">envoyer</button><br>
        </form>
        <div>
            <title>La voiture recherchée</title>
            <ul>
                <li>
                    [ <%= voitureId %> ] marque : <%= voitureMarque %> model : <%= voitureModel %> prix : <%= voiturePrix %>$
                </li>
            </ul><br>
        </div>
        <a href = "./add">Ajouter un vehicule </a> <br>
        <a href = "./get-all">Liste des vehicules </a> <br><a href = "./">Accueil </a> <br>
        <a href = "./contact">Contact </a>  <br>
    </body>
</html>