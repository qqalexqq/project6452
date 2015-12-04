package cc.ntechnologies.entities;

import com.googlecode.objectify.annotation.*;

@Entity
public class Room {
	@Id Long id ; 
	@Index private String building;
	@Index private int number;

	public Room ()  {
		
	}
}
