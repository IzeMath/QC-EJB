package roomServices;

import java.util.List;

import javax.ejb.Remote;

import org.quizcon.Room;

@Remote
public interface RoomServicesRemote {
	
	public void createRoom(String name, String password);
	public void addPlayer(String id);
	public List<Room> getListRoom();

}
