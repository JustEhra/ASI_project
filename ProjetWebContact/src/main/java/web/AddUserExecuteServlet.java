package web;


import ejbUser.User;
import ejbUser.UserManagerRemote;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AddUserExecuteServlet")
public class AddUserExecuteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        user.setNom(request.getParameter("user.nom"));
        user.setMail(request.getParameter("user.mail"));
        user.setPassword(request.getParameter("user.password"));

        UserManagerRemote userManagerRemote = EjbLocator.getLocator().getUserManager();
        System.out.println(userManagerRemote);


        User newUser = userManagerRemote.ajouterUser(user);
        RequestDispatcher rd = null;

        if(newUser.getId() > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("mail",user.getMail());
            session.setAttribute("username",user.getNom());
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsps/user/userNotAdded.jsp").forward(request, response);
        }
    }
}

