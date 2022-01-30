package hw;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class GestionDeStock implements GestionDeStockRemote {

    @PersistenceContext
    EntityManager em;
    public Produit ajouter(Produit produit) {
        em.persist(produit);
        return produit;
    }
    public List<Produit> listerTousLesProduits() {
        return em.createNamedQuery("findAllProducts").getResultList();
    }
    public Produit rechercherProduit(int id) {
        return em.find(Produit.class, id);
    }
}


