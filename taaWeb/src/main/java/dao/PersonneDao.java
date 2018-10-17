package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javaObjects.Personne;


public class PersonneDao implements GenericDao<Personne> {
	EntityManager manager;

	public PersonneDao(EntityManager manager) {
		this.manager = manager;
	}

	public Personne findById(long id) {
		Personne Personne = (Personne)manager.createQuery("SELECT l FROM Personne l WHERE l.id=:id", Personne.class).setParameter("id", id)
				.getSingleResult();
		return Personne;
	}

	public List<Personne> findAll() {
		List<Personne> personnes = new ArrayList<Personne>();
		personnes = manager.createQuery("SELECT l FROM Personne l", Personne.class).getResultList();
		return personnes;
	}

	public Personne add(Personne o) {
		manager.persist(o);
		return o;
	}

	public void delete(Personne o) {
		manager.remove(o);
	}

}
