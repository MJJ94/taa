package myapp.javaObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Place{
	 /**
	 * 
	 */

    @Id
    @GeneratedValue
	private Long id;

	    private String itemName;

	    public Place() {
	        super();
	    }

	    public Place(String itemName) {
	        this.itemName = itemName;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getItemName() {
	        return itemName;
	    }

	    public void setItemName(String itemName) {
	        this.itemName = itemName;
	    }
}
