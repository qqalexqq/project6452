package cc.ntechnologies.entities;

import com.googlecode.objectify.annotation.*;


@Entity
public class Room {
	@Id
    private Long id;

	@Index
    private String building;

	@Index
    private int number;

	public Room()  {

	}

    public Room(String building, int number) {
        this.building = building;
        this.number = number;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
}
