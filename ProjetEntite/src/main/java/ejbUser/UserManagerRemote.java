package ejbUser;

import hw.Produit;

import javax.ejb.Remote;
import java.util.Collection;
import java.util.List;

@Remote
public interface UserManagerRemote {

    public User ajouterUser(User user);

    public Collection<User> listerUser();

    public User getUserByMailAndPassword(String Mail,String Password);
}