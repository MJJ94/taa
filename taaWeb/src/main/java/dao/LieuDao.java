package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javaObjects.Lieu;

public class LieuDao implements GenericDao<Lieu> {

	EntityManager manager;

	public LieuDao(EntityManager manager) {
		this.manager = manager;
	}

	public Lieu findById(long id) {
		Lieu lieu = (Lieu)manager.createQuery("SELECT l FROM Lieu l WHERE l.id=:id", Lieu.class).setParameter("id", id)
				.getSingleResult();
		return lieu;
	}

	public List<Lieu> findAll() {
		List<Lieu> lieux = new ArrayList<Lieu>();
		lieux = manager.createQuery("SELECT l FROM Lieu l", Lieu.class).getResultList();
		return lieux;
	}

	public Lieu add(Lieu o) {
		manager.persist(o);
		return o;
	}

	public void delete(Lieu o) {
		manager.remove(o);
	}

}
