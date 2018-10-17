package javaObjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Lieu implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -2687755706786960033L;

	private Long id;

	    private String name;

	    private List<Personne> personnes = new ArrayList<Personne>();

	    
	    public Lieu() {
			// TODO Auto-generated constructor stub
		}
	    public Lieu(String name) {
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

	    @ManyToMany(mappedBy = "lieu", cascade = CascadeType.PERSIST)
	    public List<Personne> getPersonnes() {
	        return personnes;
	    }
	    

	    public void setPersonnes(List<Personne> personnes) {
	        this.personnes = personnes;
	    }
}
