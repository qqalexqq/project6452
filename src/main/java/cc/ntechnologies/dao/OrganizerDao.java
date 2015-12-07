package cc.ntechnologies.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import cc.ntechnologies.entities.Organizer;

public class OrganizerDao {

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

    public List<Organizer> getAll() {
        return ofy().load().type(Organizer.class).list();
    }
    
}
