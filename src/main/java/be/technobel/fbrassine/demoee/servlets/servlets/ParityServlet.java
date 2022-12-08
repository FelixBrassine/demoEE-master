package be.bstorm.akimts.demoee.servlets.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/parity")
public class ParityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String numberParam = req.getParameter("number");

        if( numberParam == null ){
            resp.setStatus( 400 );
            resp.getWriter().print("Un paramètre 'number' est nécessaire");
            return;
        }

        try {
            int number = Integer.parseInt( numberParam );
            if( number % 2 == 0 ){
                resp.getWriter().print( "Le nombre est pair" );
            }
            else {
                resp.getWriter().print( "le nombre est impair" );
            }
//            resp.setStatus(200); // code par defaut
        }
        catch (NumberFormatException ex){
            resp.setStatus(400);
            resp.getWriter().print("Le paramètre n'a pas une valeur enitère, connard");
        }


    }
}
