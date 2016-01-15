package cc.ntechnologies.controller;

import cc.ntechnologies.FacesUtils;
import cc.ntechnologies.entities.Conference;
import cc.ntechnologies.entities.Room;
import cc.ntechnologies.entities.Speaker;
import cc.ntechnologies.service.ConferenceService;
import cc.ntechnologies.service.RoomService;
import cc.ntechnologies.service.SpeakerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("request")
public class ConferenceController implements Serializable {

    private static final long serialVersionUID = 1L;

    private ConferenceService conferenceService;
    private SpeakerService speakerService;
    private RoomService roomService;
    private FacesUtils facesUtils;

    private Map<String, Long> speakersMap = new HashMap<String, Long>();
    private Map<String, Long> roomsMap = new HashMap<String, Long>();

    @Size(min=1, message="Please provide talk topic.")
    private String topic;

    @NotNull(message="Please provide talk date.")
    private Date date;

    @NotNull(message="Please provide talk speaker.")
    private Long speakerId;

    @NotNull(message="Please provide talk room.")
    private Long roomId;

    @Inject
    public ConferenceController(final ConferenceService conferenceService, final SpeakerService speakerService, final RoomService roomService, FacesUtils facesUtils) {
        List<Speaker> speakersList = speakerService.getAll(0, Integer.MAX_VALUE);

        for (Speaker speaker : speakersList) {
            this.speakersMap.put(speaker.getFullName(), speaker.getId());
        }

        List<Room> roomList = roomService.getAll(0, Integer.MAX_VALUE);

        for (Room room : roomList) {
            this.roomsMap.put(room.getFullRoomName(), room.getId());
        }

        this.conferenceService = conferenceService;
        this.speakerService = speakerService;
        this.roomService = roomService;
        this.facesUtils = facesUtils;
    }

    public void createConference() {
        Speaker speaker = speakerService.findSpeakerById(this.speakerId);
        Room room = roomService.findRoomById(this.roomId);

        Conference conference = new Conference(this.topic, this.date, room, speaker);
        conferenceService.save(conference);

        facesUtils.addSuccessMessage("Added talk " + conference.getTopic());
    }

    public Map<String, Long> getSpeakersMap() {
        return this.speakersMap;
    }

    public Map<String, Long> getRoomsMap() {
        return this.roomsMap;
    }

    public String getTopic() {
        return this.topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public Long getSpeakerId() {
        return this.speakerId;
    }
    public void setSpeakerId(Long speakerId) {
        this.speakerId = speakerId;
    }
    public Long getRoomId() {
        return this.roomId;
    }
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
