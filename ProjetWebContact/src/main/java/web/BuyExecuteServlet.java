package web;

import ejbBillet.Billet;
import ejbBillet.BilletManagerRemote;
import ejbUser.User;
import ejbUser.UserManagerRemote;
import web.EjbLocator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/BuyExecuteServlet")
public class BuyExecuteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BilletManagerRemote billetManagerRemote = EjbLocator.getLocator().getBilletManager();
        UserManagerRemote userManagerRemote = EjbLocator.getLocator().getUserManager();
        HttpSession session = request.getSession();

        int ID = parseInt(request.getParameter("billet.id"));
        int uID = (int) session.getAttribute("id");
        Billet billet = billetManagerRemote.findBilletById(ID);
        User user = userManagerRemote.findUserById(uID);
        billet.setUser(user);
        billetManagerRemote.buyBillet(billet);
        request.setAttribute("billet", billet);
        request.getRequestDispatcher("/WEB-INF/jsps/buyProof.jsp").forward(request, response);
    }
}