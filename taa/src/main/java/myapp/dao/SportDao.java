package myapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import myapp.javaObjects.Sport;

@Transactional
public interface SportDao extends JpaRepository<Sport, Long>{

	
	@Query("select s from Sport s where s.name = 'Mer'")
	public List<Sport> giveSportNautique();
}
