package cc.ntechnologies.dao;

import cc.ntechnologies.entities.Speaker;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;


@Repository
public class SpeakerDao implements Serializable {

    private final static long serialVersionUID = 1L;

    public Speaker findById(Long id) {
        return ofy().load().type(Speaker.class).id(id).now();
    }

    public void delete(Speaker speaker) {
        ofy().delete().entity(speaker).now();
    }

    public Speaker save(Speaker speaker) {
        ofy().save().entities(speaker).now();

        return speaker;
    }

    public List<Speaker> getAll() {
        return ofy().load().type(Speaker.class).list();
    }

    public List<Speaker> getAll(int start, int max) {
        return ofy().load().type(Speaker.class).offset(start).limit(max).list();
    }

    public int getNumberOfSpeakers() {
        return ofy().load().type(Speaker.class).count();
    }
}

