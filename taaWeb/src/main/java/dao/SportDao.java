package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javaObjects.Sport;

public class SportDao implements GenericDao<Sport>{
	EntityManager manager;

	public SportDao(EntityManager manager) {
		this.manager = manager;
	}

	public Sport findById(long id) {
		Sport Sport = (Sport)manager.createQuery("SELECT l FROM Sport l WHERE l.id=:id", Sport.class).setParameter("id", id)
				.getSingleResult();
		return Sport;
	}

	public List<Sport> findAll() {
		List<Sport> sports = new ArrayList<Sport>();
		sports = manager.createQuery("SELECT l FROM Sport l", Sport.class).getResultList();
		return sports;
	}

	public Sport add(Sport o) {
		manager.persist(o);
		return o;
	}

	public void delete(Sport o) {
		manager.remove(o);
	}

}
