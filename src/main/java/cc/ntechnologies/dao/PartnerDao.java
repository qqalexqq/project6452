package cc.ntechnologies.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.Serializable;
import java.util.List;

import cc.ntechnologies.entities.Partner;
import org.springframework.stereotype.Repository;


@Repository
public class PartnerDao implements Serializable {

    private final static long serialVersionUID = 1L;

    public Partner findById(Long id) {
        return ofy().load().type(Partner.class).id(id).now();
    }

    public void delete(Partner partner) {
        ofy().delete().entity(partner).now();
    }

    public Partner save(Partner partner) {
        ofy().save().entities(partner).now();

        return partner;
    }

    public List<Partner> getAll(int start, int max) {
        return ofy().load().type(Partner.class).offset(start).limit(max).list();
    }

    public int getNumberOfPartners() {
        return ofy().load().type(Partner.class).count();
    }
}
