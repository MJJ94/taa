package myapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import myapp.javaObjects.Lieu;

@Transactional
public interface LieuDao extends JpaRepository<Lieu, Long> {
	



}
