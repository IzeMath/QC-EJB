package roomServices;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.quizcon.Room;

/**
 * Session Bean implementation class RoomServices
 */
@Stateless
public class RoomServices implements RoomServicesRemote {

	@PersistenceContext(unitName = "QC-JPA")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public RoomServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int createRoom(final String name, final String password) {
		int id = 0;
		do {
			id = ThreadLocalRandom.current().nextInt(100000, 999999);
		} while (em.find(Room.class, id) != null);
		final Room r = new Room(id, name, password);
		em.persist(r);
		return id;

	}

	@Override
	public void addPlayer(final int id) {
		final Room r = em.find(Room.class, id);
		int oldNbPlayers = r.getNbPlayers();
		r.setNbPlayers(oldNbPlayers++);
		em.merge(r);
	}

	@Override
	public List<Room> getListRoom() {
		final Query query = em.createNamedQuery("getListRoom", Room.class);
		final List<Room> lr = query.getResultList();
		return lr;
	}

	@Override
	public void removePlayer(final int id) {
		final Room r = em.find(Room.class, id);
		int oldNbPlayers = r.getNbPlayers();
		r.setNbPlayers(oldNbPlayers--);
		em.merge(r);

	}

	@Override
	public boolean canAccess(final int id, final String password) {
		final Query query = em.createNamedQuery("canAccess", Room.class);
		query.setParameter("id", id);
		query.setParameter("password", password);
		return !query.getResultList().isEmpty();
	}
}
