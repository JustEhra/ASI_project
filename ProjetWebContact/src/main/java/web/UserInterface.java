package web;

import ejbBillet.BilletManagerRemote;
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

@WebServlet("/UserInterface")
public class UserInterface extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        HttpSession session = request.getSession();
        UserManagerRemote userManagerRemote = EjbLocator.getLocator().getUserManager();
        request.setAttribute("toPrint", session.getId());

        BilletManagerRemote billetManagerRemote = EjbLocator.getLocator().getBilletManager();
        int uID = (int) session.getAttribute("id");
        User user = userManagerRemote.findUserById(uID);
        request.setAttribute("chercheBilletbyUser", billetManagerRemote.chercheBilletbyUser(user));

        request.getRequestDispatcher("/WEB-INF/jsps/user/sessionTokken.jsp").forward(request, response);
    }
}
