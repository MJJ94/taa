package myapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import myapp.javaObjects.Place;
import myapp.javaObjects.Person;

@Transactional
public interface PlaceDao extends JpaRepository<Place, Long> {
	
	@Query("select p from Place p Where p.name = ?1")
	public Place findByName(String name);


}
