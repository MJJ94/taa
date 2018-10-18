package myapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myapp.dao.LieuDao;
import myapp.dao.PersonneDao;
import myapp.dao.SportDao;
import myapp.javaObjects.Lieu;
import myapp.javaObjects.Personne;
import myapp.javaObjects.Sport;

@RestController
@RequestMapping("/personneService")
public class PersonneService {
//	EntityManager manager = EntityManagerHelper.getEntityManager();

	@Autowired
	PersonneDao personneDao;

	@Autowired
	LieuDao lieuDao;

	@Autowired
	SportDao sportDao;

	@GetMapping(value = "/{id}")
	public Personne getPersonne(@PathVariable("id") Long id) {
		// sportDao.giveSportNautique();
		Optional<Personne> personne = personneDao.findById(id);
		return personne.get();
	}

	@GetMapping(value = "/name/{name}")
	public Personne getPersonneByName(@PathVariable("name") String name) {
		// sportDao.giveSportNautique();
		Personne personne = personneDao.findByName(name);
		return personne;
	}

	@PostMapping("/personne")
	public void addPerson(@RequestBody Personne p) {
		personneDao.save(p);
	}

	@DeleteMapping("/personne")
	public void deletePerson(@RequestBody Personne p) {
		personneDao.delete(p);

	}
}
