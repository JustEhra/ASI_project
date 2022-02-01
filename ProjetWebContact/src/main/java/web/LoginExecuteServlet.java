package web;

import ejbUser.User;
import ejbUser.UserManagerRemote;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/LoginExecuteServlet")
public class LoginExecuteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserManagerRemote userManagerRemote = EjbLocator.getLocator().getUserManager();
        User loggedUser = null;
        loggedUser = userManagerRemote.getUserByMailAndPassword(request.getParameter("user.mail"),request.getParameter("user.password"));
        if(loggedUser != null) {
            HttpSession session = request.getSession();
            session.setAttribute("id",loggedUser.getId());
            session.setAttribute("mail", loggedUser.getMail());
            session.setAttribute("username", loggedUser.getNom());
            session.setAttribute("administrator",loggedUser.isAdministrator());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        request.setAttribute("error", "Il semble qu'il y ai eu un problème !");
        request.getRequestDispatcher("/WEB-INF/jsps/user/loginForm.jsp").forward(request, response);
    }

}


