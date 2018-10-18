package myapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import myapp.javaObjects.Lieu;
import myapp.javaObjects.Personne;

@Transactional
public interface LieuDao extends JpaRepository<Lieu, Long> {
	
	@Query("select l from Lieu l Where l.name = ?1")
	public Lieu findByName(String name);


}
