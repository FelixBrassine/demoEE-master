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

@WebServlet("/get-all")
public class GetAllServlet extends HttpServlet {

    private final GarageService service = GarageServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();


        resp.getWriter().println("""
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <title>Title</title>
                    </head>
                    <body>
                                    
                        <h1>La liste des voitures</h1>
                                    
                        <ul>
                    """ );

        for (Voiture voiture : service.getAll()) {
            out.println("<li>["+ voiture.getId()+"] "+voiture.getMarque()+" - "+voiture.getModele()+" - "+voiture.getPrix()+" $</li>");

        }
        out.println("""
                        </ul><br>
                        <a href = \"./add\">Ajouter un vehicule </a> <br>
                        <a href = \"./get-one\">Trouver un vehicule </a> <br>
                        <a href = \"/demo\">Accueil </a> <br>
                        <a href = \"./contact\">Contact </a>  <br>
                    </body>
                </html>""");
    }
}
