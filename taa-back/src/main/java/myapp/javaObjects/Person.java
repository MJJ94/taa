package myapp.javaObjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Person{
	/**
	 * 
	 */

	private Long id;

	private String firstName;

	private String lastName;

	private Place place;

	private List<Sport> sports;

	private String email;

	private String password;

	public Person() {
	}

	public Person(String firstName, String lastName, Place place, List<Sport> sports, String email, String password) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.place = place;
		this.sports = sports;
		this.email = email;
		this.setPassword(password);
	}
	
	public Person(String lastName, Place place) {
		this.lastName = lastName;
		this.place = place;
	}

	public Person(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	@Column(nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToOne
	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	@ManyToMany
	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", name=" + firstName + " " + lastName + ", place= " + place.getName();

	}
}
