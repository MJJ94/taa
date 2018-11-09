package myapp;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jsonwebtoken.lang.Arrays;
import myapp.dao.PersonDao;
import myapp.javaObjects.Person;
//import myapp.javaObjects.Role;
import myapp.javaObjects.Sport;
import myapp.services.PersonService;

@SpringBootApplication
public class SampleDataJpaApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleDataJpaApplication.class, args);
	}
	
//	@Override
//
//	public void run(String... params) throws Exception {
//
//		Person admin = new Person();
//
//		admin.setFirstName("admin");
//
//		admin.setPassword("admin");
//
//		admin.setEmail("admin@email.com");
//
//		List<Role> roles = new ArrayList<Role>();
//		
//		admin.setRoles(roles);
//		
//		PersonService personService;
//		
//		personService.signup(admin);
//
//		Person client = new Person();
//
//		client.setFirstName("client");
//
//		client.setPassword("client");
//
//		client.setEmail("client@email.com");
//		
//		//client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));
//
//		personService.signup(client);
//
//		Person p1 = new Person("toto","titi","titi.toto@gmail.com",null);
//
//		Sport tennis = new Sport("tennis");
//
//		Sport surf = new Sport("surf");
//
//		Sport paddle = new Sport("paddle");
//
//		Sport foot = new Sport("foot");
//
//		Sport golf = new Sport("golf");
//		
//		
//
//		//personService.save(p1, new HashSet<>(Arrays.asList(tennis,surf,foot,paddle,golf)));
//
//	}

}
