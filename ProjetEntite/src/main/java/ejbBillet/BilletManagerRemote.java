package ejbBillet;

import ejbUser.User;

import javax.ejb.Remote;
import java.util.Collection;

@Remote
public interface BilletManagerRemote {

    public Billet ajouterBillet(Billet billet);

    public Collection<Billet> chercheBillet(String _depart, String _arivee, String _date);

    public Collection<Billet> chercheBilletbyUser(User user);

    public Billet findBilletById(int id);

    public void buyBillet(Billet billet, User user);
    }