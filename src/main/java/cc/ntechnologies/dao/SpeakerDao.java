package cc.ntechnologies.dao;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import cc.ntechnologies.entities.Speaker;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * Created by aleksandr on 03.12.15.
 */
@Repository
public class SpeakerDao implements Serializable {

    private final static long serialVersionUID = 1L;

    public static Speaker findById(Long id) {
        return ofy().load().type(Speaker.class).id(id).now();
    }

    public static void delete(Speaker speaker) {
        ofy().delete().entity(speaker).now();
    }

    public static Speaker save(Speaker speaker) {
        ofy().save().entities(speaker).now();

        return speaker;
    }

    public static List<Speaker> getAll() {
        return ofy().load().type(Speaker.class).list();
    }
}

