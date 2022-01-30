package ejbBillet;

import ejbAgenda.Contact;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
@LocalBean
public class BilletManager implements BilletManagerRemote {

    @PersistenceContext
    EntityManager em;

    public Billet ajouterBillet(Billet billet) {
        em.persist(billet);
        return billet;
    }
    public Collection<Billet> listerBillet() {return em.createQuery("SELECT c FROM Billet c").getResultList();}

}