package myapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import myapp.javaObjects.Personne;

@Transactional
public interface PersonneDao extends JpaRepository<Personne, Long>{

}
