package userService;

import java.util.Hashtable;
import java.util.List;

import javax.ejb.Remote;

import org.user.Statistique;
import org.user.Utilisateur;

@Remote
public interface UserServicesRemote {

	public Utilisateur login(String email, String password);
	public void createUser(String username, String email, String password);
	public void createUser(final String username, final String email, final String password, List<Statistique> lStat);
	public Hashtable<String, Float> getStats(Utilisateur user);
	
	

}
