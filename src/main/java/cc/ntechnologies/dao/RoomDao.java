package cc.ntechnologies.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.Serializable;
import java.util.List;

import cc.ntechnologies.entities.Room;
import org.springframework.stereotype.Repository;


@Repository
public class RoomDao implements Serializable {

    private final static long serialVersionUID = 1L;

    public Room findById(Long id) {
        return ofy().load().type(Room.class).id(id).now();
    }

    public void delete(Room room) {
        ofy().delete().entity(room).now();
    }

    public Room save(Room room) {
        ofy().save().entities(room).now();

        return room;
    }

    public List<Room> getAll(int start, int max) {
        return ofy().load().type(Room.class).offset(start).limit(max).list();
    }

    public int getNumberOfRooms() {
        return ofy().load().type(Room.class).count();
    }
}
