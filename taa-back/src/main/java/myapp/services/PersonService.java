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

import io.swagger.annotations.ApiResponse;

import myapp.dao.PlaceDao;
import myapp.dao.PersonDao;
import myapp.dao.SportDao;
import myapp.javaObjects.Person;


@RestController
@RequestMapping("/personService")
@Api(value= "PersonServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class PersonService {
	private static final Logger log = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	PersonDao personDao;

	@Autowired
	PlaceDao placeDao;

	@Autowired
	SportDao sportDao;


	

	@GetMapping(value = "/id/{id}")
	@ApiOperation("get person with spicific id")
	@ApiResponse(code=200,message="Ok",response=Person.class)

	public Person getPerson(@PathVariable("id") Long id) {
		log.info("Getting person with id " + id);
		Optional<Person> person = personDao.findById(id);
		return person.get();
	}

	@GetMapping("/person/all")
	@ApiOperation("get all person")
	public List<Person> getAllPerson() {
		log.info("Getting all persons");
		return personDao.findAll();
	}

	@GetMapping(value = "/person/{firstName}")
	@ApiOperation("get person with spicific firstname")
	public boolean existsByFirstName(@PathVariable("firstName") String firstName) {
		log.info("Getting person by his first name");
		return personDao.existsByFirstName(firstName);
	}

	@PostMapping("/person/add")
	@ApiOperation("add a new person")
	public void addPerson(@RequestBody Person p) {
		log.info("Adding new Person: " + p.toString());
		personDao.save(p);
	}

	@DeleteMapping("/person/delete")
	@ApiOperation("delete a person")
	public void deletePerson(@RequestBody Person p) {
		log.info("Deleting person: " + p.toString());
		personDao.delete(p);

	}

	@GetMapping(value = "/email/{email}")
	@ApiOperation("get person with spicific email")
	@ApiResponse(code=200,message="Ok",response=Person.class)
	public Person findByEmail(@PathVariable("email") String email) {
		log.info("Getting person by email " + email);
		return personDao.findByEmail(email);
	}




}
