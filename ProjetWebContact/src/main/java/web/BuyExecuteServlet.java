package web;

import ejbBillet.Billet;
import ejbBillet.BilletManagerRemote;
import web.EjbLocator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/BuyExecuteServlet")
public class BuyExecuteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BilletManagerRemote billetManagerRemote = EjbLocator.getLocator().getBilletManager();
        int ID = parseInt(request.getParameter("billet.id"));
        Billet billet = billetManagerRemote.findBilletById(ID);
        billet.setQuantiteEnStock(billet.getQuantiteEnStock()-1);
        billetManagerRemote.buyBillet(billet);
        request.setAttribute("billet", billet);
        request.getRequestDispatcher("/WEB-INF/jsps/buyProof.jsp").forward(request, response);


    }
}