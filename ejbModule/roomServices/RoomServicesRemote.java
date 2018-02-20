package roomServices;

import java.util.List;

import javax.ejb.Remote;

import org.quizcon.Room;

@Remote
public interface RoomServicesRemote {
	
	public int createRoom(String name, String password);
	public void addPlayer(int id);
	public void removePlayer(int id);
	public List<Room> getListRoom();
	public boolean canAccess(int id, String password);
	public void deleteRoom(int id);

}
