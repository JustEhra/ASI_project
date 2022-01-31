package ejbAgenda;

import javax.ejb.Remote;
import java.util.Collection;

@Remote
public interface ContactManagerRemote {

    Contact ajouterContact(Contact contact);

    Collection<Contact> listerContact();

}