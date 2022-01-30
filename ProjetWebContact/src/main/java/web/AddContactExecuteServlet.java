package web;


import ejbAgenda.Contact;
import ejbAgenda.ContactManagerRemote;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddContactExecuteServlet")
public class AddContactExecuteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contact contact = new Contact();
        contact.setPrenom(request.getParameter("contact.prenom"));
        contact.setNom(request.getParameter("contact.nom"));
        contact.setAddresse(request.getParameter("contact.adresse"));
        contact.setCodePostal(Integer.parseInt(request.getParameter("contact.codePostal")));
        contact.setVille(request.getParameter("contact.ville"));
        contact.setMobile(request.getParameter("contact.mobile"));
        contact.setTelephone(request.getParameter("contact.telephone"));
        ContactManagerRemote contactManagerRemote = EjbLocator.getLocator().getContactManager();


        Contact newContact = contactManagerRemote.ajouterContact(contact);
        RequestDispatcher rd = null;
        if(newContact.getId() > 0) {
            rd = request.getRequestDispatcher("/WEB-INF/jsps/contactAdded.jsp");
        }
        else {
            rd = request.getRequestDispatcher("/WEB-INF/jsps/contactNotAdded.jsp");
        }
        rd.forward(request, response);
    }
}



