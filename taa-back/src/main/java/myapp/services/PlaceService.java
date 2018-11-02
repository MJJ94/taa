package myapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myapp.dao.PlaceDao;
import myapp.dao.PersonDao;
import myapp.javaObjects.Place;

@RestController
@RequestMapping("/placeService")
@CrossOrigin
public class PlaceService {

	@Autowired
	PlaceDao placeDao;

	@Autowired
	PersonDao personneDao;

	@GetMapping(value = "/{id}")
	public Place getLieu(@PathVariable("id") Long id) {
		Optional<Place> place = placeDao.findById(id);

		return place.get();
	}

	@GetMapping(value = "/places")
	public List<Place> getAllPlaces() {
		List<Place> places = placeDao.findAll();

		return places;
	}

	@PostMapping("/place")
	public void addPlace(@RequestBody Place l) {
		placeDao.save(l);
	}

	@DeleteMapping("/place")
	public void deletePlace(@RequestBody Place l) {
		placeDao.delete(l);

	}

}
