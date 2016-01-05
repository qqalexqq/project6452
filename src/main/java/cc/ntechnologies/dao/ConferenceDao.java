package cc.ntechnologies.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.Serializable;
import java.util.List;

import cc.ntechnologies.entities.Conference;
import org.springframework.stereotype.Repository;


@Repository
public class ConferenceDao implements Serializable {

    private final static long serialVersionUID = 1L;

    public Conference findById(Long id) {
        return ofy().load().type(Conference.class).id(id).now();
    }

    public void delete(Conference conference) {
        ofy().delete().entity(conference).now();
    }

    public Conference save(Conference conference) {
        ofy().save().entities(conference).now();

        return conference;
    }

    public List<Conference> getAll(int start, int max) {
        return ofy().load().type(Conference.class).offset(start).limit(max).list();
    }

    public int getNumberOfConferences() {
        return ofy().load().type(Conference.class).count();
    }
}
