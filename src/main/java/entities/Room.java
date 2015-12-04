package entities;

import com.googlecode.objectify.annotation.*;


@Entity
public class Room {

	@Id Long id ; 
	@Index private String building;
	@Index private int number;
	
	
	public Room ()  {
		
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Long getId() {
		return id;
	}
	
	
	
}
