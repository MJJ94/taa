package myapp.javaObjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Personne implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7379999702455069154L;

	private Long id;

    private String name;

    private List<Lieu> lieux;
    
    private List<Sport> sports;

    public Personne() {
    }

    public Personne(String name, List<Lieu> lieux, List<Sport>sports) {
        this.name = name;
        this.lieux = lieux;
        this.sports = sports;
    }

    public Personne(String name) {
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

    @ManyToMany
    public List<Lieu> getLieu() {
        return lieux;
    }

    public void setLieu(List<Lieu> lieux) {
        this.lieux = lieux;
    }
    
    @ManyToMany
    public List<Sport> getSport() {
    	return sports;
    }
    
    public void setSport(List<Sport>sports) {
    	this.sports = sports;
    }

    @Override
    public String toString() {
    	List<String> lieuxString = new ArrayList<String>();
		for(Lieu l:lieux) {
            lieuxString.add(l.getName());
    		}
        return "Personne [id=" + id + ", name=" + name + ", lieux= " + lieuxString;

    }
}
