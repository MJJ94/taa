package myapp.javaObjects;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sport{
	/**
	* 
	*/
    @Id
    @GeneratedValue
	private Long id;

	private String name;

	public Sport() {
		super();
	}

	public Sport(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
