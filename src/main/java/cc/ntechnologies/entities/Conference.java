package cc.ntechnologies.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.*;


@Entity
public class Conference implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Index
    private String topic;

    @Index
    private Date date;

    //relations
    private Ref<Speaker> speaker;
    private Ref<Room> room;


    public Conference() {

    }

    public Conference(String topic, Date date, Room room, Speaker speaker) {
        this.topic = topic;
        this.date = date;
        this.setRoom(room);
        this.setSpeaker(speaker);
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
         this.date = date;
    }
    public Room getRoom() {
        return this.room.get();
    }
    public void setRoom(Room room) {
        this.room = Ref.create(room);
    }
    public Speaker getSpeaker() {
        return this.speaker.get();
    }
    public void setSpeaker(Speaker speaker) {
        this.speaker = Ref.create(speaker);
    }
}
