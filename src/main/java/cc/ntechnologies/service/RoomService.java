package cc.ntechnologies.service;

import cc.ntechnologies.dao.RoomDao;
import cc.ntechnologies.entities.Room;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Service
public class RoomService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RoomDao roomDao;

    public void save(Room room) {
        roomDao.save(room);
    }

    public void delete(Room room) {
        roomDao.delete(room);
    }

    public Room findRoomById(Long id) {
        return roomDao.findById(id);
    }

    public List<Room> getAll(int first, int pageSize) {
        return roomDao.getAll(first, pageSize);
    }

    public int getNumberOfRooms() {
        return roomDao.getNumberOfRooms();
    }
}
