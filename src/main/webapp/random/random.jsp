<!DOCTYPE html>
<%@ page import="java.util.Random" %>
<%! Random random = new Random(); %>
<%! int chiffreRandom; %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Random</title>
</head>
<body>

<h1>Le nombre aleatoire</h1>

<div>
    <% chiffreRandom = random.nextInt(50)+1; %>
    <p><%= chiffreRandom %></p>
</div>
<a href = "/demo">Accueil </a> <br>

</body>

</html>