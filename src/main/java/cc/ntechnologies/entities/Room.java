package cc.ntechnologies.entities;

import com.googlecode.objectify.annotation.*;

import java.io.Serializable;


@Entity
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

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

    public String getFullRoomName() {
        return this.building + " " + this.number;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Room))//changed this from (getClass() != obj.getClass())
            return false;
        Room other = (Room) obj;
        if (this.getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!this.getId().equals(other.getId()))
            return false;
        return true;
    }
}
