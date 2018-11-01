package myapp.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import myapp.javaObjects.Sport;

@RestController
@RequestMapping("/sportService")
@CrossOrigin
public class SportService {
	
	@Autowired
	SportDao sportDao;
	
	@Autowired
	PersonneDao personneDao;

	@Autowired
	LieuDao lieuDao;
	
	@GetMapping(value="/{id}")
	public Sport getSport(@PathVariable("id") String id) {
		Optional<Sport> sport = sportDao.findById(Long.parseLong(id));
		return sport.get();
	}
	
	@GetMapping(value = "/name/{name}")
	public Sport getSportByName(@PathVariable("name") String name) {
		// sportDao.giveSportNautique();
		Sport sport = sportDao.findByName(name);
		return sport;
	}

	
	@PostMapping("/sport")
	public void addSport(@RequestBody Sport s) {
		sportDao.save(s);
	}
	
	@DeleteMapping("/sport")
	public void deleteSport(@RequestBody Sport s) {
		sportDao.delete(s);
	}
	
	@GetMapping(value = "/sports")
	public List<Sport> getAllSports() {
		List<Sport> sports = sportDao.findAll();

		return sports;
	}
	
	
	

}
