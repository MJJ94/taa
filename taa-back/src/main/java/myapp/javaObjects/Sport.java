package myapp.javaObjects;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sport implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -2959708523025785328L;

	private Long id;

	private String name;

	public Sport() {
		super();
	}

	public Sport(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
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
