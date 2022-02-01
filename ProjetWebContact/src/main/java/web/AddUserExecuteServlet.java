package web;


import com.google.common.hash.Hashing;
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
import java.nio.charset.StandardCharsets;

@WebServlet("/AddUserExecuteServlet")
public class AddUserExecuteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        UserManagerRemote userManagerRemote = EjbLocator.getLocator().getUserManager();

        //Check for already used Email and return Error
        if(null != userManagerRemote.getUserByMail(request.getParameter("user.mail"))) {
            request.setAttribute("error", "Cette Email est déjà utilisé !");
            request.getRequestDispatcher("/WEB-INF/jsps/user/userForm.jsp").forward(request, response);
        }

        user.setNom(request.getParameter("user.nom"));
        user.setMail(request.getParameter("user.mail"));

        //Hash pwd
        String sha256hex = Hashing.sha256()
                .hashString(request.getParameter("user.password"), StandardCharsets.UTF_8)
                .toString();

        user.setPassword(sha256hex);
        user.setAdministrator(false);


        User newUser = userManagerRemote.ajouterUser(user);
        RequestDispatcher rd = null;

        if(newUser.getId() > 0) {
            HttpSession session = request.getSession();

            //set mail and username in session for later use
            session.setAttribute("mail",user.getMail());
            session.setAttribute("username",user.getNom());
            session.setAttribute("administrator",user.isAdministrator());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsps/user/userNotAdded.jsp").forward(request, response);
        }
    }
}

