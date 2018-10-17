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
public class Sport implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -2959708523025785328L;

	private Long id;

	    private String name;

	    private List<Personne> personnes = new ArrayList<Personne>();

	    
	    public Sport() {
			// TODO Auto-generated constructor stub
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

	    @ManyToMany(mappedBy = "sport", cascade = CascadeType.PERSIST)
	    public List<Personne> getPersonnes() {
	        return personnes;
	    }
	    

	    public void setPersonnes(List<Personne> personnes) {
	        this.personnes = personnes;
	    }
}
