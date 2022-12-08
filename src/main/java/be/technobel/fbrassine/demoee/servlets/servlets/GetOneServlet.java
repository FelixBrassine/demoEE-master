package be.bstorm.akimts.demoee.servlets.servlets;

import be.bstorm.akimts.demoee.servlets.model.Voiture;
import be.bstorm.akimts.demoee.servlets.service.GarageService;
import be.bstorm.akimts.demoee.servlets.service.GarageServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get-one")
public class GetOneServlet extends HttpServlet {
    int id;
    private final GarageService service = GarageServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        resp.getWriter().println("""
                  <form action="/demo/get-one" method="post">                              
                        <div>
                            <p>Donnez l'id de la voiture<p>
                            <label for="id-in">id</label><br>
                            <input type="number" name="id" id="id-in">
                        </div>         
                        <button type="submit">envoyer</button><br>
                         <a href = \"./add\">Ajouter un vehicule </a>  <br>
                        <a href = \"./get-all\">Liste des vehicules </a> <br>
                        <a href = \"/demo\">Accueil </a> <br>
                        <a href = \"./contact\">Contact </a>  <br>
                """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        String idParam = req.getParameter("id");

        try {
            id = Integer.parseInt( idParam );
            resp.getWriter().println("""
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <title>Title</title>
                    </head>
                    <body>                                    
                        <h1>La voiture recherchée</h1>                        
                        <ul>
                    """ );
            for (Voiture voiture : service.getAll()){
                if (voiture.getId() == id){
                    out.println("<li>["+ voiture.getId()+"] "+voiture.getMarque()+" - "+voiture.getModele()+" - "+voiture.getPrix()+" $</li>");
                    break;
                }else {
                    resp.getWriter().print("Mauvais id");
                    return;
                }
            }
            out.println("""
                                    </ul><br>
                                    <a href = \"./add\">Ajouter un vehicule </a> <br>
                                    <a href = \"./get-one\">Trouver un vehicule </a> <br>
                                    <a href = \"./get-all\">Liste des vehicules </a> <br>
                                    <a href = \"./contact\">Contact </a>  <br>
                                </body>
                            </html>
                        """);
        }
        catch (NumberFormatException ex){
            resp.setStatus(400);
            resp.getWriter().print("Choisissez un id !");
        }
    }
}
