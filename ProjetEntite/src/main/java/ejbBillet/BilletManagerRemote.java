package ejbBillet;

import javax.ejb.Remote;
import java.util.Collection;

@Remote
public interface BilletManagerRemote {
    Billet ajouterBillet(Billet billet);

    Collection<Billet> listerBillet();

}