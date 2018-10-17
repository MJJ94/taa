package javaObjects;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.LieuDao;
import dao.PersonneDao;
import dao.SportDao;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createPersonnes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		test.listPersonnes();
		manager.close();
		factory.close();
	}

	private void createPersonnes() {
		LieuDao lieuDao = new LieuDao(manager);
		PersonneDao personneDao = new PersonneDao(manager);
		SportDao sportDao = new SportDao(manager);
		int numOfPersonnes = manager.createQuery("Select a From Personne a", Personne.class).getResultList().size();
		
		if (numOfPersonnes == 0) {
			Lieu beaulieau = new Lieu("beaulieau");
			Lieu villjean = new Lieu("villjean");
			List<Lieu> lieux = new ArrayList<Lieu>();
			lieux.add(beaulieau);
			lieux.add(villjean);
			
			Sport kayak = new Sport("kayak");
			Sport basket = new Sport("basket-ball");
			List<Sport> sports = new ArrayList<Sport>();
			sports.add(kayak);
			sports.add(basket);
			
			lieuDao.add(beaulieau);
			lieuDao.add(villjean);
			sportDao.add(kayak);
			sportDao.add(basket);
			
			personneDao.add(new Personne("Jakab Gipsz", lieux,sports));
			personneDao.add(new Personne("Captain Nemo", lieux,sports));
			personneDao.add(new Personne("Mahmoud JAMMAL", lieux,sports));
			personneDao.add(new Personne("Mouhyi-eddine", lieux,sports));

		}
	}

	private void listPersonnes() {
		List<Personne> resultList = manager.createQuery("Select a From Personne a", Personne.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Personne next : resultList) {
			System.out.println("next personne: " + next);
		}
	}
}
