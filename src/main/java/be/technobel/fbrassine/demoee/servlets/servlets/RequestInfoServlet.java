package be.technobel.fbrassine.demoee.servlets.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

@WebServlet("/info")
public class RequestInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("request URI: " + req.getRequestURI());
        System.out.println("request URL: " + req.getRequestURL());
        System.out.println("HTTP METHOD: " + req.getMethod());
        System.out.println("one HEADER: " + req.getHeader("accept"));

        System.out.println("TOUS LES PARAMS:");
        Enumeration<String> paramNames = req.getParameterNames();
        while(paramNames.hasMoreElements()){
            String paramName = paramNames.nextElement();
            System.out.println(paramName + " - " + req.getParameter(paramName));
        }

        System.out.println("BODY");
        BufferedReader reader = req.getReader();
        reader.lines()
                .forEach(System.out::println);
    }
}
