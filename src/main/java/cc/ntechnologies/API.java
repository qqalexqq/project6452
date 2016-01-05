package cc.ntechnologies;

import java.util.List;

import cc.ntechnologies.entities.Conference;
import cc.ntechnologies.entities.News;
import cc.ntechnologies.entities.Organizer;
import cc.ntechnologies.entities.Partner;
import cc.ntechnologies.entities.Speaker;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import static com.googlecode.objectify.ObjectifyService.ofy;


@Api(name="api", version = "1.00", namespace = @ApiNamespace(ownerDomain="project645-2.appspot.com", ownerName="ntech", packagePath=""))
public class API {
    @ApiMethod(name = "getAllSpeakers", httpMethod = "GET")
    public List<Speaker> allSpeakers() {
        return ofy().load().type(Speaker.class).list();
    }

    @ApiMethod(name = "getAllConferences", httpMethod = "GET")
    public List<Conference> allConferences() {
        return ofy().load().type(Conference.class).list();
    }

    @ApiMethod(name = "getAllOrganizers", httpMethod = "GET")
    public List<Organizer> allOrganizers() {
        return ofy().load().type(Organizer.class).list();
    }

    @ApiMethod(name = "getAllPartners", httpMethod = "GET")
    public List<Partner> allPartners() {
        return ofy().load().type(Partner.class).list();
    }

    @ApiMethod(name = "getAllNews", httpMethod = "GET")
    public List<News> allNews() {
        return ofy().load().type(News.class).list();
    }
}
