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

@WebServlet("/add")
public class AddVoitureServlet extends HttpServlet {

    private final GarageService service = GarageServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("""                          
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>
                                
                    <h1>Ajouter une voiture</h1>
                                
                    <form action="/demo/add" method="post">
                                
                                
                        <div>
                            <label for="id-in">id</label><br>
                            <input type="number" name="id" id="id-in">
                        </div>
                       
                        <div>
                            <label for="marque-in">Marque</label><br>
                            <input type="text" name="marque" id="marque-in">
                        </div>
                                
                        <div>
                            <label for="modele-in">Modele</label><br>
                            <input type="text" name="modele" id="modele-in">
                        </div>
                                
                        <div>
                            <label for="prix-in">prix</label><br>
                            <input type="number" name="prix" id="prix-in">
                        </div>
                                
                        <button type="submit">envoyer</button>
                    </form>      
                    <form action="/demo/contact" method="post">          
                        <button type="submit">contact</button>
                    </form>   <br>
                    <a href = \"./get-one\">Trouver un vehicule </a> <br>
                    <a href = \"./get-all\">Liste des vehicules </a> <br>
                    <a href = \"/demo\">Accueil </a> <br>
                    <a href = \"./contact\">Contact </a>   <br>
                </body>
                </html>
                """);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String marque = req.getParameter("marque");
        String modele = req.getParameter("modele");
        long id = Long.parseLong( req.getParameter("id") );
        double prix = Double.parseDouble( req.getParameter("prix") );

        Voiture v = new Voiture(id, marque, modele, prix);

        service.ajouter(v);

        resp.sendRedirect("/demo/get-all");
    }
}
