package web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Redirige del root ("/") al controlador principal de la aplicación
@WebServlet(name = "RootServlet", urlPatterns = {"/"})
public class RootServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        response.sendRedirect(request.getContextPath() + "/ServletControlador");
    }
}
