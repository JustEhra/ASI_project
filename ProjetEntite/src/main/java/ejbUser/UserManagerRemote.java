package ejbUser;

import ejbBillet.Billet;
import hw.Produit;

import javax.ejb.Remote;
import java.util.Collection;
import java.util.List;

@Remote
public interface UserManagerRemote {

    public User ajouterUser(User user);

    public Collection<User> listerUser();

    public User getUserByMailAndPassword(String Mail,String Password);
    public User getUserByMail(String Mail);
    public void addNewBillet(User user, Billet billet);
    public User findUserById(int id);
}