package entities;

import com.googlecode.objectify.annotation.*;

@Entity
public class Organizer {
	@Id Long id;
	@Index private String firstname;
	@Index private String lastname;

	public Organizer (){
		
	}
}
