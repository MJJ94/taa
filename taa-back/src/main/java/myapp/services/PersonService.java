package myapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import myapp.exception.CustomException;
import myapp.javaObjects.Person;
import myapp.securityConfig.JwtTokenProvider;


@RestController
@RequestMapping("/personService")
@Api(value= "PersonServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class PersonService {

	@Autowired
	PersonDao personDao;

	@Autowired
	PlaceDao lieuDao;

	@Autowired
	SportDao sportDao;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping(value = "/{id}")
	@ApiOperation("get person with spicific id")
	@ApiResponse(code=200,message="Ok",response=Person.class)

	public Person getPerson(@PathVariable("id") Long id) {
		Optional<Person> person = personDao.findById(id);
		return person.get();
	}

	@GetMapping("all")
	public List<Person> getAllPerson() {
		return personDao.findAll();
	}

	@GetMapping(value = "/{firstName}")
	public boolean existsByFirstName(@PathVariable("firstName") String firstName) {
		return personDao.existsByFirstName(firstName);
	}

	@PostMapping("/person/add")
	public void addPerson(@RequestBody Person p) {
		personDao.save(p);
	}

	@DeleteMapping("/person/delete")
	public void deletePerson(@RequestBody Person p) {
		personDao.delete(p);

	}

	@GetMapping(value = "/email/{email}")
	@ApiOperation("get person with spicific email")
	@ApiResponse(code=200,message="Ok",response=Person.class)
	public Person findByEmail(@PathVariable("email") String email) {
		return personDao.findByEmail(email);
	}

		@PostMapping("/signin")
		public String signin(String firstNamme, String password) {
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(firstNamme, password));
				return jwtTokenProvider.createToken(firstNamme, personDao.findByfirstName(firstNamme).getRoles());
			} catch (AuthenticationException e) {
				throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
			}
		}
		@PostMapping("/signup")
		public String signup( @RequestBody Person person) {
			System.out.println("test "+person.getFirstName());	
			System.out.println("test "+person.getLastName());	
			System.out.println("test "+person.getPassword());	
			if (!personDao.existsByFirstName(person.getFirstName())) {
				//person.setPassword(passwordEncoder.encode(person.getPassword()));
				personDao.save(person);
				return jwtTokenProvider.createToken(person.getFirstName(), person.getRoles());
			} else {
				throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
			}
		}


}
