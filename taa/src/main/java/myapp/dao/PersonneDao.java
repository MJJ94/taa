package myapp.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import myapp.javaObjects.Personne;
import myapp.javaObjects.Sport;

@Transactional
public interface PersonneDao extends JpaRepository<Personne, Long>{
	@Query("select p from Personne p Where p.name = ?1")
	public Optional<Personne> findByName(String name);
	
}
