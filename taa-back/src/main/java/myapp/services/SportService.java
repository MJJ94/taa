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
import myapp.dao.SportDao;

import myapp.javaObjects.Sport;

@RestController
@RequestMapping("/sportService")
@Api(value = "sportServiceApi", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class SportService {
	private static final Logger log = LoggerFactory.getLogger(SportService.class);

	@Autowired
	private SportDao sportDao;

	@GetMapping(value = "/id/{id}")
	@ApiOperation("get sport with spicific id")
	public Sport getSport(@PathVariable("id") String id) {
		log.info("Getting sport by id: " + id);
		Optional<Sport> sport = sportDao.findById(Long.parseLong(id));
		return sport.get();
	}

	@PostMapping("/sport/add")
	@ApiOperation("add a new sport")
	public void addSport(@RequestBody Sport s) {
		log.info("adding Sport: " + s.getItemName());
		sportDao.save(s);
	}

	@DeleteMapping("/sport/delete")
	@ApiOperation("delete a sport")
	public void deleteSport(@RequestBody Sport s) {
		log.info("Deleting sport " + s.getItemName());
		sportDao.delete(s);
	}

	@GetMapping(value = "/sports/all")
	@ApiOperation("get all sport")
	public List<Sport> getAllSports() {
		log.info("Getting all sports");
		List<Sport> sports = sportDao.findAll();

		return sports;
	}

}
