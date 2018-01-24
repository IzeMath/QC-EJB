package userService;

import javax.ejb.Remote;

import org.user.Utilisateur;

@Remote
public interface UserServicesRemote {

	public Utilisateur login(String email, String password);
	void createUser(String name, String fname, String username, String email, String password);
	public String test();
	

}
