package web;
import ejbAgenda.ContactManagerRemote;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserInterface")
public class UserInterface extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("toPrint", session.getId());
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsps/Connection/connection.jsp");
        rd.forward(request, response);
    }
}
