package be.technobel.fbrassine.demoee.servlets.servlets;

import be.technobel.fbrassine.demoee.servlets.model.Voiture;
import be.technobel.fbrassine.demoee.servlets.service.GarageService;
import be.technobel.fbrassine.demoee.servlets.service.GarageServiceImpl;
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

        long id = 0;
        long voitureId = 0;
        String voitureMarque = " ";
        String voitureModel = " ";
        double voiturePrix = 0;
        req.setAttribute("voitureId", voitureId);
        req.setAttribute("voitureMarque", voitureMarque);
        req.setAttribute("voitureModel", voitureModel);
        req.setAttribute("voiturePrix", voiturePrix);
        String idParam = req.getParameter("id");
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException ex) {
            resp.setStatus(400);
            resp.getWriter().print("Choisissez un id !");
        }
        for (Voiture voiture : service.getAll()) {
            if (voiture.getId() == id) {
                voitureId = voiture.getId();
                voitureMarque = voiture.getMarque();
                voitureModel = voiture.getModele();
                voiturePrix = voiture.getPrix();
                req.setAttribute("voitureId", voitureId);
                req.setAttribute("voitureMarque", voitureMarque);
                req.setAttribute("voitureModel", voitureModel);
                req.setAttribute("voiturePrix", voiturePrix);
                req.getRequestDispatcher("/voiture/get-one.jsp").forward(req, resp);
                break;
            }
        }
        req.getRequestDispatcher("/voiture/get-one.jsp").forward(req, resp);
    }
}