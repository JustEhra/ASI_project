package web;

import ejbAgenda.ContactManagerRemote;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ListContactServlet")
public class ListContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        ContactManagerRemote contactManagerRemote = EjbLocator.getLocator().getContactManager();
        request.setAttribute("listContacts", contactManagerRemote.listerContact());
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsps/listContact.jsp");
        rd.forward(request, response);
    }
}
