package cc.ntechnologies.entities;

import java.util.Date;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;


@Entity
public class Conference {
    @Id
    private Long id;

    @Index
    private String topic;

    @Index
    private Date date;

    //relations
    // @Load @Parent private List<Ref<Speaker>> speakers;
    @Parent
    private Ref<Room> room;


    public Conference() {

    }

    public Conference(String topic, Date date, Ref<Room> room) {
        this.topic = topic;
        this.date = date;
        this.room = room;
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
    public Ref<Room> getRoom() {
        return room;
    }
    public void setRoom(Ref<Room> room) {
        this.room = room;
    }
}
