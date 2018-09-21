package myapp.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myapp.dao.LieuDao;
import myapp.dao.PersonneDao;
import myapp.dao.SportDao;
import myapp.javaObjects.Lieu;
import myapp.javaObjects.Personne;
import myapp.javaObjects.Sport;

@RestController
@RequestMapping("/person")
public class PersonneService {
//	EntityManager manager = EntityManagerHelper.getEntityManager();
	
	@Autowired
	PersonneDao personneDao;
	
	@Autowired
	LieuDao lieuDao;
	
	@Autowired
	SportDao sportDao;
	
	@GetMapping(value="/{id}")
	public Personne getPersonne(@PathVariable("id") String id) {
		//sportDao.giveSportNautique();
		Optional<Personne> personne = personneDao.findById(Long.parseLong(id));
		return personne.get();
	}
	
    public void addPerson(Personne p) {
    	personneDao.save(p);
    }
    
    public void deletePerson(long id) {
    	personneDao.deleteById(id);
    	
    }
}
