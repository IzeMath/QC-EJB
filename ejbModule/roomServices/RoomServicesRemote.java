package roomServices;

import java.util.List;

import javax.ejb.Remote;

import org.quizcon.Room;

@Remote
public interface RoomServicesRemote {
	
	public int createRoom();
	public void addPlayer(int id);
	public void removePlayer(int id);
	public List<Room> getListRoom();
	public boolean exist(int id);

}
