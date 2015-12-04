package entities;

import com.googlecode.objectify.annotation.*;

@Entity
public class User {
	@Id Long id ; 
	@Index private String username;
	@Index private String password;

	public User () {
		
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
