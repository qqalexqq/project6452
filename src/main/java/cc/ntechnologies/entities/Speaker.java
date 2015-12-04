package cc.ntechnologies.entities;

import com.googlecode.objectify.annotation.*;

@Entity
public class Speaker {
	@Id public Long id;
	@Index public String firstname;
	@Index public String lastname;
	@Index public String description;
	// PHOTO

	public Speaker () {

	}

	public Speaker(String firstname, String lastname, String description){
		this.firstname = firstname;
		this.lastname = lastname;
		this.description = description;
	}
}
