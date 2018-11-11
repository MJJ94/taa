package myapp.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import myapp.dao.PlaceDao;
import myapp.dao.PersonDao;
import myapp.javaObjects.Place;

@RestController
@RequestMapping("/placeService")
@Api(value= "placeServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class PlaceService {
	private static final Logger log = LoggerFactory.getLogger(PlaceService.class);

	@Autowired
	PlaceDao placeDao;

	@Autowired
	PersonDao personneDao;

	@GetMapping(value = "/id/{id}")
	@ApiOperation("get place with spicific id")
	public Place getPLace(@PathVariable("id") Long id) {
		log.info("Getting city by id: " + id);
		Optional<Place> place = placeDao.findById(id);

		return place.get();
	}

	@GetMapping(value = "/places/all")
	@ApiOperation("get all places ")
	public List<Place> getAllPlaces() {
		log.info("Getting all places");
		List<Place> places = placeDao.findAll();

		return places;
	}

	@PostMapping("/place/add")
	@ApiOperation("add a new place")
	public void addPlace(@RequestBody Place l) {
		log.info("Adding new place: " + l.getName());
		placeDao.save(l);
	}

	@DeleteMapping("/place/add")
	@ApiOperation("delete a place")
	public void deletePlace(@RequestBody Place l) {
		log.info("Deleting " + l.getName());
		placeDao.delete(l);

	}

}
