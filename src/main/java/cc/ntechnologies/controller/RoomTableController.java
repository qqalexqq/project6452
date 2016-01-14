package cc.ntechnologies.controller;

import cc.ntechnologies.FacesUtils;
import cc.ntechnologies.entities.Room;
import cc.ntechnologies.service.RoomService;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@Scope("view")
public class RoomTableController implements Serializable {
    private static final long serialVersionUID = 1L;

    private RoomService roomService;
    private FacesUtils facesUtils;

    private LazyDataModel<Room> roomModel;
    private Room selectedRoom;

    private static final Logger log = Logger.getLogger(RoomTableController.class.getName());

    @Inject
    public RoomTableController(final RoomService roomService, FacesUtils facesUtils) {
        roomModel = new LazyDataModel<Room>() {
            @Override
            public List<Room> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                return roomService.getAll(first, pageSize);
            }

            @Override
            public Long getRowKey(Room room) {
                return (room == null ? null : room.getId());
            }

            @Override
            public Room getRowData(String rowKey) {
                Long id = Long.parseLong(rowKey);

                for (Room room : (List<Room>) this.getWrappedData()) {
                    if (room.getId().equals(id)) {
                        return room;
                    }
                }

                return null;
            }
        };

        roomModel.setRowCount(roomService.getNumberOfRooms());

        this.roomService = roomService;
        this.facesUtils = facesUtils;
    }

    public void deleteRoom() {
        roomService.delete(selectedRoom);
        roomModel.setRowCount(roomModel.getRowCount() - 1);

        facesUtils.addSuccessMessage("Room successfully deleted.");
    }

    public void updateRoom() {
        roomService.save(selectedRoom);

        facesUtils.addSuccessMessage("Room successfully updated.");
    }

    public LazyDataModel<Room> getRoomModel() {
        return roomModel;
    }
    public void setRoomModel(LazyDataModel<Room> roomModel) {
        this.roomModel = roomModel;
    }
    public Room getSelectedRoom() {
        return selectedRoom;
    }
    public void setSelectedRoom(Room selectedRoom) {
        this.selectedRoom = selectedRoom;
    }
}
