package cc.ntechnologies.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.Serializable;
import java.util.List;

import cc.ntechnologies.entities.Organizer;
import org.springframework.stereotype.Repository;


@Repository
public class OrganizerDao implements Serializable {

    private final static long serialVersionUID = 1L;

    public Organizer findById(Long id) {
        return ofy().load().type(Organizer.class).id(id).now();
    }

    public void delete(Organizer organizer) {
        ofy().delete().entity(organizer).now();
    }

    public Organizer save(Organizer organizer) {
        ofy().save().entities(organizer).now();

        return organizer;
    }

    public List<Organizer> getAll(int start, int max) {
        return ofy().load().type(Organizer.class).offset(start).limit(max).list();
    }

    public int getNumberOfOrganizers() {
        return ofy().load().type(Organizer.class).count();
    }
}
