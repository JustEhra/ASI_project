package web;


import ejbBillet.Billet;
import ejbBillet.BilletManagerRemote;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddBilletExecuteServlet")
public class AddBilletExecuteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Billet billet = new Billet();
        billet.setDepart(request.getParameter("billet.depart"));
        billet.setArivee(request.getParameter("billet.arivee"));
        billet.setType(request.getParameter("billet.type"));
        billet.setDate(Integer.parseInt(request.getParameter("billet.date")));
        billet.setPrix(Integer.parseInt(request.getParameter("billet.prix")));
        billet.setQuantiteEnStock(Integer.parseInt(request.getParameter("billet.quantiteEnStock")));
        BilletManagerRemote billetManagerRemote = EjbLocator.getLocator().getBilletManager();
        System.out.println(billetManagerRemote);


        Billet newBillet = billetManagerRemote.ajouterBillet(billet);
        RequestDispatcher rd = null;

        if(newBillet.getId() > 0) {
            rd = request.getRequestDispatcher("/WEB-INF/jsps/billetAdded.jsp");
        }
        else {
            rd = request.getRequestDispatcher("/WEB-INF/jsps/billetNotAdded.jsp");
        }


        rd.forward(request, response);
    }
}

