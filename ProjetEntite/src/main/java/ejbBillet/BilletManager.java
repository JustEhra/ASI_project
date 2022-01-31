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
    public Collection<Billet> chercheBillet(String _depart, String _arivee, String _date) {
        return em.createQuery("SELECT b FROM Billet b WHERE b.depart LIKE '%" + _depart + "%' AND b.arivee LIKE '%" + _arivee + "%' AND b.date LIKE '%" + _date + "%' ORDER BY b.prix").getResultList();
    }

}