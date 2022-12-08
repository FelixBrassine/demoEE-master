<!DOCTYPE html>
<%@ page import="be.bstorm.akimts.demoee.servlets.model.Voiture" %>
<%@ page import="be.bstorm.akimts.demoee.servlets.service.GarageService" %>
<%@ page import="be.bstorm.akimts.demoee.servlets.service.GarageServiceImpl" %>

<%! private final GarageService service = GarageServiceImpl.getInstance(); %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>La liste des voitures</h1>

<ul>
    <% for (Voiture voiture : service.getAll()) { %>
    <li>[ <%= voiture.getId() %> ]  <%= voiture.getMarque() %> - <%= voiture.getModele()%> - <%= voiture.getPrix() %> </li>
    <% } %>
</ul><br>
<a href = "/add">Ajouter un vehicule </a> <br>
<a href = "/get-one">Trouver un vehicule </a> <br>
<a href = "/demo">Accueil </a> <br>
<a href = "/contact">Contact </a>  <br>
</body>
</html>