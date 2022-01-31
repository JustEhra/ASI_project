package ejbUser;

import com.google.common.hash.Hashing;
import ejbAgenda.Contact;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

@Stateless
@LocalBean
public class UserManager implements UserManagerRemote {

    @PersistenceContext
    EntityManager em;

    public User ajouterUser(User user) {
        em.persist(user);
        return user;
    }
    public Collection<User> listerUser() {return em.createQuery("SELECT c FROM User c").getResultList();}
    public User getUserByMail(String Mail){
        List<User> user = em.createQuery("SELECT u FROM User u WHERE u.mail = '" + Mail+"'").getResultList();
        if(user.isEmpty()) return null;
        return user.get(0);
    }

    public User getUserByMailAndPassword(String Mail,String Pass){
        String sha256hex = Hashing.sha256()
                .hashString(Pass, StandardCharsets.UTF_8)
                .toString();

        List<User> user = em.createQuery("SELECT u FROM User u WHERE u.mail = '" + Mail + "' AND u.password ='" + sha256hex + "'").getResultList();
        if(user.isEmpty()) return null;
        return user.get(0);
    }


}