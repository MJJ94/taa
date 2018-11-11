package myapp.javaObjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Person implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7379999702455069154L;

	private Long id;

    private String firstName;
    
    private String lastName;

    private List<Place> places;
    
    private List<Sport> sports;
    
    private String email;
    
    private String password;
    
    private List<Role> roles;

    

	public Person() {
    }

    public Person(String firstName, String lastName,List<Place> places, List<Sport>sports,String email, String password) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.places = places;
        this.sports = sports;
        this.email=email;
        this.setPassword(password);
    }
    public Person(String firstName, String lastName,String email, String password) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
        this.roles= new ArrayList<>();
        this.roles.add(Role.ROLE_ADMIN);
    }
   


	public Person(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    @Column(nullable= false)
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    @Column(nullable= false)
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
    
    @Column(nullable= false)
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

    @Column(nullable= false)
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany
    public List<Place> getPlace() {
        return places;
    }

    public void setPlace(List<Place> places) {
        this.places = places;
    }
    
    @ManyToMany
    public List<Sport> getSport() {
    	return sports;
    }
    
    public void setSport(List<Sport>sports) {
    	this.sports = sports;
    }
    
   
    @Transient
    public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
    public String toString() {
    	List<String> placesString = new ArrayList<String>();
		for(Place l:places) {
            placesString.add(l.getName());
    		}
        return "Personne [id=" + id + ", name=" + firstName + " " + lastName + ", places= " + placesString;

    }
}
