package myapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import myapp.javaObjects.Person;

@Transactional
public interface PersonDao extends JpaRepository<Person, Long> {
//	@Query("select p from Person p Where p.name = ?1")
//	public Person findByName(String name);

	@Query ("select p from Person p Where p.email = ?1")
	public Person findByEmail (String email);
}
