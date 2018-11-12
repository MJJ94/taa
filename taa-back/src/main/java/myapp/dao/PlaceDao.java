package myapp.dao;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import myapp.javaObjects.Place;

@Transactional
public interface PlaceDao extends JpaRepository<Place, Long> {

}
