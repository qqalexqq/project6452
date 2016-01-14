package cc.ntechnologies.controller;

import cc.ntechnologies.FacesUtils;
import cc.ntechnologies.entities.Room;
import cc.ntechnologies.service.RoomService;
import org.hibernate.validator.constraints.Range;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Controller
@Scope("request")
public class RoomController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RoomService roomService;

    @Inject
    private FacesUtils facesUtils;

    @Size(min=1, message="Please provide room building name.")
    private String building;

    @Range(min=0, message="Please provide room building number.")
    @NotNull(message="Please provide room building number.")
    private int number;

    public void createRoom() {
        Room room = new Room(building, number);
        roomService.save(room);

        facesUtils.addSuccessMessage("Added room " + room.getFullRoomName());
    }

    public String getBuilding() {
        return this.building;
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
