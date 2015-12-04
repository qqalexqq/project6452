package entities;

import com.googlecode.objectify.annotation.*;

@Entity
public class Partner {

	
	@Id Long id ; 
	@Index private String name;

	
	// PHOTO
	
	public Partner() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
}
