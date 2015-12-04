package entities;

import com.googlecode.objectify.annotation.*;;


@Entity
public class Speaker {
	
	@Id private Long id;
	@Index private String firstname;
	@Index private String lastname;
	@Index private String description;
	// PHOTO
	
	
	public Speaker () {
		
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	

	
}
