package cc.ntechnologies.entities;

import com.googlecode.objectify.annotation.*;

import java.io.Serializable;

@Entity
public class Speaker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	@Index
	private String firstname;
	@Index
	private String lastname;
	@Index
	private String description;
	// PHOTO

	public Speaker () {

	}

	public Speaker(String firstname, String lastname, String description){
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setDescription(description);
	}

	public String getFullName() { return String.format("%s %s", this.getFirstname(), this.getLastname()); }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
