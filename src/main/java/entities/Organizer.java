package entities;


import com.googlecode.objectify.annotation.*;
@Entity
public class Organizer {
	
	@Id Long id ; 
	@Index private String firstname;
	@Index private String lastname;
	
	
	public Organizer (){
		
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
	public Long getId() {
		return id;
	}

	
}
