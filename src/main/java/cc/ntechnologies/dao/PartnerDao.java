package cc.ntechnologies.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import cc.ntechnologies.entities.Partner;

public class PartnerDao {


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

    public List<Partner> getAll() {
        return ofy().load().type(Partner.class).list();
    }
}
