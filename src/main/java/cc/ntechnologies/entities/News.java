package cc.ntechnologies.entities;

import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.*;

@Entity
public class News {
	@Id Long id ; 
	@Index private String title;
	@Index private String text;
	// PHOTO

	//relations
	@Index private List<Ref<Organizer>> organizers;

	public News() {
		
	}
}
