package myapp;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
	

}
