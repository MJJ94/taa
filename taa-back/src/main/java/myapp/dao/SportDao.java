package myapp.dao;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import myapp.javaObjects.Sport;

@Transactional
public interface SportDao extends JpaRepository<Sport, Long>{

}
