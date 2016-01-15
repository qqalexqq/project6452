package cc.ntechnologies;

import java.util.List;

import cc.ntechnologies.entities.*;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import static com.googlecode.objectify.ObjectifyService.ofy;


@Api(name="api", version = "1.00", namespace = @ApiNamespace(ownerDomain=Config.PROJECT_NAME + ".appspot.com", ownerName="ntech", packagePath=""),
     clientIds = {Config.ANDROID_API_KEY})
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

    @ApiMethod(name = "getAllRoom", httpMethod = "GET")
    public List<Room> allRoom() {
        return ofy().load().type(Room.class).list();
    }
}
