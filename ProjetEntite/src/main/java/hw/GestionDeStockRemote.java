package hw;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface GestionDeStockRemote {
    public Produit ajouter(Produit produit);

    public Produit rechercherProduit(int id);

    public List<Produit> listerTousLesProduits();
}