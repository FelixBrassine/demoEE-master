package be.bstorm.akimts.demoee.servlets.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        resp.getWriter().println("""
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <title>Contact</title>
                    </head>
                    <body>           
                        <h1>Contact :</h1>
                        <ul>
                            <li>
                                <p>Garage de la station</p>
                            </li>
                            <li>
                                <p>rue de la gare<p>
                            </li>
                            <li>
                                <p>Virton</p>
                            </li>
                            <li>
                                <p>tel : 063 / 12 34 56</p>
                            </li>
                            <li>
                                <p>email : gdls@outlook.com</p>
                            </li>
                        </ul><br>
                        <a href = \"./add\">Ajouter un vehicule </a> <br>
                        <a href = \"./get-one\">Trouver un vehicule </a> <br>
                        <a href = \"./get-all\">Liste des vehicules </a> <br>
                <a href = \"/demo\">Accueil </a> <br>
                    </body></html>""");
    }
}
