package entities;

import com.googlecode.objectify.annotation.*;

@Entity
public class Speaker {
	@Id private Long id;
	@Index private String firstname;
	@Index private String lastname;
	@Index private String description;
	// PHOTO

	public Speaker () {
		
	}
}
