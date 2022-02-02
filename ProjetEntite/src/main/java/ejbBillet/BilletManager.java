package ejbBillet;

import ejbUser.User;

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

    public Collection<Billet> chercheBilletbyUser(User user) {
        return em.createQuery("SELECT b FROM Billet b WHERE b.user.id = '" + user.getId() + "'" ).getResultList();
    }

    public Billet findBilletById(int id) {
        return em.find(Billet.class, id);
    }

    public void buyBillet(Billet billet, User user) {

        em.merge(billet);
        em.merge(user);

    }
}