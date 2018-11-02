package myapp.services;

import java.util.Optional;

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
//	EntityManager manager = EntityManagerHelper.getEntityManager();

	@Autowired
	PersonDao personDao;

	@Autowired
	PlaceDao lieuDao;

	@Autowired
	SportDao sportDao;

	@GetMapping(value = "/{id}")
	@ApiOperation("get person with spicific id")
	@ApiResponse(code=200,message="Ok",response=Person.class)
	
	public Person getPerson(@PathVariable("id") Long id) {
		Optional<Person> person = personDao.findById(id);
		return person.get();
	}

//	@GetMapping(value = "/name/{name}")
//	public Person getPersonByName(@PathVariable("name") String name) {
//		Person person = personDao.findByName(name);
//		return person;
//	}

	@PostMapping("/person")
	public void addPerson(@RequestBody Person p) {
		personDao.save(p);
	}

	@DeleteMapping("/person")
	public void deletePerson(@RequestBody Person p) {
		personDao.delete(p);

	}
	
	@GetMapping(value = "/email/{email}")
	@ApiOperation("get person with spicific email")
	@ApiResponse(code=200,message="Ok",response=Person.class)
	public Person findByEmail(@PathVariable("email") String email) {
		return personDao.findByEmail(email);
	}
}
