package myapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myapp.dao.LieuDao;
import myapp.dao.PersonneDao;
import myapp.javaObjects.Lieu;
import myapp.javaObjects.Personne;

@RestController
@RequestMapping("/lieuService")
public class LieuService {

	@Autowired
	LieuDao lieuDao;
	
	@Autowired
	PersonneDao personneDao;
	
	@GetMapping(value = "/{id}")
	public Lieu getLieu(@PathVariable("id") Long id) {
		Optional<Lieu> lieu = lieuDao.findById(id);
		
		return lieu.get();
	}
	
	@PostMapping("/lieu")
	public void addLieu(@RequestBody Lieu l) {
		lieuDao.save(l);
	}

	@DeleteMapping("/lieu")
	public void deleteLieu(@RequestBody Lieu l) {
		lieuDao.delete(l);

	}
	
}
