package cc.ntechnologies.entities;

import com.googlecode.objectify.annotation.*;

@Entity
public class Partner {
	@Id Long id;
	@Index private String name;
	// PHOTO
	
	public Partner() {
		
	}
}
