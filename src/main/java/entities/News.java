package entities;

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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getId() {
		return id;
	}
	
	
	

}
