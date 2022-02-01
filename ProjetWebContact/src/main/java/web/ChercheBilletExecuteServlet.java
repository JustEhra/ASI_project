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

@WebServlet("/ChercheBilletExecuteServlet")
public class ChercheBilletExecuteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BilletManagerRemote billetManagerRemote = EjbLocator.getLocator().getBilletManager();
        String D=request.getParameter("billet.depart");
        String A=request.getParameter("billet.arivee");
        String date=request.getParameter("billet.date");
        request.setAttribute("chercheBillet", billetManagerRemote.chercheBillet(D, A, date));
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsps/listBillet.jsp");
        rd.forward(request, response);


    }
}

