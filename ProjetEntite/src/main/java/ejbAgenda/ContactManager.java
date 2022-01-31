package ejbAgenda;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
@LocalBean
public class ContactManager implements ContactManagerRemote {

    @PersistenceContext
    EntityManager em;

    public Contact ajouterContact(Contact contact) {
        em.persist(contact);
        return contact;
    }
    public Collection<Contact> listerContact() {
        // Vous pouvez aussi utiliser une named query définie dans l’entité
        return em.createQuery("SELECT c FROM Contact c").getResultList();

    }
}




